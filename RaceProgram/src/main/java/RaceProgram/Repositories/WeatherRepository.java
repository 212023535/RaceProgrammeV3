package RaceProgram.Repositories;


import RaceProgram.Domain.Weather;
import org.springframework.data.repository.CrudRepository;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by student on 2015/04/30.
 */
public interface WeatherRepository extends CrudRepository<Weather,Calendar>
{
    public Weather findByDate(Calendar date);
}
