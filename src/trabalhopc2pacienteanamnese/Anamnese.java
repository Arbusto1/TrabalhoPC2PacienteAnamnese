package trabalhopc2pacienteanamnese;

public class Anamnese {
    
    private long id;
    private String motivo, relato, diagnostico;
    private Paciente paciente;
    private static long auxId;
    
    Anamnese() {
        
    }
    
    Anamnese(String motivo, String relato, String diagnostico, Paciente paciente) {
        this.id = auxId++;
        this.relato = relato;
        this.diagnostico = diagnostico;
        this.paciente = paciente;
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
