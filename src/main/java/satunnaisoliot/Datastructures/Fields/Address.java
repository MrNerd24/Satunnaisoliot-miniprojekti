package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Address extends GenericStringField {

    private static HashMap<String, Address> addresses = new HashMap<>();

    private Address(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.ADDRESS;
    }

    @Override
    public String getTypeString() {
        return "address";
    }
    
    public static Address getAddressObject(String address) {
        if (Address.addresses.get(address) == null) {
            Address.addresses.put(address, new Address(address));
        }
        return Address.addresses.get(address);
    }

}
