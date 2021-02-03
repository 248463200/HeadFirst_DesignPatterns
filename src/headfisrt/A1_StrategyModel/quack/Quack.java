package headfisrt.A1_StrategyModel.quack;

public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
