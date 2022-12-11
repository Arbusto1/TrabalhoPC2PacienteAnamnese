package sistema.view;

import java.util.List;
import java.util.Scanner;
import sistema.models.TipoUsuario;
import sistema.models.Usuario;

public class UsuarioView {

    private Scanner sc;

    public UsuarioView() {
        sc = new Scanner(System.in);
    }

    public Usuario lerUsuario() {

        Usuario u = new Usuario();

        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "CADASTRO DE USUÁRIO *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        for (;;) {

            try {

                System.out.println("");
                System.out.println("Qual o nome do Usuário? ");
                u.setLogin(sc.next());
                System.out.println("Qual o nome de Login?");
                u.setNomeLogin(sc.next());
                System.out.println("Qual a senha?");
                u.setSenha(sc.next());

                System.out.println("Qual o tipo de usuario? (Digite 1 para MEDICO 2 para"
                        + " ATENDENTE)");
                for (;;) {

                    int s = sc.nextInt();
                    if (s == 1) {

                        u.setTipo(TipoUsuario.MEDICO);
                        break;
                    } else if (s == 2) {

                        u.setTipo(TipoUsuario.ATENDENTE);
                        break;
                    } else {
                        System.out.println("Insira um número válido!");
                    }
                }
                break;

            } catch (Exception e) {

                System.out.println("");
                System.out.println("Algum valor não está compatível, por favor"
                        + " tente novamente com os dados corretos");
                System.out.println("");
            }
        }
        return u;
    }

    public void listar(List<Usuario> us) {
        System.out.printf("%7s%16s%16s%7s", "ID", "Nome", "NomeLogin", "Senha");
        for (Usuario u : us) {
            System.out.printf("%7s%16s%16s%7s", u.getId(), u.getNome(), u.getLogin(), u.getSenha() + "\n");
        }
        System.out.println("\n");
    }

    public void print(String mns) {
        System.out.println(mns);
    }

    public Usuario altrar(Usuario u) {
        Usuario alt = lerUsuario();
        alt.setId(u.getId());
        return alt;
    }

    public long pegaId() {

        long pID = 0;

        for (;;) {
            try {
                System.out.println("Insira o ID: ");
                pID = sc.nextLong();
                break;
            } catch (Exception e) {
                System.out.println("Favor inserir um valor válido!");
            }
        }

        return pID;
    }
}
