package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.Bikes;
import RaceProgram.Repositories.BikesRepository;
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

public class TestCrudBikes
{
    String classCode;
    int bikeNumber;

    @Autowired
    BikesRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        List<Bikes> bikesList = new ArrayList<Bikes>();
        Bikes bikes = new Bikes.Builder(46).bikeType("Honda CBR 600RR").classCode("S600").driverName("Valentino Rossi").build();
        repository.save(bikesList);
        classCode= bikes.getClassCode();
        Assert.assertNotNull(bikes.getClassCode());
    }

    @Test
    public void testRead() throws Exception
    {
        Bikes bikes = repository.findByNumber(bikeNumber);
        Assert.assertEquals("46",bikes.getBikeNumber());
    }

    @Test
    public void testUpdate() throws Exception
    {
        Bikes bikes = repository.findByNumber(bikeNumber);
        Bikes newBike = new Bikes.Builder(76).bikeType("Suzuki GSX-R 750").classCode("SBS").driverName("Trevino Solomons").build();
        repository.save(newBike);
        Assert.assertEquals("SBS",bikes.getClassCode());
        Assert.assertEquals(76,bikes.getBikeNumber());
    }

    @Test
    public void testDelete() throws Exception
    {
        Bikes bikes = repository.findByNumber(bikeNumber);
        repository.delete(bikes);
        Bikes newBikes = repository.findByNumber(bikeNumber);
        Assert.assertNull(newBikes);
    }
}
