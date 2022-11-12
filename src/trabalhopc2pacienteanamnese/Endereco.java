package trabalhopc2pacienteanamnese;

public class Endereco {
    
    private String bairro, rua, cidade;
    private int numero;
    
    Endereco() {
        
    }
    
    private Endereco(String bairro, String rua, String cidade, int numero) {
        this.bairro = bairro;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
    }
    
    public static Endereco getInstance(String bairro, String rua, String cidade,
            int numero) {
        
        if (bairro != null && rua != null && cidade != null) {
            return new Endereco(bairro, rua, cidade, numero);
        }
        return null;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
