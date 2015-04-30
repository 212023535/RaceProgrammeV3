package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.Drivers;
import RaceProgram.Repositories.DriversRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration

public class TestCrudDrivers
{
    String name;

    @Autowired
    DriversRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Drivers drivers = new Drivers.Builder(88).classCode("S&GT").driverName("Dawie Joubert").build();
        repository.save(drivers);
        name = drivers.getDriverName();
        Assert.assertNotNull(drivers.getClassCode());
    }

    @Test
    public void testRead() throws Exception
    {
        Drivers drivers = repository.findByName(name);
        Assert.assertEquals("Dawie Joubert",drivers.getDriverName());
    }

    @Test
    public void testUpdate() throws Exception
    {
        Drivers drivers = repository.findByName(name);
        Drivers newDrivers = new Drivers.Builder(14).classCode("S&GT").driverName("Rudi Zeeman").build();
        repository.save(newDrivers);
        Assert.assertEquals("S&GT",newDrivers.getClassCode());
        Assert.assertEquals("Rudi Zeeman", drivers.getDriverName());
    }

    @Test
    public void testDelete() throws Exception
    {
        Drivers drivers = repository.findByName(name);
        repository.delete(drivers);
        Drivers newDrivers = repository.findByName(name);
        Assert.assertNull(newDrivers);
    }
}
