package RaceProgram.Domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/15.
 */
@Entity
public class Grid implements Serializable
{
    private List<Drivers> driversList;
    private String classCode;
    private int gridSize;
    private int gridPosition;

    private Grid(){}

    public Grid(Builder builder)
    {
        driversList = builder.driversList;
        gridSize = builder.gridSize;
        classCode = builder.classCode;
        gridPosition = builder.gridPosition;
    }


    public List<Drivers> getDrivers() {
        return driversList;
    }

    public String getClassCode() {
        return classCode;
    }

    public int getGridPosition(){return gridPosition;}

    public List<Drivers> getDriversList() {
        return driversList;
    }

    public int getGridSize() {
        return gridSize;
    }

    public static class Builder
    {
        private List<Drivers> driversList;
        private int gridSize;
        private String classCode;
        private int gridPosition;

        public Builder(int gridSize)
        {
            this.gridSize = gridSize;
        }


        public Builder driverName(List<Drivers> value){
            this.driversList=value;
            return this;
        }

        public Builder classCode(String value)
        {
            this.classCode = value;
            return this;
        }

        public Builder gridPosition(int value)
        {
            this.gridPosition = value;
            return this;
        }

        public Builder copy(Grid value)
        {
            this.gridSize = value.getGridSize();
            this.gridPosition = value.getGridPosition();
            this.classCode = value.getClassCode();
            this.driversList = value.getDriversList();
            return this;
        }

        public Grid build()
        {
            return new Grid(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid = (Grid) o;

        if (classCode != null ? !classCode.equals(grid.classCode) : grid.classCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return classCode != null ? classCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "classCode='" + classCode + '\'' +
                ", gridSize=" + gridSize +
                '}';
    }
}
