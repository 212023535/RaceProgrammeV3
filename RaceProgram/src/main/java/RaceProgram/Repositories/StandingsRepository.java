package RaceProgram.Repositories;

import RaceProgram.Domain.Standings;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/04/16.
 */
public interface StandingsRepository extends CrudRepository<Standings,Integer>
{
    public Standings findByStanding(int position);
}
