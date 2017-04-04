package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Organization extends GenericStringField {

    private static HashMap<String, Organization> organizations = new HashMap<>();

    private Organization(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.ORGANIZATION;
    }

    @Override
    public String getTypeString() {
        return "organization";
    }
    
    public static Organization getOrganizationObject(String organization) {
        if (Organization.organizations.get(organization) == null) {
            Organization.organizations.put(organization, new Organization(organization));
        }
        return Organization.organizations.get(organization);
    }

}
