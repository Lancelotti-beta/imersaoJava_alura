import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeFigurinha {

    public void cria (String uri, String nameFile) throws Exception {
        //Fazer a leitura da imagem 
        InputStream input = new URL(uri).openStream();
        BufferedImage imageOrigin = ImageIO.read(input);

        //criar uma nova imagem
        int width = imageOrigin.getWidth();
        int height = imageOrigin.getHeight();
        int newHeigth = height + 175;

        BufferedImage newImage = new BufferedImage(width, newHeigth, BufferedImage.TRANSLUCENT);
        
        //copiar a nova imagem para a imagem Original
        Graphics2D graphics = (Graphics2D)newImage.getGraphics();
        graphics.drawImage(imageOrigin, 0, 0, null);

        //configurações da fonte
        // var font = new Font(Font.ROMAN_BASELINE, Font.BOLD, 32);
        // graphics.setColor(Color.DARK_GRAY);
        // graphics.setFont(font);

        // //Criar um texto na nova Imagem
        // graphics.drawString(text, width - 100, newHeigth - 100);


        //escrever a nova imagem em um arquivo 
        File file = new File(nameFile);
        if (!file.exists()) {
            file.mkdirs();
        }

        ImageIO.write(newImage, "png", file);
    }
}
