package DesignPattern.Builder.Normal;

public class BuildBlueBike extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("Build Blue Bike Frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Build Blue Seat Frame");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
