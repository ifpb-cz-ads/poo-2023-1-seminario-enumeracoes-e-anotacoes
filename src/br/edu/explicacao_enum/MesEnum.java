package br.edu.explicacao_enum;

public enum MesEnum {
    JANEIRO(1),
    FEVEREIRO(2),
    MARCO(3);
    private final int indice;
    public int getIndice() {
        return indice;
    }
    private MesEnum(int indice){
        this.indice = indice;
    }

    // Main
    public static void main(String[] args) {
        MesEnum mes = MesEnum.MARCO;

        // Comparando utilizando o '=='
        System.out.println("Comparação com '=='\n");
        if(mes == MesEnum.MARCO){
            System.out.println("São iguais\n\n");
        }else{
            System.out.println("São diferentes\n\n");            
        }
        // Valor esperado "São iguais"

        // Comparando utilizando o equals
        System.out.println("Comparação com equals\n");
        if(mes.equals(MesEnum.JANEIRO)){
            System.out.println("São iguais\n\n");
        }else{
            System.out.println("São diferentes\n\n");
        }
        // Valor esperado "São diferentes"
    }
}
