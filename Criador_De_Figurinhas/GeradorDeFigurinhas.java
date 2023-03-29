package Criador_De_Figurinhas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;


public class GeradorDeFigurinhas {


    public void cria() throws Exception {
        // Leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("Entrada/TopMovies_9.jpg"));
        InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_9.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        // Criar nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        //Copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 400);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("Legal", 500, novaAltura - 90);

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("Saida/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
        var geradorDeFigurinhas = new GeradorDeFigurinhas();
        geradorDeFigurinhas.cria();
    }

}
