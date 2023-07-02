package br.edu.ifpb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpb.enumerations.TiposUsuario;

public class Sistema implements Serializable {
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

    public Usuario buscarUsuario(Scanner entrada, String mat){
        Usuario usuarioAchado = new Usuario();
        for (Object usuarios : getUsuarios()) {
            Usuario usuario = (Usuario) usuarios;
            if(usuario.getMatricula().equals(mat)){
                usuarioAchado = usuario;
            }
        }
        return usuarioAchado;
    }

}
