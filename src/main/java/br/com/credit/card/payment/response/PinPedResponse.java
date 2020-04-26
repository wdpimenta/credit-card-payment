package br.com.credit.card.payment.response;

import br.com.credit.card.payment.exception.NotFoundException;

import java.util.stream.Stream;

public enum PinPedResponse {
    DADOS_DO_CARTAO(0, null),
    MENSAGEM_A_SER_PARA_O_OPERADOR(1, null),
    MENSAGEM_A_SER_PARA_O_CLIENTE(2, null),
    MENSAGEM_A_SER_PARA_O_CLIENTE_E_OPERADOR(3, null),
    TITULO_DA_APRESENTACAO_DO_MENU(4, "21"),
    REMOVE_A_MENSAGEM_APRESENTADA_NO_VISOR_DO_OPERADOR(11, "1"),
    REMOVE_A_MENSAGEM_APRESENTADA_NO_VISOR_DO_CLIENTE(12, "2"),
    REMOVE_A_MENSAGEM_APRESENTADA_NO_VISOR_DO_CLIENTE_E_OPERADOR(13, "3"),
    REMOVE_TITULO_DA_APRESENTACAO_DO_MENU(14, "4"),
    EXIBE_INFORMACOES_DETALHADAS(15, null),
    REMOVE_CABECALHO_APROVADO_POR_COMANDO(16, "15"),
    APRESENTA_UM_TEXTO_E_TEM_RESPOSTA_DE_SIM_OU_NAO(20, null),
    APRESENTA_UM_MENU_DE_OPCOES(21, "1"),
    APRESENTA_MENSAGEM_E_AGUARDE_O_OPERADOR_CONFIRMAR(22, null),
    DESEJA_CANCELAR_A_OPERACAO(23, null),
    DEVE_LER_UM_CAMPO_COM_TAMANHO_MIN_E_MAX_NAO_DEPENDE_DO_OPERADOR(29, null),
    DEVE_LER_UM_CAMPO_COM_TAMANHO_MIN_E_MAX(30, null),
    DEVE_LER_O_NUMERO_DO_CHEQUE(31, null),
    DEVE_LER_UM_CAMPO_MONETARIO(34, null),
    DEVE_LER_UM_CODIGO_EM_BARRAS(35, null),
    DEVE_LER_UM_CAMPO_DE_FROMA_MASCARADO_COM_TAMANHO_MIN_E_MAX(41, null),
    EXIBE_UM_MENU_DE_OPCOES_E_PERMITE_QUE_O_USUARIO_SELECIONE_UMA(42, null);

    private final int code;
    private final String comando;
    private final boolean possuiComando;

    public static PinPedResponse findPinPedResponseByCode(int code) {
        var result = Stream.of(values()).filter(response -> response.getCode() == code).findFirst();
        return result.orElseThrow(() -> new NotFoundException("Não foi possivel encontrar resposta com codigo = " + code));
    }

    PinPedResponse(int code, String comando) {
        this.code = code;
        this.comando = comando;
        this.possuiComando = (comando != null);
    }

    public static boolean is(PinPedResponse response, PinPedResponse question) {
        return response == question;
    }

    public String getComando() {
        return comando;
    }

    public boolean isPossuiComando() {
        return possuiComando;
    }

    public int getCode() {
        return code;
    }
}
