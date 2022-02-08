import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
    public static List<ServletMapping> list=new ArrayList<>();

     static {
         list.add(new ServletMapping("servlet1","","MyRouter"));
         list.add(new ServletMapping("servlet2","data","MyRouter2"));

     }

}
