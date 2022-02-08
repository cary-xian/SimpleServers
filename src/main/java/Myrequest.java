import java.io.IOException;
import java.io.InputStream;

public class Myrequest {
    String method;
    String path;
    String IntiPath;
    String data;
    String request;
    String url;
    protected Myrequest(InputStream in){
        int len=-1;
        byte[] bytes=new byte[2048];
        try {
            if((len=in.read(bytes))!=-1){
                request=new String(bytes,0,len);

                String temp=request.split("\n")[0];
                method=temp.split("\\s")[0];
                System.out.println("请求方法:"+method);
                IntiPath=temp.split("\\s")[1];
                System.out.println("地址:"+IntiPath);
//                data=data.split("\n")[1];
                path=temp.split("\\s")[1].split("/")[1];
                System.out.println("二级地址:"+path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {

        return path;
    }

    public String getIntiPath() {
        return IntiPath;
    }

    public void setIntiPath(String intiPath) {
        IntiPath = intiPath;
    }

   public String getUrl(){
        return url;
   }

    public String getData() {
        return data;
    }
}
