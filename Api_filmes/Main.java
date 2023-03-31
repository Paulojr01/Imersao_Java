package Api_filmes;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-16";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);



        for(int i=0; i < 3; i++){

            Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            var geradora = new GeradorDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }

    }


}
