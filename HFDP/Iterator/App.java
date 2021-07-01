package Iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// using the iterator to go over different types of lists 
public class App {
    
    public static void main(String args[]) {
        List<Object> list = new ArrayList<Object>();
        list.add("hello");
        list.add("world");

        List<Object> list2 = new ArrayList<Object>(); 
        list2.add(1);
        list2.add(2);

        GenericIterator<Object> ge = new GenericIterator<Object>();
        ge.printItems(list);
        ge.printItems(list2);

    }
}
