package sistema.date;

import java.util.List;
import sistema.models.Usuario;
import sistema.date.exception.InserirUsuarioException;
import sistema.date.exception.UsuarioNaoEncontradoException;

public interface IRepositorioUsuario {
    
    public void add(Usuario u) throws InserirUsuarioException, IllegalArgumentException;
    
    public List<Usuario> listar();
    
    public boolean excluir(long id);
    
    public Usuario buscar(long id);
    
    public void alterar(Usuario uAlt) throws UsuarioNaoEncontradoException;
}
