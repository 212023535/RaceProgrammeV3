package RaceProgram.Repositories;

import RaceProgram.Domain.Bikes;
import RaceProgram.Domain.ClassSponsors;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/04/30.
 */
public interface ClassSponsorRepository extends CrudRepository<ClassSponsors,String>
{
    public ClassSponsors findByClassCode(String code);
}
