package controle;

import modelo.*;

import java.util.List;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class ControleUsuarios {
    // implementar metodo para lidar com usuarios (incluindo pagamento, endere�o e telefone)
    private List<Usuario> usuarios;

    /**
     *
     * @param d referente a controle dados
     */
    public ControleUsuarios(ControleDados d) {
        this.usuarios = d.getUsuarios();
    }

    /**
     *
     * @return nomes de usuarios
     */
    public String[] getNomes() {
        String[] nomes = new String[this.usuarios.size()];

        for (int i = 0; i < this.usuarios.size(); i++) {
            nomes[i] = this.usuarios.get(i).getNome();
        }

        return nomes;
    }


    //-------------Gets e sets----------------

    public Telefone getTelefone(int i) {
        return this.usuarios.get(i).getTelefone();
    }

    public Pagamento getPagamento(int i) {
        return this.usuarios.get(i).getPagamento();
    }

    public Endereco getEndereco(int i) {
        return this.usuarios.get(i).getEndereco();
    }


}
