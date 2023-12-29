package TankGame.Programe02;
import javax.swing.*;


public class PotTankGame extends JFrame {
    public static void main(String[] args){
        new PotTankGame();
    }

    public PotTankGame() {
        MyPanel mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
