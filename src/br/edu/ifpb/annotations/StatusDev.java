package br.edu.ifpb.annotations;
public @interface StatusDev {
    public enum Status {
        COMPLETO, INCOMPLETO
    }
    String descricao();
    Status status() default Status.INCOMPLETO;

}
