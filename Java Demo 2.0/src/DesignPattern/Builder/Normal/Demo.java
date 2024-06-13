package DesignPattern.Builder.Normal;

public class Demo {
    public static void main(String[] args) {
        // 创建Director对象
        Director director = new Director(new BuildBlueBike());

        // director指挥建造Bike
        Bike blueBike = director.construct();

    }
}
