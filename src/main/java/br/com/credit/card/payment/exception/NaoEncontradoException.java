package br.com.credit.card.payment.exception;

public class NaoEncontradoException extends RuntimeException {
    public NaoEncontradoException(String message) {
        super(message);
    }
}
