import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConverteJSON {
    public static void main(String[] args) {

        //String jsonPessoa = "{\"nome\":\"Rodrigo\",\"idade\":20,\"cidade\":\"Brasília\"}";
        String jsonPessoa = "{\"nome\":\"Rodrigo\",\"cidade\":\"Brasília\"}";
        System.out.println(jsonPessoa);


        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);
        System.out.println(pessoa);
    }
}
