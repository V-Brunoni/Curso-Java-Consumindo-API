import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String cep = "";

        System.out.println("Informe o CEP que deseja consultar: ");
        cep = sc.nextLine();

        ConsultaCEP consulta = new ConsultaCEP();

        try{
            Endereco endereco = consulta.buscaEndereco(cep);
            System.out.println(endereco);

            GeradorArquivo gerador = new GeradorArquivo();
            gerador.geraJson(endereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação.");
        }






    }
}
