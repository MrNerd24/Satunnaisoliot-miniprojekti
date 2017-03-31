package satunnaisoliot.Datastructures.Generic;

import java.util.Objects;

/**
 *
 * @author juuso_j0pbwen
 */
public abstract class GenericStringField extends GenericField {

    private String content;

    /**
     * Creates a new String field.
     * @param content of the field.
     */
    public GenericStringField(String content) {
        this.content = content;
    }

    /**
     * 
     * @return the content saved in this field.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets a new value to this field.
     * @param content that should be the new value saved in this object.
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    /**
     * Returns the value of this field in BibTex friendly format. Doesn't give the type of this field, only value. Some fields can have many values, these values have to be combined by the method caller.
     * @return BibTex field value;
     */
    @Override
    public String toBibTex() {
        return content;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.content);
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
        final GenericStringField other = (GenericStringField) obj;
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }

}
