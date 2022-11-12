package trabalhopc2pacienteanamnese;

public class Sistema {

    Paciente[] paciente = new Paciente[10];
    Anamnese[] anamnese = new Anamnese[10];

    boolean adicionarPaciente(Paciente p) {

        if (p != null && this.verificaExiPac(p)) {

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

    boolean verificaExiPac(Paciente p) {
        if (p != null) {

            for (int i = 0; i < paciente.length; i++) {

                if (p.getNome() != null) {
                    if (paciente[i] != null) {
                        if (p.getNome().equals(paciente[i].getNome()) && p.getNomeMae().equals(paciente[i].getNomeMae())) {

                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    void aumentarPac(Paciente p) {

        Paciente[] aux = new Paciente[paciente.length * 2];

        int i = 0;
        for (; i < paciente.length; i++) {

            aux[i] = paciente[i];
        }
        paciente = aux;
        paciente[i] = p;
    }

    boolean alterarPac(String nome, String nomeM, Paciente p) {

        for (int i = 0; i < paciente.length; i++) {

            if (paciente[i] != null && nome.equals(paciente[i].getNome())
                    && nomeM.equals(paciente[i].getNomeMae())) {

                paciente[i] = p;
                return true;
            }
        }
        return false;
    }
    
    boolean auxAlterarPac(String nome, String nomeMae) {
        
        for (int i = 0; i < paciente.length; i++) {
            
            if (paciente[i] != null && nome.equals(paciente[i].getNome())
                    && nomeMae.equals(paciente[i].getNomeMae())) {
                return true;
            }
        }
        return false;
    }

    boolean excluirPac(String nome, String nomeM) {

        for (int i = 0; i < paciente.length; i++) {

            if (paciente[i] != null) {
                if (nome.equals(paciente[i].getNome()) && nomeM.equals(paciente[i].getNomeMae())) {

                    for (int j = 0; j < paciente[i].getVetAnamnese().length; j++) {

                        if (paciente[i].getVetAnamnese()[j] != null) {

                            return false;
                        }
                    }
                    paciente[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    boolean listarPac() {

        if (paciente != null) {

            System.out.print("Nome           Nome da Mãe    Cidade         Bairro         Rua            Número  Número CNS  Sexo");
            System.out.println("");
            if (paciente != null) {
                for (int i = 0; i < paciente.length; i++) {

                    if (paciente[i] != null) {

                        char[] nome = new char[16];
                        char[] nomeM = new char[16];
                        char[] cidade = new char[16];
                        char[] bairro = new char[16];
                        char[] rua = new char[16];

                        for (int j = 0; j < nome.length - 1; j++) {
                            if (paciente[i].getNome() != null && paciente[i].getNomeMae() != null) {
                                if (j < paciente[i].getNome().length()) {
                                    nome[j] = paciente[i].getNome().charAt(j);
                                } else {
                                    nome[j] = ' ';
                                }

                                if (j < paciente[i].getNomeMae().length()) {
                                    nomeM[j] = paciente[i].getNomeMae().charAt(j);
                                } else {
                                    nomeM[j] = ' ';
                                }
                            }
                        }

                        for (int j = 0; j < cidade.length - 1; j++) {
                            if (paciente[i].getEndereco() != null) {
                                if (paciente[i].getEndereco().getBairro() != null) {
                                    if (j < paciente[i].getEndereco().getBairro().length()) {
                                        bairro[j] = paciente[i].getEndereco().getBairro().charAt(j);
                                    } else {
                                        bairro[j] = ' ';
                                    }
                                }
                                if (paciente[i].getEndereco().getCidade() != null) {
                                    if (j < paciente[i].getEndereco().getCidade().length()) {
                                        cidade[j] = paciente[i].getEndereco().getCidade().charAt(j);
                                    } else {
                                        cidade[j] = ' ';
                                    }
                                }
                                if (paciente[i].getEndereco().getRua() != null) {
                                    if (j < paciente[i].getEndereco().getRua().length()) {
                                        rua[j] = paciente[i].getEndereco().getRua().charAt(j);
                                    } else {
                                        rua[j] = ' ';
                                    }
                                }
                            }

                        }

                        for (int j = 0; j < nome.length; j++) {
                            System.out.print(nome[j]);
                        }

                        for (int j = 0; j < nomeM.length; j++) {
                            System.out.print(nomeM[j]);
                        }

                        for (int j = 0; j < cidade.length; j++) {
                            System.out.print(cidade[j]);

                        }

                        for (int j = 0; j < bairro.length; j++) {
                            System.out.print(bairro[j]);
                        }

                        for (int j = 0; j < rua.length; j++) {
                            System.out.print(rua[j]);
                        }
                        if (paciente[i].getEndereco() != null) {
                            System.out.printf("%04d", paciente[i].getEndereco().getNumero());
                            System.out.print("    ");
                            System.out.printf("%010d", paciente[i].getNumCNS());
                            System.out.print("  ");
                            System.out.print(paciente[i].getSexo());
                            System.out.print("     ");

                            System.out.println("");
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    Paciente buscarCNS(long numCNS) {
        for (int i = 0; i < this.paciente.length; i++) {
            if (this.paciente[i] != null && numCNS == this.paciente[i].getNumCNS()) {
                return this.paciente[i];
            }
        }
        return null;
    }

    boolean AdicionarAnamnese(Anamnese a) {
        if (a != null) {
            for (int i = 0; i < anamnese.length; i++) {
                if (anamnese[i] == null) {
                    anamnese[i] = a;
                    return true;
                }
            }
        }
        return false;
    }

    void listarAnam(Paciente p) {
        System.out.println("DIAGNÓSTICO: \t \t" + "MOTIVO: \t \t" + "RELATO: ");
        for (int i = 0; i < anamnese.length; i++) {
            if (anamnese[i] != null) {
                System.out.println(i + 1 + " " + anamnese[i].getDiagnostico() + " \t \t" + anamnese[i].getMotivo() + " \t \t" + anamnese[i].getRelato() + " ");
            }
        }

    }

    boolean listarTodasAnam() {

        if (anamnese != null) {

            System.out.printf("%-7s %-11s %-11s %-11s %-11s %n",
                    "ID", "NOME", "MOTIVO", "RELATO", "DIAGNÓSTICO");
            for (int i = 0; i < anamnese.length; i++) {
                if (anamnese[i] != null) {
                    //System.out.println(i + 1 + " " + anamnese[i].paciente.nome + anamnese[i].diagnostico + " \t \t" + anamnese[i].motivo + " \t \t" + anamnese[i].relato + " ");
                    char[] nome = new char[13];
                    char[] diagnostico = new char[13];
                    char[] motivo = new char[13];
                    char[] relato = new char[13];

                    for (int j = 0; j < nome.length - 1; j++) {

                        if (j < anamnese[i].getPaciente().getNome().length()) {
                            nome[j] = anamnese[i].getPaciente().getNome().charAt(j);
                        } else {
                            nome[j] = ' ';
                        }
                        if (j < anamnese[i].getDiagnostico().length()) {
                            diagnostico[j] = anamnese[i].getDiagnostico().charAt(j);
                        } else {
                            diagnostico[j] = ' ';
                        }
                        if (j < anamnese[i].getMotivo().length()) {
                            motivo[j] = anamnese[i].getMotivo().charAt(j);
                        } else {
                            motivo[j] = ' ';
                        }
                        if (j < anamnese[i].getRelato().length()) {
                            relato[j] = anamnese[i].getRelato().charAt(j);
                        } else {
                            relato[j] = ' ';
                        }

                    }
                    System.out.printf("%04d", i);
                    System.out.print("    ");
                    for (int j = 0; j < nome.length; j++) {

                        System.out.print(nome[j]);
                    }
                    for (int j = 0; j < motivo.length; j++) {
                        System.out.print(motivo[j]);
                    }
                    for (int j = 0; j < relato.length; j++) {
                        System.out.print(relato[j]);
                    }
                    for (int j = 0; j < diagnostico.length; j++) {
                        System.out.print(diagnostico[j]);
                    }
                    System.out.println("");

                }
            }
            return true;
        }
        return false;

    }

    boolean AdicionarAnam(Paciente p, Anamnese a) {
        if (p != null) {
            for (int i = 0; i < p.getVetAnamnese().length; i++) {
                if (p.getVetAnamnese()[i] == null) {
                    p.getVetAnamnese()[i] = a;
                    return true;
                }
            }
        }
        return false;
    }

    Anamnese[] buscarNomeAnam(String nome) {
        Anamnese[] nomes = new Anamnese[10];
        if (paciente != null) {
            for (int i = 0; i < paciente.length; i++) {
                if (anamnese[i] != null) {
                    if (paciente[i] != null && nome.equals(paciente[i].getNome())) {
                        if (nome.equals(anamnese[i].getPaciente().getNome())) {
                            nomes[i] = anamnese[i];
                        }
                    }
                }
            }
            return nomes;
        }
        return null;
    }

    int identificarID(int escolha, Anamnese[] nomess) {
        for (int i = 0; i < nomess.length; i++) {
            if (escolha == i) {
                return i;
            }
        }
        return -1;
    }

    void init() {

        Endereco ep1 = Endereco.getInstance("Melo Viana", "Jasmin", "Coronel Fabriciano", 58);
        Paciente p1 = Paciente.getInstance("João", "Renata", Sexo.MASCULINO, ep1);
        this.adicionarPaciente(p1);

        Endereco ep2 = Endereco.getInstance("Giovanini", "Paquetá", "Coronel Fabriciano", 69);
        Paciente p2 = Paciente.getInstance("Emerson", "Barbara", Sexo.MASCULINO, ep2);
        Anamnese a4 = Anamnese.getInstance("Vomito", "Vomitou por dois dias", "Virose", p2);
        p2.setAnamnese(a4);
        this.AdicionarAnam(p2, a4);
        this.AdicionarAnamnese(a4);
        this.adicionarPaciente(p2);

        Endereco ep4 = Endereco.getInstance("Primavera", "Carmélia", "Timóteo", 66);
        Paciente p4 = Paciente.getInstance("Augusto", "Diana", Sexo.MASCULINO, ep4);
        this.adicionarPaciente(p4);

    }
}
