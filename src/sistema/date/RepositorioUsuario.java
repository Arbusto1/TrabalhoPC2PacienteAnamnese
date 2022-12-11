package sistema.date;

import java.util.ArrayList;
import java.util.List;
import sistema.date.exception.UsuarioNaoEncontradoException;
import sistema.date.exception.InserirUsuarioException;
import sistema.models.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario {
    
    private List<Usuario> usuarios;
    private long idRepo;

    public RepositorioUsuario() {
        usuarios = new ArrayList<Usuario>();
    }
    
    @Override
    public void add(Usuario u) throws IllegalArgumentException, InserirUsuarioException {
        
        if (u == null) {
            throw new IllegalArgumentException("Favor inserir um dado correto");
        } else if (!usuarios.add(u)) {
            throw new InserirUsuarioException("Não foi possível armazenar!");
        }
    }
    
    @Override
    public List<Usuario> listar() {
        List<Usuario> copia = new ArrayList<Usuario>();
        for (Usuario u : usuarios) {
            try {
                copia.add(u.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return copia;
    }
    
    @Override
    public boolean excluir(long id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Usuario buscar(long id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    
    @Override
    public void alterar(Usuario uAlt) throws UsuarioNaoEncontradoException {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).equals(uAlt)) {
                usuarios.set(i, uAlt);
                return;
            }
        }
        throw new UsuarioNaoEncontradoException("Usuário não encontrado");
    }
}
