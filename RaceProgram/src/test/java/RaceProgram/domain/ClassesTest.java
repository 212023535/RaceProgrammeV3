package RaceProgram.domain;

import RaceProgram.Domain.Classes;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by student on 2015/04/15.
 */
public class ClassesTest
{

    @Test
    public void testClasses() throws Exception
    {
        Classes classes = new Classes.Builder("S&GT").className("Sports % GT").gridSize(12).raceTime("12:30").build();
        Assert.assertEquals("S&GT",classes.getClassCode());
    }
}
