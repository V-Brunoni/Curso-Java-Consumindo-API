package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String busca = "";

        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) //Muda a politica de nomenclatura do campo, para o gson aceitar as variáveis no record com letra minuscula
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) { //Compara uma String sem fazer distinção entre letras maiúsculas e minúsculas

            System.out.println("Informe o filme que deseja buscar: ");
            busca = sc.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String chave = "d72c4101";
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + chave;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
                System.out.println(meuTituloOMDB);

                //try { //tente executar o que está dentro das chaves
                Titulo meuTitulo = new Titulo(meuTituloOMDB);
                System.out.println("\nTitulo já convertido...");
                System.out.println(meuTitulo + "\n");

                titulos.add(meuTitulo);


                //FileWriter escrita = new FileWriter("filmes.txt");         //cria um arquivo com o nome filmes no padrão txt
                //escrita.write(meuTitulo.toString());                       //Transcreve para o arquivo txt o que está no meuTitulo
                //escrita.close();                                           //Termina a escrita do arquivo

            } catch (
                    NumberFormatException e) { // se não conseguir execute o que está dentro do catch | try catch é usado para manter o codigo rodando sem exibir as exception
                System.out.println("ERRO! Formato de número inválido.");
                System.out.println(e.getMessage() + "\n"); //Exibe a mensagem de erro
            } catch (IllegalArgumentException e) {
                System.out.println("Erro de argumento na busca, verifique o endereço informado!\n");
            } catch (ConversaoDeAnoException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("O programa finalizou!\n");





    }
}
