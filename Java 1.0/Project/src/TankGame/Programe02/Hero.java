package TankGame.Programe02;

import java.util.concurrent.CopyOnWriteArrayList;

public class Hero extends Tank{
    public Hero(int x, int y) {
        super(x, y);
        super.direct = "Up";
        super.speed = 15;
    }

    Shot shot;           //该处定义, 防止下方shot重复定义报错
    CopyOnWriteArrayList<Shot> shots = new CopyOnWriteArrayList<>();

    public void shotEnemy() {   //初始化子弹位置

        if (shots.size() == 3)
            return;

        switch (direct) {
            case "Up":
                shot = new Shot(getX() + 17, getY() - 100, "Up");
                break;
            case "Right":
                shot = new Shot(getX() + 60, getY() - 82, "Right");
                break;
            case "Down":
                shot = new Shot(getX() + 17, getY() - 40, "Down");
                break;
            case "Left":
                shot = new Shot(getX(), getY() - 82, "Left");
                break;
            default:
                System.out.println("shotEnemy输入有误");
        }

        shots.add(shot);
        new Thread(shot).start();
    }
}
