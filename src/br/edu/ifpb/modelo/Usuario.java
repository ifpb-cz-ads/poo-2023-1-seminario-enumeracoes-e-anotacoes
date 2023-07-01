package br.edu.ifpb.modelo;

import br.edu.ifpb.enumerations.TiposUsuario;


public class Usuario {
    String nomeCompleto;
    String email;
    String matricula;
    TiposUsuario tipo;

    public Usuario() {
    }

    public Usuario(String nomeCompleto, String email, String matricula, TiposUsuario tipo){
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.matricula = matricula;
        this.tipo = tipo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TiposUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TiposUsuario tipo) {
        this.tipo = tipo;
    }
}
