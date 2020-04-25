package br.com.credit.card.payment.config;

public class ConfigurationBuilder {
    private ConfigurationBuilder() {
    }

    private Configuration configuration;

    public static ConfigurationBuilder builder() {
        ConfigurationBuilder build = new ConfigurationBuilder();
        build.configuration = new Configuration();
        return build;
    }

    public ConfigurationBuilder ip(String ip) {
        configuration.setIp(ip);
        return this;
    }

    public ConfigurationBuilder company(String company) {
        configuration.setCompany(company);
        return this;
    }

    public ConfigurationBuilder terminal(String terminal) {
        configuration.setTerminal(terminal);
        return this;
    }

    public Configuration build() {
        return configuration;
    }

}
