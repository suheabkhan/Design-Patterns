package structural.decoratorPattern.Example;

public class CleaningDecorator extends Decorator{
    public CleaningDecorator(Writer writer) {
        super(writer);
    }

    @Override
    public void write(String text) {
        //replaces all special characters
        text = text.replaceAll("[^a-zA-z0-9]"," ");
        super.write(text);
    }
}
