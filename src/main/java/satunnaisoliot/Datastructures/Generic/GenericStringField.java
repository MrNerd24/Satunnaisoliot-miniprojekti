package satunnaisoliot.Datastructures.Generic;

public abstract class GenericStringField extends GenericField {

    private String content;

    public GenericStringField(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public String toBibTex() {
        return content;
    }

}
