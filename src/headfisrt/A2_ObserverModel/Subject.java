package headfisrt.A2_ObserverModel;

public interface Subject {
     void registerObverser(Observer observer);

     void removeObverser(Observer observer);

     void notifyObverser();
}
