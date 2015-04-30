package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.Weather;
import RaceProgram.Repositories.WeatherRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;

/**
 * Created by student on 2015/04/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration

public class TestCrudWeather
{
    Calendar date;

    @Autowired
    WeatherRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Weather weather = new Weather.Builder(date).weather("Sunny").build();
        repository.save(weather);
        date = weather.getDate();
        Assert.assertNotNull(weather);
    }

    @Test
    public void testRead() throws Exception
    {
        Weather weather = repository.findByDate(date);
        Assert.assertEquals("Sunny",weather.getWeather());
    }

    @Test
    public void testUpdate() throws Exception {
        Weather weather = repository.findByDate(date);
        Weather newWeather = new Weather.Builder(date).weather("Rainy").build();
        repository.save(weather);
        Assert.assertEquals("Rainy",newWeather.getWeather());
    }

    @Test
    public void testDelete() throws Exception
    {
        Weather weather = repository.findByDate(date);
        repository.delete(weather);
        Weather newWeather = repository.findByDate(date);
        Assert.assertNull(newWeather);
    }

}
