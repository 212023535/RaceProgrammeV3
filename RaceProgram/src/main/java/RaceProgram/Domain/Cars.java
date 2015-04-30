package RaceProgram.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/13.
 */
@Embeddable
public class Cars implements Serializable
{
    private int carNumber;
    private String driverName;
    private String carType;
    private String classCode;

    private Cars() {}

    public Cars(Builder builder)
    {
        classCode = builder.classCode;
        carNumber = builder.carNumber;
        driverName = builder.driverName;
        carType = builder.carType;
    }

    public int getCarNumber()
    {
        return carNumber;
    }

    public String getClassCode()
    {
        return classCode;
    }

    public String getCarType()
    {
        return carType;
    }

    public String getDriverName()
    {
        return driverName;
    }

    public static class Builder
    {
        private String driverName;
        private int carNumber;
        private String classCode;
        private String carType;

        public Builder(int carNumber)
        {
            this.carNumber = carNumber;
        }

        public Builder classCode(String value)
        {
            this.classCode = value;
            return this;
        }

        public Builder driverName(String value)
        {
            this.driverName = value;
            return this;
        }

        public Builder carType(String value)
        {
            this.carType = value;
            return this;
        }

        public Builder copy(Cars value)
        {
            this.carNumber = value.getCarNumber();
            this.carType = value.getCarType();
            this.driverName = value.getDriverName();
            this.classCode = value.getClassCode();
            return this;
        }

        public Cars build()
        {
            return new Cars(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;

        Cars cars = (Cars) o;

        if (carNumber != cars.carNumber) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return carNumber;
    }

    @Override
    public String toString()
    {
        return "Cars{" +
                "carNumber=" + carNumber +
                ", driverName='" + driverName + '\'' +
                ", carType='" + carType + '\'' +
                ", classCode='" + classCode + '\'' +
                '}';
    }
}
