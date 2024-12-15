interface Area{
    final static float pi =3.14F;
    float compute(float x,float y);
}
class Reactangle implements Area{

    public float compute(float x, float y){
        return (x*y);

    }
}

class Circle implements Area{
    public float compute(float x, float y){
        return (pi*x*x);

    }
}



class Interface1 {

    public static void main(String arg[]){
        Reactangle react = new Reactangle();
        Circle cir = new Circle();
        Area area;
        area = react;
        System.out.println("Area of Reactangle="+area.compute(10,20));
        area = cir;
        System.out.println("Area of Circle ="+area.compute(10,10));

    }
    
}
