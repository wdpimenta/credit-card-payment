package br.com.credit.card.payment.config;

import br.com.credit.card.payment.exception.ConfigurationPinPedException;
import br.com.credit.card.payment.factory.CliSiTefFactory;
import br.com.credit.card.payment.response.ConfigurationRoutineResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import softwareexpress.sitef.jCliSiTefI;

public class ConfigurePinPed {
    private Logger logger = LoggerFactory.getLogger(ConfigurePinPed.class);

    public void configurePinPed(Configuration configuration) {
        logger.info("Start pin ped configuration");
        jCliSiTefI cliSiTef = CliSiTefFactory.getFactory().getCliSiTef();
        cliSiTef.SetEnderecoSiTef(configuration.getIp());
        cliSiTef.SetCodigoLoja(configuration.getCompany());
        cliSiTef.SetNumeroTerminal(configuration.getTerminal());
        cliSiTef.SetConfiguraResultado(ConfigurationRoutineResponse.SUCESSO.get());

        var returnPinPad = ConfigurationRoutineResponse.findByCode(cliSiTef.ConfiguraIntSiTefInterativo());
        logger.info("Configuration response '{}'", returnPinPad);
        if (returnPinPad != ConfigurationRoutineResponse.SUCESSO) {
            throw new ConfigurationPinPedException("Erro '" + returnPinPad.name() + "' ao configurar o Pin Ped");
        }
    }
}
