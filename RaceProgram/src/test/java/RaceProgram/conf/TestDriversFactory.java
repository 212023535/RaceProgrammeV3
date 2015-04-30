package RaceProgram.conf;

import RaceProgram.Conf.Factories.DriversFactory;
import RaceProgram.Domain.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class TestDriversFactory
{
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateDrivers() throws Exception
    {
        int vehicleNumber = 88;
        Map<String,String> values = new HashMap<String, String>();

        values.put("classCode","S&GT");
        values.put("driverName","Dawie Joubert");

        Drivers drivers = DriversFactory.createDrivers(vehicleNumber,values);

        Assert.assertEquals("Dawie Joubert",drivers.getDriverName());
    }

    @Test
    public void testUpdateDrivers() throws Exception
    {
        int vehicleNumber = 77;
        Map<String,String> values = new HashMap<String, String>();

        values.put("classCode","S&GT");
        values.put("driverName","Dawie Joubert");

        Drivers drivers = DriversFactory.createDrivers(vehicleNumber,values);

        Drivers newDriver = new Drivers.Builder(vehicleNumber).copy(drivers).driverName("Johan Engelbrecht").build();

        Assert.assertEquals("Johan Engelbrecht",newDriver.getDriverName());
        Assert.assertEquals(77,newDriver.getVehicleNumber());
        Assert.assertEquals("S&GT",newDriver.getClassCode());
    }

    @Test
    public void testCreateCars() throws Exception
    {
        int carNumber = 0;
        Map<String,String> values = new HashMap<String, String>();
        String carType = "Lotus Exige Motorsport";

        values.put("classCode","S&GT");
        values.put("driverName","Dawie Joubert");

        Cars car = DriversFactory.createCars(carNumber,values,carType);

        Assert.assertEquals("Lotus Exige Motorsport",car.getCarType());
    }

    @Test
    public void testUpdateCars() throws Exception
    {
        int carNumber = 88;
        Map<String,String> values = new HashMap<String, String>();
        String carType = "Porsche GT3 Cup";

        values.put("classCode","S&GT");
        values.put("driverName","Dawie Joubert");

        Cars car = DriversFactory.createCars(carNumber,values,carType);

        Cars newCar = new Cars.Builder(carNumber).copy(car).carType(carType).build();

        Assert.assertEquals(88,newCar.getCarNumber());
        Assert.assertEquals("Dawie Joubert",newCar.getDriverName());
        Assert.assertEquals("Porsche GT3 Cup",newCar.getCarType());
        Assert.assertEquals("S&GT",newCar.getClassCode());
    }

    @Test
    public void testCreateBikes() throws Exception
    {
        int bikeNumber = 0;
        Map<String,String> values = new HashMap<String, String>();
        String bikeType = "Ducati 1199 Panigale";

        values.put("classCode","SBS");
        values.put("driverName","Casey Stoner");

        Bikes bike = DriversFactory.createBikes(bikeNumber, values, bikeType);

        Assert.assertEquals("Ducati 1199 Panigale", bike.getBikeType());
    }

    @Test
    public void testUpdateBikes() throws Exception
    {
        int bikeNumber = 6;
        Map<String,String> values = new HashMap<String, String>();
        String bikeType = "Yamaha R1";

        values.put("classCode","SBS");
        values.put("driverName","Casey Stoner");

        Bikes bike = DriversFactory.createBikes(bikeNumber, values, bikeType);

        Bikes newBike = new Bikes.Builder(bikeNumber).copy(bike).bikeType(bikeType).build();

        Assert.assertEquals(6,bike.getBikeNumber());
        Assert.assertEquals("Casey Stoner",newBike.getDriverName());
        Assert.assertEquals("Yamaha R1",newBike.getBikeType());
        Assert.assertEquals("SBS",newBike.getClassCode());
    }

    @Test
    public void testCreatePitCrews() throws Exception
    {
        boolean answer = true;
        String driverName = "";

        PitCrews pitCrews = DriversFactory.createPitCrews(false,"Dawie Joubert");

        Assert.assertFalse(pitCrews.getAnswer());
    }

    @Test
    public void testUpdatePitCrews() throws Exception
    {
        boolean answer = true;
        String driverName = "";

        PitCrews pitCrews = DriversFactory.createPitCrews(false,"Dawie Joubert");

        PitCrews newPitCrew = new PitCrews.Builder("Dawie Joubert").copy(pitCrews).answer(true).build();

        Assert.assertEquals("Dawie Joubert",newPitCrew.getDriverName());
        Assert.assertTrue(newPitCrew.getAnswer());
    }

    @Test
    public void testCreateGrid() throws Exception
    {
        int gridSize = 15;
        int gridPosition = 6;
        List<Drivers> driversList = new ArrayList<Drivers>();
        String classCode = "S&GT";

        Grid grid = DriversFactory.createGrid(gridSize,gridPosition,classCode,driversList);

        Assert.assertEquals(6,grid.getGridPosition());
    }

    @Test
    public void testUpdateGrid() throws Exception
    {
        int gridSize = 15;
        int gridPosition = 6;
        List<Drivers> driversList = new ArrayList<Drivers>();
        String classCode = "";

        Grid grid = DriversFactory.createGrid(gridSize,gridPosition,classCode,driversList);

        Grid newGrid = new Grid.Builder(gridSize).copy(grid).classCode("MSC").build();

        Assert.assertEquals(6,newGrid.getGridPosition());
        Assert.assertEquals(15,newGrid.getGridSize());
        Assert.assertEquals("MSC",newGrid.getClassCode());
    }

    @Test
    public void testCreateStandings() throws Exception
    {
        int position = 0;
        Map<String,String> values = new HashMap<String, String>();
        List<Drivers> driversList = new ArrayList<Drivers>();

        values.put("classCode","V8M");
        values.put("className","V8 Masters");

        Standings standings = DriversFactory.createStandings(position,values,driversList);

        Assert.assertEquals("V8M",standings.getClassCode());
    }

    @Test
    public void testUpdateStandings() throws Exception
    {
        int position = 0;
        Map<String,String> values = new HashMap<String, String>();
        List<Drivers> driversList = new ArrayList<Drivers>();

        values.put("classCode","V8M");
        values.put("className","V8 Masters");

        Standings standings = DriversFactory.createStandings(position,values,driversList);

        Standings newStandings = new Standings.Builder(standings.getClassCode()).copy(standings).position(8).build();

        Assert.assertEquals(8,newStandings.getPosition());
        Assert.assertEquals("V8M",newStandings.getClassCode());
        Assert.assertEquals("V8 Masters",newStandings.getClassName());
    }
}
