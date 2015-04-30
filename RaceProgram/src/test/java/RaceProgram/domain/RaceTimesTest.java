package RaceProgram.domain;

import RaceProgram.Domain.RaceTimes;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by student on 2015/04/16.
 */
public class RaceTimesTest
{
    @Test
    public void testRaceTimes() throws Exception
    {
        RaceTimes raceTimes = new RaceTimes.Builder("S&GT").raceTime("09:15").build();
        Assert.assertEquals("09:15",raceTimes.getRaceTime());
    }
}
