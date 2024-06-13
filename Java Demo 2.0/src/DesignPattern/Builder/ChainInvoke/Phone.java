package DesignPattern.Builder.ChainInvoke;

public class Phone {
    private final String cpu;
    private final String screen;
    private final String memory;
    private final String mainboard;

    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setScreen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder setMemory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder setMainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }
}
