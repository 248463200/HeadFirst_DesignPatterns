package headfisrt.A2_ObserverModel.base2;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherData extends Observable {
    private float temperture; //温度
    private float humidity; //湿度
    private float pressure; //气压


    public void setWeatherData( float temperture,float humidity, float pressure){
        this.temperture = temperture;
        this.humidity = humidity;
        this.pressure = pressure;
        weatherDataChanged();
    }


    public  void  weatherDataChanged(){
        setChanged();
        notifyObservers();
    }

    public float getTemperture() {
        return temperture;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
