package sistema.view;

import java.util.Scanner;

public class MenuView {

    private static Scanner sc = new Scanner(System.in);

    public int menuPaciente() {

        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "MENU ATENDENTE *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para CADASTRAR UM PACIENTE");
        System.out.println("Digite 2 para CADASTRAR UM PACIENTE COM DEFICIÊNCIA");
        System.out.println("Digite 3 para ALTERAR UM PACIENTE");
        System.out.println("Digite 4 para EXCLUIR UM PACIENTE");
        System.out.println("Digite 5 para LISTAR OS PACIENTES");

        System.out.print("Digite aqui: ");
        return sc.nextInt();
    }

    public int menuUsuario() {

        System.out.println("*********** SISTEMA DE CONSULTAS ***************\n");
        System.out.println("1 - LOGIN");
        System.out.println("2 - CADASTRO DE USUÁRIO");
        System.out.println("3 - EXCLUIR USUARIO");
        System.out.println("4 - ALTERAR USUÁRIO");
        System.out.println("5 - LISTAR USUÁRIO");
        System.out.println("0 - SAIR");

        System.out.print("Digite aqui: ");
        return sc.nextInt();
    }

    public int menuAnamnese() {
        
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "MENU MEDICO *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

        System.out.println("Digite 0 para sair ");
        System.out.println("Digite 1 para ADICIONAR UMA NOVA ANAMNESE ");
        System.out.println("Digite 2 para ALTERAR UMA ANAMNESE ");
        System.out.println("Digite 3 para LISTAR ANAMNESES ");
        System.out.println("Digite 4 para BUSCAR UMA ANAMNESE ");

        System.out.print("Digite aqui: ");
        return sc.nextInt();
    }
}
