public class MyRouter2 extends Servlet{
        @Override
        public void doGet(Myrequest resquest,MyResponse response) {
            System.out.println("您的请求是get请求");
            String content="world";
            response.write(content);
        }

        @Override
        public void doPost(Myrequest resquest,MyResponse response) {
            System.out.println("您的请求是post请求");
            String content="world";
            response.write(content);
        }
    }
