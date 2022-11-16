package trabalhopc2pacienteanamnese;

public class Paciente {

    private long numCNS;
    private String nome, nomeMae;
    private Sexo sexo;
    private Endereco endereco;
    private Anamnese anamnese;
    private Anamnese[] vetAnamnese = new Anamnese[10];
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
    
    public Paciente(Paciente p) {
        this.numCNS = p.numCNS;
        this.nome = p.nome;
        this.nomeMae = p.nomeMae;
        this.sexo = p.sexo;
        if (p.endereco != null) {
            this.endereco = new Endereco(p.endereco);
        }
        if (p.anamnese != null) {
            this.anamnese = p.anamnese;
        }
        if (p.vetAnamnese != null) {
            this.vetAnamnese = p.vetAnamnese;
        }
    }
    
    public static Paciente getInstance(String nome, String nomeMae, Sexo sexo,
            Endereco endereco) {
        
        if (nome.length() >= 3 && nomeMae.length() >= 3 && endereco != null) {
            return new Paciente(nome, nomeMae, sexo, endereco);
        } else {
            return null;
        }
    }
    
    public void addEndereco(String cidade, String bairro, String rua, int numRes) {
        Endereco e = Endereco.getInstance(bairro, rua, cidade, numRes);
        this.endereco = e;
    }

    public Anamnese[] getVetAnamnese() {
        return vetAnamnese;
    }
    
    public void setVetAnamnese(Anamnese[] vetAnam) {
        this.vetAnamnese = vetAnam;
    }
    
    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }
    
    public Anamnese getAnamnese() {
        return anamnese;
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
