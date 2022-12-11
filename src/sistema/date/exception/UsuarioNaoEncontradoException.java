package sistema.date.exception;

public class UsuarioNaoEncontradoException extends Exception {
    
    public UsuarioNaoEncontradoException() {
        super();
    }
    
    public UsuarioNaoEncontradoException(String mns) {
        super(mns);
    }
}
