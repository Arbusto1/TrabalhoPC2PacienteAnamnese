package sistema.models;

public class Usuario implements Cloneable {

    protected static int contador;
    protected long id;
    protected String nome, login, senha;
    protected Enum tipoUsuario;

    public Usuario() {
        contador++;
        this.id = contador;
    }

    public Usuario(String login, String nomeLogin, String senha, Enum tipoUsuario) {
        this();
        this.nome = login;
        this.login = nomeLogin;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public static Usuario getInstance(String login, String nomeLogin, String senha, Enum tipoUsuario) {
        if (login != null && nomeLogin != null && senha != null && tipoUsuario != null) {
            return new Usuario(login, nomeLogin, senha, tipoUsuario);
        }

        return null;
    }
    
    @Override
    public Usuario clone() throws CloneNotSupportedException {
        return (Usuario) super.clone();
    }

    public Usuario(Usuario u) {
        this.id = u.id;
        this.nome = u.nome;
        this.login = u.login;
        this.senha = senha;
        this.tipoUsuario = u.tipoUsuario;
    }

    public boolean verificaruUsuarioPorNomeLogin(String nome) {
        if (nome.equals(this.login)) {
            return true;
        }
        return false;
    }

    public boolean verificaruSenhaDoUsuario(String senha) {
        if (senha.equals(this.senha)) {
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

    public String getNome() {
        return nome;
    }

    public void setLogin(String login) {
        this.nome = login;
    }

    public String getLogin() {
        return login;
    }

    public void setNomeLogin(String nomeLogin) {
        this.login = nomeLogin;
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

    public void setId(long id) {
        this.id = id;
    }

}
