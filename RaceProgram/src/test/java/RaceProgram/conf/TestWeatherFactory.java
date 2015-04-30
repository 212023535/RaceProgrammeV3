package RaceProgram.conf;

import RaceProgram.Conf.Factories.WeatherFactory;
import RaceProgram.Domain.Weather;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by student on 2015/04/23.
 */
public class TestWeatherFactory
{
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateWeather() throws Exception
    {
        Calendar date = Calendar.getInstance();
        String weather = "Sunny, MAX: 27, MIN:18";

        Weather weather1 = WeatherFactory.createWeather(date,weather);

        Assert.assertEquals("Sunny, MAX: 27, MIN:18",weather1.getWeather());
    }

    @Test
    public void testUpdateWeather() throws Exception
    {
        Calendar date = Calendar.getInstance();
        String weather = "Sunny, MAX: 27, MIN:18";

        Weather weather1 = WeatherFactory.createWeather(date,weather);

        Weather newWeather = new Weather.Builder(date).copy(weather1).weather("Rain, MAX 16, MIN: 8").build();

        Assert.assertEquals("Rain, MAX 16, MIN: 8",newWeather.getWeather());
    }
}
