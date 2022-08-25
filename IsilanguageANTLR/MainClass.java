import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){

     Scanner _key = new Scanner(System.in);

      double  a;
      double  b;
      double  c;

      System.out.println("Teste 1");
      a = Math.sqrt(20);
      b = Math.log(10);
      
      if (a>b) {
      	System.out.println("a e maior que b");
      }
      else {
      	System.out.println("b e maior que a");
      }


  }
}