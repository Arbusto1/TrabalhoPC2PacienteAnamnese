package sistema.controls;

import java.util.List;
import sistema.date.IRepositorioPaciente;
import sistema.date.exception.InserirPacienteException;
import sistema.date.exception.PacienteNaoEncontradoException;
import sistema.models.Paciente;
import sistema.view.PacienteView;

public class ControlePaciente {
    
    private IRepositorioPaciente repoPaciente;
    private PacienteView viewPaciente;
    
    public ControlePaciente(IRepositorioPaciente repo) {
        viewPaciente = new PacienteView();
        repoPaciente = repo;
    }
    
    public void inserir() {
        Paciente pCrud = viewPaciente.lerPaciente();
        try {
            repoPaciente.add(pCrud);
        } catch (InserirPacienteException e) {
            System.out.println("Não foi possível inserir o paciente");
        } catch (IllegalArgumentException e) {
            System.out.println("Algum argumento inválido");
        }
    }
    
    public void alterar() {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "ALTERAR PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        List<Paciente> pacientes = repoPaciente.listar();
        viewPaciente.listar(pacientes);

        long id = viewPaciente.pegaId();
        Paciente p = repoPaciente.buscar(id);

        if (p != null) {
            Paciente pAlt = viewPaciente.alterar(p);
            try {
                repoPaciente.alterar(pAlt);
                viewPaciente.print("Paciente alterado com sucesso!");
            } catch (PacienteNaoEncontradoException e) {
                System.out.println("Não foi possível alterar o paciente");
            }
        }
    }
    
        public void excluir() {
        List<Paciente> pacientes = repoPaciente.listar();
        viewPaciente.listar(pacientes);
        
        long id = viewPaciente.pegaId();
        if (repoPaciente.excluir(id)) {
            System.out.println("Paciente excluido com sucesso!");
        } else {
            System.out.println("Não foi possível excluir o paciente");
        }
    }
    
    public void listar() {
        List<Paciente> pacientes = repoPaciente.listar();
        viewPaciente.listar(pacientes);
    }
}
