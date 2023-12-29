package TankGame.Programe01;

import java.util.Vector;


public class EnemyTank extends Tank{

    public EnemyTank(int x, int y) {
        super(x, y);
        super.direct = "Down";
        super.speed = 2;
    }


}



