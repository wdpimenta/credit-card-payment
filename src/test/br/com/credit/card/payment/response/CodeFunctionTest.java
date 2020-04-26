package br.com.credit.card.payment.response;

import br.com.credit.card.payment.comunication.CodeFunction;
import br.com.credit.card.payment.exception.NotFoundException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static br.com.credit.card.payment.comunication.CodeFunction.findCodeFunctionByCode;
import static br.com.credit.card.payment.comunication.CodeFunction.findCodeFunctionByName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class CodeFunctionTest {

    @Test
    void findCodeFunctionByNameShouldBeReturnEnum() {
        var response = findCodeFunctionByName("ABRE_MENU_DE_TRANSACAO_GERENCIAL");
        assertThat(response, is(CodeFunction.ABRE_MENU_DE_TRANSACAO_GERENCIAL));
        assertThat(response, CoreMatchers.not(CodeFunction.BENEFICIO_REFEICAO_WAPPA));
    }

    @Test
    void findCodeFunctionByNameShouldBeThrowNotFoundException() {
        var exception = Assertions.assertThrows(NotFoundException.class, () -> findCodeFunctionByName("Desconhecido"));
        assertThat(exception.getMessage(), is("Nao pode ser encontrado codigo de funcao com o nome 'Desconhecido'"));
    }

    @Test
    void findCodeFunctionByCodeShouldBeReturnEnum() {
        var response = findCodeFunctionByCode(110);
        assertThat(response, is(CodeFunction.ABRE_MENU_DE_TRANSACAO_GERENCIAL));
        assertThat(response, CoreMatchers.not(CodeFunction.BENEFICIO_REFEICAO_WAPPA));
    }

    @Test
    void findCodeFunctionByCodeShouldBeThrowNotFoundException() {
        var exception = Assertions.assertThrows(NotFoundException.class, () -> findCodeFunctionByCode(-454545));
        assertThat(exception.getMessage(), is("Codigo de funcao '-454545' desconhecido"));
    }
}