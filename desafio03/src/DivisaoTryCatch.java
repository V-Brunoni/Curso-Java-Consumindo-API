import java.util.Scanner;

public class DivisaoTryCatch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero1 = 0;
        int numero2 = 0;

        System.out.println("Informe o primeiro número para a divisão: ");
        numero1 = sc.nextInt();

        System.out.println("Informe o segundo número para a divisão: ");
        numero2 = sc.nextInt();

        try {
            int resultado = numero1 / numero2;
            System.out.println("O resultado da divisão é " + resultado);
        } catch (ArithmeticException e){
            System.out.println("A divisão não pode ser feita por 0!");
        }


    }
}
