package satunnaisoliot.datastructures.generic;

/**
 *
 * @author juuso_j0pbwen
 */
public abstract class GenericNumberField extends GenericField {

    private int content;

    /**
     * Creates a new numeric Field.
     * @param number value of the field.
     */
    protected GenericNumberField(int number) {
        this.content = number;
    }

    /**
     *
     * @return the number this field holds.
     */
    public int getContent() {
        return content;
    }

    /**
     * Sets content of this field.
     * @param number to be the new value of this field.
     */
    public void setContent(int number) {
        this.content = number;
    }

    @Override
    public String toString() {
        return Integer.toString(content);
    }

    /**
     * Returns the value of this field in BibTex friendly format. Doesn't give the type of this field, only value. Some fields can have many values, these values have to be combined by the method caller.
     * @return BibTex field value;
     */
    @Override
    public String toBibTex() {
        return Integer.toString(content);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.content;
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
        final GenericNumberField other = (GenericNumberField) obj;
        if (this.content != other.content) {
            return false;
        }
        return true;
    }
    
    

}
