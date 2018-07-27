import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setSize(1024, 600);
        this.setupGameCanvas();

        this.keyboardEvent();
        this.windowEvent();
        this.setVisible(true);
    }
    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);

    }
    private void windowEvent(){

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

    }
    private void keyboardEvent(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.positionXPlayer[0] -= gameCanvas.player.v;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.positionXPlayer[0] += gameCanvas.player.v;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    gameCanvas.player.positionYPlayer[0] -= gameCanvas.player.v;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    gameCanvas.player.positionYPlayer[0] += gameCanvas.player.v;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("Space Released");
                }
            }
        });

    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
