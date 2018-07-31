import java.awt.*;


    public class Background {
        private Graphics graphics;

        public Background(Graphics graphics) {
            this.graphics = graphics;
        }

        public void renderBackground() {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0,0,1024,600);
        }
    }

