import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public BufferedImage image;
    public int x;
    public int y;
    public int w;
    public int h;
    public int vx;
    public int vy;
    public void run(){
        this.x += this.vx;
        this.y += this.vy;
        if(this.x > 1024 || this.x < 1) this.vx = -this.vx;
        if(this.y > 600 || this.y < 1) this.vy = -this.vy;
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, this.w, this.h, null);
    }
}
