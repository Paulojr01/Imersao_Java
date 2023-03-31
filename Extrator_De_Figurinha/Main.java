package Extrator_De_Figurinha;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception{

        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a url: ");
        String url = ler.nextLine();
        System.out.printf("aguarde...");
        System.out.println();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);



        for(int i=0; i < conteudos.size(); i++){

            Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            var geradora = new GeradorDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }

    }

    // https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-18 api nasa
}
