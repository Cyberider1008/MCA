import java.lang.Thread;


class A extends Thread{
    public void run(){

        for(int i=1;i<6;i++){
            System.out.println("2*"+i+"="+(2*i));
        }

    }
}


class B extends Thread{
    public void run(){

        for(int i=1;i<6;i++){
            System.out.println("3*"+i+"="+(3*i));
        }

    }
}


class C extends Thread{
    public void run(){

        for(int i=1;i<6;i++){
            System.out.println("4*"+i+"="+(4*i));
        }

    }
}


class Thread1{
    public static void main(String arg[]){
        A a = new A();
        B b = new B();
        C c = new C();

try{

    a.start();
    Thread.sleep(20000);

}
catch(Exception e){

}
        
       
        b.start();
        c.start();

    }
}