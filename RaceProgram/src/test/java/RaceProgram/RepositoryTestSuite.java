package RaceProgram;

import RaceProgram.repository.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by student on 2015/04/30.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestCrudBikes.class, TestCrudCars.class, TestCrudClasses.class, TestCrudClassSponsors.class,
        TestCrudDrivers.class,TestCrudGrid.class,TestCrudPitCrews.class,TestCrudRaceTimes.class,
        TestCrudStandings.class,TestCrudWeather.class})

public class RepositoryTestSuite {
}
