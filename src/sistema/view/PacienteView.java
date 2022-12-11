package sistema.view;

import java.util.List;
import java.util.Scanner;
import sistema.models.Endereco;
import sistema.models.Paciente;
import sistema.models.Sexo;

public class PacienteView {

    private Scanner sc;

    public PacienteView() {
        sc = new Scanner(System.in);
    }

    public Paciente lerPaciente() {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "CADASTRO DE PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

        Paciente p = new Paciente();
        Endereco e = new Endereco();
        for (;;) {

            try {

                System.out.println("");
                System.out.println("Qual o nome do Paciente? ");
                p.setNome(sc.nextLine());
                System.out.println("Qual o nome da mãe? ");
                p.setNomeMae(sc.nextLine());

                System.out.println("Qual o sexo do paciente? (Digite 1 para MASCULINO 2 para"
                        + " FEMININO e 3 para INTERSEXO)");
                for (;;) {

                    int s = sc.nextInt();
                    sc.nextLine();
                    if (s == 1) {

                        p.setSexo(Sexo.MASCULINO);
                        break;
                    } else if (s == 2) {

                        p.setSexo(Sexo.FEMININO);
                        break;
                    } else if (s == 3) {

                        p.setSexo(Sexo.INTERSEXO);
                        break;
                    } else {
                        System.out.println("Insira um número válido!");
                    }
                }

                System.out.println("Qual a cidade onde mora? ");
                e.setCidade(sc.nextLine());
                System.out.println("Qual o bairo? ");
                e.setBairro(sc.nextLine());
                System.out.println("Qual a rua? ");
                e.setRua(sc.nextLine());
                System.out.println("Qual o número da residência?");
                e.setNumero(sc.nextInt());
                sc.nextLine();
                p.setEndereco(e);
                break;

            } catch (Exception ex) {

                System.out.println("\n Algum valor não está compatível, por favor"
                        + " tente novamente com os dados corretos\n");
            }
            break;
        }
        return p;
    }

    public void listar(List<Paciente> pac) {
        System.out.printf("%7s%16s%16s%%8s%16s%16s%16s%4s", "numCNS", "Nome",
                "Nome da Mãe", "Sexo", "Cidade", "Bairro", "Rua",
                "Número da residência");
        System.out.println("\n");
        for (Paciente p : pac) {
            System.out.printf("%7s%16s%16s%%8s%16s%16s%16s%4s", p.getNumCNS(),
                    p.getNome(), p.getNomeMae(), p.getSexo(),
                    p.getEndereco().getCidade(), p.getEndereco().getBairro(),
                    p.getEndereco().getRua(), p.getEndereco().getNumero() + "\n");
        }
        System.out.println("\n");
    }

    public void print(String mns) {
        System.out.println(mns);
    }

    public Paciente alterar(Paciente p) {
        Paciente pAlt = lerPaciente();
        pAlt.setnumCNS(p.getNumCNS());
        return pAlt;
    }

    public long pegaId() {
        long id = 0;

        for (;;) {
            try {
                System.out.println("Insira o ID: ");
                id = sc.nextLong();
                return id;
            } catch (Exception e) {
            }
        }
    }
}
