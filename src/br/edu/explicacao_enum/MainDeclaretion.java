package br.edu.explicacao_enum;

public class MainDeclaretion {
	enum Periodo{ //Declarando o tipo enum
		//Conjunto de constantes
		MANHA,
	    TARDE, 
	    NOITE;
	}

	public static void main(String[] args) {
		Periodo periodo; //Declaração da variável enum
	    periodo = Periodo.MANHA; //Atualizando a variável
	    System.out.println(periodo);
	}
}
