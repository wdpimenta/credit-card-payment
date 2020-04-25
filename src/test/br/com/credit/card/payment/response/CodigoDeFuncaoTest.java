package br.com.credit.card.payment.response;

import br.com.credit.card.payment.exception.NaoEncontradoException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static br.com.credit.card.payment.response.CodigoDeFuncao.findCodigoDeFuncaoByCodigo;
import static br.com.credit.card.payment.response.CodigoDeFuncao.findCodigoDeFuncaoByName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class CodigoDeFuncaoTest {

    @Test
    void findCodigoDeFuncaoByNameShouldBeReturnABRE_MENU_DE_TRANSACAO_GERENCIAL() {
        var response = findCodigoDeFuncaoByName("ABRE_MENU_DE_TRANSACAO_GERENCIAL");
        assertThat(response, is(CodigoDeFuncao.ABRE_MENU_DE_TRANSACAO_GERENCIAL));
        assertThat(response, CoreMatchers.not(CodigoDeFuncao.BENEFICIO_REFEICAO_WAPPA));
    }

    @Test
    void findCodigoDeFuncaoByNameShouldBeThrowNaoEncontradoException() {
        var exception = Assertions.assertThrows(NaoEncontradoException.class, () -> findCodigoDeFuncaoByName("Desconhecido"));
        assertThat(exception.getMessage(), is("Nao pode ser encontrado codigo de funcao com o nome 'Desconhecido'"));
    }

    @Test
    void findCodigoDeFuncaoByCodigoShouldBeReturnABRE_MENU_DE_TRANSACAO_GERENCIAL() {
        var response = findCodigoDeFuncaoByCodigo(110);
        assertThat(response, is(CodigoDeFuncao.ABRE_MENU_DE_TRANSACAO_GERENCIAL));
        assertThat(response, CoreMatchers.not(CodigoDeFuncao.BENEFICIO_REFEICAO_WAPPA));
    }

    @Test
    void findCodigoDeFuncaoByCodigoShouldBeThrowNaoEncontradoException() {
        var exception = Assertions.assertThrows(NaoEncontradoException.class, () -> findCodigoDeFuncaoByCodigo(-454545));
        assertThat(exception.getMessage(), is("Codigo de funcao '-454545' desconhecido"));
    }
}