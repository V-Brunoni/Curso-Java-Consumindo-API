package br.com.alura.screenmatch.excecao;

public class ConversaoDeAnoException extends RuntimeException {

    private String mensagem;

    public ConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
