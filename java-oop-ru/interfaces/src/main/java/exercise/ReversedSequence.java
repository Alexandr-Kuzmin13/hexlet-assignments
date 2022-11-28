package exercise;

// BEGIN
class ReversedSequence implements CharSequence {

    private final String source;

    ReversedSequence(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    @Override
    public int length() {
        return source.length();
    }

    @Override
    public char charAt(int index) {
        return source.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return source.substring(start, end);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            result.insert(0, source.charAt(i));
        }
        return result.toString();
    }
}
// END
