package decorator;

import lombok.AllArgsConstructor;

public class TimedDocument implements Document {
    private final Document document;
    public TimedDocument(Document document){
        this.document = document;
    }

    @Override
    public String parse(){
        long starttime = System.currentTimeMillis();
        String text = document.parse();
        long endtime = System.currentTimeMillis();
        System.out.println("Parsing time: "+ (endtime - starttime) + " ms\n" );
        return text;
    }
}
