import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {
    OutputStream out;
    protected MyResponse(OutputStream out){
        this.out=out;
    }
    public void write(String context){
        StringBuffer buf=new StringBuffer();
        buf.append("Http/1.1 200 OK\n");
        buf.append("Content-Type:text/html charset:utf-8\n");
        buf.append("Access-Control-Allow-Origin:*\n");
        buf.append("\r\n");
        buf.append("<html><head><title>服务器返回信息</title></head><body>");
        buf.append(context);
        buf.append("</body></html>");
        try {
            out.write(buf.toString().getBytes(),0,buf.length());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
