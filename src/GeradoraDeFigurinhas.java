import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void criar(InputStream inputStream, String nomeArquivo) throws Exception{

        //Leitura de imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg")); CRIA O INPUT DE BYTES A PARTIR DE UM ARQUIVO LOCAL
        //inputStream inputStream = new URL(url).openStream(); CRIA O INPUT DE BYTES A PARTIR DE UMA URL
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //Cria nova imagem em memória com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);

        //Copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0,null);

        //Configurar fonte
        Font fonte = new Font(Font.SANS_SERIF,Font.BOLD,64);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        //Escrever uma frase na nova imagem
        graphics.drawString("Topzera", 100, novaAltura - 100);

        //Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
