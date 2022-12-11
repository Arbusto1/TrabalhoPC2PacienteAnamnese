package sistema;

import sistema.controls.ControleAnamnese;
import sistema.controls.ControlePaciente;
import sistema.controls.ControleUsuario;
import sistema.date.IRepositorioPaciente;
import sistema.date.IRepositorioUsuario;
import sistema.view.MenuView;

public class Sistema {

    private ControleUsuario controleUsuario;
    private ControlePaciente controlePaciente;
    private ControleAnamnese controleAnamnese;
    private MenuView menuView;

    private static Sistema sistema;

    public static Sistema getInstance(IRepositorioUsuario repoUsu,
            IRepositorioPaciente repoPac) {
        if (sistema == null) {
            return sistema = new Sistema(repoUsu, repoPac);
        } else {
            return sistema;
        }
    }

    private Sistema(IRepositorioUsuario repoUsu, IRepositorioPaciente repoPac) {
        controleUsuario = new ControleUsuario(repoUsu);
        controlePaciente = new ControlePaciente(repoPac);
    }

    public void iniciar() {
        menuView = new MenuView();

        int select = 0;

        do {

            select = menuView.menuUsuario();
            switch (select) {
                case 1:

                    //login
                    break;
                case 2:

                    controleUsuario.inserir();
                    break;
                case 3:

                    controleUsuario.excluir();
                    break;
                case 4:

                    controleUsuario.alterar();
                    break;
                case 5:

                    controleUsuario.listar();
                    break;
                case 0:

                    System.out.println("Sistema desligado!");
                    break;
            }
        } while (select != 0);

    }
}
