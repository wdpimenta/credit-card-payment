package br.com.credit.card.payment.comunication;

public class TiposBuffer {

	public static String BUFFER_INSIRA_CARTAO = "Insira ou passe o cartao na leitora";
	public static String BUFFER_MODO_INVALIDO = "Modo Invalido";
	public static String BUFFER_TRANSACAO_OK = "Transacao OK";
	public static String BUFFER_JA_EFETUADA = "Transacao ja efetuada";

	public static String BUFFER_SOLICITE_SENHA = "SOLICITE A SENHA";
	public static String BUFFER_AGUARDE_SENHA = "DIGITE A SENHA";

	public static String BUFFER_CONECTANDO = "Conectando";

	public static String BUFFER_CARTAO_REMOVIDO = "Cartao Removido";
	public static String BUFFER_REMOVIDO = "Removido";

	public static String BUFFER_SENHA_INVALIDA = "SENHA INVALIDA";
	public static String BUFFER_SENHA_INCORRETA = "SENHA INCORRETA!";

	public static String BUFFER_AGUARDE = "Aguarde";
	public static String BUFFER_PROCESSANDO = "em processamento";

	public static String BUFFER_RETIRE = "Retire o cartao da leitora";
	public static String BUFFER_TAXA_EMBARQUE = "Forneca a taxa de embarque";
	public static String BUFFER_TAXA_SERVICO = "Forneca a taxa de servico";
	public static String BUFFER_DEBITO_CREDITO = "1:Cartao de Debito;2:Cartao de Credito;";
	public static String BUFFER_VISA_SAQUE = "SAQUE";
	public static String BUFFER_VISA_CUSTEIO = "1:VISA ELECTRON;2:AGRO CUSTEIO";
	public static String BUFFER_MAGNETICO_DIGITADO = "1:Magnetico/Chip;2:Digitado;";
	
	public static String BUFFER_FORMA_PAGAMENTO = "1:Cheque;2:Cartao de Debito;3:Cartao de Credito;4:Cartao Private Label;5:Confirmacao de Pre-autorizacao;6:Cartao Gift";
	public static String BUFFER_INCOMM = "1:Teste de comunicacao;2:Reimpressao de comprovante;3:Cancelamento de transacao;4:Pre-autorizacao;5:Consulta parcelas CDC;6:Consulta Private Label;7:Consulta saque e saque Fininvest;8:Consulta Saldo Debito;9:Consulta Saldo Credito;10:Petrobras Premmia;11:Outros Cielo;12:Menu Administrativo Gift;13:Menu Gift InComm";
	public static String BUFFER_INCOMM_FASTPIN = "1:Venda FastPin InComm;2:Retorno de FastPin InComm";
	public static String BUFFER_INCOMM_VALOR = "Valor";
	public static String BUFFER_INCOMM_EAN = "Codigo do Produto (EAN)";
	
	public static String BUFFER_CANCELADO = "Operacao Cancelada";
	
	public static String BUFFER_MODO_PARCELA = "1:A Vista;2:Financ. Loja;3:Financ. Adm.;";
	public static String BUFFER_NUMERO_PARCELAS = "Forneca o numero de parcelas";
	
	
	public static int BUFFER_NUMERO_PARCELAS_INT = 2;
	public static int BUFFER_MODO_PARCELA_INT = 3;
	
	public static int BUFFER_INSIRA_CARTAO_INT = 1;
	public static int BUFFER_MODO_INVALIDO_INT = 2;
	public static int BUFFER_TRANSACAO_OK_INT = 3;
	public static int BUFFER_JA_EFETUADA_INT = 4;

	public static int BUFFER_SOLICITE_SENHA_INT = 5;
	public static int BUFFER_AGUARDE_SENHA_INT = 5;

	public static int BUFFER_CONECTANDO_INT = 6;

	public static int BUFFER_CARTAO_REMOVIDO_INT = 7;
	public static int BUFFER_REMOVIDO_INT = 7;

	public static int BUFFER_SENHA_INVALIDA_INT = 8;
	public static int BUFFER_SENHA_INCORRETA_INT = 8;

	public static int BUFFER_AGUARDE_INT = 9;
	public static int BUFFER_PROCESSANDO_INT = 9;

	public static int BUFFER_RETIRE_INT = 10;
	public static int BUFFER_TAXA_EMBARQUE_INT = 11;
	public static int BUFFER_TAXA_SERVICO_INT = 12;
	public static int BUFFER_DEBITO_CREDITO_INT = 13;
	public static int BUFFER_VISA_SAQUE_INT = 14;
	public static int BUFFER_VISA_CUSTEIO_INT = 15;
	public static int BUFFER_MAGNETICO_DIGITADO_INT = 16;
	
	public static int BUFFER_INCOMM_INT = 17;
	public static int BUFFER_INCOMM_FASTPIN_INT = 18;
	public static int BUFFER_INCOMM_VALOR_INT = 19;
	public static int BUFFER_INCOMM_EAN_INT = 20;
	
	public static int BUFFER_CANCELADO_INT = 21;


	public static int pegaBufferInt(String bf) {
		int ret = 0;
		if (bf.contains(BUFFER_INSIRA_CARTAO) || bf.contains("SiTef Conectado")) {
			ret = BUFFER_INSIRA_CARTAO_INT;

		} else if (bf.contains(BUFFER_MODO_INVALIDO)) {
			ret = BUFFER_MODO_INVALIDO_INT;

		} else if (bf.contains(BUFFER_TRANSACAO_OK)) {
			ret = BUFFER_TRANSACAO_OK_INT;

		} else if (bf.contains(BUFFER_JA_EFETUADA)) {
			ret = BUFFER_JA_EFETUADA_INT;

		} else if (bf.contains(BUFFER_SOLICITE_SENHA)) {
			ret = BUFFER_AGUARDE_SENHA_INT;

		} else if (bf.contains(BUFFER_AGUARDE_SENHA)) {
			ret = BUFFER_AGUARDE_SENHA_INT;

		} else if (bf.contains(BUFFER_CONECTANDO)) {
			ret = BUFFER_CONECTANDO_INT;

		} else if (bf.contains(BUFFER_CARTAO_REMOVIDO)) {
			ret = BUFFER_CARTAO_REMOVIDO_INT;

		} else if (bf.contains(BUFFER_REMOVIDO)) {
			ret = BUFFER_REMOVIDO_INT;

		} else if (bf.contains(BUFFER_SENHA_INVALIDA)) {
			ret = BUFFER_SENHA_INVALIDA_INT;

		} else if (bf.contains(BUFFER_SENHA_INCORRETA)) {
			ret = BUFFER_SENHA_INCORRETA_INT;

		} else if (bf.contains(BUFFER_AGUARDE)) {
			ret = BUFFER_AGUARDE_INT;

		} else if (bf.contains(BUFFER_PROCESSANDO)) {
			ret = BUFFER_PROCESSANDO_INT;

		} else if (bf.contains(BUFFER_RETIRE)) {
			ret = BUFFER_RETIRE_INT;

		} else if (bf.contains(BUFFER_TAXA_EMBARQUE)) {
			ret = BUFFER_TAXA_EMBARQUE_INT;

		} else if (bf.contains(BUFFER_TAXA_SERVICO)) {
			ret = BUFFER_TAXA_SERVICO_INT;

		} else if (bf.contains(BUFFER_DEBITO_CREDITO) || bf.contains(BUFFER_FORMA_PAGAMENTO)) {
			ret = BUFFER_DEBITO_CREDITO_INT;

		} else if (bf.contains(BUFFER_VISA_SAQUE)) {
			ret = BUFFER_VISA_SAQUE_INT;

		} else if (bf.contains(BUFFER_VISA_CUSTEIO)) {
			ret = BUFFER_VISA_CUSTEIO_INT;

		} else if (bf.contains(BUFFER_MAGNETICO_DIGITADO)) {
			ret = BUFFER_MAGNETICO_DIGITADO_INT;

		} else if(bf.contains(BUFFER_INCOMM)){
			ret = BUFFER_INCOMM_INT;
			
		} else if(bf.contains(BUFFER_INCOMM_FASTPIN)){
			ret = BUFFER_INCOMM_FASTPIN_INT;
			
		} else if(bf.contains(BUFFER_INCOMM_VALOR)){
			ret = BUFFER_INCOMM_VALOR_INT;
			
		} else if(bf.contains(BUFFER_INCOMM_EAN)){
			ret = BUFFER_INCOMM_EAN_INT;
			
		}  else if(bf.contains(BUFFER_CANCELADO)){
			ret = BUFFER_CANCELADO_INT;
			
		} else if(bf.contains(BUFFER_MODO_PARCELA)){
			ret = BUFFER_MODO_PARCELA_INT;
			
		} else if(bf.contains(BUFFER_NUMERO_PARCELAS)){
			ret = BUFFER_NUMERO_PARCELAS_INT;
		}
		
		return ret;
	}
//-----------------------------------------------------------------
}
