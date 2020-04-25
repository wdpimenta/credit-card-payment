package br.com.credit.card.payment.response;


import br.com.credit.card.payment.exception.RespostaTransacaoException;

public enum TransactionResponse {
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
    ERRO_NA_EXECUCAO_DA_ROTINA_INTERATIVA(-12),
    DOCUMENTO_FISCAL_NAO_ENCONTRADO_NOS_REGISTROS_DA_CLISITEF(-13),
    OPERACAO_CANCELADA_PELA_AUTOMACAO_COMERCIAL(-15),
    PARAMETRO_CANCELADO_PELA_AUTOMACAO_COMERCIAL(-20),
    UTILIZANDO_UMA_PALAVRA_PROIBIDA_PARA_COLETAR_DADO_NO_PINPED(-21),
    ERRO_NO_CORRESPONDENTE_BANCARIO(-25),
    ERRO_AO_ACESSAR_ARQUIVO_DE_CONFIGURACAO(-30),
    TRANSACAO_NEGADA_PELO_SERVIDOR_SITEF(-40),
    DADOS_INVALIDOS(-41),
    PROBLEMA_NA_EXECUCAO_DE_ALGUMA_ROTINA_NO_PINPED(-43),
    TRANSACAO_NAO_SEGURA(-50),
    ERRO_INTERNO_DO_MODULO(-100);
    private final int code;


    TransactionResponse(int codigo) {
        this.code = codigo;
    }

    public static TransactionResponse findTransactionResponseByNome(String nome) {
        for (TransactionResponse transacao : values()) {
            if (transacao.name().equals(nome)) {
                return transacao;
            }
        }
        throw new RespostaTransacaoException("Erros detectados internamente pela rotina!");
    }

    public static TransactionResponse findTransactionResponseByCode(int code) {
        for (TransactionResponse transaction : values()) {
            if (transaction.get() == code) {
                return transaction;
            }
        }
        throw new RespostaTransacaoException("Erros detectados internamente pela rotina!");
    }

    public int get() {
        return code;
    }


}
