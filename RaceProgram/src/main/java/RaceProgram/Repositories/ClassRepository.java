package RaceProgram.Repositories;

import RaceProgram.Domain.Classes;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/04/15.
 */
public interface ClassRepository extends CrudRepository<Classes,Long>
{
    public Classes findByCode(String classCode);
}
