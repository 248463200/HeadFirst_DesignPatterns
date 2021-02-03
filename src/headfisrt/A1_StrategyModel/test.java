package headfisrt.A1_StrategyModel;

import headfisrt.A1_StrategyModel.animal.Duck;
import headfisrt.A1_StrategyModel.animal.MallardDuck;
import headfisrt.A1_StrategyModel.fly.FlyWithWings;
import headfisrt.A1_StrategyModel.quack.Quack;

public class test {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyWithWings());
        duck.setQuackBehavior(new Quack());

        duck.performFly();
        duck.performQuack();
    }
}
