package structural.decoratorPattern.Example;

public class LowercaseDecorator extends Decorator{
    @Override
    public void write(String text) {
        text = text.toLowerCase();
        super.write(text);
    }

    public LowercaseDecorator(Writer writer) {
        super(writer);
    }
}
