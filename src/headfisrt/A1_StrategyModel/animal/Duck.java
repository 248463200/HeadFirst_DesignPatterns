package headfisrt.A1_StrategyModel.animal;

import headfisrt.A1_StrategyModel.fly.FlyBehavior;
import headfisrt.A1_StrategyModel.quack.QuackBehavior;

public abstract class Duck {

     FlyBehavior flyBehavior;
     QuackBehavior quackBehavior;


    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public Duck() {
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float ,even decoys!");
    }
}
