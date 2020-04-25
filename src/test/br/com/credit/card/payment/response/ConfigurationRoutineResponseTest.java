package br.com.credit.card.payment.response;

import br.com.credit.card.payment.exception.ConfigurationRoutineResponseException;
import org.junit.jupiter.api.Test;

import static br.com.credit.card.payment.response.ConfigurationRoutineResponse.IP_INVALIDO_OU_NAO_RESOLVIDO;
import static br.com.credit.card.payment.response.ConfigurationRoutineResponse.SUCESSO;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ConfigurationRoutineResponseTest {

    @Test
    void findByNameShouldBeReturnSUCESSO() {
        var response = ConfigurationRoutineResponse.findByName("SUCESSO");
        assertThat(response, is(SUCESSO));
    }

    @Test
    void findByNameShouldBeThrowConfigurationRoutineResponseExceptionWhenNotFoundByName() {
        var exception = assertThrows(ConfigurationRoutineResponseException.class, () -> ConfigurationRoutineResponse.findByName("NotFound"));
        assertThat(exception.getMessage(), is("Rotina de configuracao 'NotFound' nao encontrada!"));
    }

    @Test
    void findByCodeShouldBeReturnEnum() {
        var response = ConfigurationRoutineResponse.findByCode(1);
        assertThat(response, is(IP_INVALIDO_OU_NAO_RESOLVIDO));
    }

    @Test
    void findByCodeShouldBeThrowConfigurationRoutineResponseExceptionWhenNotFoundByCode() {
        var exception = assertThrows(ConfigurationRoutineResponseException.class, () -> ConfigurationRoutineResponse.findByCode(-78785554));
        assertThat(exception.getMessage(), is("Rotina de configuracao '-78785554' nao encontrada!"));
    }
}