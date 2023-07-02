package br.edu.explicacao_enum;

public class MainHerdados {
	public enum Estacoes{ //Declarando o tipo enum
        //Conjunto de constantes
        PRIMAVERA,
        VERAO,
        OUTONO,
        INVERNO;
    }

    public static void main(String[] args) {
        //Declarando um array com o método values():
        Estacoes arrayEstacoes[] = Estacoes.values();

        //Percorrendo o array com o values
        System.out.println("Método Values():");
        for(Estacoes estacoes : arrayEstacoes){
            System.out.println(estacoes);
        }

        //Método toString():
        System.out.println("\nMétodo toString():");
        System.out.println(Estacoes.PRIMAVERA.toString());

        //Método ordinal():
        System.out.println("\nMétodo ordinal():");
        for(Estacoes estacao : arrayEstacoes){
            System.out.println("A estação " + estacao + " corresponde ao índece " + estacao.ordinal());
        }
        
        //Método valueOf():
        System.out.println("\nMétodo valueOf():");
        System.out.println(Estacoes.valueOf("primavera".toUpperCase()));
    }
}
