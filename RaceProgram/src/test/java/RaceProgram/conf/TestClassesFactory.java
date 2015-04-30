package RaceProgram.conf;

import RaceProgram.Conf.Factories.ClassesFactory;
import RaceProgram.Domain.ClassSponsors;
import RaceProgram.Domain.Classes;
import RaceProgram.Domain.Drivers;
import RaceProgram.Domain.RaceTimes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class TestClassesFactory
{
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateClass() throws Exception
    {
        List<Drivers> driversList = new ArrayList<Drivers>();
        Map<String,String> values = new HashMap<String, String>();
        String raceTime;
        int gridSize;

        values.put("classCode","S&GT");
        values.put("className","Sports & GT");
        gridSize = 8;
        raceTime = "11:00";

        Classes classes = ClassesFactory.createClass(12,values,"11:00",driversList);

        Assert.assertEquals("S&GT",classes.getClassCode());
    }

    @Test
    public void testUpdateClass() throws Exception
    {
        List<Drivers> driversList = new ArrayList<Drivers>();
        Map<String,String> values = new HashMap<String, String>();
        String raceTime;
        int gridSize;

        values.put("classCode","S&GT");
        values.put("className","Sports & GT");
        gridSize = 8;
        raceTime = "11:00";

        Classes classes = ClassesFactory.createClass(gridSize,values,raceTime,driversList);

        Classes newClass = new Classes.Builder(classes.getClassCode()).copy(classes).gridSize(6).raceTime("11:30").build();

        Assert.assertEquals("S&GT",newClass.getClassCode());
        Assert.assertEquals("Sports & GT",newClass.getClassName());
        Assert.assertEquals(6,newClass.getGridSize());
        Assert.assertEquals("11:30",newClass.getRaceTime());
    }

    @Test
    public void testCreateSponsor() throws Exception
    {
        Map<String,String> values = new HashMap<String, String>();
        String sponsor;

        values.put("classCode","SBS");
        values.put("className","Superbikes");
        sponsor = "Midas";

        ClassSponsors classSponsors = ClassesFactory.createSponsors(values,sponsor);

        Assert.assertEquals("Midas",classSponsors.getSponsor());

    }

    @Test
    public void testUpdateSponsor() throws Exception
    {
        Map<String,String> values = new HashMap<String, String>();
        String sponsor = "";

        values.put("classCode","SBS");
        values.put("className","Superbikes");

        ClassSponsors classSponsors = ClassesFactory.createSponsors(values,sponsor);

        ClassSponsors newSponsor = new ClassSponsors.Builder(classSponsors.getClassCode()).copy(classSponsors).sponsor("Sony").build();

        Assert.assertEquals("Sony",newSponsor.getSponsor());
        Assert.assertEquals("Superbikes",newSponsor.getClassName());
        Assert.assertEquals("SBS",newSponsor.getClassCode());
    }

    @Test
    public void testCreateRaceTimes() throws Exception
    {
        Map<String,String> values = new HashMap<String, String>();

        values.put("classCode","S600");
        values.put("raceTime","14:30");

        RaceTimes raceTimes = ClassesFactory.createRaceTimes(values);

        Assert.assertEquals("S600",raceTimes.getClassCode());
    }

    @Test
    public void testUpdateRaceTimes() throws Exception
    {
        Map<String,String> values = new HashMap<String, String>();

        values.put("classCode","S600");
        values.put("raceTime","14:30");

        RaceTimes raceTimes = ClassesFactory.createRaceTimes(values);

        RaceTimes newRaceTime = new RaceTimes.Builder(raceTimes.getClassCode()).copy(raceTimes).raceTime("12:00").build();

        Assert.assertEquals("12:00",newRaceTime.getRaceTime());
        Assert.assertEquals("S600",newRaceTime.getClassCode());
    }
}
