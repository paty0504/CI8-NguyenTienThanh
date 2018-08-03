import java.util.ArrayList;
import java.util.List;

public class EnemyAttack implements EnemyShoot{
    public int timeInterval = 0;
    public List<BulletEnemy> bulletEnemies = new ArrayList<>();
    @Override
    public void run(Enemy enemy) {
        if (this.timeInterval == 50) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 15) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set((new Vector2D(2, 0)).rotate(angle)
                );
                this.bulletEnemies.add(bulletEnemy);
            }
            this.timeInterval = 0;
        } else {
            this.timeInterval += 1;
        }
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());

    }
}