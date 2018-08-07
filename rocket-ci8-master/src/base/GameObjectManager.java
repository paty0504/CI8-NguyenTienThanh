package base;

import game.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    static public GameObjectManager instance = new GameObjectManager();

    public List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list.forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public Player searchPlayer() {
        for (GameObject gameObject: GameObjectManager.instance.list) {
            if (gameObject.getClass() == Player.class) {
                return ((Player) gameObject);
            }
        }
        return null;
    }

    public void renderAll(Graphics graphics) {
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }

}