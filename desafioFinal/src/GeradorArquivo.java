import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    public void geraJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escreve = new FileWriter(endereco.cep() + ".json"); // Cria o arquivo json com o cep buscado
        escreve.write(gson.toJson(endereco));
        escreve.close();
    }
}
