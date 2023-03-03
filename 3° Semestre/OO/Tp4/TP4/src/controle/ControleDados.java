package controle;

import modelo.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class ControleDados {
    private Dados d = new Dados();

    public ControleDados() {
        d.preDados();
    }

    /**
     * Valid os dodos inserir/editar de Usuario
     * @param dadosUsuario exporta os dados de um novo Usuario
     * @return true quando for autorizado a inserir e/ou editar um Usuario
     */
    public boolean inserirEditarUsuario(String[] dadosUsuario) {
        //0 - idUsuario; 1 - nome;2 - cpf; 3 - telefone; 4 - pagamento; 5 - endereco;
        Usuario p = new Usuario(Integer.parseInt(dadosUsuario[0]), dadosUsuario[1], Integer.parseInt(dadosUsuario[2]),
                new Telefone(Integer.parseInt(dadosUsuario[3]), Integer.parseInt(dadosUsuario[4])), //telefone
                null, //pagamento
                new Endereco(Integer.parseInt(dadosUsuario[9]), Integer.parseInt(dadosUsuario[8]), dadosUsuario[6], dadosUsuario[7])); //endere�o
        return d.inserirEditarUsuario(p);
    }

    /**
     *Metodo para remover um Usuario
     * @param posicao refente a posicao do Usuario que vai ser reovido
     * @return
     */

    public boolean removerUsuario(int posicao) {
        return this.getUsuarios().remove(this.getUsuarios().get(posicao));
    }

    /**
     * Valida os dodos inserir/editar de Blusa
     * @param dadosBlusa exporta os dados de um novo Usuario
     * @return true quando for autorizado a inserir e/ou editar um Usuario
     */
    public boolean inserirEditarBlusa(String[] dadosBlusa) {
        Blusa p = new Blusa(Integer.parseInt(dadosBlusa[0]), //ID
                dadosBlusa[1], //nome
                dadosBlusa[2], //marca
                Float.parseFloat(dadosBlusa[3]), //preco
                dadosBlusa[4], //departamento
                dadosBlusa[5], //descricao
                dadosBlusa[6], //cor
                dadosBlusa[7], //tamanho
                dadosBlusa[8], //modeloblusa
                null); //usuario(vendedor)
        d.inserirEditarBlusa(p, Integer.parseInt(dadosBlusa[0]));
        return true;
    }

    /**
     * Método para remover uma blusa
     * @param i posição da blusa que vai ser removido
     * @return true se a blusa foi removido
     */
    public boolean removerBlusa(int i) {
        String blusaRemovida = d.getBlusas()[i].getNome();

        if (i == (d.getQtdBlusas() - 1)) {
            d.setQtdBlusas(d.getQtdBlusas() - 1);
            d.getBlusas()[d.getQtdBlusas()] = null;
            return true;
        } else {
            int cont = 0;
            while (d.getBlusas()[cont].getNome().compareTo(blusaRemovida) != 0) {
                cont++;
            }

            for (int j = cont; j < d.getQtdBlusas() - 1; j++) {
                d.getBlusas()[j] = null;
                d.getBlusas()[j] = d.getBlusas()[j + 1];
            }
            d.getBlusas()[d.getQtdBlusas()] = null;
            d.setQtdBlusas(d.getQtdBlusas() - 1);
            return true;
        }

    }

    /**
     * Valida os dodos inserir/editar de calca
     * @param dadosCalca exporta os dados de uma nova Calca
     * @return true quando for autorizado a inserir e/ou editar um Usuario
     */
    // CALCAS -------------
    public boolean inserirEditarCalca(String[] dadosCalca) {
        Calca p = new Calca(Integer.parseInt(dadosCalca[0]), dadosCalca[1], dadosCalca[2], Float.parseFloat(dadosCalca[3]), dadosCalca[4], dadosCalca[5], dadosCalca[6], dadosCalca[7], dadosCalca[8], null);
        d.inserirEditarCalca(p, Integer.parseInt(dadosCalca[0]));
        return true;
    }
    /**
     * Método para remover uma calca
     * @param i posição da calca que vai ser removido
     * @return true se a calca foi removido
     */
    public boolean removerCalca(int i) {
        String calcaRemovida = d.getCalcas()[i].getNome();

        if (i == (d.getQtdCalcas() - 1)) {
            d.setQtdCalcas(d.getQtdCalcas() - 1);
            d.getCalcas()[d.getQtdCalcas()] = null;
            return true;
        } else {
            int cont = 0;
            while (d.getCalcas()[cont].getNome().compareTo(calcaRemovida) != 0) {
                cont++;
            }

            for (int j = cont; j < d.getQtdCalcas() - 1; j++) {
                d.getCalcas()[j] = null;
                d.getCalcas()[j] = d.getCalcas()[j + 1];
            }
            d.getCalcas()[d.getQtdCalcas()] = null;
            d.setQtdCalcas(d.getQtdCalcas() - 1);
            return true;
        }

    }

    /**
     * Valid os dodos inserir/editar de bijuteria
     * @param dadosBijus exporta os dados de uma nova bijuteria
     * @return true quando for autorizado a inserir e/ou editar uma Bijuteria
     */
    // BIJUS --------------
    public boolean inserirEditarBijus(String[] dadosBijus) {
        Bijuteria p = new Bijuteria(Integer.parseInt(dadosBijus[0]), dadosBijus[1], dadosBijus[2], Float.parseFloat(dadosBijus[3]), dadosBijus[4], dadosBijus[5], dadosBijus[6], dadosBijus[7], dadosBijus[8], null);
        d.inserirEditarBiju(p, Integer.parseInt(dadosBijus[0]));
        return true;
    }

    /**
     * Método para remover uma Bijuteria
     * @param i posição da bijuteria que vai ser removido
     * @return true se a bijuteria foi removido
     */
    public boolean removerBiju(int i) {
        String bijuRemovida = d.getBijus()[i].getNome();

        if (i == (d.getQtdBijus() - 1)) {
            d.setQtdBijus(d.getQtdBijus() - 1);
            d.getBijus()[d.getQtdBijus()] = null;
            return true;
        } else {
            int cont = 0;
            while (d.getBijus()[cont].getNome().compareTo(bijuRemovida) != 0) {
                cont++;
            }

            for (int j = cont; j < d.getQtdBijus() - 1; j++) {
                d.getBijus()[j] = null;
                d.getBijus()[j] = d.getBijus()[j + 1];
            }
            d.getBijus()[d.getQtdBijus()] = null;
            d.setQtdBijus(d.getQtdBijus() - 1);
            return true;
        }
    }

    //-------------Gets e sets----------------

    public Dados getDados() {
        return d;
    }

    public void setDados(Dados d) {
        this.d = d;
    }

    public List<Usuario> getUsuarios() {
        return this.d.getUsuarios();
    }

    public Blusa[] getBlusas() {
        return this.d.getBlusas();
    }

    public int getQtdBlusas() {
        return this.d.getQtdBlusas();
    }

    public Bijuteria[] getBijus() {
        return this.d.getBijus();
    }

    public int getQtdBijus() {
        return this.d.getQtdBijus();
    }

    public Calca[] getCalcas() {
        return this.d.getCalcas();
    }

    public int getQtdCalcas() {
        return this.d.getQtdCalcas();
    }

    public Carrinho getCarrinho() {
        return this.d.getCarrinho();
    }

    public int getQtdItensCarrs() {
        return this.d.getQtdItensCarrs();
    }

    public List<Compra> getCompras() {
        return this.d.getCompras();
    }

    public int getQtdCompras() {
        return this.d.getQtdCompras();
    }


}