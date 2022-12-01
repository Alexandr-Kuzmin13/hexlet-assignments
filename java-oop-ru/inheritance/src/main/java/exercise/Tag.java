package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public abstract class Tag {

    private final String nameTag;

    private final Map<String, String> tagAttributes;

    private String tag;

    private List<Tag> children;

    protected Tag(String nameTag, Map<String, String> tagAttributes) {
        this.nameTag = nameTag;
        this.tagAttributes = tagAttributes;
    }

    protected Tag(String nameTag, Map<String, String> tagAttributes, String tag, List<Tag> children) {
        this.nameTag = nameTag;
        this.tagAttributes = tagAttributes;
        this.tag = tag;
        this.children = children;
    }

    public String getNameTag() {
        return nameTag;
    }

    public Map<String, String> getTagAttributes() {
        return tagAttributes;
    }

    public abstract String toString();
}
// END
