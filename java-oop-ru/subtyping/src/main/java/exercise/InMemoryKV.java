package exercise;

import java.util.Map;

// BEGIN
class InMemoryKV implements KeyValueStorage {

    private final Map<String, String> data;

    InMemoryKV(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
    }

    @Override
    public void unset(String key) {
        //this.data.remove(key, this.get(key, "default"));
        this.data.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {

        return this.data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return this.data;
    }
}
// END
