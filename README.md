# PythonCompiler
Code used to convert the Isilanguage to C with python

## Nomes
André Kazuo Yasui RA 11071215




## Checklist 

### Geral

- [X] Possuir 2 tipos de dados (pelo menos 1 String) 
- [X] Possuir a instrução de decisão (if/else)	
- [X] Pelo menos 1 estrutura de repetição	
- [X] Verificar Atribuições com compatibilidade de tipos (semântica) 	
- [X] Possuir operações de Entrada e Saída	
- [X] Aceitar números decimais 	
- [X] Verificar declaração de variávies (não usar variáveis que não foram declaradas)	
- [X] Verificar se há variáveis declaradas e não-utilizadas (warning)	
- [X] Geração de pelo menos 1 linguagem destino (C/Java/Python)

 ### Anexo 1

- [X] Nova instrução Switch/Case
- [X] Inclusão de novos operadores (exponenciação, raiz quadrada, logaritmos)

 ### Anexo 2

- [ ] Criar um editor Web para o código
- [ ] Tornar o compilador um Webservice para receber programas e enviar respostas de possíveis erros

## Vídeo

## Exemplos de programas testados

####Exemplo 1

--Input-- input.isi

programa

numero a.
texto x.
escreva("Programa Teste").

a := "oi".

fimprog.

--Output--

Semantic error - A variável a não é um texto

####Exemplo 2

--Input-- input.isi

programa

numero a, a.
texto x.
escreva("Oi").

a := 2

fimprog.


--Output--

Semantic error - Symbol a already declared

####Exemplo 3

--Input-- input.isi

programa

  numero a, b,c.
  texto  t1.

  leia(a).
  leia(b).
    
  
  a := 1 + 2 * 3 / b.
  b := 2.
  c:= 33.

  escreva(c).
  
  a := 2 + exp(b, 3)+raiz(c)+log(1).
  escreva(raiz(b)).
  escreva(exp(2,1)).
  escreva(log(2)).
  c := exp(1,1) + raiz(2) + log(c).
  
  
  testa (a){
  caso 1:{
  	escreva(a).
  	}
  caso 2: {
  	escreva(b).
  }
  }
  
  enquanto (a == 2){
  escreva(a).
  }

  se ( a > log(b) ) entao {
     escreva (a).
  }
  senao {
     escreva (b).
  }
  
  

fimprog.


--Output--

Compilation Successful
CommandLeitura [id=a]
CommandLeitura [id=b]
CommandAtribuicao [id=a, expr=1+2*3/b]
CommandAtribuicao [id=b, expr=2]
CommandAtribuicao [id=c, expr=33]
CommandEscrita [id=c]
CommandAtribuicao [id=a, expr=2+Math.pow(b, 3)+Math.sqrt(c)+Math.log(1)]
CommandEscrita [id=Math.sqrt(b)]
CommandEscrita [id=Math.pow(2, 1)]
CommandEscrita [id=Math.log(2)]
CommandAtribuicao [id=c, expr=Math.pow(1, 1)+Math.sqrt(2)+Math.log(c)]
CommandSwitch [condition=a]
CommandCaso [caso=1, listaCase=[CommandEscrita [id=a]]]
CommandCaso [caso=2, listaCase=[CommandEscrita [id=b]]]
CommandSwitch - FechaSwitch
CommandEnquanto [condition=a==2, listaWhile=[CommandEscrita [id=a]]]
CommandDecisao [condition=a>Math.log(b), listaTrue=[CommandEscrita [id=a]], listaFalse=[CommandEscrita [id=b]]]

--MainClass.java--
import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){

     Scanner _key = new Scanner(System.in);

      double  a;
      double  b;
      double  c;
      String  t1;

      a= _key.nextDouble();
      b= _key.nextDouble();
      a = 1+2*3/b;
      b = 2;
      c = 33;
      System.out.println(c);
      a = 2+Math.pow(b, 3)+Math.sqrt(c)+Math.log(1);
      System.out.println(Math.sqrt(b));
      System.out.println(Math.pow(2, 1));
      System.out.println(Math.log(2));
      c = Math.pow(1, 1)+Math.sqrt(2)+Math.log(c);
      
      switch (a) {
      	case 1 :{
			System.out.println(a);
		}

      	case 2 :{
			System.out.println(b);
		}

      }

      
      while (a==2) {
      	System.out.println(a);
      }

      
      if (a>Math.log(b)) {
      	System.out.println(a);
      }
      else {
      	System.out.println(b);
      }


  }
}
