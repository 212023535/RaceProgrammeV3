package RaceProgram.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/13.
 */
@Embeddable
public class RaceTimes implements Serializable
{
    private String classCode;
    private String raceTime;

    private RaceTimes(){}

    public RaceTimes(Builder builder)
    {
        classCode = builder.classCode;
        raceTime = builder.raceTime;
    }

    public String getClassCode()
    {
        return classCode;
    }

    public String getRaceTime()
    {
        return raceTime;
    }

    public static class Builder
    {
        private String raceTime;
        private String classCode;


        public Builder(String classCode)
        {
            this.classCode = classCode;
        }

        public Builder raceTime(String value)
        {
            this.raceTime = value;
            return this;
        }

        public Builder copy(RaceTimes value)
        {
            this.classCode = value.getClassCode();
            this.raceTime = value.getRaceTime();
            return this;
        }

        public RaceTimes build()
        {
            return new RaceTimes(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof RaceTimes)) return false;

        RaceTimes raceTimes = (RaceTimes) o;

        if (raceTime != null ? !raceTime.equals(raceTimes.raceTime) : raceTimes.raceTime != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return raceTime != null ? raceTime.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "RaceTimes{" +
                "classCode='" + classCode + '\'' +
                ", raceTime='" + raceTime + '\'' +
                '}';
    }
}
