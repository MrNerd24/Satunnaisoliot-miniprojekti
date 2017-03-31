package satunnaisoliot.Datastructures.Fields;

import java.util.Objects;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericField;

public class Author extends GenericField {

    private String firstName;
    private String lastName;
    private String name;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        } else {
            return firstName + " " + lastName;
        }
    }

    @Override
    public FieldType getType() {
        return FieldType.AUTHOR;
    }

    @Override
    public String toBibTex() {
        if (name != null) {
            return "{" + name + "}";
        } else {
            return firstName + " {" + lastName + "}";
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.firstName);
        hash = 59 * hash + Objects.hashCode(this.lastName);
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTypeString() {
        return "author";
    }

}
