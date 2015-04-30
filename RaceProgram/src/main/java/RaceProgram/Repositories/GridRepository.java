package RaceProgram.Repositories;

import RaceProgram.Domain.Grid;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/04/16.
 */
public interface GridRepository extends CrudRepository<Grid,Integer>
{
    public Grid findByPosition(int gridPosition);
}
