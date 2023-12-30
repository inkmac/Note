import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotExample {

    public static void main(String[] args) {
        int line = 9;
        int lineRun = 94500; // CHANGTUIAN 95000 + 1000   // 38500 // diyuyou 57000 + 1000
        int reversRun = 1800; // 2000
        int forwardRun = 15000;
        int timeAdjust = 1000;

        int startLine;
        do {
            startLine = Integer.parseInt(showInputBox("请输入起始行数: "));
        } while (startLine <= 0 || startLine > line);

        try {
            Robot robot = new Robot();
            Thread.sleep(3000);

            while (true) {
                for (int i = startLine - 1; i < line; i++) {
                    goRight(robot, lineRun);
                    goBack(robot, reversRun);
                    Thread.sleep(500);
                    goLeft(robot, lineRun);

                    if (i != 8) {
                        Thread.sleep(500);
                        goBack(robot, reversRun);
                    }
                }

                startLine = 1;

                goLeft(robot, timeAdjust);
                goForward(robot, forwardRun);
                goRight(robot, timeAdjust);
            }

        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String showInputBox(String message) {
        return javax.swing.JOptionPane.showInputDialog(null, message);
    }

    private static void goRight(Robot robot, int timeRun) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_D);
        robot.delay(timeRun);
        robot.keyRelease(KeyEvent.VK_D);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    private static void goBack(Robot robot, int timeRun) {
        robot.keyPress(KeyEvent.VK_S);
        robot.delay(timeRun);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    private static void goLeft(Robot robot, int timeRun) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(timeRun);
        robot.keyRelease(KeyEvent.VK_A);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    private static void goForward(Robot robot, int timeRun) {
        robot.keyPress(KeyEvent.VK_W);
        robot.keyPress(KeyEvent.VK_E);
        robot.delay(timeRun);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }
}

