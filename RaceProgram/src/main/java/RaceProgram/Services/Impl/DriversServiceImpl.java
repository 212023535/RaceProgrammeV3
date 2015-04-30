package RaceProgram.Services.Impl;

import RaceProgram.Domain.Drivers;
import RaceProgram.Repositories.DriversRepository;
import RaceProgram.Services.DriversService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/15.
 */
public class DriversServiceImpl implements DriversService
{
    @Autowired
    DriversRepository repository;
    public List<Drivers> getDrivers()
    {
        List<Drivers> allDrivers = new ArrayList<Drivers>();

        Iterable<Drivers> drivers = repository.findAll();
        for (Drivers drivers1 : drivers)
        {
            allDrivers.add(drivers1);
        }
        return allDrivers;
    }
}
