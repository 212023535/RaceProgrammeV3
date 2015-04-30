package RaceProgram.Repositories;

import RaceProgram.Domain.Bikes;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/04/21.
 */
public interface BikesRepository extends CrudRepository<Bikes,Integer>
{
    public Bikes findByNumber(int bikeNumber);
}
