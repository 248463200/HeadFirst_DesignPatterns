package headfisrt.A8_DelegateModel.simple;

public class AEmploee implements IEmploee {
    @Override
    public void doing(String command) {
        System.out.println("我是java程序员，现在要做"+command);
    }
}
