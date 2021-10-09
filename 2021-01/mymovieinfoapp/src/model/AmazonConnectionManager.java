package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class AmazonConnectionManager {
    public BufferedImage requisitarPoster(String posterUrl) throws IOException {
        URLConnection connection = (new URL(posterUrl)).openConnection();
        BufferedImage resposta = ImageIO.read(connection.getInputStream());
        return resposta;
    }
}
