package sistema;

import sistema.controls.ControleUsuario;
import sistema.date.IRepositorioUsuario;
import sistema.view.MenuView;

public class Sistema {

    private ControleUsuario controleUsuario;
    private MenuView menuView;

    private static Sistema sistema;

    public static Sistema getInstance(IRepositorioUsuario repoUsu) {
        if (sistema == null) {
            return sistema = new Sistema(repoUsu);
        } else {
            return sistema;
        }
    }

    private Sistema(IRepositorioUsuario repoUsu) {
        controleUsuario = new ControleUsuario(repoUsu);
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

                    System.out.println("Finalizado com sucesso!");
                    break;
            }
        } while (select != 0);

    }
}
