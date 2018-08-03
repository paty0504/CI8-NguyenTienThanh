import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Enemy {

    public BufferedImage image;
    EnemyShoot enemyShoot;
    Renderer renderer;

    public Vector2D position;

    public int width;
    public int height;

    public Vector2D velocity;

    private List<BulletEnemy> bulletEnemies;
    private int timeIntervalBullet = 0;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyAttack();
        this.renderer = new ImageRenderer("resources/images/circle.png", 10, 10);
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
    }

//    private void shoot() {
//        if (this.timeIntervalBullet == 30) {
//            for (double angle = 0.0; angle <360.0; angle += 360 /15 ){
//            BulletEnemy bulletEnemy = new BulletEnemy();
//            try {
//                bulletEnemy.image = ImageIO.read(new File("resources/images/circle.png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            bulletEnemy.position.set(this.position);
//            bulletEnemy.velocity.set(2, 0);
//            this.bulletEnemies.add(bulletEnemy);
//            this.timeIntervalBullet = 0;
//        } }else {
//            this.timeIntervalBullet += 1;
//        }
//
//        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
//    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, this.width, this.height, null);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));

    }
}