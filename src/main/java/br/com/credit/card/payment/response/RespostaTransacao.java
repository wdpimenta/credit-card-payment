package br.com.credit.card.payment.response;


import br.com.credit.card.payment.exception.RespostaTransacaoException;

public enum RespostaTransacao {
    SUCESSO(0),
    CHAMA_ROTINA_DE_CONTINUIDADE_DO_PROCESSO(10000),
    MODULO_PDV_CHAMOU_ALGUMA_ROTINA_SEM_ANTES_EXETUAR_FUNCAO_CONFIGURA(-1),
    OPERACAO_CANCELADA_PELO_OPERADOR(-2),
    PARAMETRO_MODALIDADE_E_INVALIDO_OU_INEXISTENTE(-3),
    FALTA_DE_PARAMETRO_NO_PDV(-4),
    SEM_COMINICACAO_COM_O_SITEF(-5),
    OPERACAO_CANCELADA_PELO_USUARIO_NO_PINPED(-6),
    RESERVADO_7_NEGATIVO(-7),
    RESERVADO_42_NEGATIVO(-42),
    CLISIFEF_NAO_POSSUI_A_IMPLEMENTACAO_DA_FUNCAO_NECESARIA_OU_ESTA_DESATUALIZADO(-8),
    ROTINA_CONTINUA_FUNCAO_SI_TEF_INTERATIVO_SEM_INICIAR_FUNCAO_INTERATIVA(-9),
    ALGUM_PARAMETRO_OBRIGATORIO_NAO_FOI_PASSADO_PELA_AUTOMACAO_COMERCIAL(-10),
    /***
     * Provavelmente o processo iterativo anterior não
     * foi executado até o final (enquanto o retorno for igual a 10000).
     */
    ERRO_NA_EXECUCAO_DA_ROTINA_INTERATIVA(-12),
    /**
     * Retornado em funções de consulta tais como ObtemQuantidadeTransaçõesPendentes.
     */
    DOCUMENTO_FISCAL_NAO_ENCONTRADO_NOS_REGISTROS_DA_CLISITEF(-13),
    OPERACAO_CANCELADA_PELA_AUTOMACAO_COMERCIAL(-15),
    PARAMETRO_CANCELADO_PELA_AUTOMACAO_COMERCIAL(-20),
    /**
     * Por exemplo SENHA, para coletar dados em aberto no
     * pinpad. Por exemplo na função ObtemDadoPinpadDiretoEx.
     */
    UTILIZANDO_UMA_PALAVRA_PROIBIDA_PARA_COLETAR_DADO_NO_PINPED(-21),
    ERRO_NO_CORRESPONDENTE_BANCARIO(-25),
    /**
     * Certifique-se que o usuário que roda a aplicação tem direitos
     * de leitura/escrita.
     */
    ERRO_AO_ACESSAR_ARQUIVO_DE_CONFIGURACAO(-30),
    TRANSACAO_NEGADA_PELO_SERVIDOR_SITEF(-40),
    DADOS_INVALIDOS(-41),
    PROBLEMA_NA_EXECUCAO_DE_ALGUMA_ROTINA_NO_PINPED(-43),
    TRANSACAO_NAO_SEGURA(-50),
    ERRO_INTERNO_DO_MODULO(-100);
    private final int codigo;


    RespostaTransacao(int codigo) {
        this.codigo = codigo;
    }

    public static RespostaTransacao findByNome(String nome) {
        for (RespostaTransacao transacao : values()) {
            if (transacao.name().equals(nome)) {
                return transacao;
            }
        }
        throw new RespostaTransacaoException("Erros detectados internamente pela rotina!");
    }

    public static RespostaTransacao findByValue(int value) {
        for (RespostaTransacao transacao : values()) {
            if (transacao.get() == value) {
                return transacao;
            }
        }
        throw new RespostaTransacaoException("Erros detectados internamente pela rotina!");
    }

    public int get() {
        return codigo;
    }


}
