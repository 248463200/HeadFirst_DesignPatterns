package headfisrt.A8_DelegateModel.simple;

public class DelegateModel {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.command("java", new Leader());
    }
}
