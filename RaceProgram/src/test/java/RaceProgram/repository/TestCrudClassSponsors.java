package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.ClassSponsors;
import RaceProgram.Repositories.ClassSponsorRepository;
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

public class TestCrudClassSponsors
{
    String classCode;

    @Autowired
    ClassSponsorRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        ClassSponsors classSponsors = new ClassSponsors.Builder("S&GT").className("Sports & GT").sponsor("Le Joubert").build();
        repository.save(classSponsors);
        classCode = classSponsors.getClassCode();
        Assert.assertNotNull(classSponsors.getClassCode());
    }

    @Test
    public void testRead() throws Exception
    {
        ClassSponsors cs = repository.findByClassCode(classCode);
        Assert.assertEquals("S&GT",cs.getClassCode());
    }

    @Test
    public void testUpdate() throws Exception
    {
        ClassSponsors cs = repository.findByClassCode(classCode);
        ClassSponsors newClassSponsors = new ClassSponsors.Builder("V8M").className("V8 Masters").sponsor("Novel Ford").build();
        repository.save(newClassSponsors);
        Assert.assertEquals("V8M", newClassSponsors.getClassCode());
        Assert.assertEquals("Novel Ford",newClassSponsors.getSponsor());
    }

    @Test
    public void testDelete() throws Exception
    {
        ClassSponsors cs = repository.findByClassCode(classCode);
        repository.delete(cs);
        ClassSponsors newCS = repository.findByClassCode(classCode);
        Assert.assertNull(newCS);
    }
}
