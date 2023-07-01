package br.edu.ifpb;

import br.edu.ifpb.enumerations.TiposUsuario;
import br.edu.ifpb.modelo.Sistema;
import br.edu.ifpb.modelo.Usuario;
import br.edu.ifpb.modelo.Solicitacao;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner entrada = new Scanner(System.in);
        int resposta;
        do {
            System.out.println("\nMENU\n1 - Adicionar usuário\n2 - Realizar solicitação \n3 - Listar solicitações do usuário \n4- Listar todas as solicitações do usuário \n5- Listar usuários bolsitas \n6- Validar solicitação");
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
                    Usuario usuarioBol1 = sistema.buscarUsuario(entrada);
                    System.out.println("Descreva a solicitação: ");
                    String descricao = entrada.nextLine();
                    LocalDate data = LocalDate.now();
                    Solicitacao solicitacao = new Solicitacao();
                    solicitacao.setDescricao(descricao);
                    solicitacao.setData(data);
                    solicitacao.setUsuario(usuarioBol1);
                    sistema.adicionaSolicitacao(solicitacao);
                    System.out.println(solicitacao);
                    break;
                case 3:
                     Usuario usuarioBol2 = sistema.buscarUsuario(entrada);
                     for (Solicitacao solicitacao1 : sistema.getSolicitacoes()) {
                        if(solicitacao1.getUsuario().equals(usuarioBol2)){
                            System.out.println(solicitacao1);
                        }
                     }
                    break;
                case 4:
                     break;
            }
        }while(resposta !=0);
    }


}



