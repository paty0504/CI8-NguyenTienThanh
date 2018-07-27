import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public BufferedImage image;

    public int x;
    public int y;

    public int width;
    public int height;

    public int velocityX;
    public int velocityY;

    public void render(Graphics graphics ){
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);

    }
    public void run(){
        this.x -= this.velocityX;

    }





}
