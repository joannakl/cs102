package recitation04;

public class Add {

    public static void main(String[] args) {
        
        int num1 = Integer.parseInt( args[0] );
        int num2 = Integer.parseInt( args[1] ); 
        
        System.out.printf( "Sum of %d and %d is %d. \n",
                num1, num2, num1+num2);
    }
}

