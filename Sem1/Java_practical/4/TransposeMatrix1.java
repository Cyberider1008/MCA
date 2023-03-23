class TransposeMatrix1{

public static void main(String arg[]){
    int original[][]={{1,2},{3,4}};
    int transpose[][] = new int[2][2];



for(int i=0;i<2;i++){
    for(int j=0;j<2;j++){
        transpose[i][j] = original[j][i]; 
    }
}
System.out.println("printing matrix without transpose: ");
for(int i=0;i<2;i++){
    for(int j=0;j<2;j++){
        System.out.print(original[i][j]+"");
    }
    System.out.println();
}

System.out.println("printing  matrix after Transpose:");

for(int i=0;i<2;i++){
    for(int j=0;j<2;j++){
        System.out.print(transpose[i][j]+"");
    }
    System.out.println();
}

}
}