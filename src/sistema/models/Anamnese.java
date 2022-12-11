package sistema.models;

public class Anamnese implements Cloneable {
    
    protected long id;
    protected String motivo, relato, diagnostico;
    protected Paciente paciente;
    protected static long auxId;
    
    public Anamnese() {
        
    }
    
    private Anamnese(String motivo, String relato, String diagnostico, Paciente paciente) {
        this.id = auxId++;
        this.motivo = motivo;
        this.relato = relato;
        this.diagnostico = diagnostico;
        this.paciente = paciente;
    }
    
    public static Anamnese getInstance(String motivo, String relato,
            String diagnostico, Paciente paciente) {
        
        if (motivo != null && relato != null && diagnostico != null && paciente != null) {
            return new Anamnese(motivo, relato, diagnostico, paciente);
        } else {
            return null;
        }
    }
    
    @Override
    public Anamnese clone() throws CloneNotSupportedException {
        return new Anamnese(motivo, relato, diagnostico, paciente.clone());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
