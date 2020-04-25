package br.com.credit.card.payment.response;

import br.com.credit.card.payment.exception.RotinaDeConfiguracaoException;

public enum RespostaRotinaDeConfiguracao {
    SUCESSO(0),
    IP_INVALIDO_OU_NAO_RESOLVIDO(1),
    CODIGO_DA_LOJA_INVALIDO(2),
    CODIGO_DO_TERMINAL_INVALIDO(3),
    ERRO_NA_INICIALIZACAO_DO_TCP_IP(6),
    FALTA_DE_MEMORIA(7),
    NAO_ENCONTROU_A_CLISITEF_OU_ELA_ESTA_COM_PROBLEMAS(8),
    CONFIGURACAO_DE_SERVIDORES_SITEF_FOI_EXCEDIDA(9),
    /**
     * possível falta de permissão para escrita
     */
    ERRO_DE_ACESSO_NA_PASTA_CLISITEF(10),
    DADOS_INVALIDOS_PASSADO_PELA_AUTOMACAO(11),
    /**
     * possível falta de configuração no servidor SiTef do arquivo .cha)
     */
    MODO_SEGURO_NAO_ATIVO(12),
    CAMINHO_DLL_INVALIDO_O_CAMINHO_COMPLETO_ESTA_MUITO_GRANDE(13);

    private final int codigo;

    RespostaRotinaDeConfiguracao(int codigo) {
        this.codigo = codigo;
    }

    public int get() {
        return codigo;
    }

    public static RespostaRotinaDeConfiguracao findByNome(String nome) {
        for (RespostaRotinaDeConfiguracao value : values()) {
            if (value.name().equals(nome)) {
                return value;
            }
        }

        throw new RotinaDeConfiguracaoException(String.format("Rotina de configuracao %s nao encontrada!", nome));
    }

    public static RespostaRotinaDeConfiguracao findByValue(int value) {
        for (RespostaRotinaDeConfiguracao configuracao : values()) {
            if (configuracao.get() == value) {
                return configuracao;
            }
        }
        throw new RotinaDeConfiguracaoException(String.format("Rotina de configuracao %d nao encontrada!", value));
    }


}
