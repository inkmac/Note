package TankGame.event_;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BallMove extends JFrame {
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        MyPanel myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(400,300);
        this.addKeyListener(myPanel);       //可以监听JPanel发生的KeyEvent
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}


class MyPanel extends Panel implements KeyListener  {

    int x = 10;     //用变量来表示坐标, 方便移动
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    //当有字符输出时候, 该方法会触发
    @Override
    public void keyTyped(KeyEvent e) {}

    //当某个键被按下, 该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + " is pressed");

        //根据用户按下的不同Key来处理小球的移动
        if (e.getKeyCode()  == KeyEvent.VK_W)     //检测是否按下了W
            y--;
        else if (e.getKeyCode()  == KeyEvent.VK_S)
            y++;
        else if (e.getKeyCode()  == KeyEvent.VK_A)
            x--;
        else if(e.getKeyCode()  == KeyEvent.VK_D)   //用else-if防止按其他键也触发
            x++;

        //还要repaint面板
        this.repaint();
    }

    //当有某个键松开了, 该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {}
}
