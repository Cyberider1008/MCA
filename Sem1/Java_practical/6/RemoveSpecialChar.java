

class RemoveSpecialChar {

    public static void main(String arg[]){
        String str = "I @m @shish";
        System.out.println("Actual String="+str);


        str = str.replaceAll("[@]", "a");
        System.out.println("String after replacement = "+str);
    }
    
}
