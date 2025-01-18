import java.util.Scanner;

public class ExercicioSenha {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a sua senha: ");
        String senha = sc.nextLine();

        try {
            validarSenha(senha);
            System.out.println("Senha válida. Acesso permitido!");
        } catch (SenhaInvalidaException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }

    private static void validarSenha(String senha){
        if (senha.length() < 8){
            throw new SenhaInvalidaException("A senha deve conter pelo menos 8 caracteres!!!");
        }
    }


}
