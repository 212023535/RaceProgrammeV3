package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.Standings;
import RaceProgram.Repositories.StandingsRepository;
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

public class TestCrudStandings
{
    int pos;

    @Autowired
    StandingsRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Standings standings = new Standings.Builder("V8M").position(8).className("V8 Masters").build();
        repository.save(standings);
        pos = standings.getPosition();
        Assert.assertNotNull(standings.getClassCode());
    }

    @Test
    public void testRead() throws Exception
    {
        Standings standings = repository.findByStanding(pos);
        Assert.assertEquals("V8 Masters", standings.getClassName());
    }

    @Test
    public void testUpdate() throws Exception {
        Standings standings = repository.findByStanding(pos);
        Standings newStandings = new Standings.Builder("V8M").position(8).className("V8 Masters").build();
        repository.save(newStandings);
        Assert.assertEquals("V8 Masters", standings.getClassName());
        Assert.assertEquals(8,newStandings.getPosition());
    }

    @Test
    public void testDelete() throws Exception
    {
        Standings standings = repository.findByStanding(pos);
        repository.delete(standings);
        Standings newStandings = repository.findByStanding(pos);
        Assert.assertNull(newStandings);
    }

}
