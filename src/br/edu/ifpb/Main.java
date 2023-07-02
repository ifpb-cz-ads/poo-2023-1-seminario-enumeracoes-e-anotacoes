package br.edu.ifpb;

import br.edu.ifpb.enumerations.TiposUsuario;
import br.edu.ifpb.modelo.Sistema;
import br.edu.ifpb.modelo.Usuario;
import br.edu.ifpb.modelo.UsuarioAdm;
import br.edu.ifpb.modelo.Solicitacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    @SuppressWarnings(value = "deprecation")
    public static void main(String[] args) {
        Sistema sistema = Main.lerSistemaDeArquivoBinario();
        Scanner entrada = new Scanner(System.in);
        ArrayList<Solicitacao> solicitacoes = sistema.getSolicitacoes();
        UsuarioAdm usuarioAdm = new UsuarioAdm("Carlos", "carlos123@gmail.com", "1111-1", TiposUsuario.ADMINISTRADOR);
        boolean loginAdm = false,loginUsuario = false;
        int opcao = Main.MenuLogin(entrada), opcao2;
        entrada.nextLine();
        switch(opcao){
            case 1:
                do{
                    System.out.println("-----------------------------");
                    System.out.println("      Login Administrador    ");
                    System.out.println("-Informe a matrícula");
                    String mat = entrada.nextLine();
                    System.out.println("-Informe a senha");
                    String senha = entrada.nextLine();
                    if(senha.equals(usuarioAdm.getSenha()) && usuarioAdm.getMatricula().equals(mat)){
                        do{
                            loginAdm = true;
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("-----------------------------");
                            System.out.printf("      Bem-vindo, %s     ", usuarioAdm.getNomeCompleto());
                            System.out.println();
                            System.out.println("1- Validar solicitações");
                            System.out.println("2- Listar todas as solicitações aprovadas");
                            System.out.println("3- Listar todos os usuários bolsistas");
                            System.out.println("4- Adicionar usuário");
                            System.out.println("5- Listar todos os usuários");
                            System.out.println("0- Sair");
                            System.out.println("-Informe a opção escolhida:");
                            opcao2 = entrada.nextInt();
                            entrada.nextLine();
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            switch(opcao2){
                                case 1:
                                    System.out.println("--------Validar solicitações");
                                    Main.salvarArquivoSerializado(usuarioAdm.validarSolicitacao(sistema, entrada));
                                    System.out.println("Solicitação validada!");
                                    break;
                                case 2:
                                    System.out.println("--------Listar todas solicitações aprovadas");
                                    Main.salvarArquivoSerializado(usuarioAdm.listarSolicitacoes(sistema, entrada, true));
                                    break;
                                case 3:
                                    System.out.println("--------Listar todos usuários bolsistas");
                                    Main.salvarArquivoSerializado(usuarioAdm.listarUsuariosBolsitas(sistema));
                                    break;
                                case 4:
                                    System.out.println("--------Adicionar usuário");
                                    System.out.println("Informe o nome completo: ");
                                    String nome = entrada.nextLine();
                                    System.out.println("Informe o e-mail: ");
                                    String email = entrada.nextLine();
                                    System.out.println("Informe a matrícula: ");
                                    String matricula = entrada.nextLine();
                                    System.out.println("Informe o tipo de usuáio:\nDiscente\nBolsista\nDocente");
                                    TiposUsuario tipo = TiposUsuario.valueOf(entrada.nextLine().toUpperCase());
                                    Usuario usuario = new Usuario(nome, email, matricula, tipo);
                                    System.out.println(usuario);
                                    sistema.adicionaUsuario(usuario);
                                    Main.salvarArquivoSerializado(sistema);
                                    break;
                                case 5:
                                    System.out.println("--------Listar todos os usuários");
                                    for (Object usuarioGen : sistema.getUsuarios()){
                                        Usuario usuarios = (Usuario) usuarioGen;
                                        System.out.println(usuarios);
                                    }
                                    break;
                                }
                            entrada.nextLine();
                        }while(opcao2!=0);
                    } else {
                        System.out.println("Senha inválida! Informe novamente.");
                    }
                }while(!loginAdm);
                break;
            case 2:
                do{
                    System.out.println("-----------------------------");
                    System.out.println("      Login Usuário    ");
                    System.out.println("-Informe a matrícula");
                    String mat = entrada.nextLine();
                    Usuario usuarioAchado = sistema.buscarUsuario(entrada, mat);
                    if(usuarioAchado!=null){
                        do{ 
                            loginUsuario = true;
                            System.out.println();
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("-----------------------------");
                            System.out.printf("      Bem-vindo, %s     ", usuarioAchado.getNomeCompleto());
                            System.out.println();
                            System.out.println("1- Fazer solicitação");
                            System.out.println("2- Listar solicitações");
                            System.out.println("3- Ver informações");
                            System.out.println("0- Sair");
                            System.out.println("-Informe a opção escolhida:");
                            opcao2 = entrada.nextInt();
                            entrada.nextLine();
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            switch(opcao2){
                                case 1:
                                    System.out.println("--------Fazer solicitação");
                                    if(usuarioAchado.getTipo()==TiposUsuario.BOLSISTA){
                                        System.out.println("Descreva a solicitação: ");
                                        String descricao = entrada.nextLine();
                                        LocalDate data = LocalDate.now();
                                        Solicitacao solicitacao = new Solicitacao();
                                        solicitacao.setDescricao(descricao);
                                        solicitacao.setData(data);
                                        solicitacao.setUsuario(usuarioAchado);
                                        sistema.adicionaSolicitacao(solicitacao);
                                        System.out.println(solicitacao);
                                        Main.salvarArquivoSerializado(sistema);
                                    } else 
                                        System.out.println("Você não tem permissão para acessar essa página!");
                                    break;
                                case 2:
                                    System.out.println("--------Listar solicitações");
                                    if(usuarioAchado.getTipo()==TiposUsuario.BOLSISTA){
                                        boolean vazia = false;
                                        for (Solicitacao solicitacao : solicitacoes) {
                                            if(solicitacao.getUsuario().getMatricula().equals(usuarioAchado.getMatricula())){
                                                vazia = true;
                                                System.out.println(solicitacao);
                                                if(solicitacao.isEstado()) System.out.println("Solicitação aprovada");
                                                else    System.out.println("Solicitação pendente!");
                                            }
                                        }
                                        if(!vazia)  System.out.println("Você não tem solicitações cadastradas!");
                                    } else 
                                        System.out.println("Você não tem permissão para acessar essa página!");
                                    break;
                                case 3:
                                    System.out.println("--------Ver informações");
                                    System.out.println(usuarioAchado);
                                    break;
                            }
                            entrada.nextLine();
                        }while(opcao2!=0);
                    }
                    else {
                        System.out.println("Matrícula inexistente! Tente novamente.");
                    }
                }while(!loginUsuario);
                break;
        }
    }

    public static int MenuLogin(Scanner entrada){
        System.out.println("-----------------------------");
        System.out.println("             MENU            ");
        System.out.println("1- Login Administrador");
        System.out.println("2- Login Usuário");
        System.out.println("Informe a opção:");
        return entrada.nextInt();
    }

    public static boolean criarArquivo(){
        File arquivo = new File("arquivo.bin");
        try{
            if(arquivo.createNewFile()){
                return true;
            } else{
                return false;
            }
        } catch(IOException e){
            System.out.println("erro ao criar arquivo");
            e.printStackTrace();
            return false;
        }
    }

    public static void salvarArquivoSerializado(Sistema sistema){
        FileOutputStream fos;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("arquivo.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sistema);
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        } catch(IOException e){
            System.out.println("Erro ao criar arquivo");
            e.printStackTrace();
        } finally{
            if(oos != null){
                try{
                    oos.close();
                } catch(IOException e){
                    System.out.println("Erro ao fechar o arquivo");
                }
            }
        }
    }

    public static Sistema lerSistemaDeArquivoBinario(){
        Sistema sistema = new Sistema();
        FileInputStream fis;
        ObjectInputStream ois = null;
        try{
            if(!criarArquivo()){
                fis = new FileInputStream("arquivo.bin");
                ois = new ObjectInputStream(fis);
                sistema = (Sistema)ois.readObject();
            }
            return sistema;
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada");
        }catch(IOException e){
            System.out.println("erro ao criar arquivo");
            e.printStackTrace();
        }finally{
            if(ois != null){
                try{
                    ois.close();
                }catch(IOException e){
                    System.out.println("erro ao fechar arquivo");
                }
            }
        }
        return sistema;
    }

}



