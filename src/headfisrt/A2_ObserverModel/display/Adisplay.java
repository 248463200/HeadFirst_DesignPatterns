package headfisrt.A2_ObserverModel.display;

import headfisrt.A2_ObserverModel.DisplayElement;
import headfisrt.A2_ObserverModel.Observer;
import headfisrt.A2_ObserverModel.Subject;
import headfisrt.A2_ObserverModel.WeatherData;

public class Adisplay implements Observer, DisplayElement {
    private float temperture; //温度
    private float humidity; //湿度
    private float pressure; //气压

    public Adisplay() {
    }

    public Adisplay(Subject weatherData){
        weatherData.registerObverser(this);
    }
    @Override
    public void display() {
        System.out.println("A   display"+"温度A:"+temperture+"湿度A:"+humidity+"气压A:"+pressure);
    }

    @Override
    public void update(float temperture, float humidity, float pressure) {
        this.temperture = temperture;
        this.humidity =humidity;
        this.pressure = pressure;
        display();
    }
}
