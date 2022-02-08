public class MyRouter extends Servlet{
    @Override
    public void doGet(Myrequest request,MyResponse response) {
        System.out.println("您的请求是get请求");
        String content="hello";
         response.write(content);
    }

    @Override
    public void doPost(Myrequest request,MyResponse response) {
        System.out.println("您的请求是post请求");
        String content="hello";
        response.write(content);
    }


}
