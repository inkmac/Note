package TankGame.Programe01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Vector;


public class MyPanel extends JPanel implements KeyListener {
    Hero hero;
    Vector<EnemyTank> enemyTanks =  new Vector<>();
    short size = 3;

    public MyPanel() {
        hero = new Hero(200,200);   //初始化自己tank位置
        for (int i = 0; i < size; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);

            enemyTanks.add(enemyTank);

        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);

        //画出tank, 封装到drawTank方法
        drawTank(hero.getX(), hero.getY() - 100, g, "me", hero.getDirect());


        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, "enemy", enemyTank.getDirect());
        }

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect("Up");   //将Direct设置成变量(属性), 这样就可以直接修改了
            hero.moveUp();      //封装成方法, 方便使用
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect("Down");
            hero.moveDown();
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect("Left");
            hero.moveLeft();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect("Right");
            hero.moveRight();
        }

        this.repaint();
    }


    public void drawTank(int x, int y, Graphics g, String type, String Direct) {
        //Tank颜色
        switch (type) {
            case "me" ->     //我方tank
                    g.setColor(Color.yellow);
            case "enemy" ->     //敌方tank
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

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

}
