package trabalhopc2pacienteanamnese;

public class Usuario {

    private static int contador;
    private long id;
    private String login, nomeLogin, senha;
    private Enum tipoUsuario;
    
    public Usuario(){
        
    }

    public Usuario(String login, String nomeLogin, String senha, Enum tipoUsuario) {
        contador++;
        this.id = contador;
        this.login = login;
        this.nomeLogin = nomeLogin;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }
    
     public static Usuario getInstance( String login, String nomeLogin, String senha, Enum tipoUsuario){
       if(login!=null && nomeLogin!= null && senha!=null && tipoUsuario!=null)
            return new Usuario(login,nomeLogin,senha ,tipoUsuario);
       
        return null;
    }
     
     boolean verificaruUsuarioPorNomeLogin(String nome){
        if(nome.equals(this.nomeLogin)){
            return true;
        }
        return false;
    }
    
    boolean verificaruSenhaDoUsuario(String senha){
        if(senha.equals(this.senha)){
            return true;
        }
        return false;
    }

    public long getId() {
        return id;
    }
     public static int getContador() {
        return contador;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Enum getTipo() {
        return tipoUsuario;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipoUsuario = tipo;
    }

}
