import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    // Star star = new Star(); khoi tao doi tuong
    private List<Star> stars; //khai bao mang
    private BufferedImage backBuffered;
    private BufferedImage playerImage;
    private List<Enemy> enemies;
    Player player = new Player();
    private int timeIntervalStar = 0;
    private Graphics graphics;
    private int timeEnemy = 0;
    private Random random = new Random();


    public GameCanvas() {

        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }
    private void setupEnemy(){
        this.enemies = new ArrayList<>();


    }
    private void setupCharacter() {
        this.setupStar();
        this.playerImage = this.loadImage("resources/images/circle.png");
        this.setupEnemy();
        this.setupPlayer();
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.renderBackground();

        this.stars.forEach(star -> star.render(graphics) );

        this.player.render(graphics);

        this.enemies.forEach(enemy -> enemy.render(graphics));


        this.repaint();
    }

    public void runAll() {
        this.stars.forEach(star -> star.run());
        this.playerMove();
        this.createStar();
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run());
        this.createPlayer();

    }
    private void setupPlayer(){
        this.player.positionYPlayer[0] = 500;
        this.player.positionYPlayer[0] = 500;
    }


    private void playerMove() {
        if (this.player.positionXPlayer[0] > 1024 && this.player.positionXPlayer[1] > 1024 && this.player.positionXPlayer[2]>1024) {
            this.player.positionXPlayer[0] = 0;
            this.createPlayer();
        }
        if (this.player.positionXPlayer[0] < 0 && this.player.positionXPlayer[1] < 0 && this.player.positionXPlayer[2] < 0) {
            this.player.positionXPlayer[0] = 1024;
            this.createPlayer();
        }
        if (this.player.positionYPlayer[0] > 600 && this.player.positionYPlayer[1] > 600 && this.player.positionYPlayer[2] > 600) {

            this.player.positionYPlayer[0] = 0;
            this.createPlayer();
        }
        if (this.player.positionYPlayer[0] < 0 && this.player.positionYPlayer[1] < 0 && this.player.positionYPlayer[2] < 0) {

            this.player.positionYPlayer[0] = 600;
            this.createPlayer();
        }
    }

    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

    private void createStar(){
        if (this.timeIntervalStar == 30){   // den 30 thi tao 1 star roi reset lai loop
            Star star = new Star();
            star.x = 1024;
            star.y = this.random.nextInt(600);
            star.image = this.loadImage("resources/images/star.png");
            star.width = 20;
            star.height = 20;
            star.velocityX = this.random.nextInt(3) + 1;
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }



    }
    private void createEnemy(){
        if(this.timeEnemy == 10){
            Enemy enemy = new Enemy();
            enemy.x = this.random.nextInt(1024);
            enemy.y = this.random.nextInt(600);
            enemy.w = 5;
            enemy.h = 5;
            enemy.image = this.loadImage("resources/images/circle.png");
            enemy.vx = this.random.nextInt(3) + 1;
            enemy.vy = this.random.nextInt(3) + 1;
            this.enemies.add(enemy);
            this.timeEnemy =0;
        } else {
            this.timeEnemy +=1;
        }
    }
    private void createPlayer() {
        this.player.positionXPlayer[1] = this.player.positionXPlayer[0] + 50;
        this.player.positionYPlayer[1] = this.player.positionYPlayer[0];

        this.player.positionXPlayer[2] = this.player.positionXPlayer[0] + 50 / 2;
        this.player.positionYPlayer[2] = this.player.positionYPlayer[0] - 50;

        this.player.v = 5;
    }
}
