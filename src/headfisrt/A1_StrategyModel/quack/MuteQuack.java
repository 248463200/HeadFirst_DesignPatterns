package headfisrt.A1_StrategyModel.quack;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("嘎嘎嘎");
    }
}
