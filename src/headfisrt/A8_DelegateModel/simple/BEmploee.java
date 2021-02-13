package headfisrt.A8_DelegateModel.simple;

public class BEmploee implements IEmploee {
    @Override
    public void doing(String command) {
        System.out.println("我是python程序员，现在要做"+command);
    }
}
