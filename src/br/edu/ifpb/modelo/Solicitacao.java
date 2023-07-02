package br.edu.ifpb.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Solicitacao implements Serializable{
    private UUID codigo = UUID.randomUUID();
    private String descricao;
    private LocalDate data;
    private Usuario usuario;
    private boolean estado;

    public UUID getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", usuario=" + usuario.getMatricula() +
                ", estado=" + estado +
                '}';
    }

}
