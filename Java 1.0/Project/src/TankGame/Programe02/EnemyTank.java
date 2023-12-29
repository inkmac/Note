package TankGame.Programe02;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class EnemyTank extends Tank implements Runnable{

    public EnemyTank(int x, int y) {
        super(x, y);
        super.direct = "Down";
        super.speed = 2;
    }

    CopyOnWriteArrayList<Shot> shots = new CopyOnWriteArrayList<>();
    short runtime = 40;


    @Override
    public void run() {
        while (true) {      //让线程一直重复执行, 一直射子弹

            if (this.isLive && shots.size() < 3) {
                Shot shot = null;

                switch (this.getDirect()) {
                    case "Up":
                        shot = new Shot(getX() + 20, getY(), "Up");
                        break;
                    case "Right":
                        shot = new Shot(getX() + 60, getY() + 20, "Right");
                        break;
                    case "Down":
                        shot = new Shot(getX() + 17, getY() + 60, "Down");
                        break;
                    case "Left":
                        shot = new Shot(getX(), getY() + 20, "Left");
                        break;
                    default:
                        System.out.println("EnemyShot输入有误");
                }

                shots.add(shot);
                new Thread(shot).start();
            }

            switch (direct) {
                case "Up":
                    for (int i = 0; i < runtime; i++) {
                        if (getY() > 0)
                            moveUp();
                        try {
                            Thread.sleep(50);   //每动一次停50ms,不然就飞走了
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "Down":
                    for (int i = 0; i < runtime; i++) {
                        if (getY() + 60 < 750)
                            moveDown();
                        try {
                            Thread.sleep(50);   //每动一次停50ms,不然就飞走了
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "Left":
                    for (int i = 0; i < runtime; i++) {
                        if (getX() > 0)
                            moveLeft();
                        try {
                            Thread.sleep(50);   //每动一次停50ms,不然就飞走了
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "Right":
                    for (int i = 0; i < runtime; i++) {
                        if (getX() + 60 < 1000)
                            moveRight();
                        try {
                            Thread.sleep(50);   //每动一次停50ms,不然就飞走了
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                default:
                    System.out.println("RandomGet wrong~");
            }


            //随机获取一个字符串, 并设置方向
            String[] randomArr = {"Up", "Down", "Left", "Right"};
            Random random = new Random();
            int randomIndex = random.nextInt(randomArr.length);
            String randomGet = randomArr[randomIndex];
            setDirect(randomGet);


            //老韩说明: 写并发程序, 一定要考虑清楚, 该线程什么时候结束!!!!!!!
            if (!this.isLive)
                break;  //break退出循环后, run方法就结束了, 线程退出
        }

    }
}

