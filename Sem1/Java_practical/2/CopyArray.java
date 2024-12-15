import java.util.Arrays;

class CopyArray{

public static void main(String arg[]){

int arr1[] = {10,20,30,40,50};
int arr2[] = {9, 18,27,36,45};

String s_arr1[] = {"c++", "java", "python"};
String s_arr2[] = {"CSS", "HTML","Javascript"};


int merge_arr[] = new int[arr1.length + arr2.length]; 

System.arraycopy(arr1,0,merge_arr,0,arr1.length);
System.arraycopy(arr2,0,merge_arr,arr1.length,arr2.length);


System.out.println(Arrays.toString(merge_arr));

Arrays.sort(merge_arr);

System.out.println("After Sort Arrays");

System.out.println(Arrays.toString(merge_arr));

System.out.println("String merge");

String merge_sarr[] = new String[s_arr1.length+s_arr2.length];

System.arraycopy(s_arr1,0,merge_sarr,0,s_arr1.length);
System.arraycopy(s_arr2,0,merge_sarr,s_arr1.length,s_arr2.length);

System.out.println(Arrays.toString(merge_sarr));

System.out.println("After sort String");
Arrays.sort(merge_sarr);
 
System.out.println(Arrays.toString(merge_sarr));

}

}