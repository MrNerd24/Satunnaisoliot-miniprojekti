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

}
