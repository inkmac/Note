package TankGame.Draw;

import javax.swing.*;
import java.awt.*;


class Draw extends JFrame{       //JFrame对应窗口
    public static void main(String[] args) {
        new Draw();
    }

    public Draw() {
        MyPanel mp = new MyPanel();

        this.add(mp);   //把面板加入到窗口
        this.setSize(400,300);  //设置窗口的大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //点击x就退出程序
        this.setVisible(true);      //可以显示

    }

}


//定义MyPanel, 继承JPanel类, 获取面板
class MyPanel extends JPanel {

    @Override
    public void paint(Graphics g) {     //系统会自动调用paint方法
        super.paint(g);     //调用父类的方法完成初始化, 不能去掉

        g.drawOval(20,20,100,100);
        g.drawLine(20,20,100,100);
        g.drawRect(20,20,50,100);


        g.setColor(Color.blue);       //需要先获取画笔
        g.fillRect(20,20,50,100);
        g.fill3DRect(20,20,50,100,false);   //实现3D图形效果, false效果比较好
        g.fillOval(20,20,100,100);


        // 只能用相对路径获取图片
        Image image = Toolkit.getDefaultToolkit().getImage(Draw.class.getResource("/bomb.png"));
        g.drawImage(image, 10, 10, 230,160, this);


        g.setColor(Color.PINK);
        g.setFont(new Font("隶书", Font.BOLD,50));
        g.drawString("你好",100,100);

        this.repaint();     //如果在paint()中调用repaint(), 就会无限paint !!!!!!!
    }
}