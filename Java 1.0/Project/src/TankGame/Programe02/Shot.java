package TankGame.Programe02;

public class Shot implements Runnable{
    int x;
    int y;
    String direct = "Up";
    final int speed = 8;
    boolean isLive = true;

    public Shot(int x, int y, String direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

//    static int i = 0;

    @Override
    public void run() {     //子弹移动
        for (;true;) {
            try {
                Thread.sleep(50);           //每次移动停50ms, 不然直接飞出了
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (direct) {
                case "Up":
                    y -= speed;
                    break;
                case "Right":
                    x += speed;
                    break;
                case "Down":
                    y += speed;
                    break;
                case "Left":
                    x -= speed;
                    break;
                default:
                    System.out.println("子弹方向输入有误");
            }


            //移出边界的时候, 就销毁
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isLive = false;
//                System.out.println("Break" + i++);
                break;
            }

            //子弹成功hitTank后, 就销毁
            if (!isLive)
                break;

        }
    }
}
