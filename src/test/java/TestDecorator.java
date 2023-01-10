import decorator.ChachedDocument;
import decorator.Document;
import decorator.SmartDocument;
import decorator.TimedDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDecorator {

    @Test
    public void testDecorator() {
        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
        Assertions.assertTrue(document.parse().startsWith("GEICO."));

        document = new TimedDocument(document);
        document.parse();

        Document document2 = new ChachedDocument("gs://lab_12_lushnei/Screenshot from 2022-11-27 20-54-53.png");
        Assertions.assertTrue(document2.parse().startsWith("8. IT-відділ УКУ вирішив додати до системи управління"));    }
}
