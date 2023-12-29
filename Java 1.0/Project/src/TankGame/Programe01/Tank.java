package TankGame.Programe01;
//封装: 代码 -> 方法; 数值 -> 变量/属性

public class Tank {
    private int x;
    private int y;
    public String direct = "Up";    //需要有一个默认值
    protected short speed;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public short getSpeed() {
        return speed;
    }

    public void setSpeed(short speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }
}
