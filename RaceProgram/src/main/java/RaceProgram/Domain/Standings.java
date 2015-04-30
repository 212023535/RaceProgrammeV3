package RaceProgram.Domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Entity
public class Standings  implements Serializable
{
    private int position;
    private List<Drivers> driversList;
    private String classCode;
    private String className;

    private Standings(){}

    public Standings(Builder builder)
    {
        position = builder.position;
        driversList = builder.driversList;
        classCode = builder.classCode;
        className = builder.className;
    }

    public int getPosition() {
        return position;
    }

    public List<Drivers> getDriverName() {
        return driversList;
    }

    public String getClassName() {
        return className;
    }

    public List<Drivers> getDriversList() {
        return driversList;
    }

    public String getClassCode() {
        return classCode;
    }

    public static class Builder
    {
        private int position;
        private List<Drivers> driversList;
        private String classCode;
        private String className;

        public Builder(String classCode)
        {
            this.classCode = classCode;
        }

        public Builder className(String value)
        {
            this.className = value;
            return this;
        }

        public Builder driverName(List<Drivers> value){
            this.driversList=value;
            return this;
        }

        public Builder position(int value)
        {
            this.position = value;
            return this;
        }

        public Builder copy(Standings value)
        {
            this.position = value.getPosition();
            this.classCode = value.getClassCode();
            this.className = value.getClassName();
            this.driversList = value.getDriversList();
            return this;
        }

        public Standings build()
        {
            return new Standings(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Standings standings = (Standings) o;

        if (position != standings.position) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return position;
    }

    @Override
    public String toString() {
        return "Standings{" +
                "position=" + position +
                ", driversList=" + driversList +
                ", className='" + className + '\'' +
                '}';
    }
}
