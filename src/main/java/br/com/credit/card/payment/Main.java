package br.com.credit.card.payment;

import br.com.credit.card.payment.config.ConfigurePinPed;

import static br.com.credit.card.payment.config.ConfigurationBuilder.builder;

public class Main {
    public static void main(String[] args) {
        ConfigurePinPed configurePinPed = new ConfigurePinPed();
        configurePinPed.configurePinPed(builder().ip("localhost").terminal("SW000002").company("00000000").build());


    }
}
