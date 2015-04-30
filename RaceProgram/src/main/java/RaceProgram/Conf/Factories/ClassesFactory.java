package RaceProgram.Conf.Factories;

import RaceProgram.Domain.ClassSponsors;
import RaceProgram.Domain.Classes;
import RaceProgram.Domain.Drivers;
import RaceProgram.Domain.RaceTimes;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class ClassesFactory
{
    public static Classes createClass(int gridSize,Map<String,String> values,String raceTime,List<Drivers> driversList)
    {
        Classes classes = new Classes.Builder(values.get("classCode"))
                                    .className(values.get("className"))
                                    .gridSize(gridSize)
                                    .raceTime(raceTime)
                                    .driversList(driversList)
                                    .build();
        return classes;
    }

    public static ClassSponsors createSponsors(Map<String,String> values,String sponsor)
    {
        ClassSponsors classSponsors = new ClassSponsors.Builder(values.get("classCode"))
                                                        .className(values.get("className"))
                                                        .sponsor(sponsor)
                                                        .build();
        return classSponsors;
    }

    public static RaceTimes createRaceTimes(Map<String,String> values)
    {
        RaceTimes raceTimes = new RaceTimes.Builder(values.get("classCode")).raceTime(values.get("raceTime")).build();
        return raceTimes;
    }
}
