import java.security.PublicKey;

public class SenhaInvalidaException extends RuntimeException{

    public SenhaInvalidaException(String mensagem){
        super(mensagem);
    }
}
