package satunnaisoliot.Datastructures.Fields;

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

}
