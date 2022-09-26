package trabalhopc2pacienteanamnese;

import java.util.Scanner;

public class Sistema {

    Paciente[] paciente = new Paciente[10];
    Anamnese[] anamnese = new Anamnese[10];

    Paciente registrarPac() {

        Scanner sc = new Scanner(System.in);
        Paciente p = new Paciente();
        Endereco ep = new Endereco();

        for (;;) {

            try {

                System.out.println("");
                System.out.println("Qual o nome do Paciente? ");
                p.nome = sc.nextLine();
                System.out.println("Qual o número de sua CNS? ");
                p.numCNS = sc.nextInt();
                sc.nextLine();
                System.out.println("Qual o nome damãe? ");
                p.nomeMae = sc.nextLine();

                System.out.println("Qual o sexo do paciente? (Digite 1 para MASCULINO 2 para"
                        + " FEMININO e 3 para INTERSEXO)");
                for (;;) {

                    int s = sc.nextInt();
                    sc.nextLine();
                    if (s == 1) {

                        p.sexo = Sexo.MASCULINO;
                        break;
                    } else if (s == 2) {

                        p.sexo = Sexo.FEMININO;
                        break;
                    } else if (s == 3) {

                        p.sexo = Sexo.INTERSEXO;
                        break;
                    } else {
                        System.out.println("Insira um número válido!");
                    }
                }

                System.out.println("Qual a cidade onde mora? ");
                ep.cidade = sc.nextLine();
                System.out.println("Qual o bairo? ");
                ep.bairro = sc.nextLine();
                System.out.println("Qual a rua? ");
                ep.rua = sc.nextLine();
                System.out.println("Qual o número da residência?");
                ep.numero = sc.nextInt();
                p.endereco = ep;
                break;
            } catch (Exception e) {

                System.out.println("");
                System.out.println("Algum valor não está compatível, por favor"
                        + " tente novamente com os dados corretos");
                System.out.println("");
            }
        }
        sc.close();
        return p;
    }

    boolean verificaExiPac(Paciente p) {
        if (p != null) {

            for (int i = 0; i < paciente.length; i++) {

                if (paciente[i] != null) {
                    if (p.nome.equals(paciente[i].nome) && p.nomeMae.equals(paciente[i].nomeMae)) {

                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean adicionar(Paciente p) {

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

    void aumentarPac(Paciente p) {

        Paciente[] aux = new Paciente[paciente.length * 2];

        int i = 0;
        for (; i < paciente.length; i++) {

            aux[i] = paciente[i];
        }
        paciente = aux;
        paciente[i] = p;
    }

    boolean alterar(String nome, String nomeM) {

        for (int i = 0; i < paciente.length; i++) {

            if (paciente[i] != null && nome.equals(paciente[i].nome)
                    && nomeM.equals(paciente[i].nomeMae)) {

                paciente[i] = registrarPac();
                return true;
            }
        }
        return false;
    }

    boolean buscarPac(String nome, String nomeM) {

        for (int i = 0; i < paciente.length; i++) {

            if (paciente[i] != null) {
                if (nome.equals(paciente[i].nome) && nomeM.equals(paciente[i].nomeMae)) {

                    /*System.out.println("Dados do paciente");
                    System.out.println("");
                    System.out.println("Nome: " + paciente[i].nome);
                    System.out.println("Nome da Mãe: " + paciente[i].nomeMae);
                    System.out.println("Número CNS: " + paciente[i].numCNS);
                    System.out.println("Sexo: " + paciente[i].sexo);
                    System.out.println("Cidade: " + paciente[i].endereco.cidade);
                    System.out.println("Bairo: " + paciente[i].endereco.bairro);
                    System.out.println("Rua: " + paciente[i].endereco.rua);
                    System.out.println("Número da redidência: " + paciente[i].endereco.numero);
                    System.out.println("");*/
                    return true;
                }
            }
        }
        System.out.println("Paciente não encontrado");
        return false;
    }

    boolean listarPac() {

        if (paciente != null) {

            System.out.printf("%-15s %-14s %-15s %-15s %-15s %-4s %-10s %-10s %n",
                     "Nome", "Nome da mãe", "Cidade", "Bairro", "Rua", "Número ",
                     "Número CNS ", "Sexo");
            System.out.println("");
            for (int i = 0; i < paciente.length; i++) {

                if (paciente[i] != null) {

                    char[] nome = new char[16];
                    char[] nomeM = new char[16];
                    char[] cidade = new char[16];
                    char[] bairro = new char[16];
                    char[] rua = new char[16];

                    for (int j = 0; j < nome.length - 1; j++) {

                        if (j < paciente[i].nome.length()) {
                            nome[j] = paciente[i].nome.charAt(j);
                        } else {
                            nome[j] = ' ';
                        }

                        if (j < paciente[i].nomeMae.length()) {
                            nomeM[j] = paciente[i].nomeMae.charAt(j);
                        } else {
                            nomeM[j] = ' ';
                        }
                    }

                    for (int j = 0; j < cidade.length - 1; j++) {

                        if (j < paciente[i].endereco.bairro.length()) {
                            bairro[j] = paciente[i].endereco.bairro.charAt(j);
                        } else {
                            bairro[j] = ' ';
                        }

                        if (j < paciente[i].endereco.cidade.length()) {
                            cidade[j] = paciente[i].endereco.cidade.charAt(j);
                        } else {
                            cidade[j] = ' ';
                        }

                        if (j < paciente[i].endereco.rua.length()) {
                            rua[j] = paciente[i].endereco.rua.charAt(j);
                        } else {
                            rua[j] = ' ';
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
                    
                    System.out.printf("%04d", paciente[i].endereco.numero);
                    System.out.print("    ");
                    System.out.printf("%010d", paciente[i].numCNS);
                    System.out.print("  ");
                    System.out.print(paciente[i].sexo);
                    
                    System.out.println("");
                    /*System.out.println(paciente[i].nome + "\t"
                            + paciente[i].numCNS + "\t"
                            + paciente[i].nomeMae + "\t" + paciente[i].sexo
                            + "\t"
                            + paciente[i].endereco.cidade + "\t"
                            + paciente[i].endereco.bairro
                            + "\t" + paciente[i].endereco.rua + "\t"
                            + paciente[i].endereco.numero
                            + "\t");*/
                }
            }
            return true;
        }
        return false;
    }

    void excluir() {

    }

    void init() {

        Paciente p1 = new Paciente();
        Endereco ep1 = new Endereco();
        p1.numCNS = 164584;
        p1.nome = "Jão";
        p1.nomeMae = "Renata";
        p1.sexo = Sexo.MASCULINO;
        ep1.bairro = "Melo Viana";
        ep1.cidade = "Coronel Fabriciano";
        ep1.rua = "Jasmin";
        ep1.numero = 58;
        p1.endereco = ep1;
        this.adicionar(p1);

        Paciente p2 = new Paciente();
        Endereco ep2 = new Endereco();
        p2.numCNS = 1678454;
        p2.nome = "Emershow";
        p2.nomeMae = "Barbara";
        p2.sexo = Sexo.MASCULINO;
        ep2.bairro = "Giovanini";
        ep2.cidade = "Coronel Fabriciano";
        ep2.rua = "Paquetá";
        ep2.numero = 69;
        p2.endereco = ep2;
        this.adicionar(p2);

        Paciente p3 = new Paciente();
        Endereco ep3 = new Endereco();
        p3.numCNS = 1278479;
        p3.nome = "Jet";
        p3.nomeMae = "Helena";
        p3.sexo = Sexo.MASCULINO;
        ep3.bairro = "Canaã";
        ep3.cidade = "Ipatinga";
        ep3.rua = "Isaías";
        ep3.numero = 777;
        p3.endereco = ep3;
        this.adicionar(p3);

        Paciente p4 = new Paciente();
        Endereco ep4 = new Endereco();
        p4.numCNS = 2972004;
        p4.nome = "Augusto";
        p4.nomeMae = "Diana";
        p4.sexo = Sexo.MASCULINO;
        ep4.bairro = "Primavera";
        ep4.cidade = "Timóteo";
        ep4.rua = "Carmélia";
        ep4.numero = 66;
        p4.endereco = ep4;
        this.adicionar(p4);

        Paciente p5 = new Paciente();
        Endereco ep5 = new Endereco();
        p5.numCNS = 2972004;
        p5.nome = "Clara";
        p5.nomeMae = "Ana";
        p5.sexo = Sexo.FEMININO;
        ep5.bairro = "Iguaçu";
        ep5.cidade = "Ipatinga";
        ep5.rua = "Ametista";
        ep5.numero = 13;
        p5.endereco = ep5;
        this.adicionar(p5);
    }
}
