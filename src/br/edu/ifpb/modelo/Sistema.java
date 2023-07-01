package br.edu.ifpb.modelo;

import java.util.ArrayList;

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
}
