package structural.decoratorPattern.Example;

public class UppercaseDecorator extends Decorator{

    public UppercaseDecorator(Writer writer) {
        super(writer);
    }

    @Override
    public void write(String text) {
        text = text.toLowerCase();
        super.write(text);
    }
}
