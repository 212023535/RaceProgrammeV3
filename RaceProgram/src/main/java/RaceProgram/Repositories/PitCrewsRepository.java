package RaceProgram.Repositories;

import RaceProgram.Domain.PitCrews;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/04/30.
 */
public interface PitCrewsRepository extends CrudRepository<PitCrews,String>
{
    public PitCrews findByDriverName(String name);
}
