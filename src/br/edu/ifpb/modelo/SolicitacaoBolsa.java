package br.edu.ifpb.modelo;

import br.edu.ifpb.enumerations.TiposUsuario;

public class SolicitacaoBolsa extends Solicitacao{
    @Override
    public void validaSolicitacao() {
        if(this.getUsuario().getTipo() != TiposUsuario.DISCENTE){ //Letras de constante de enum maiscula
            throw new RuntimeException(); //lança execeção que para o código
        }
        this.setEstado(true);
    }



}
