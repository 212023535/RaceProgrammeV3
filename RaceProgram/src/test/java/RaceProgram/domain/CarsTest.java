package RaceProgram.domain;

import RaceProgram.Domain.Cars;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by student on 2015/04/16.
 */
public class CarsTest
{
    @Test
    public void testCars() throws Exception
    {
        Cars cars = new Cars.Builder(14).carType("Porsche GT3 Cup").classCode("S&GT").driverName("Craig Jarvis").build();
        Assert.assertEquals("Porsche GT3 Cup",cars.getCarType());
    }
}
