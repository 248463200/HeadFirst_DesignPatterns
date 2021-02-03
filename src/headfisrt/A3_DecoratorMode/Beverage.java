package headfisrt.A3_DecoratorMode;

public abstract class Beverage {
    String description = "Unknown";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
