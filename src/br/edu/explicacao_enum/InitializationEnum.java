package br.edu.explicacao_enum;

public class InitializationEnum {

	public enum DiaSemana{ //Declaração de enum dentro de uma classe
		//Conjunto de constantes inicializadas
		SEGUNDA(1, "Segunda-feira"), 
		TERÇA(2, "Terça-feira"),
		QUARTA(3, "Quarta-feira"),
		QUINTA(4, "Quinta-feira"),
		SEXTA(5, "Sexta-feira"),
		SABADO(6, "Sabado"),
		DOMINGO(7, "Domingo");
		
		private final int valor; //Variavel de inteiro
		private final String dia; //Variavel de String
		
		private DiaSemana(int valor, String dia) { //Constructor privado
			//Atribui valores à variáveis
			this.valor = valor; 
			this.dia = dia;
		}
		
		//Retorna os valores das variaveis
		public int getValor() {
			return this.valor;
		}
		
		public String getDia() {
			return this.dia;
		}	
	} //Fim do Enum
	
	//Método main da claase
	public static void main(String[] args) {
		
		for (DiaSemana dia : DiaSemana.values()) {
			System.out.println("Chave: " + dia + "; Valor: " 
		+ dia.getValor() + "; Dia: " + dia.getDia() + ";\n");
		}
	}
}
