package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericIterator<Object> {
    
    List<Object> collection;
    Iterator it; 

    public GenericIterator() {
    }

    // if you wanted to operate on the items, what you could do is add a callback? 
    public void printItems(List<Object> items) {
        this.collection = items;
        this.it = collection.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
