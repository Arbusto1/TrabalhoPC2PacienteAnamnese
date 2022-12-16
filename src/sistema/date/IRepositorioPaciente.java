package sistema.date;

import java.util.List;
import sistema.date.exception.InserirPacienteException;
import sistema.date.exception.PacienteNaoEncontradoException;
import sistema.models.Paciente;
import sistema.models.PacienteComDeficiencia;

public interface IRepositorioPaciente {
    
    public void add(Paciente p) throws IllegalArgumentException, InserirPacienteException;
    
    public void add(PacienteComDeficiencia pd) throws IllegalArgumentException, InserirPacienteException;
    
    public List<Paciente> listar();
    
    public boolean excluir(long id);
    
    public Paciente buscar(long id);
    
    public void alterar(Paciente pAlt) throws PacienteNaoEncontradoException;
}
