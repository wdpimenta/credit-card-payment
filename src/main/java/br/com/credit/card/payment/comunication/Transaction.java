package br.com.credit.card.payment.comunication;

import br.com.credit.card.payment.factory.CliSiTefFactory;
import br.com.credit.card.payment.response.PinPedResponse;
import br.com.credit.card.payment.response.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import softwareexpress.sitef.jCliSiTefI;

import static br.com.credit.card.payment.response.PinPedResponse.APRESENTA_UM_MENU_DE_OPCOES;
import static br.com.credit.card.payment.response.TransactionResponse.CHAMA_ROTINA_DE_CONTINUIDADE_DO_PROCESSO;

public class Transaction {
    private final Logger logger = LoggerFactory.getLogger(Transaction.class);


    public void performsTransaction(CodeFunction codeFunction, String valueToPlay) {
        logger.info("Operation '{}' code: '{}'", codeFunction, codeFunction.get());
        logger.info("Value to play: R$ {}", valueToPlay);

        var cliSiTef = CliSiTefFactory.getFactory().getCliSiTef();
        cliSiTef.SetModalidade(0);
        cliSiTef.SetFuncaoSiTef(codeFunction.get());
        cliSiTef.SetValor(valueToPlay);
        cliSiTef.SetNumeroCuponFiscal("");
        cliSiTef.SetDataFiscal("");
        cliSiTef.SetHorario("");
        cliSiTef.SetOperador("Operador");
        cliSiTef.SetParametrosAdicionais("");

        int codeResponse = cliSiTef.IniciaFuncaoSiTefInterativo();
        logger.info("Response code: '{}'", codeResponse);
        var response = TransactionResponse.findTransactionResponseByCode(codeResponse);
        logger.info("Response: {}", response);
        cliSiTef.SetBuffer("");
        cliSiTef.SetContinuaNavegacao(0);
    }

    public void verifyTransactionResponse() {
        int formaPagamento = 3;
        TransactionResponse response = CHAMA_ROTINA_DE_CONTINUIDADE_DO_PROCESSO;
        while (response == CHAMA_ROTINA_DE_CONTINUIDADE_DO_PROCESSO) {
            logger.info("================================================");
            jCliSiTefI cliSiTef = CliSiTefFactory.getFactory().getCliSiTef();
            response = TransactionResponse.findTransactionResponseByCode(cliSiTef.ContinuaFuncaoSiTefInterativo());
            String auxBuffer = cliSiTef.GetBuffer();

            int bufferTipo = TiposBuffer.pegaBufferInt(auxBuffer);

            if ((formaPagamento == 3) && (bufferTipo == 3)) {
                bufferTipo = 1; // vista
            }


            int proxComandoPinPad = cliSiTef.GetProximoComando();
            var responseByCode = PinPedResponse.findPinPedResponseByCode(proxComandoPinPad);


            logger.info("\nTipo: {} \nBuffer: {} \nproxComando: {} \nByCode: {}", bufferTipo, auxBuffer, proxComandoPinPad, responseByCode.name());

            if (proxComandoPinPad >= 20 && proxComandoPinPad != 23 && proxComandoPinPad != 22) {
                if (bufferTipo == TiposBuffer.BUFFER_TAXA_EMBARQUE_INT) {
                    cliSiTef.SetBuffer("0");
                }

                if (bufferTipo == TiposBuffer.BUFFER_CANCELADO_INT) {
                    cliSiTef.SetBuffer("0");
                }

                if (bufferTipo == TiposBuffer.BUFFER_TAXA_SERVICO_INT) {
                    cliSiTef.SetBuffer("0");
                }

                if (bufferTipo == TiposBuffer.BUFFER_DEBITO_CREDITO_INT) {//13

                    if (formaPagamento == 2) {
                        cliSiTef.SetBuffer("2");
                    } else if (formaPagamento == 3) {
                        cliSiTef.SetBuffer("3");
                    } else {
                        cliSiTef.SetBuffer("2");
                    }
                }

                if (bufferTipo == TiposBuffer.BUFFER_VISA_SAQUE_INT) {
                    cliSiTef.SetBuffer("0");
                }

                if (bufferTipo == TiposBuffer.BUFFER_MODO_PARCELA_INT) {
                    cliSiTef.SetBuffer("2");
                }

                if (bufferTipo == TiposBuffer.BUFFER_VISA_CUSTEIO_INT) {
                    cliSiTef.SetBuffer("1");
                }

                if (bufferTipo == TiposBuffer.BUFFER_MAGNETICO_DIGITADO_INT) {
                    cliSiTef.SetBuffer("1");
                }

                if (bufferTipo == TiposBuffer.BUFFER_INCOMM_INT) {
                    cliSiTef.SetBuffer("13");
                }

                if (bufferTipo == TiposBuffer.BUFFER_INCOMM_FASTPIN_INT) {//18
                    cliSiTef.SetBuffer("1");
                }

                if (bufferTipo == TiposBuffer.BUFFER_INCOMM_VALOR_INT) {//19
                    cliSiTef.SetBuffer("");
                }

                if (bufferTipo == TiposBuffer.BUFFER_NUMERO_PARCELAS_INT) {//2
                    cliSiTef.SetBuffer("1");
                }
            }

        }

        if (response == TransactionResponse.SUCESSO) {
            CliSiTefFactory.getFactory().getCliSiTef().FinalizaTransacaoSiTefInterativo();
        }

        System.out.println(">>> " + response);

    }


}
