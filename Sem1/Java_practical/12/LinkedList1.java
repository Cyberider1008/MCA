import java.util.Iterator;
import java.util.LinkedList;

class LinkedList1 {

public static void main(String arg[]){

    LinkedList<String> l1 = new LinkedList<String>();
    l1.add("ravi"); 
    l1.add("ramesh");
    l1.add("rahul");
    l1.add("mohan");
    Iterator<String> itr =l1.iterator();
    while(itr.hasNext()){
        System.out.println(itr.next());
    }
}


    
}
