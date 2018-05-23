package util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Darko
 */
public class Sesija {

    private static Sesija instance;
    private Map<String, Object> map;

    private Sesija() {
        map = new HashMap<>();
    }

    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public Object remove(String key) {
        return map.remove(key);
    }
}
