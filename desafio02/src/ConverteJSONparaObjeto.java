import com.google.gson.Gson;

public class ConverteJSONparaObjeto {
    public static void main(String[] args) {


        String jsonLivro = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Akemi\",\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";
        System.out.println(jsonLivro);

        Gson gson = new Gson();
        Livro livro = gson.fromJson(jsonLivro, Livro.class);
        System.out.println("\n"+livro);


    }
}
