import java.util.Random;
import java.util.Scanner;

public class Hw {
    public static void main(String[] args) {

        // Map
        int w = 4;
        int h = 4;

        //Player
        int xP = 0;
        int yP = 0;
        // enemy1
        Random random = new Random();
        int e1x = random.nextInt(4);
        int e1y = random.nextInt(4);
        // enemy2

        int e2x = random.nextInt(4);
        int e2y = random.nextInt(4);
        int gx = random.nextInt(4);
        int gy = random.nextInt(4);
        boolean win = true;

        while(true){

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (xP == j && yP == i) {
                        System.out.print("P");

                    } else if ((e1x == j && e1y == i) || (e2x == j && e2y == i)) {
                        System.out.print("E");
                    }
                     else if (gx == j && gy == i) {
                        System.out.print("G");
                    }
                    else {
                        System.out.print("*");
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            int dx = 0;
            int dy = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your move?");
            String key = scanner.next();
            if (key.equals("w")) {
                dy -= 1;
            } else if (key.equals("a")) {
                dx-= 1;
            } else if (key.equals("d")) {
                dx += 1;
            } else if (key.equals("s")) {
                dy += 1;
            }
            if ((0 <= ( xP + dx)&& ( xP + dx) <= 4) && (0 <= ( yP + dy) && ( yP + dy)  <= 4) ){
                xP += dx;
                yP += dy;

            }
            if (0<= (e1x + 1) && (e1x +1) <=4){
                e1x +=1;
                if (e1x == 4){
                    e1x -=4;
                }
            }
            if (0<= (e2y + 1) && (e2y +1) <=4){
                e2y +=1;
                if (e2y == 4){
                    e2y -=4;
                }
            }

            if (((xP == e1x) && (yP == e1y)) || ((xP == e2x) && (yP == e2y)) ){
                System.out.println("You lose");
                break;
            }
            if (xP == gx && yP == gy){
                win = false;
            }
            if (win == false) {

                System.out.println("You win");
                break;
            }
        }


    }
}