import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainVeiculo {
    public static void main(String[] args) {


        Veiculo veiculo = new Veiculo("Chevrolet", "Celta", 2015, 40000);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(veiculo);

        System.out.println(json);
    }
}
