# PythonCompiler
Code used to convert the Isilanguage to java using ANTLR4

## Nomes

Alan Gustavo Zanatelli da Silva RA: 11108716

André Kazuo Yasui RA 11071215

Matheus Cavalari Barbosa RA 11201810233

Vinícius de Figueiredo Trindade RA 11096415

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

#### Exemplo 1

--Input-- input.isi
```
programa

numero a.
texto x.
escreva("Programa Teste").

a := "oi".

fimprog.
```
--Output--
```
Semantic error - A variável a não é um texto
```

#### Exemplo 2

--Input-- input.isi
```
programa

numero a, a.
texto x.
escreva("Oi").

a := 2

fimprog.
```

--Output--

Semantic error - Symbol a already declared

#### Exemplo 3

--Input-- input.isi
```
programa

numero a,b,c.
texto t.

t := "oi".

leia(a).

a := raiz(a).
b := log(10).
c := exp(a, 2).
c := raiz(b) + c + exp(2,2).

se (a>b) entao
{
	escreva("a e maior que b").
}senao
{
	escreva("b e maior que a").
}

enquanto(a != b){
	escreva(a).
}

testa (t){
	caso "a":{
		escreva(a).
	}
	caso "oi":{
		escreva(t).
	}
}

fimprog.
```

--Output--
```
Compilation Successful
CommandAtribuicao [id=t, expr="oi"]
CommandLeitura [id=a]
CommandAtribuicao [id=a, expr=Math.sqrt(a)]
CommandAtribuicao [id=b, expr=Math.log(10)]
CommandAtribuicao [id=c, expr=Math.pow(a, 2)]
CommandAtribuicao [id=c, expr=Math.sqrt(b)+c+Math.pow(2, 2)]
CommandDecisao [condition=a>b, listaTrue=[CommandEscrita [id="a e maior que b"]], listaFalse=[CommandEscrita [id="b e maior que a"]]]
CommandEnquanto [condition=a!=b, listaWhile=[CommandEscrita [id=a]]]
CommandSwitch [condition=t]
CommandCaso [caso="a", listaCase=[CommandEscrita [id=a]]]
CommandCaso [caso="oi", listaCase=[CommandEscrita [id=t]]]
CommandSwitch - FechaSwitch
```
--MainClass.java--
```
import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){

     Scanner _key = new Scanner(System.in);

      double  a;
      double  b;
      double  c;
      String  t;

      t = "oi";
      a= _key.nextDouble();
      a = Math.sqrt(a);
      b = Math.log(10);
      c = Math.pow(a, 2);
      c = Math.sqrt(b)+c+Math.pow(2, 2);
      
      if (a>b) {
      	System.out.println("a e maior que b");
      }
      else {
      	System.out.println("b e maior que a");
      }

      
      while (a!=b) {
      	System.out.println(a);
      }

      
      switch (t) {
      	case "a" :{
			System.out.println(a);
		}

      	case "oi" :{
			System.out.println(t);
		}

      }


  }
}
```
#### Exemplo 4

--Input-- input.isi
```
programa

numero a,b,c.
escreva("Teste 1").

a := raiz(20).
b := log(10).

se (a>b) entao
{
	escreva("a e maior que b").
}senao
{
	escreva("b e maior que a").
}

fimprog.
```
--Output--
```
Compilation Successful
CommandEscrita [id="Teste 1"]
CommandAtribuicao [id=a, expr=Math.sqrt(20)]
CommandAtribuicao [id=b, expr=Math.log(10)]
CommandDecisao [condition=a>b, listaTrue=[CommandEscrita [id="a e maior que b"]], listaFalse=[CommandEscrita [id="b e maior que a"]]]
```
--MainClass.java--
```
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
```
#### Exemplo 5

--Input-- input.isi
```
programa

numero idade,idadeFutura.
escreva("Previsao para 2050").
escreva("Quantos anos voce faz ou fez em 2022").
leia(idade).

idadeFutura := idade + 28.

escreva("Em 2050 voce tera  ").
escreva(idadeFutura).
escreva("anos").


se (idadeFutura > 80) entao
{
	escreva("Provavelmente voce estara morto em 2050").
}senao
{
	escreva("Provavelmente voce estara vivo em 2050").
}


fimprog.
```
--Output---
```
Compilation Successful
CommandEscrita [id="Previsao para 2050"]
CommandEscrita [id="Quantos anos voce faz ou fez em 2022"]
CommandLeitura [id=idade]
CommandAtribuicao [id=idadeFutura, expr=idade+28]
CommandEscrita [id="Em 2050 voce tera  "]
CommandEscrita [id=idadeFutura]
CommandEscrita [id="anos"]
CommandDecisao [condition=idadeFutura>80, listaTrue=[CommandEscrita [id="Provavelmente voce estara morto em 2050"]], listaFalse=[CommandEscrita [id="Provavelmente voce estara vivo em 2050"]]]
```
--MainClass.java--
```
import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){

     Scanner _key = new Scanner(System.in);

      double  idade;
      double  idadeFutura;

      System.out.println("Previsao para 2050");
      System.out.println("Quantos anos voce faz ou fez em 2022");
      idade= _key.nextDouble();
      idadeFutura = idade+28;
      System.out.println("Em 2050 voce tera  ");
      System.out.println(idadeFutura);
      System.out.println("anos");
      
      if (idadeFutura>80) {
      	System.out.println("Provavelmente voce estara morto em 2050");
      }
      else {
      	System.out.println("Provavelmente voce estara vivo em 2050");
      }


  }
}
```
#### Exemplo 6

--Input-- Input.isi
```
programa

texto nome.
escreva("Inicio do teste captura nome").
escreva("Escreva o seu nome").
leia(nome).

escreva("Seja bem vindo ao teste Sr(a) ").
escreva(nome).
escreva("Fim do teste captura nome").

fimprog.
```
--Output--
```
Compilation Successful
CommandEscrita [id="Inicio do teste captura nome"]
CommandEscrita [id="Escreva o seu nome"]
CommandLeitura [id=nome]
CommandEscrita [id="Seja bem vindo ao teste Sr(a) "]
CommandEscrita [id=nome]
CommandEscrita [id="Fim do teste captura nome"]
```
--MainClass()--
```
import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){

     Scanner _key = new Scanner(System.in);

      String  nome;

      System.out.println("Inicio do teste captura nome");
      System.out.println("Escreva o seu nome");
      nome= _key.nextLine();
      System.out.println("Seja bem vindo ao teste Sr(a) ");
      System.out.println(nome);
      System.out.println("Fim do teste captura nome");

  }
}
```
