import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){

     Scanner _key = new Scanner(System.in);

      double  a;
      double  b;
      double  c;
      double  d;
      String  x;

      System.out.println("Programa Teste");
      a= _key.nextDouble();
      System.out.println(a);
      b = Math.log(a)+Math.sqrt(3);
      x = "a";
      
      if (a<b) {
      	c = a-b;
      	d = Math.pow(a, 2);
      	c = 1;
      }
      else {
      	c = Math.log(a);
      }

      
      while (a==2) {
      	System.out.println(a);
      }

      
      switch (x) {
      	case "a" :{
			System.out.println(b);
		}

      	case "b" :{
			c= _key.nextDouble();
		}

      }

      c = 1;
      d = c*a+b;

  }
}