package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    private final String nameTag;

    private final Map<String, String> tagAttributes;

    SingleTag(String nameTag, Map<String, String> tagAttributes) {
        super(nameTag, tagAttributes);
        this.nameTag = nameTag;
        this.tagAttributes = tagAttributes;
    }

    public String getNameTag() {
        return nameTag;
    }

    public Map<String, String> getTagAttributes() {
        return tagAttributes;
    }

    @Override
    public String toString() {

        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append("<" + nameTag);

        for (Map.Entry<String, String> element: tagAttributes.entrySet()) {

            resultBuilder.append(" " + element.getKey() + "=\"" + element.getValue() + "\"");

        }

        resultBuilder.append(">");

        return resultBuilder.toString();
    }

}
// END
