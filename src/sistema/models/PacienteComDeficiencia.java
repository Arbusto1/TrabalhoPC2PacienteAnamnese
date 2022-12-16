package sistema.models;

public class PacienteComDeficiencia extends Paciente {
    
    protected String fatorComplicador;
    protected Deficiencia deficiencia;
    
    public PacienteComDeficiencia() {
    }
    
    private PacienteComDeficiencia(String nome, String nomeMae,
            Sexo sexo, Endereco endereco, Deficiencia deficiencia, 
            String fatorComplicador) {
        
        super(nome, nomeMae, sexo, endereco);
        this.deficiencia = deficiencia;
        this.fatorComplicador = fatorComplicador;
    }
    
    public static PacienteComDeficiencia getInstance(String nome, String nomeMae,
            Sexo sexo, Endereco endereco, Deficiencia deficiencia, 
            String fatorComplicador) {
        
        if (nome != null && nomeMae != null && endereco != null && fatorComplicador != null) {
            return new PacienteComDeficiencia(nome, nomeMae, sexo, endereco,
            deficiencia, fatorComplicador);
        } else {
            return null;
        }
    }
    
    @Override
    public PacienteComDeficiencia clone() throws CloneNotSupportedException {
        return new PacienteComDeficiencia(nome, nomeMae, sexo, endereco.clone(), deficiencia, fatorComplicador);
    }

    public String getFatorComplicador() {
        return fatorComplicador;
    }

    public void setFatorComplicador(String fatorComplicador) {
        this.fatorComplicador = fatorComplicador;
    }

    public Deficiencia getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(Deficiencia deficiencia) {
        this.deficiencia = deficiencia;
    }
    
}
