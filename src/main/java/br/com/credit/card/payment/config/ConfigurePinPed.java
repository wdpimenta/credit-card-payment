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
        CliSiTefFactory.getFactory().setConfigure(configuration);
        jCliSiTefI cliSiTef = CliSiTefFactory.getFactory().getCliSiTef();

        var returnPinPad = ConfigurationRoutineResponse.findByCode(cliSiTef.ConfiguraIntSiTefInterativo());
        logger.info("Configuration response '{}'", returnPinPad);
        if (returnPinPad != ConfigurationRoutineResponse.SUCESSO) {
            logger.error("Error '{}'", returnPinPad);
            throw new ConfigurationPinPedException("Erro '" + returnPinPad.name() + "' ao configurar o Pin Ped");
        }
    }
}
