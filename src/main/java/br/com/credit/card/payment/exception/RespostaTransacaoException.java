package br.com.credit.card.payment.exception;

public class RespostaTransacaoException extends RuntimeException {
    public RespostaTransacaoException(String message) {
        super(message);
    }
}
