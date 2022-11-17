package trabalhopc2pacienteanamnese;

public class Anamnese {
    
    private long id;
    private String motivo, relato, diagnostico;
    private Paciente paciente;
    private static long auxId;
    
    Anamnese() {
        
    }
    
    private Anamnese(String motivo, String relato, String diagnostico, Paciente paciente) {
        this.id = auxId++;
        this.motivo = motivo;
        this.relato = relato;
        this.diagnostico = diagnostico;
        this.paciente = paciente;
    }
    
        public Anamnese(Anamnese a) {
        this.id = a.id;
        this.motivo = a.motivo;
        this.relato = a.relato;
        this.diagnostico = a.diagnostico;
        this.paciente = new Paciente(a.paciente);
    }
    
    public static Anamnese getInstance(String motivo, String relato,
            String diagnostico, Paciente paciente) {
        
        if (motivo != null && relato != null && diagnostico != null && paciente != null) {
            return new Anamnese(motivo, relato, diagnostico, paciente);
        } else {
            return null;
        }
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
