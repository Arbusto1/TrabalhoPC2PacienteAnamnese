// GRUPO: BIANCA , AUGUSTO
package sistema;

import sistema.models.Sexo;
import sistema.models.TipoUsuario;
import sistema.models.Usuario;
import sistema.models.Paciente;
import sistema.models.Anamnese;
import java.util.Scanner;

public class AntMain {

    static Scanner sc = new Scanner(System.in);
    
    static AntSistema sistema = AntSistema.getInstance();

    public static void main(String[] args) {

        int select = 0;
        int selectt = 0;
        int selecttt = 0;
        do {
            sistema.init();
            System.out.println("*********** SISTEMA DE CONSULTAS ***************\n");
            System.out.println("1 - LOGIN");
            System.out.println("2 - CADASTRO DE USUÁRIO");
            System.out.println("3 - EXCLUIR USUARIO");
            System.out.println("4 - ALTERAR USUÁRIO");
            System.out.println("5 - LISTAR USUÁRIO");
            System.out.println("0 - SAIR");

            System.out.print("Digite aqui: ");
            selectt = sc.nextInt();

            switch (selectt) {
                case 1:
                    Scanner scn = new Scanner(System.in);

                    System.out.println("*********** TELA DE LOGIN ***************\n");
                    boolean verificador = false;
                    int x;
                    do {
                        System.out.print("\nInsira seu nome de Login: ");
                        String nome = scn.next();

                        System.out.print("\nInsira sua senha: ");
                        String senha = scn.next();

                        x = sistema.VerificarSeUsuarioExiste(nome);
                        if (x > -1) {
                            if (sistema.VerificarSenhaDoUsuario(senha, x)) {
                                System.out.println("\nLogin realizado com sucesso!\n---------------------------------------------------------------");
                            }
                            verificador = true;
                        } else {
                            System.out.println("\n-----------------------------------------------\nUsuário ou senha inválidos!\n-----------------------------------------------");
                        }

                    } while (verificador != true);

                    int opcao1;
                    if (sistema.VerificarTipoDoUsuario(x) == TipoUsuario.ATENDENTE) {
                        opcao1 = 1;
                    } else {
                        opcao1 = 2;
                    }
                    switch (opcao1) {
                        case 1:
                            do {

                                System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                        + "MENU ATENDENTE *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                                System.out.println("Digite 0 para sair");
                                System.out.println("Digite 1 para CADASTRAR UM PACIENTE");
                                System.out.println("Digite 2 para ALTERAR UM PACIENTE");
                                System.out.println("Digite 3 para EXCLUIR UM PACIENTE");
                                System.out.println("Digite 4 para LISTAR OS PACIENTES");
                                System.out.print("Digite aqui: ");

                                select = sc.nextInt();
                                sc.nextLine();
                                System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                        + "*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                                switch (select) {

                                    case 0:
                                        break;

                                    case 1:
                                        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                                + "CADASTRO DE PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

                                        Paciente p = new Paciente();
                                        String cidade,
                                         bairro,
                                         rua;
                                        int numRes;

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
                                                cidade = sc.nextLine();
                                                System.out.println("Qual o bairo? ");
                                                bairro = sc.nextLine();
                                                System.out.println("Qual a rua? ");
                                                rua = sc.nextLine();
                                                System.out.println("Qual o número da residência?");
                                                numRes = sc.nextInt();
                                                sc.nextLine();
                                                break;

                                            } catch (Exception e) {

                                                System.out.println("");
                                                System.out.println("Algum valor não está compatível, por favor"
                                                        + " tente novamente com os dados corretos");
                                                System.out.println("");
                                            }
                                        }
                                        p.addEndereco(cidade, bairro, rua, numRes);

                                        if (sistema.adicionarPaciente(p)) {

                                            System.out.println("O paciente foi adicionado com sucesso!");
                                        } else {

                                            System.out.println("Não foi possível cadastrar o paciente");
                                        }
                                        break;

                                    case 2:

                                        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                                + "ALTERAR PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

                                        System.out.println("Qual o nome do paciente? ");
                                        String nomeP = sc.nextLine();
                                        System.out.println("Qual o nome da mãe desse paciente?");
                                        String nomeM = sc.nextLine();

                                        if (sistema.auxAlterarPac(nomeP, nomeM)) {
                                            Paciente p1 = new Paciente();
                                            String cidad, bairo, ru;
                                            int numR;

                                            for (;;) {

                                                try {

                                                    System.out.println("");
                                                    System.out.println("Qual o nome do Paciente? ");
                                                    p1.setNome(sc.nextLine());
                                                    System.out.println("Qual o nome damãe? ");
                                                    p1.setNomeMae(sc.nextLine());

                                                    System.out.println("Qual o sexo do paciente? (Digite 1 para MASCULINO 2 para"
                                                            + " FEMININO e 3 para INTERSEXO)");
                                                    for (;;) {

                                                        int s = sc.nextInt();
                                                        sc.nextLine();
                                                        if (s == 1) {

                                                            p1.setSexo(Sexo.MASCULINO);
                                                            break;
                                                        } else if (s == 2) {

                                                            p1.setSexo(Sexo.FEMININO);
                                                            break;
                                                        } else if (s == 3) {

                                                            p1.setSexo(Sexo.INTERSEXO);
                                                            break;
                                                        } else {
                                                            System.out.println("Insira um número válido!");
                                                        }
                                                    }

                                                    System.out.println("Qual a cidade onde mora? ");
                                                    cidad = sc.nextLine();
                                                    System.out.println("Qual o bairo? ");
                                                    bairo = sc.nextLine();
                                                    System.out.println("Qual a rua? ");
                                                    ru = sc.nextLine();
                                                    System.out.println("Qual o número da residência?");
                                                    numR = sc.nextInt();
                                                    sc.nextLine();
                                                    break;
                                                } catch (Exception e) {

                                                    System.out.println("");
                                                    System.out.println("Algum valor não está compatível, por favor"
                                                            + " tente novamente com os dados corretos");
                                                    System.out.println("");
                                                }
                                            }
                                            p1.addEndereco(cidad, bairo, ru, numR);

                                            if (sistema.alterarPac(nomeP, nomeM, p1)) {
                                                System.out.println("Paciente alterado com sucesso!");
                                            } else {
                                                System.out.println("!!!! Não foi possível alterar o paciente !!!!");
                                            }
                                        } else {
                                            System.out.println("!!!! Não foi possível encontrar o paciente !!!!");
                                        }
                                        break;

                                    case 3:

                                        System.out.println("Qual o nome do paciente a ser excluido? ");
                                        String nomee = sc.nextLine();
                                        System.out.println("Qual o nome da mãe do paciente? ");
                                        String nomeMe = sc.nextLine();

                                        if (sistema.excluirPac(nomee, nomeMe)) {

                                            System.out.println("O paciente foi excluido com sucesso!");
                                        } else {

                                            System.out.println("!!!! Não foi possível excluir o paciente !!!!");
                                        }

                                        break;

                                    case 4:

                                        System.out.println("");
                                        sistema.listarPac();
                                        System.out.println("");
                                        break;

                                }
                            } while (select != 0);
                            break;

                        case 2:
                            do {

                                System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                        + "MENU MEDICO *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

                                System.out.println("Digite 0 para sair ");
                                System.out.println("Digite 1 para ADICIONAR UMA NOVA ANAMNESE ");
                                System.out.println("Digite 2 para ALTERAR UMA ANAMNESE ");
                                System.out.println("Digite 3 para LISTAR ANAMNESES ");
                                System.out.println("Digite 4 para BUSCAR UMA ANAMNESE ");

                                System.out.print("Digite aqui: ");

                                select = sc.nextInt();
                                sc.nextLine();
                                System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                        + "*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                                switch (select) {

                                    case 1:

                                        Anamnese a = new Anamnese();
                                        Paciente c = new Paciente();
                                        Scanner sc = new Scanner(System.in);

                                        System.out.print("NÚMERO DA CNSS DO PACIENTE:  ");
                                        long numCNS2 = sc.nextInt();

                                        if (sistema.buscarCNS(numCNS2) != null) {
                                            System.out.println("");
                                            System.out.println("PACIENTE: " + sistema.buscarCNS(numCNS2).getNome());
                                            System.out.println("");
                                            System.out.println("RELATO DO PACIENTE:");
                                            a.setRelato(sc.next());
                                            sc.nextLine();
                                            System.out.println("MOTIVO: ");
                                            a.setMotivo(sc.next());
                                            sc.nextLine();
                                            System.out.println("DIAGNOÓSTICO DA DO CASO");
                                            a.setDiagnostico(sc.next());
                                            sc.nextLine();
                                            a.setPaciente(sistema.buscarCNS(numCNS2));

                                            sistema.AdicionarAnamnese(a);
                                            sistema.AdicionarAnam(a.getPaciente(), a);

                                            System.out.println("*=*=*=* ANAMNESE REGISTRADA COM SUCESSO *=*=*=*");
                                        } else {
                                            System.out.println("CNS NÃO ENCONTRADA");
                                        }

                                        break;

                                    case 2:
                                        Scanner scnn = new Scanner(System.in);
                                        System.out.println("NOME DO PACIENTE:  ");
                                        String nome = scnn.next();
                                        Anamnese[] nomess = new Anamnese[10];

                                        if (sistema.buscarNomeAnam(nome) != null) {
                                            System.out.println("ID " + "\t" + "NOME \t" + "NOME DA MÃE \t");
                                            nomess = sistema.buscarNomeAnam(nome);
                                            int j = 0;
                                            for (int i = 0; i < sistema.buscarNomeAnam(nome).length; i++) {
                                                if (nomess[i] != null) {
                                                    System.out.println(i + "\t" + nomess[i].getPaciente().getNome() + "\t" + nomess[i].getPaciente().getNomeMae());
                                                    j = +1;
                                                }
                                            }
                                        } else {
                                            System.out.println("PACIENTE NÃO ENCONTRADO");
                                        }

                                        System.out.println("DIGITE O ID DA ANAMNESE QUE DESJA ALTERAR ANAMNESE ");
                                        int escolha = scn.nextInt();
                                        int y = sistema.identificarID(escolha, nomess);

                                        nomess[y].setDiagnostico(null);
                                        nomess[y].setMotivo(null);
                                        nomess[y].setRelato(null);
                                        Scanner scc = new Scanner(System.in);
                                        System.out.println("MOTIVO: ");
                                        nomess[y].setMotivo(scc.next());
                                        System.out.println("RELATO DO PACIENTE: ");
                                        nomess[y].setRelato(scc.next());
                                        System.out.println("DIAGNÓSTICO");
                                        nomess[y].setDiagnostico(scc.next());
                                        sistema.AdicionarAnamnese(nomess[y]);
                                        System.out.println("*=*=*=* ANAMNESE ALTERADA COM SUCESSO *=*=*=*\n");

                                        break;

                                    case 3:
                                        System.out.println("*=*=*=*=*=*=* ANAMNESES *=*=*=*=*=*=*");
                                        sistema.listarTodasAnam();
                                        System.out.println("");
                                        break;

                                    case 4:
                                        Scanner sd = new Scanner(System.in);
                                        System.out.println("NOME DO PACIENTE:  ");
                                        String nomee = sd.next();
                                        Anamnese[] nomesss = new Anamnese[10];

                                        if (sistema.buscarNomeAnam(nomee) != null) {
                                            System.out.println("ID " + "\t" + "NOME \t" + "NOME DA MÃE \t");
                                            nomesss = sistema.buscarNomeAnam(nomee);

                                            for (int i = 0; i < sistema.buscarNomeAnam(nomee).length; i++) {
                                                if (nomesss[i] != null) {
                                                    System.out.println(i + "\t" + nomesss[i].getPaciente().getNome() + "\t" + nomesss[i].getPaciente().getNomeMae());

                                                }
                                            }
                                        } else {
                                            System.out.println("INVÁLIDO");
                                        }
                                        break;
                                }
                            } while (select != 0);

                            break;
                    }
                    break;

                case 2:

                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                            + "CADASTRO DE USUÁRIO *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

                    Usuario u = new Usuario();
                    String nomeLogin,
                     login,
                     senha;
                    TipoUsuario tipo;

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

                    if (sistema.addUsuario(u)) {

                        System.out.println("O usuário foi cadastrado com sucesso!");
                    } else {

                        System.out.println("Não foi possível cadastrar o usuário");
                    }
                    break;

                case 4:
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                            + "ALTERAR USUARIO*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

                    System.out.println("Qual o nome do Usuário? ");
                    String nomeU = sc.next();
                    System.out.println("Qual o login? ");
                    String loginU = sc.next();
                    System.out.println("Digite a senha ");
                    String senhaU = sc.next();

                    if (sistema.auxAlterarUsuario(loginU, senhaU, nomeU)) {
                        Usuario u1 = new Usuario();
                        String nomeUsu, senhaUsu, nomeLoginUsu;

                        for (;;) {

                            try {

                                System.out.println("");
                                System.out.println("Qual o nome do Usuário? ");
                                u1.setLogin(sc.next());
                                System.out.println("Qual o nome de Login? ");
                                u1.setNomeLogin(sc.next());
                                System.out.println("Digite a senha ");
                                u1.setSenha(sc.next());

                                System.out.println("Qual o tipo de usuario? (Digite 1 para MEDICO 2 para"
                                        + " ATENDENTE)");
                                for (;;) {

                                    int s = sc.nextInt();
                                    if (s == 1) {

                                        u1.setTipo(TipoUsuario.MEDICO);
                                        break;
                                    } else if (s == 2) {

                                        u1.setTipo(TipoUsuario.ATENDENTE);
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

                        if (sistema.alterarUsuario(loginU, senhaU, nomeU, u1)) {
                            System.out.println("Paciente alterado com sucesso!");
                        } else {
                            System.out.println("!!!! Não foi possível alterar o paciente !!!!");
                        }
                    } else {
                        System.out.println("!!!! Não foi possível encontrar o paciente !!!!");
                    }
                    break;
                case 3:
                    System.out.println("Qual o nome do usuário a ser excluido? ");
                    String nomeUsu = sc.nextLine();
                    System.out.println("Qual o nome de Login? ");
                    String nomeLoginn = sc.nextLine();
                    System.out.println("Digite a senha:  ");
                    String senhaa = sc.nextLine();

                    if (sistema.excluirUsuario(nomeUsu, nomeLoginn, senhaa)) {

                        System.out.println("O paciente foi excluido com sucesso!");
                    } else {

                        System.out.println("!!!! Não foi possível excluir o paciente !!!!");
                    }
                    break;
                case 5:
                    System.out.println("*=*=*=*=*=*=* USUÁRIOS *=*=*=*=*=*=*");
                    sistema.listarUsuario();
                    System.out.println("");
                    break;
                case 0:
                    break;
            }

        } while (selectt != 0);

    }

}
