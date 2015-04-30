package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.PitCrews;
import RaceProgram.Repositories.PitCrewsRepository;
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

public class TestCrudPitCrews
{
    String name;

    @Autowired
    PitCrewsRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        PitCrews pitCrews = new PitCrews.Builder("Justin Divaris").answer(true).build();
        repository.save(pitCrews);
        name = pitCrews.getDriverName();
        Assert.assertNotNull(pitCrews.getAnswer());
    }

    @Test
    public void testRead() throws Exception
    {
        PitCrews pitCrews = repository.findByDriverName(name);
        Assert.assertEquals("Justin Divaris", pitCrews.getDriverName());
    }

    @Test
    public void testUpdate() throws Exception
    {
        PitCrews pitCrews = repository.findByDriverName(name);
        PitCrews newPitCrews = new PitCrews.Builder("Justin Divaris").answer(true).build();
        repository.save(newPitCrews);
        Assert.assertEquals(true,newPitCrews.getAnswer());
        Assert.assertEquals("Rudi Zeeman", newPitCrews.getDriverName());
    }

    @Test
    public void testDelete() throws Exception
    {
        PitCrews pitCrews = repository.findByDriverName(name);
        repository.delete(pitCrews);
        PitCrews newPitCrews = repository.findByDriverName(name);
        Assert.assertNull(newPitCrews);
    }

}
