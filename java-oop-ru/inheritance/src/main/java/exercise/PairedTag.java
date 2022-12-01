package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {

    private final String nameTag;

    private final Map<String, String> tagAttributes;

    private final String tag;

    private final List<Tag> children;

    public PairedTag(String nameTag, Map<String, String> tagAttributes, String tag, List<Tag> children) {
        super(nameTag, tagAttributes, tag, children);
        this.nameTag = nameTag;
        this.tagAttributes = tagAttributes;
        this.tag = tag;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append("<" + nameTag);

        for (Map.Entry<String, String> element: tagAttributes.entrySet()) {

            resultBuilder.append(" " + element.getKey() + "=\"" + element.getValue() + "\"");

        }

        resultBuilder.append(">");

        for (var child: children) {

            resultBuilder.append("<" + child.getNameTag());

            for (Map.Entry<String, String> element: child.getTagAttributes().entrySet()) {

                resultBuilder.append(" " + element.getKey() + "=\"" + element.getValue() + "\"");

            }

            resultBuilder.append(">");
        }

        resultBuilder.append(tag + "</" + nameTag + ">");

        return resultBuilder.toString();
    }
}
// END
