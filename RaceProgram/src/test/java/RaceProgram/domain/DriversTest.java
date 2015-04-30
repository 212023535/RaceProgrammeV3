package RaceProgram.domain;

import RaceProgram.Domain.Drivers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by student on 2015/04/16.
 */
public class DriversTest
{
    @Test
    public void testDrivers() throws Exception
    {
        Drivers drivers = new Drivers.Builder(88).classCode("V8M").driverName("Dawie Joubert").build();
        Assert.assertEquals("Dawie Joubert",drivers.getDriverName());
    }
}
