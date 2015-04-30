package RaceProgram.Repositories;

import RaceProgram.Domain.Cars;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/04/16.
 */
public interface CarsRepository extends CrudRepository<Cars,Integer>
{
    public Cars findByNumber(int carNumber);
}
