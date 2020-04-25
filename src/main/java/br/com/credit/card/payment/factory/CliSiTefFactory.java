package br.com.credit.card.payment.factory;

import br.com.credit.card.payment.config.Configuration;
import br.com.credit.card.payment.response.ConfigurationRoutineResponse;
import softwareexpress.sitef.jCliSiTefI;

public class CliSiTefFactory {
    private static CliSiTefFactory factory;
    private jCliSiTefI cliSiTefI;

    private CliSiTefFactory() {
        cliSiTefI = new jCliSiTefI();
    }

    public static CliSiTefFactory getFactory() {
        if (factory == null) {
            factory = new CliSiTefFactory();
        }
        return factory;
    }

    public jCliSiTefI getCliSiTef() {
        return cliSiTefI;
    }

    public void setConfigure(Configuration configuration) {
        cliSiTefI.SetEnderecoSiTef(configuration.getIp());
        cliSiTefI.SetCodigoLoja(configuration.getCompany());
        cliSiTefI.SetNumeroTerminal(configuration.getTerminal());
        cliSiTefI.SetConfiguraResultado(ConfigurationRoutineResponse.SUCESSO.get());
    }
}
