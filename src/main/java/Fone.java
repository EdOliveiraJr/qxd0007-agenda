public class Fone {
    private Identificador identificador;
    private String numero;


    public Fone(Identificador identificador, String numero){
        this.identificador = identificador;
        this.numero = numero;
    }

    public static boolean validarNumero(String numero) {
        return numero.matches("[\\(\\)\\-\\d]{1,}");        
    }

    public Identificador getIdentificador() {
        return identificador;
    }

    public String getNumero() {
        return numero;
    }

}
