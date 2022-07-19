import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //Receber e configurar as informações da API
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest resposta = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = cliente.send(resposta, BodyHandlers.ofString());        
        
        String body = response.body();

        //Parser as iformções da API para extrair o que é preciso
        ParseJson json = new ParseJson();
        List<Map<String, String>> lista = json.parse(body);

        //mostrar os dados
        for (Map<String,String> filmes : lista) {
            System.out.println(filmes.get("image"));
            System.out.println(filmes.get("fullTitle"));
            System.out.println(filmes.get("rank"));
            System.out.println();
        }

    }
}

//LINK'S Alternativos
/* 
    "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"
    "https://api.mocki.io/v2/549a5d8b"
    "https://alura-filmes.herokuapp.com/conteudos"
    "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json"
*/