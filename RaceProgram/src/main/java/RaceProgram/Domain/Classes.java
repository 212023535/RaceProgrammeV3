package RaceProgram.Domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Classes implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String className;
    @Column(unique = true)
    private String classCode;
    private int gridSize;
    private String raceTime;
    private List<Drivers> driversList;

    private Classes(){}

    public Classes(Builder builder)
    {
        id=builder.id;
        className = builder.className;
        gridSize = builder.gridSize;
        raceTime = builder.raceTime;
        classCode = builder.classCode;
        driversList = builder.driversList;
    }

    public Long getId() {
        return id;
    }

    public String getClassName()
    {
        return className;
    }

    public String getClassCode()
    {
        return classCode;
    }

    public int getGridSize()
    {
        return gridSize;
    }

    public List<Drivers> getDrivers() {
        return driversList;
    }

    public String getRaceTime()
    {
        return raceTime;
    }

    public static class Builder
    {
        private String className;
        private int gridSize;
        private String raceTime;
        private String classCode;
        private Long id;
        private List<Drivers> driversList;

        public Builder(String classCode)
        {
            this.classCode = classCode;
        }

        public Builder gridSize(int value)
        {
            this.gridSize = value;
            return this;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder raceTime(String value)
        {
            this.raceTime = value;
            return this;
        }

        public Builder className(String value)
        {
            this.className = value;
            return this;
        }

        public Builder driversList(List<Drivers> value){
            this.driversList=value;
            return this;
        }

        public Builder copy(Classes value)
        {
            this.driversList = value.getDrivers();
            this.classCode = value.getClassCode();
            this.className = value.getClassName();
            this.gridSize = value.getGridSize();
            this.raceTime = value.getRaceTime();
            return this;
        }

        public Classes build()
        {
            return new Classes(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classes classes = (Classes) o;

        if (id != null ? !id.equals(classes.id) : classes.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "className='" + className + '\'' +
                ", id=" + id +
                ", classCode='" + classCode + '\'' +
                ", gridSize=" + gridSize +
                ", raceTime='" + raceTime + '\'' +
                '}';
    }
}
