import java.util.Scanner;

class Elect_bill{
public static void main(String arg[]){
Scanner sc = new Scanner(System.in);
System.out.print("Enter Your unit : ");
int unit = sc.nextInt();

double bill = Cal_Elec_bill(unit);
System.out.println("Total bill is "+bill);

}

public static double Cal_Elec_bill(int unit){

int fixed_price = 100;
double rate0_100 = 6.30;
double rate101_200 = 6.85;
double ratemorethan200 = 7.40;

if(unit<=100){

return fixed_price+(unit*rate0_100);

}
else if(unit <=200){


return (fixed_price+(100 * rate0_100)+(unit-100)*rate101_200);

}

else{

return (fixed_price + (100*rate0_100)+(100*rate101_200)+(unit-100)*ratemorethan200);

}




}


}