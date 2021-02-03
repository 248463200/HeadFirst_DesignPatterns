package headfisrt.A3_DecoratorMode;

public class Test {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();

        Mocha mocha = new Mocha(espresso);

        System.out.println(mocha.getDescription()+mocha.cost());
    }
}
