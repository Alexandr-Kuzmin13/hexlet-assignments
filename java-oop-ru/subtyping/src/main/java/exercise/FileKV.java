package exercise;

import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {

    private final String filepath;
    private final Map<String, String> data;

    FileKV(String filepath, Map<String, String> data) {
        this.filepath = filepath;
        this.data = data;
    }

    public String getFilepath() {
        return filepath;
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
    }

    @Override
    public void unset(String key) {
        data.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return data;
    }
}
// END
