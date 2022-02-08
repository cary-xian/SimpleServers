import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Mytomcat {
      protected int port=2006;
      protected ServerSocket server;
      protected Socket client;
      protected Map<String,String> serverspool=new HashMap<>();
      public Mytomcat() {}
      protected String clazz;
    public Mytomcat(ServerSocket server, Socket client) {

        this.server = server;
        this.client = client;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public void start() {

        try {
            init();
            server = new ServerSocket(port);
            while (true) {
                System.out.println("服务器已经启动成功");
                client = server.accept();
                if (client != null) {
                    System.out.println("服务器已经接送到客户端请求");
                    InputStream in = client.getInputStream();
//                    int len = -1;
//                    byte[] bytes = new byte[2048];
//
//                    if ((len = in.read(bytes)) != -1) {
//                        String r = new String(bytes, 0, len);
//                        System.out.println(r);
//                    }

                    Myrequest request = new Myrequest(in);
                    OutputStream out = client.getOutputStream();
                    MyResponse response = new MyResponse(out);
                    dispath(request, response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    client.close();
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

      public void init(){

              for (ServletMapping servlet : ServletMappingConfig.list) {
                  System.out.println(servlet.getUrl());
                  serverspool.put(servlet.getUrl(), servlet.getClazz());
              }
              if(serverspool.size()==0){
                  System.out.println("初始化失败。。。");
              }

      }
      public void dispath(Myrequest request,MyResponse response){
          try {
                  if(clazz==null) {
                      clazz = serverspool.get(request.getIntiPath());
                      System.out.println(clazz);
                  }
                  Class<Servlet> m = (Class<Servlet>) Class.forName(clazz);
                  Servlet s = m.getDeclaredConstructor().newInstance();
                  s.server(request,response);
              } catch (ClassNotFoundException e) {
                  e.printStackTrace();
              } catch (InstantiationException e) {
                  e.printStackTrace();
              } catch (IllegalAccessException e) {
                  e.printStackTrace();
              } catch (NoSuchMethodException e) {
                  e.printStackTrace();
              } catch (InvocationTargetException e) {
              e.printStackTrace();
              }


      }
}
