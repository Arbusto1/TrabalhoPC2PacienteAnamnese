package sistema.date.exception;

public class PacienteNaoEncontradoException extends Exception {

    public PacienteNaoEncontradoException() {
    }
    
    public PacienteNaoEncontradoException(String mns) {
        System.out.println(mns);
    }
}
