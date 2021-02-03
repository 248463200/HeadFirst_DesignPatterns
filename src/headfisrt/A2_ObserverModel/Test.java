package headfisrt.A2_ObserverModel;

import headfisrt.A2_ObserverModel.display.Adisplay;
import headfisrt.A2_ObserverModel.display.Bdispay;
import headfisrt.A2_ObserverModel.display.Cdisplay;

public class Test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Adisplay a = new Adisplay(weatherData);
        Bdispay b = new Bdispay(weatherData);
        Cdisplay c = new Cdisplay(weatherData);

        weatherData.setWeatherData(33,22,11);

    }
}
