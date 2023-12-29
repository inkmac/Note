package TankGame.Programe02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class MyPanel extends JPanel implements KeyListener,Runnable {
    Hero hero;
    CopyOnWriteArrayList<EnemyTank> enemyTanks =  new CopyOnWriteArrayList<>();
    short size = 4;

    CopyOnWriteArrayList<Bomb> bombs = new CopyOnWriteArrayList<>();
    Image image;


    public MyPanel() {       //初始化tank的一些属性
        hero = new Hero(300,500);

        for (int i = 0; i < size; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 17, enemyTank.getY() + 55, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }

        image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb.png"));
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);

        //画出Hero, 子弹
        if (hero.isLive)
            drawTank(hero.getX(), hero.getY() - 100, g, "hero", hero.getDirect());

        for (Shot shot : hero.shots) {
            if (shot != null && shot.isLive)
                g.fillOval(shot.x, shot.y, 5, 5);
            else
                hero.shots.remove(shot);
        }


        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, "enemyTank", enemyTank.getDirect());

                for (Shot shot : enemyTank.shots) {
                    if (shot.isLive) {
                        g.fillOval(shot.x, shot.y, 5, 5);
                    }
                    else
                        enemyTank.shots.remove(shot);
                }
            }
        }


        for (Bomb bomb : bombs) {
            if (bomb.time > 0)
                g.drawImage(image, bomb.x, bomb.y, 60, 60, this);
            if (bomb.time == 0)
                bombs.remove(bomb);
            bomb.timeDown();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect("Up");   //将Direct设置成属性(变量), 这样就可以直接修改了
            if (hero.getY() > 100)
                hero.moveUp();      //封装成方法, 方便使用
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect("Down");
            if (hero.getY() + 60 < 830)
                hero.moveDown();
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect("Left");
            if (hero.getX() > 0)
                hero.moveLeft();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect("Right");
            if (hero.getX() + 60 < 1000)
                hero.moveRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_J)
            hero.shotEnemy();
    }


    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}


    //判断是否击中了enemyTank, 如果击中了就将hero.shot和enemyTank全部杀死
    public void hitTank(Shot s, Tank tank) {
        switch (tank.getDirect()) {
            case "Down", "Up":      //上下情况相同
                if (s.x > tank.getX() && s.x < tank.getX() + 40
                        && s.y > tank.getY() && s.y < tank.getY() + 60) {
                    s.isLive = false;
                    tank.isLive = false;
                    if (tank instanceof EnemyTank) {
                        enemyTanks.remove(tank);
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            case "Right", "Left":
                if (s.x > tank.getX() && s.x < tank.getX() + 60
                        && s.y > tank.getY() && s.y < tank.getY() + 40) {
                    s.isLive = false;
                    tank.isLive = false;
                    if (tank instanceof EnemyTank) {
                        enemyTanks.remove(tank);
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            default:
                System.out.println("hitTank wrong~");
        }
    }


    public void hitEnemyTank() {
        //对每一颗子弹都进行判断
        for (Shot shot : hero.shots) {
            //判断 ①hero是否发射了子弹 ②子弹是否击中了敌人
            if (shot != null && shot.isLive) {
                for (EnemyTank enemyTank : enemyTanks) {
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    public void hitHero() {
        for (EnemyTank enemyTank : enemyTanks) {
            for (Shot shot : enemyTank.shots) {
                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }


    @Override
    //其实写在这里的方法只是为了方便repaint(), 不过实际上都可以移至paint()中
    public void run() {
        while (true) {
            try {
                Thread.sleep(5);    //必须停止, 不然repaint太快Bomb显示不出来
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            hitEnemyTank();
            hitHero();
            this.repaint();
        }
    }



    public void drawTank(int x, int y, Graphics g, String type, String Direct) {
        //Tank颜色
        switch (type) {
            case "hero" ->     //我方tank
                    g.setColor(Color.yellow);
            case "enemyTank" ->     //敌方tank
                    g.setColor(Color.cyan);
            default ->
                    System.out.println("tank队伍输入有误");
        }


        switch (Direct) {
            case "Up":
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10,y+20,20,20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case "Down":
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10,y+20,20,20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case "Left":
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x, y + 20, x + 30, y + 20);
                break;
            case "Right":
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            default:
                System.out.println("Tank方向输入有误");
        }

    }
}
