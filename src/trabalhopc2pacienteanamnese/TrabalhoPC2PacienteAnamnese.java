package trabalhopc2pacienteanamnese;

import java.util.Random;
import java.util.Scanner;

public class TrabalhoPC2PacienteAnamnese {

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {

        int select;
        Sistema sistema = new Sistema();
        sistema.init();

        do {

            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                    + "CADASTRO DE PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("Digite 0 para sair");
            System.out.println("Digite 1 para cadastrar um paciente");
            System.out.println("Digite 2 para alterar um paciente");
            System.out.println("Digite 3 para excluir um paciente");
            System.out.println("Digite 4 para buscar um pacientes");
            System.out.println("Digite 5 para listar os pacientes");
            System.out.println("Digite aqui: ");
            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                    + "*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");

            select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                
                case 0:
                    break;
                    
                case 1:
                    
                    if (sistema.adicionar(sistema.registrarPac())) {

                        System.out.println("O paciente foi adicionado com sucesso!");
                    } else {
                        
                        System.out.println("Não foi possível cadastrar o paciente");
                    }
                    break;
                    
                case 2:
                    
                    System.out.println("Qual o nome do paciente? ");
                    String nome = sc.nextLine();
                    System.out.println("Qual o nome da mão desse paciente?");
                    String nomeM = sc.nextLine();
                    
                    if (sistema.alterar(nome, nomeM)) {
                        
                        System.out.println("Paciente alterado com sucesso!");
                    } else {
                        
                        System.out.println("Não foi possível alterar o paciente");
                    }
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    
                    System.out.println("Qual o nome do paciente a ser buscado? ");
                    String nomeB = sc.nextLine();
                    System.out.println("Qual o ome da Mãe? ");
                    String nomeMB = sc.nextLine();
                    if (sistema.buscarPac(nomeB, nomeMB)) {
                        System.out.println("O paciente existe!");
                    } else {
                        System.out.println("Paciente não encontrado!");
                    }
                    break;
                    
                case 5:
                    
                    System.out.println("");
                    sistema.listarPac();
                    System.out.println("");
                    break;
            }
        } while (select != 0);
    }

}
