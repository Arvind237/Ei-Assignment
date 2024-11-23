package Creational;

// Product Class
class Car {
    private String engine;
    private int wheels;
    private String color;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", color=" + color + "]";
    }
}

// Builder Interface
interface CarBuilder {
    void buildEngine();
    void buildWheels();
    void paintCar();
    Car getCar();
}

// Concrete Builder
class SportsCarBuilder implements CarBuilder {
    private Car car;

    public SportsCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("V8 Engine");
    }

    @Override
    public void buildWheels() {
        car.setWheels(4);
    }

    @Override
    public void paintCar() {
        car.setColor("Red");
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}

// Director
class CarDirector {
    private CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constructCar() {
        builder.buildEngine();
        builder.buildWheels();
        builder.paintCar();
        return builder.getCar();
    }
}

// Client Class
public class BuilderPattern {
    public static void main(String[] args) {
        CarBuilder sportsCarBuilder = new SportsCarBuilder();
        CarDirector director = new CarDirector(sportsCarBuilder);

        Car car = director.constructCar();
        System.out.println(car);
    }
}
