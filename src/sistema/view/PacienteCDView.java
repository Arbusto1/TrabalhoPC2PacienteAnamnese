package sistema.view;

import sistema.models.Deficiencia;
import sistema.models.Endereco;
import sistema.models.Paciente;
import sistema.models.PacienteComDeficiencia;
import sistema.models.Sexo;

public class PacienteCDView extends PacienteView {

    @Override
    public Paciente lerPaciente() {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "CADASTRO DE PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

        PacienteComDeficiencia pd = new PacienteComDeficiencia();
        Endereco e = new Endereco();
        for (;;) {

            try {

                System.out.println("");
                System.out.println("Qual o nome do Paciente? ");
                pd.setNome(sc.nextLine());
                System.out.println("Qual o nome da mãe? ");
                pd.setNomeMae(sc.nextLine());

                System.out.println("Qual o sexo do paciente? (Digite 1 para MASCULINO 2 para"
                        + " FEMININO e 3 para INTERSEXO)");
                for (;;) {

                    int s = sc.nextInt();
                    sc.nextLine();
                    if (s == 1) {

                        pd.setSexo(Sexo.MASCULINO);
                        break;
                    } else if (s == 2) {

                        pd.setSexo(Sexo.FEMININO);
                        break;
                    } else if (s == 3) {

                        pd.setSexo(Sexo.INTERSEXO);
                        break;
                    } else {
                        System.out.println("Insira um número válido!");
                    }
                }

                System.out.println("Qual a deficiência do paciente? (Digite 1"
                        + " para MOTORA, 2 para MENTAL, 3 para VISUAL)");

                for (;;) {

                    int s = sc.nextInt();
                    sc.nextLine();
                    if (s == 1) {

                        pd.setDeficiencia(Deficiencia.MOTORA);
                        break;
                    } else if (s == 2) {

                        pd.setDeficiencia(Deficiencia.MENTAL);
                        break;
                    } else if (s == 3) {

                        pd.setDeficiencia(Deficiencia.VISUAL);
                        break;
                    } else {
                        System.out.println("Insira um número válido!");
                    }
                }

                System.out.println("Qual foi seu fator complicador? ");
                pd.setFatorComplicador(sc.nextLine());

                System.out.println("Qual a cidade onde mora? ");
                e.setCidade(sc.nextLine());
                System.out.println("Qual o bairo? ");
                e.setBairro(sc.nextLine());
                System.out.println("Qual a rua? ");
                e.setRua(sc.nextLine());
                System.out.println("Qual o número da residência?");
                e.setNumero(sc.nextInt());
                sc.nextLine();
                pd.setEndereco(e);
                break;

            } catch (Exception ex) {

                System.out.println("\n Algum valor não está compatível, por favor"
                        + " tente novamente com os dados corretos\n");
            }
            break;
        }
        return pd;
    }
}
