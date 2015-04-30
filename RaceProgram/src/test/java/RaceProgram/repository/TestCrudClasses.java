package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.Classes;
import RaceProgram.Repositories.ClassRepository;
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
 * Created by student on 2015/04/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudClasses
{
    private String classCode;
    private Long id;

    @Autowired
    ClassRepository repository;

    @Test
    public void testCreate() throws Exception {
        List<Classes> classesList = new ArrayList<Classes>();
        Classes classes = new Classes.Builder("S&GT").className("Sports & GT").gridSize(12).raceTime("11:00").build();
        repository.save(classesList);
        classCode= classes.getClassCode();
        Assert.assertNotNull(classes.getClassCode());
    }

    @Test
    public void testRead() throws Exception
    {
        Classes classes = repository.findOne(id);
        Assert.assertEquals("Sports & GT",classes.getClassName());
    }

    @Test
    public void testUpdate() throws Exception {
        Classes classes = repository.findOne(id);
        Classes newClass = new Classes.Builder("SB").className("Superbikes").gridSize(21).raceTime("12:30").build();
        repository.save(newClass);
        Assert.assertEquals("Superbikes",classes.getClassName());
        Assert.assertEquals("12:30",classes.getRaceTime());
    }

    @Test
    public void testDelete() throws Exception
    {
        Classes classes = repository.findOne(id);
        repository.delete(classes);
        Classes newClass = repository.findOne(id);
        Assert.assertNull(newClass);
    }
}
