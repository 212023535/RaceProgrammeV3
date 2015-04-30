package RaceProgram.Domain;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Weather
{
    private Calendar date;
    private String weather;

    private Weather(){}

    public Weather(Builder builder) {
        date = builder.date;
        weather = builder.weather;
    }

    public String getWeather() {
        return weather;
    }

    public Calendar getDate() {
        return date;
    }

    public static class Builder
    {
        private String weather;
        private Calendar date;

        public Builder(Calendar date)
        {
            this.date = date;
        }

        public Builder weather(String value)
        {
            this.weather = value;
            return this;
        }

        public Builder copy(Weather values)
        {
            this.weather = values.getWeather();
            this.date = values.getDate();
            return this;
        }

        public Weather build()
        {
            return new Weather(this);
        }
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}
