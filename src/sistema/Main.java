package sistema;

import sistema.date.IRepositorioPaciente;
import sistema.date.IRepositorioUsuario;
import sistema.date.RepositorioPaciente;
import sistema.date.RepositorioUsuario;

public class Main {

    public static void main(String[] args) {
        IRepositorioPaciente repoPaciente = new RepositorioPaciente();
        IRepositorioUsuario repoUsuario = new RepositorioUsuario();
        Sistema sistema = Sistema.getInstance(repoUsuario, repoPaciente);
        sistema.iniciar();
    }
}
