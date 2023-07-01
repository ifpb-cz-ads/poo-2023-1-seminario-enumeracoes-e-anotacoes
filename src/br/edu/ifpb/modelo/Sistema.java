package br.edu.ifpb.modelo;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpb.enumerations.TiposUsuario;

public class Sistema {
    @SuppressWarnings(value = { "rawtypes"})
    private ArrayList usuarios = new ArrayList();

    private ArrayList<Solicitacao> solicitacoes = new ArrayList<>();

    public Sistema() {
    }

    public ArrayList getUsuarios() {
        return usuarios;
    }

    public ArrayList<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void adicionaUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void removeUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }

    public void adicionaSolicitacao(Solicitacao solicitacao){
        solicitacoes.add(solicitacao);
    }

    public void removeSolicitacao(Solicitacao solicitacao){
        solicitacoes.remove(solicitacao);
    }

    public Usuario buscarUsuario(Scanner entrada){
        int i = 0;
        for (Object usuarios : getUsuarios()) {
            Usuario usuarioBol = (Usuario) usuarios;
            if(usuarioBol.getTipo()==TiposUsuario.Bolsista){
                System.out.println(i + " - " + usuarioBol);
            }
            i++;
        }
        System.out.println("Escolha o usuário: ");
        int indexUsuario = entrada.nextInt();
        Usuario usuarioBol = (Usuario) getUsuarios().get(indexUsuario);
        return usuarioBol;
    }
}
