package headfisrt.A2_ObserverModel;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperture; //温度
    private float humidity; //湿度
    private float pressure; //气压

    public WeatherData(){
        observers = new ArrayList<>();
    }
    public void weatherDataChanged(){
        notifyObverser();
    }

    public void setWeatherData( float temperture,float humidity, float pressure){
        this.temperture = temperture;
        this.humidity = humidity;
        this.pressure = pressure;
        weatherDataChanged();
    }

    @Override
    public void registerObverser(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObverser(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObverser() {
        for (Observer o :observers){
            o.update(temperture,humidity,pressure);
        }
    }
}
