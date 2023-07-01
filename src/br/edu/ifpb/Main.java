package br.edu.ifpb;

import br.edu.ifpb.enumerations.TiposUsuario;
import br.edu.ifpb.modelo.Sistema;
import br.edu.ifpb.modelo.SolicitacaoBolsa;
import br.edu.ifpb.modelo.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner entrada = new Scanner(System.in);
        int resposta;
        do

        {
            System.out.println("\nMENU\n1 - Adicionar usuário\n2 - Listar usuários\n3 - Realizar solicitação");
            resposta = entrada.nextInt();
            entrada.nextLine();

            switch (resposta) {
                case 1:
                    System.out.println("Informe o nome completo: ");
                    String nome = entrada.nextLine();
                    System.out.println("Informe o e-mail: ");
                    String email = entrada.nextLine();
                    System.out.println("Informe a matrícula: ");
                    String matricula = entrada.nextLine();
                    System.out.println("Informe o tipo de usuáio:\nDiscente\nBolsista\nDocente\nAdministador");
                    TiposUsuario tipo = TiposUsuario.valueOf(entrada.nextLine());
                    Usuario usuario = new Usuario(nome, email, matricula, tipo);
                    sistema.adicionaUsuario(usuario);
                    break;

                case 2:
                    for (Object usuarios : sistema.getUsuarios()) {
                        System.out.println(usuarios);
                    }
                    break;
                case 3:
                    System.out.println("Descreva a solicitação: ");
                    String descricao = entrada.nextLine();
                    LocalDate data = LocalDate.now();
                    Usuario usuario1 = (Usuario) sistema.getUsuarios().get(0); //TODO: selecionar o usuário solicitante da lista
                    SolicitacaoBolsa solicitacaoBolsa = new SolicitacaoBolsa();
                    solicitacaoBolsa.setDescricao(descricao);
                    solicitacaoBolsa.setData(data);
                    solicitacaoBolsa.setUsuario(usuario1);
                    sistema.adicionaSolicitacao(solicitacaoBolsa);
                    System.out.println(solicitacaoBolsa);
            }
        }while(resposta !=0);
    }


}



