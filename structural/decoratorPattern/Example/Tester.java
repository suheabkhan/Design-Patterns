package structural.decoratorPattern.Example;

public class Tester {
    public static void main(String[] args) {
        String text = "my!#Name%*is))suheab";
        Writer writer = new CleaningDecorator(new LowercaseDecorator(new ConsoleWriter()));
        writer.write(text);
        //first the cleaning decorartor kicks inn, then removes special chars, then lowercase decorator kicks inn..and theb does the
        //lower case conversion.. then writes into the console.
    }
}
