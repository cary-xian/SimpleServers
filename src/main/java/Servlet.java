public abstract class Servlet {
    protected abstract void doGet(Myrequest request,MyResponse response);
    protected abstract void doPost(Myrequest request,MyResponse response);
    protected void server(Myrequest request,MyResponse response){
          System.out.println(request.getMethod());
          if(request.getMethod().equalsIgnoreCase("GET")){
              doGet(request,response);
          }else if(request.getMethod().equalsIgnoreCase("POST")){
              doPost(request,response);
          }
    }
}
