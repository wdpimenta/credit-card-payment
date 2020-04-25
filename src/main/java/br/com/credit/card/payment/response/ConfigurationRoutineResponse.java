package br.com.credit.card.payment.response;

import br.com.credit.card.payment.exception.ConfigurationRoutineResponseException;

import java.util.stream.Stream;


public enum ConfigurationRoutineResponse {
    SUCESSO(0),
    IP_INVALIDO_OU_NAO_RESOLVIDO(1),
    CODIGO_DA_LOJA_INVALIDO(2),
    CODIGO_DO_TERMINAL_INVALIDO(3),
    ERRO_NA_INICIALIZACAO_DO_TCP_IP(6),
    FALTA_DE_MEMORIA(7),
    NAO_ENCONTROU_A_CLISITEF_OU_ELA_ESTA_COM_PROBLEMAS(8),
    CONFIGURACAO_DE_SERVIDORES_SITEF_FOI_EXCEDIDA(9),
    ERRO_DE_ACESSO_NA_PASTA_CLISITEF(10),
    DADOS_INVALIDOS_PASSADO_PELA_AUTOMACAO(11),
    MODO_SEGURO_NAO_ATIVO(12),
    CAMINHO_DLL_INVALIDO_O_CAMINHO_COMPLETO_ESTA_MUITO_GRANDE(13);

    private final int code;

    ConfigurationRoutineResponse(int code) {
        this.code = code;
    }

    public int get() {
        return code;
    }

    public static ConfigurationRoutineResponse findByName(String name) {
        var first = Stream.of(values()).filter(response -> response.name().equals(name)).findFirst();
        return first.orElseThrow(() -> new ConfigurationRoutineResponseException(String.format("Rotina de configuracao '%s' nao encontrada!", name)));


    }

    public static ConfigurationRoutineResponse findByCode(int code) {
        var first = Stream.of(values()).filter(response -> response.get() == code).findFirst();
        return first.orElseThrow(() -> new ConfigurationRoutineResponseException(String.format("Rotina de configuracao '%d' nao encontrada!", code)));
    }


}
