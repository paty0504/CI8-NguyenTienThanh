import java.awt.image.BufferedImage;
import java.awt.*;

public class Player {
    BufferedImage image;
    int []positionXPlayer = new int[3];
    int []positionYPlayer = new int[3];
    int v;
    public void render(Graphics graphics) {
        graphics.setColor(Color.GREEN);

        graphics.fillPolygon(this.positionXPlayer, this.positionYPlayer, 3);
    }


}
