package headfisrt.A2_ObserverModel.display;

import headfisrt.A2_ObserverModel.DisplayElement;
import headfisrt.A2_ObserverModel.Observer;
import headfisrt.A2_ObserverModel.Subject;
import headfisrt.A2_ObserverModel.WeatherData;

public class Bdispay implements DisplayElement, Observer {
    private float temperture; //温度
    private float humidity; //湿度
    private float pressure; //气压

    public Bdispay() {
    }

    public Bdispay(Subject weatherData){
        weatherData.registerObverser(this);
    }
    @Override
    public void display() {
        System.out.println("B   display"+"温度B:"+temperture+"湿度B:"+humidity+"气压B:"+pressure);
    }

    @Override
    public void update(float temperture, float humidity, float pressure) {
        this.temperture = temperture;
        this.humidity =humidity;
        this.pressure = pressure;
        display();
    }
}
