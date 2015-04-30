package RaceProgram.Conf.Factories;

import RaceProgram.Domain.Weather;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class WeatherFactory
{
    public static Weather createWeather(Calendar date,String weather)
    {
        Weather weather1 = new Weather.Builder(date).weather(weather).build();

        return weather1;
    }
}
