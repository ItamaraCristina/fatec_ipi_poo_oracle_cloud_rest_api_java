import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.*;
import org.json.JSONObject;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class PessoaService {
  private HttpClient client = HttpClient.newHttpClient();  
  private final String url;

  public void listar(){
    try{
     HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        var response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.body());
        JSONObject raiz = new JSONObject(response.body());
        JSONArray items = raiz.getJSONArray("items");
        JSONObject primeiro = items.getJSONObject(0);
        System.out.println(primeiro);
        String nome = primeiro.getString("nome");
        System.out.println(nome);

    }
    catch(Exception e){
        System.out.println(e.getMessage());
        e.printStackTrace();

    }
 }

}

//objeto exception e que te entrega informação
//https://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@github.com/ItamaraCristina/fatec_ipi_poo_oracle_cloud_rest_api_java.git
// 
