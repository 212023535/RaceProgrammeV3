package RaceProgram.repository;

import RaceProgram.App;
import RaceProgram.Domain.Grid;
import RaceProgram.Repositories.GridRepository;
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

public class TestCrudGrid
{
    int position;

    @Autowired
    GridRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Grid grid = new Grid.Builder(12).classCode("MSC").gridPosition(5).build();
        repository.save(grid);
        position = grid.getGridPosition();
        Assert.assertNotNull(grid.getClassCode());
    }

    @Test
    public void testRead() throws Exception
    {
        Grid grid = repository.findByPosition(position);
        Assert.assertEquals(12,grid.getGridSize());
    }

    @Test
    public void testUpdate() throws Exception
    {
        Grid grid = repository.findByPosition(position);
        Grid newGrid = new Grid.Builder(20).classCode("V8M").gridPosition(5).build();
        repository.save(newGrid);
        Assert.assertEquals("V8M",newGrid.getClassCode());
        Assert.assertEquals(20, newGrid.getGridSize());
    }

    @Test
    public void testDelete() throws Exception
    {
        Grid grid = repository.findByPosition(position);
        repository.delete(grid);
        Grid newGrid = repository.findByPosition(position);
        Assert.assertNull(newGrid);
    }
}
