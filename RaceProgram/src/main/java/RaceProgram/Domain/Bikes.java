package RaceProgram.Domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Embeddable
public class Bikes implements Serializable
{
    private int bikeNumber;
    private String driverName;
    private String bikeType;
    @Column(unique = true)
    private String classCode;

    private Bikes(){}

    public Bikes(Builder builder)
    {
        classCode = builder.classCode;
        bikeNumber = builder.bikeNumber;
        driverName = builder.driverName;
        bikeType = builder.bikeType;
    }

    public int getBikeNumber() {
        return bikeNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getBikeType() {
        return bikeType;
    }

    public String getClassCode() {
        return classCode;
    }

    public static class Builder
    {
        private String driverName;
        private int bikeNumber;
        private String classCode;
        private String bikeType;

        public Builder(int bikeNumber)
        {
            this.bikeNumber = bikeNumber;
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

        public Builder bikeType(String value)
        {
            this.bikeType = value;
            return this;
        }

        public Builder copy(Bikes value)
        {
            this.bikeNumber = value.getBikeNumber();
            this.bikeType = value.getBikeType();
            this.driverName = value.getDriverName();
            this.classCode = value.getClassCode();
            return this;
        }

        public Bikes build()
        {
            return new Bikes(this);
        }
    }
}
