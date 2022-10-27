import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
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

    }
    catch(Exception e){
        System.out.println(e.getMessage());
        e.printStackTrace();

    }
 }

}

//objeto exception e que te entrega informação
//https://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@github.com/ItamaraCristina/fatec_ipi_poo_oracle_cloud_rest_api_java.git
