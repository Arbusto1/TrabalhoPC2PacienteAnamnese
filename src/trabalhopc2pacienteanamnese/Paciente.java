package trabalhopc2pacienteanamnese;

public class Paciente {

    private long numCNS;
    private String nome, nomeMae;
    private Sexo sexo;
    private Endereco endereco;
    Anamnese anamnese;
    Anamnese[] vetAnamnese = new Anamnese[10];
    private static long idPac;
    
    Paciente() {
        this.numCNS = idPac++;
    }
    
    private Paciente(String nome, String nomeMae, Sexo sexo, Endereco endereco) {
        this.numCNS = idPac++;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.sexo = sexo;
        this.endereco = endereco;
    }
    
    public static Paciente getInstance(String nome, String nomeMae, Sexo sexo,
            Endereco endereco) {
        
        if (nome.length() >= 3 && nomeMae.length() >= 3 && endereco != null) {
            return new Paciente(nome, nomeMae, sexo, endereco);
        } else {
            return null;
        }
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public long getNumCNS() {
        return numCNS;
    }
}
