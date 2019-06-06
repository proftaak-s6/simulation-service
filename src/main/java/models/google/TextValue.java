
package models.google;

// NEEDED
public class TextValue {

    private String text;
    private int value;

    public TextValue() {
    }

    public TextValue(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + " text='" + getText() + "'" + ", value='" + getValue() + "'" + "}";
    }

}
