package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.Cars;
import RaceProgram.Repositories.CarsRepository;
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

public class TestCrudCars
{
    String classCode;
    int carNumber;

    @Autowired
    CarsRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        List<Cars> carsList = new ArrayList<Cars>();
        Cars cars = new Cars.Builder(88).classCode("S&GT").driverName("Dawie Joubert").carType("Lotus Exige").build();
        repository.save(carsList);
        classCode= cars.getClassCode();
        Assert.assertNotNull(cars.getClassCode());
    }

    @Test
    public void testRead() throws Exception
    {
        Cars cars = repository.findByNumber(carNumber);
        Assert.assertEquals(88, cars.getCarNumber());
    }

    @Test
    public void testUpdate() throws Exception
    {
        Cars cars = repository.findByNumber(carNumber);
        Cars newCar = new Cars.Builder(14).classCode("S&GT").driverName("Rudi Zeeman").carType("Ariel Atom 500").build();
        repository.save(newCar);
        Assert.assertEquals("S&GT",cars.getClassCode());
        Assert.assertEquals(14,cars.getCarNumber());
    }

    @Test
    public void testDelete() throws Exception
    {
        Cars cars = repository.findByNumber(carNumber);
        repository.delete(cars);
        Cars newCar = repository.findByNumber(carNumber);
        Assert.assertNull(newCar);
    }
}
