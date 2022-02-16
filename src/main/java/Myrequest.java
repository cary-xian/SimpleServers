import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Myrequest {
    String method;
    String contentpath;
    String servletpath;
    String data;
    String request;
    String requesturl;
    String paramrter;
    protected Myrequest(InputStream in) {
        int len = -1;
        byte[] bytes = new byte[2048];
        try {
            if ((len = in.read(bytes)) > 0) {
                request = new String(bytes, 0, len);
                //System.out.println(request);
                String temp = request.split("\n")[0];
                method = temp.split("\\s")[0];
                System.out.println("请求方法:" + method);
                requesturl = temp.split("\\s")[1];
                System.out.println("url:" + requesturl);
                if (requesturl.equals("/")) {
                    contentpath = "";
                } else {
                    contentpath = requesturl.split("/")[1];
                }
                System.out.println("虚拟目录:" + contentpath);

                if ((!contentpath.equals("favicon.ico"))&&(!contentpath.equals(""))&&(!requesturl.endsWith(contentpath))) {
                    servletpath = requesturl.split("/")[2];
                    System.out.println("二级目录:" + servletpath);
                    paramrter = requesturl.split("\\?")[1];
                    System.out.println("参数:" + paramrter);
                }



            }
        } catch(IOException e){
             e.printStackTrace();
        }

    }

    public String getMethod() {
        return method;
    }

    public String getData(){

        return data;
    }
    public String getContentpath(){
       return contentpath;
    }
}
