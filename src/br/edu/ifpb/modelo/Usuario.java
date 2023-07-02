package br.edu.ifpb.modelo;
import java.io.Serializable;

import br.edu.ifpb.enumerations.TiposUsuario;


public class Usuario implements Serializable {
    private String nomeCompleto;
    private String email;
    private String matricula;
    private TiposUsuario tipo;

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

    @Override
    public String toString() {
        return "Usuario{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", matricula='" + matricula + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
