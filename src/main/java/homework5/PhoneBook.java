package homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private static final HashMap<String, List<String>> phoneBook = new HashMap<>();

    public void add(String lastname, List<String> phones) {
        phoneBook.put(lastname, phones);
    }

    public Object find(String lastname) {
        if(phoneBook.containsKey(lastname)) {
            return phoneBook.get(lastname);
        }
        return new ArrayList<String>();
    }
}

