package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Author extends GenericStringField {

    private static HashMap<String, Author> authors = new HashMap<>();

    private Author(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.AUTHOR;
    }

    @Override
    public String getTypeString() {
        return "author";
    }

    public static Author getAuthorObject(String author) {
        if (Author.authors.get(author) == null) {
            Author.authors.put(author, new Author(author));
        }
        return Author.authors.get(author);
    }

}
