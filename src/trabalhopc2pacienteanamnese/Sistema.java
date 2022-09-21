package trabalhopc2pacienteanamnese;

public class Sistema {
    
    Paciente[] paciente = new Paciente[10];
    Anamnese[] anamnese = new Anamnese[10];
    
    boolean adicionar(Paciente p) {

        if (p != null) {
            
            for (int i = 0; i < paciente.length; i++) {
                
                if (paciente[i] == null) {
                    
                    paciente[i] = p;
                    return true;
                }
            }
            aumentarPac(p);
            return true;
        } else {
            
            return false;
        }
    }
    
    void aumentarPac(Paciente p){
        
        Paciente[] aux = new Paciente[paciente.length * 2];
        
        int i = 0;
        for (; i < paciente.length; i++) {
            
            aux[i] = paciente[i];
        }
        paciente = aux;
        paciente[i] = p;
    }

    void alterar() {

    }

    void listar() {

    }
}
