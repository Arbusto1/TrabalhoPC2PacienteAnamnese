package sistema.controls;

import java.util.List;
import sistema.date.IRepositorioUsuario;
import sistema.date.exception.InserirUsuarioException;
import sistema.date.exception.UsuarioNaoEncontradoException;
import sistema.view.UsuarioView;
import sistema.models.Usuario;

public class ControleUsuario {

    private UsuarioView viewUsuario;
    private IRepositorioUsuario repoUsuario;

    public ControleUsuario(IRepositorioUsuario repo) {
        viewUsuario = new UsuarioView();
        repoUsuario = repo;
    }

    public void inserir() {
        Usuario uCrud = viewUsuario.lerUsuario();
        try {
            repoUsuario.add(uCrud);
        } catch (IllegalArgumentException e) {
            System.out.println("Algum dado está inválido!");
        } catch (InserirUsuarioException e) {
            System.out.println("Não foi possível inserir no BD");
        }
    }

    public void alterar() {
        viewUsuario.print("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "ALTERAR USUARIO*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        List<Usuario> usuarios = repoUsuario.listar();
        viewUsuario.listar(usuarios);

        long id = viewUsuario.pegaId();
        Usuario u = repoUsuario.buscar(id);

        if (u != null) {
            Usuario uAlt = viewUsuario.altrar(u);
            try {
                repoUsuario.alterar(uAlt);
                viewUsuario.print("Usuario alterado com sucesso!");
            } catch (UsuarioNaoEncontradoException e) {
                System.out.println("Não foi possível alterar o usuario");
            }
        }
    }

    public void excluir() {
        List<Usuario> usuarios = repoUsuario.listar();
        viewUsuario.listar(usuarios);
        
        long id = viewUsuario.pegaId();
        if (repoUsuario.excluir(id)) {
            System.out.println("Usuario excluido com sucesso!");
        } else {
            System.out.println("Não foi possível excluir o usuario");
        }
    }
    
    public void listar() {
        List<Usuario> usuarios = repoUsuario.listar();
        viewUsuario.listar(usuarios);
    }
}
