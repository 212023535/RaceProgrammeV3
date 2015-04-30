package RaceProgram.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Embeddable
public class ClassSponsors implements Serializable
{
    private String classCode;
    private String className;
    private String sponsor;

    private ClassSponsors(){}

    public ClassSponsors(Builder builder)
    {
        classCode = builder.classCode;
        className = builder.className;
        sponsor = builder.sponsor;
    }

    public String getClassName() {
        return className;
    }

    public String getSponsor() {
        return sponsor;
    }

    public String getClassCode() {
        return classCode;
    }

    public static class Builder
    {
        private String className;
        private String classCode;
        private String sponsor;

        public Builder(String classCode)
        {
            this.classCode = classCode;
        }

        public Builder classCode(String value)
        {
            this.classCode = value;
            return this;
        }

        public Builder className(String value)
        {
            this.className = value;
            return this;
        }

        public Builder sponsor(String value)
        {
            this.sponsor = value;
            return this;
        }

        public Builder copy(ClassSponsors value)
        {
            this.classCode = value.getClassCode();
            this.className = value.getClassName();
            this.sponsor = value.getSponsor();
            return this;
        }

        public ClassSponsors build()
        {
            return new ClassSponsors(this);
        }
    }

    @Override
    public String toString() {
        return "ClassSponsors{" +
                "className='" + className + '\'' +
                ", sponsor='" + sponsor + '\'' +
                '}';
    }
}
