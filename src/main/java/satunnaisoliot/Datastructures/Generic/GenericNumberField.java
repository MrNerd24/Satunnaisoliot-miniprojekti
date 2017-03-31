package satunnaisoliot.Datastructures.Generic;

public abstract class GenericNumberField extends GenericField {

    private int content;

    protected GenericNumberField(int number) {
        this.content = number;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int number) {
        this.content = number;
    }

    @Override
    public String toString() {
        return Integer.toString(content);
    }

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
