package decorator;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
//        Document document = new SmartDocument("gs://lab_12_lushnei/Screenshot from 2022-11-27 20-54-53.png");
        System.out.println(document.parse());

        document = new TimedDocument(document);
        document.parse();

        Document document2 = new ChachedDocument("gs://lab_12_lushnei/Screenshot from 2022-11-27 20-54-53.png");
        System.out.println(document2.parse());
    }
}
