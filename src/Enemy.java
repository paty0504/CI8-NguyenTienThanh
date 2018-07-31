import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Enemy {

    public BufferedImage image;

    Vector2D velocity;
    Vector2D position;

    public int width;
    public int height;

    public double angle = 0.0;

    private List<BulletEnemy> bulletEnemies;
    private int timeIntervalBullet = 0;

    public Enemy() {
        this.bulletEnemies = new ArrayList<>();
    }

    public void run() {
       this.position.addUp(velocity);

    }
    public void shootingAround(){
        this.velocity = this.velocity.rotate(angle);
        this.shoot();
    }

    private void shoot() {
        if (this.timeIntervalBullet == 30) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            try {
                bulletEnemy.image = ImageIO.read(new File("resources/images/circle.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bulletEnemy.position.set(this.position.x, this.position.y);
            bulletEnemy.velocity.set(2, 0);
            this.bulletEnemies.add(bulletEnemy);
            this.timeIntervalBullet = 0;
        } else {
            this.timeIntervalBullet += 1;
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }


    public void render(Graphics graphics) {
        graphics.drawImage(this.image,(int) this.position.x,(int) this.position.y, this.width, this.height, null);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));

    }
   public void followingEnemy(Vector2D vector2D) {
        this.velocity = vector2D.subtract(this.position).normalized();
    }
}
