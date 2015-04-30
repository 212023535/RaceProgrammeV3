package RaceProgram.API;

import RaceProgram.Domain.Classes;
import RaceProgram.Services.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by student on 2015/04/15.
 */
@RestController
@RequestMapping("/API/**")
public class HomePage
{
    @Autowired
    private ClassesService classesService;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/classes",method = RequestMethod.GET)
    public Classes getClasses()
    {
        Classes classes = new Classes.Builder("S&GT").className("Sports & GT").gridSize(18).build();
        return classes;
    }

    @RequestMapping(value = "/classes",method = RequestMethod.GET)
    public List<Classes> getClasses2()
    {
        return classesService.getClasses();
    }

}
