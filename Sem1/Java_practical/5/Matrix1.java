import java.util.Scanner;

 class Matrix1 {
    public static void main(String arg[]){


        int row=0;
        int column = 0;
        int a[][] = null;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter row n column size :");
        row = sc. nextInt();
        column = sc.nextInt();
        a = new int[row][column];
        System.out.println("enter Matrix: ");
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j] = sc.nextInt();

            }
        }

        int rowsum;
        int columnsum;
        for(int i=0;i<3;i++){
            rowsum = 0;
            columnsum = 0;
            for(int j =0;j<3;j++){
                rowsum += a[i][j];
                columnsum += a[j][i];
             }
             System.out.println("Row-"+(i+1)+" sum="+rowsum);
             System.out.println("column-"+(i+1)+" sum="+columnsum);
        }
        sc.close();

    }
    
}
