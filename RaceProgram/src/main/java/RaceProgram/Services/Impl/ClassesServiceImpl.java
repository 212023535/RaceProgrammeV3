package RaceProgram.Services.Impl;

import RaceProgram.Domain.Classes;
import RaceProgram.Repositories.ClassRepository;
import RaceProgram.Services.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/15.
 */
@Service
public class ClassesServiceImpl implements ClassesService
{
    @Autowired
    ClassRepository repository;
    public List<Classes> getClasses()
    {
        List<Classes> allClasses = new ArrayList<Classes>();

        Iterable<Classes> classes = repository.findAll();
        for(Classes classes1 : classes)
        {
            allClasses.add(classes1);
        }
        return allClasses;
    }
}
