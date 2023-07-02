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

    public static void main(String[] args) {
        Sistema sistema = Main.lerSistemaDeArquivoBinario();
        Scanner entrada = new Scanner(System.in);
        ArrayList<Solicitacao> solicitacoes = sistema.getSolicitacoes();
        UsuarioAdm usuarioAdm = new UsuarioAdm("Carlos", "carlos123@gmail.com", "1111-1", TiposUsuario.Administrador);
        boolean loginAdm = false;
        int opcao = Main.MenuLogin(entrada);
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
                        loginAdm = true;
                        System.out.println("-----------------------------");
                        System.out.printf("      Bem-vindo, %s     ", usuarioAdm.getNomeCompleto());
                        System.out.println();
                        System.out.println("1- Validar solicitações");
                        System.out.println("2- Listar todas as solicitações");
                        System.out.println("3- Listar todos os usuários bolsistas");
                        System.out.println("-Informe a opção escolhida:");
                        int opcao2 = entrada.nextInt();
                        switch(opcao2){
                            case 1:
                                do{ 
                                    System.out.println("0- Voltar");
                                    Main.salvarArquivoSerializado(usuarioAdm.validarSolicitacao(sistema, entrada));
                                }while(opcao2!=0);
                                break;
                            case 2:
                                do{ 
                                        System.out.println("0- Voltar");
                                        Main.salvarArquivoSerializado(usuarioAdm.listarSolicitacoes(sistema, entrada, false));
                                    }while(opcao2!=0);
                                break;
                            case 3:
                                    System.out.println("0- Voltar");
                                    Main.salvarArquivoSerializado(usuarioAdm.listarUsuariosBolsitas(sistema));
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    } else {
                        System.out.println("Senha inválida! Informe novamente.");
                    }
                }while(loginAdm!=true);
            case 2:
                    System.out.println("-----------------------------");
                    System.out.println("      Login Usuário    ");
                    System.out.println("-Informe a matrícula");
                    String mat = entrada.nextLine();
                    System.out.println("-Informe a senha");
                    String senha = entrada.nextLine();
                break;
        }
    }

    public static int MenuLogin(Scanner entrada){
        System.out.println("-----------------------------");
        System.out.println("             MENU            ");
        System.out.println("1- Login Administrador");
        System.out.println("2- Login Usuário");
        System.out.println("Informe a opção:");
        int opcao = entrada.nextInt();
        return opcao;
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
        FileOutputStream fos = null;
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
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            if(criarArquivo()!=true){
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



