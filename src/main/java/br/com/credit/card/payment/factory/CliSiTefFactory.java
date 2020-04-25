package br.com.credit.card.payment.factory;

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
}
