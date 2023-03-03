package negocio;

public class Usuario {
    private int idUsuario;
    private String nome;
    private int cpf;
    private Telefone telefone;
    private Pagamento pagamento;
    private Endereco endereco;
    //private byte[] fotoPerfil;


    // --------- Metodo construtor ----------
    public Usuario(int idUsuario, String nome, int cpf, Telefone telefone, Pagamento pagamento, Endereco endereco/*, byte[] fotoPerfil*/) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.pagamento = pagamento;
        this.endereco = endereco;
        //this.fotoPerfil = fotoPerfil;
    }

    public String toString() {
        return "--------------Usuário--------------" +
                "\nID Usuário: " + idUsuario +
                "\nNome do aluno: " + nome +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nPagamento: " + pagamento +
                "\nEndereço: " + endereco;
    }

    public int toStringID() {
        return idUsuario;
    }

    //-------------- metodos ----------------
    public String cadastrarUsuario(String n) {
        return this.nome = n;
    }

    public void editarUsuario(String e) {
        this.nome = e;
    }

    public void buscarUsuario() {

    }

    public void excluirUsuario() {

    }


    // -----------gets e sets ------------

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


}