package sistema.date;

import java.util.ArrayList;
import java.util.List;
import sistema.date.exception.InserirPacienteException;
import sistema.date.exception.PacienteNaoEncontradoException;
import sistema.models.Paciente;

public class RepositorioPaciente implements IRepositorioPaciente {
    
    private List<Paciente> pacientes;
    
    public RepositorioPaciente() {
        pacientes = new ArrayList<Paciente>();
    }
    
    @Override
    public void add(Paciente p) throws InserirPacienteException, IllegalArgumentException {
        if (p == null) {
            throw new IllegalArgumentException("Insira um argumento válido");
        } else if (!pacientes.add(p)) {
            throw new InserirPacienteException("Não foi possível inserir o paciente");
        }
    }
    
    @Override
    public List<Paciente> listar() {
        List<Paciente> lPac = new ArrayList<Paciente>();
        for (Paciente p : pacientes) {
            try {
                lPac.add(p.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return lPac;
    }
    
    @Override
    public boolean excluir(long id) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNumCNS()== id) {
                pacientes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void alterar(Paciente pAlt) throws PacienteNaoEncontradoException {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).equals(pAlt)) {
                pacientes.set(i, pAlt);
                return;
            }
        }
        throw new PacienteNaoEncontradoException("O paciente não foi encontrado");
    }
    
    @Override
    public Paciente buscar(long id) {
        for (Paciente p : pacientes) {
            if (p.getNumCNS()== id) {
                return p;
            }
        }
        return null;
    }
}
