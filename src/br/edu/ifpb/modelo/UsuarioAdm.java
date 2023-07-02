package br.edu.ifpb.modelo;

import java.util.Scanner;

import br.edu.ifpb.enumerations.TiposUsuario;

public class UsuarioAdm extends Usuario{
    private String senha = "654123";

    public UsuarioAdm(String nomeCompleto, String email, String matricula, TiposUsuario tipo) {
        super(nomeCompleto, email, matricula, tipo);
    }

    public String getSenha() {
        return senha;
    }

    public Sistema validarSolicitacao(Sistema sistema, Scanner entrada){
        listarSolicitacoes(sistema, entrada, false);
        int indexSolicitacao = entrada.nextInt();
        Solicitacao solicitacao = sistema.getSolicitacoes().get(indexSolicitacao);
        solicitacao.setEstado(true);
        return sistema;
    }

    public Sistema listarSolicitacoes(Sistema sistema, Scanner entrada, boolean todas){
        for (Solicitacao solicitacao : sistema.getSolicitacoes()) {
                if(solicitacao.isEstado()==todas){
                    System.out.println("ID- " + sistema.getSolicitacoes().indexOf(solicitacao));
                    System.out.println(solicitacao);
                }
        }
        return sistema;
    }

    public Sistema listarUsuariosBolsitas(Sistema sistema){
        for (Object usuario : sistema.getUsuarios()){
            Usuario usuarioBol = (Usuario) usuario;
            if(usuarioBol.getTipo()==TiposUsuario.Bolsista){
                System.out.println(usuarioBol);
            }
        }
        return sistema;
    }
}
