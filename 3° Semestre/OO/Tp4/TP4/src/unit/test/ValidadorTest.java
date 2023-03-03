package unit.test;

import org.junit.jupiter.api.Test;
import view.Validador;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorTest {

    @Test
    void isCPF() {
        assertTrue(Validador.validaCPF("50100544002"), "deve retornar true quando CPF valido");
        assertFalse(Validador.validaCPF("501.005.440-02"), "deve retornar false quando CPF valido e com pontos");
        assertFalse(Validador.validaCPF("123"), "deve retornar false quando tamanho for menor que onze");
        assertFalse(Validador.validaCPF("12345671231"), "deve retornar false quando o CPF for invalido");
        assertFalse(Validador.validaCPF("00000000000"), "CPF nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaCPF("11111111111"), "CPF nao pode ser todos os numeros igual a um");
        assertFalse(Validador.validaCPF("22222222222"), "CPF nao pode ser todos os numeros igual a dois");
        assertFalse(Validador.validaCPF("33333333333"), "CPF nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaCPF("44444444444"), "CPF nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaCPF("55555555555"), "CPF nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaCPF("66666666666"), "CPF nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaCPF("77777777777"), "CPF nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaCPF("88888888888"), "CPF nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaCPF("99999999999"), "CPF nao pode ser todos os numeros igual a zero");
    }

    @Test
    void validaTelefone() {
        assertTrue(Validador.validaTelefone("61993525277"), "telefone valido");
        assertFalse(Validador.validaTelefone("1"), "telefone tamanho invalido");
        assertFalse(Validador.validaTelefone("00000000000"), "telefone nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaTelefone("11111111111"), "telefone nao pode ser todos os numeros igual a um");
        assertFalse(Validador.validaTelefone("22222222222"), "telefone nao pode ser todos os numeros igual a dois");
        assertFalse(Validador.validaTelefone("33333333333"), "telefone nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaTelefone("44444444444"), "telefone nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaTelefone("55555555555"), "telefone nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaTelefone("66666666666"), "telefone nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaTelefone("77777777777"), "telefone nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaTelefone("88888888888"), "telefone nao pode ser todos os numeros igual a zero");
        assertFalse(Validador.validaTelefone("99999999999"), "telefone nao pode ser todos os numeros igual a zero");
    }
}