package RaceProgram.Conf.Factories;

import RaceProgram.Domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class DriversFactory
{
    public static Drivers createDrivers(int vehicleNumber,Map<String,String> values)
    {
        Drivers drivers = new Drivers.Builder(vehicleNumber).classCode(values.get("classCode")).driverName(values.get("driverName")).build();
        return drivers;
    }

    public static Cars createCars(int carNumber,Map<String,String> values,String carType)
    {
        Cars cars = new Cars.Builder(carNumber).driverName(values.get("driverName")).classCode(values.get("classCode"))
                        .carType(carType).build();

        return cars;
    }

    public static Bikes createBikes(int bikeNumber,Map<String,String> values,String bikeType)
    {
        Bikes bikes = new Bikes.Builder(bikeNumber).driverName(values.get("driverName")).classCode(values.get("classCode"))
                .bikeType(bikeType).build();

        return bikes;
    }

    public static PitCrews createPitCrews(boolean answer, String driverName)
    {
        PitCrews pitCrews = new PitCrews.Builder(driverName).answer(answer).build();

        return pitCrews;
    }

    public static Grid createGrid(int gridSize,int gridPosition,String classCode,List<Drivers> driversList)
    {
        Grid grid = new Grid.Builder(gridSize).driverName(driversList)
                        .gridPosition(gridPosition).classCode(classCode).build();

        return grid;
    }

    public static Standings createStandings(int position,Map<String,String> values,List<Drivers> driversList)
    {
        Standings standings = new Standings.Builder(values.get("classCode")).position(position).className(values.get("className"))
                                    .driverName(driversList).build();

        return standings;
    }
}
