import java.util.*;  


class ArrayList1{

    public static void main(String arg[]){

        ArrayList<String> list=new ArrayList<String>();
        list.add("ravi");
        list.add("vijay");
        list.add("madhav");
        list.add("akash");
        list.add("mauyur");
        list.add("ramesh");
        list.add("rahul");

        Iterator itr = list.iterator();
        

        while(itr.hasNext()){
            System.out.println(itr.next());
        }


    }
    
}
