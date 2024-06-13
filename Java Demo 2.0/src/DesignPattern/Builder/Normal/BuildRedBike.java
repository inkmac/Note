package DesignPattern.Builder.Normal;

public class BuildRedBike extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("Build Red Bike Frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Build Red Bike Seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
