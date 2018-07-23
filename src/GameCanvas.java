import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {

    private BufferedImage starImage;
    private BufferedImage backBuffered;
    private BufferedImage playerImage;

    public int positionXStar = 1024;
    public int positionYStar = 200;

    public int positionXPlayer = 600;
    public int positionYPlayer = 200;

    public int dx = 10;
    public int dy = 10;

    private Graphics graphics;
    public static Random r = new Random();


    public GameCanvas() {

        this.setSize(1024, 600);

        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();

        // load anh
        try {
            this.starImage = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // draw

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);

    }

    public void renderAll() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);

        this.graphics.drawImage(this.starImage, this.positionXStar, this.positionYStar, 20, 20, null);

        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);

        this.repaint();

        if(this.positionXPlayer < 0){
            this.positionXPlayer = 1024;
            this.positionYPlayer = r.nextInt(600);
        }
        if(this.positionYPlayer < 0){
            this.positionYPlayer = 600;
            this.positionXPlayer = r.nextInt(1024);
        }
        if(this.positionXPlayer > 1024){
            this.positionXPlayer = 0;
            this.positionYPlayer = r.nextInt(600);
        }
        if(this.positionYPlayer > 600){
            this.positionYPlayer = 0;
            this.positionXPlayer = r.nextInt(1024);
        }
        this.positionXStar +=dx;
        if(this.positionXStar < 10 || this.positionXStar > 1024){
            dx = -dx;
        }
        this.positionYStar +=dy;
        if(this.positionYStar < 10 || this.positionYStar > 600){
            dy = -dy;
        }



    }

}
