package RaceProgram;

/**
 * Created by student on 2015/04/30.
 */

import RaceProgram.conf.TestClassesFactory;
import RaceProgram.conf.TestDriversFactory;
import RaceProgram.conf.TestWeatherFactory;
import RaceProgram.domain.CarsTest;
import RaceProgram.domain.ClassesTest;
import RaceProgram.domain.DriversTest;
import RaceProgram.domain.RaceTimesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestClassesFactory.class,TestDriversFactory.class,TestWeatherFactory.class,
        CarsTest.class,DriversTest.class,ClassesTest.class,
        RaceTimesTest.class})

public class TestSuite
{

}
