package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.RaceTimes;
import RaceProgram.Repositories.RaceTimesRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by student on 2015/04/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration

public class TestCrudRaceTimes
{
    String code;

    @Autowired
    RaceTimesRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        RaceTimes raceTimes = new RaceTimes.Builder("S&GT").raceTime("11:30").build();
        repository.save(raceTimes);
        code = raceTimes.getClassCode();
        Assert.assertNotNull("S&GT",raceTimes.getClassCode());
    }

    @Test
    public void testRead() throws Exception
    {
        RaceTimes raceTimes = repository.findByClass(code);
        Assert.assertEquals("S&GT",raceTimes.getClassCode());
    }

    @Test
    public void testUpdate() throws Exception
    {
        RaceTimes raceTimes = repository.findByClass(code);
        RaceTimes newRaceTimes = new RaceTimes.Builder("S&GT").raceTime("11:30").build();
        repository.save(newRaceTimes);
        Assert.assertEquals("S&GT",raceTimes.getClassCode());
    }

    @Test
    public void testDelete() throws Exception
    {
        RaceTimes raceTimes = repository.findByClass(code);
        repository.delete(raceTimes);
        RaceTimes raceTimes1 = repository.findByClass(code);
        Assert.assertNull(raceTimes1);
    }
}
