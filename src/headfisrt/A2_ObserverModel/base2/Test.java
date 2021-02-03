package headfisrt.A2_ObserverModel.base2;

import headfisrt.A2_ObserverModel.base2.display.Adisplay;
import headfisrt.A2_ObserverModel.base2.display.Bdisplay;
import headfisrt.A2_ObserverModel.base2.display.Cdisplay;

public class Test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Adisplay a = new Adisplay(weatherData);

        Bdisplay b = new Bdisplay(weatherData);

        Cdisplay c = new Cdisplay(weatherData);

        weatherData.setWeatherData(33,22,11);


    }
}
