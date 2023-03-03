package negocio;

public class Teste {
    // instanciando os objetos
    public static void main(String[] args) {
        //cadastrando usuario
        Endereco e1 = new Endereco(71, 2, "rua maria", "casa 12");
        Pagamento p1 = new Pagamento(555, 987, 2023);
        Telefone t1 = new Telefone(61, 999);
        Usuario u1 = new Usuario(1, "Raquel", 1234, t1, p1, e1);

        Endereco e2 = new Endereco(92, 9, "avenida parque", "casa 2");
        Pagamento p2 = new Pagamento(5033, 241, 1922);
        Telefone t2 = new Telefone(61, 988);
        Usuario u2 = new Usuario(2, "Vera", 531, t2, p2, e2);

        System.out.println(u1.toString() + "\n");

        Blusa b1 = new Blusa(1, "Cropped pra reagir", "Renner",
                29, "feminino", "Leve e confortavel",
                "Preto", "M", "Cropped", u1);

        Blusa b2 = new Blusa(2, "Blusa manga longa", "Shein",
                58.90, "feminino", "", "preto",
                "Tamanhos disponiveis: P M G ", "Manga longa", u2);

        System.out.println(b1.toString() + "\n");
        System.out.println(b2);

        Calca c1 = new Calca(2, "Jeans básico", "C&a",
                44.9, "masculino", "Para usar no cotidiano",
                "Azul", "42", "Jeans", u1);

        Calca c2 = new Calca(3, "Calca cargo", "Renner",
                119.90, "feminina", "Tecido leve e confortavel com bolsos lateraisna perna",
                "Proto", "38", "Cargo", u2);


        Bijuteria bj1 = new Bijuteria(2, "Gargantilha gotica", "Romanel",
                20.5, "Feminino", "Gargantilha estilo anos 90, bem gótica suave",
                "Preto", "U", "Colar", u1);

        Bijuteria bj2 = new Bijuteria(4, "Pulseira", "Shein",
                45.50, "Feminino", "",
                "Prata", "U", "Pulseira", u2);


        //ADICIONANDO PRODUTO AO CARRINHO

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(b1);
        carrinho.adicionarProduto(c1);
        carrinho.adicionarProduto(c2);
        carrinho.adicionarProduto(bj1);
        carrinho.adicionarProduto(bj2);

        //System.out.println(cr1.valorProdutos()+"\n");
        System.out.println(carrinho.toString() + "\n");

        Compra compra1 = new Compra("12/03/2020", "Esperando pagamento", 1, u2, carrinho);
        System.out.println(compra1.toString() + "\n");
    }

}
