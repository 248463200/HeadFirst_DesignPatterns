package headfisrt.A1_StrategyModel.animal;

import headfisrt.A1_StrategyModel.fly.FlyNoWay;
import headfisrt.A1_StrategyModel.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        super.flyBehavior = new FlyNoWay();
        super.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a MallardDuck");
    }
}
