package TankGame.Programe02;

public class Bomb {
    int x;
    int y;
    int time = 75;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void timeDown() {
        if (time > 0)
            time--;
    }
}
