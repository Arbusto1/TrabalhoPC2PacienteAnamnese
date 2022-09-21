package trabalhopc2pacienteanamnese;

public class Paciente {

    long numCNS;
    String nome, nomeMae;
    Sexo sexo;
    Endereco endereco;
    
    void init(){
        
        Paciente p1 = new Paciente();
        p1.numCNS = 164584;
        p1.nome = "Jão";
        p1.nomeMae = "Renata";
        p1.sexo = Sexo.MASCULINO;
        p1.endereco.bairro = "Melo Viana";
        p1.endereco.cidade = "Coronel Fabriciano";
        p1.endereco.rua = "Jasmim";
        p1.endereco.numero = 58;
        
        Paciente p2 = new Paciente();
        p1.numCNS = 1678454;
        p1.nome = "Emershow";
        p1.nomeMae = "Barbara";
        p1.sexo = Sexo.MASCULINO;
        p1.endereco.bairro = "Giovanini";
        p1.endereco.cidade = "Coronel Fabriciano";
        p1.endereco.rua = "Paquetá";
        p1.endereco.numero = 69;
        
        Paciente p3 = new Paciente();
        p1.numCNS = 1278479;
        p1.nome = "Jet";
        p1.nomeMae = "Helena";
        p1.sexo = Sexo.MASCULINO;
        p1.endereco.bairro = "Canaã";
        p1.endereco.cidade = "Ipatinga";
        p1.endereco.rua = "Isaías";
        p1.endereco.numero = 777;
        
        Paciente p4 = new Paciente();
        p1.numCNS = 2972004;
        p1.nome = "Augusto";
        p1.nomeMae = "Diana";
        p1.sexo = Sexo.MASCULINO;
        p1.endereco.bairro = "Primavera";
        p1.endereco.cidade = "Timóteo";
        p1.endereco.rua = "Carmélia";
        p1.endereco.numero = 66;
    }
}
