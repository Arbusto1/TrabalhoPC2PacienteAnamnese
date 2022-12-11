package sistema.models;

public class Endereco implements Cloneable {
    
    protected String bairro, rua, cidade;
    protected int numero;
    
    public Endereco() {
        
    }
    
    private Endereco(String bairro, String rua, String cidade, int numero) {
        this.bairro = bairro;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
    }
    
    public static Endereco getInstance(String bairro, String rua, String cidade,
            int numero) {
        
        if (bairro != null && rua != null && cidade != null && numero > 0) {
            return new Endereco(bairro, rua, cidade, numero);
        }
        return null;
    }
    
    @Override
    public Endereco clone() throws CloneNotSupportedException {
        return (Endereco) super.clone();
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
