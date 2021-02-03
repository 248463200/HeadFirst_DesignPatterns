package headfisrt.A2_ObserverModel.base2.display;

import headfisrt.A2_ObserverModel.base2.DisplayElement;
import headfisrt.A2_ObserverModel.base2.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class Adisplay implements DisplayElement, Observer {
    private float temperture; //温度
    private float humidity; //湿度
    private float pressure; //气压
    private Observable observable;
    public Adisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("A   display"+"温度A:"+temperture+"湿度A:"+humidity+"气压A:"+pressure);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData w = (WeatherData) o;
            this.temperture = w.getTemperture();
            this.humidity =w.getHumidity();
            this.pressure = w.getPressure();
            display();
        }
    }
}
