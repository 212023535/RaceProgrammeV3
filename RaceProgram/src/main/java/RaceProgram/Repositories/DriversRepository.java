package RaceProgram.Repositories;

import RaceProgram.Domain.Drivers;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/04/15.
 */
public interface DriversRepository extends CrudRepository<Drivers,String>
{
    public Drivers findByName(String driverName);
}
