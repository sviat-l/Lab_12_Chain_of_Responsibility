package decorator;

import lombok.SneakyThrows;

public class ChachedDocument implements Document{
    private String gcsPath;
    private DBConnection dbConnection;

    @SneakyThrows
    public ChachedDocument(String gcsPath){
        this.gcsPath = gcsPath;
        dbConnection = DBConnection.getInstance();
    }

    @Override
    public String parse(){
        String query = dbConnection.dbGetQuery("SELECT IMGdata from rc_table WHERE gcsPath = "
                                        + "'" + gcsPath + "'");
        if (query != null){
            return query;
        }
        SmartDocument smartDocument = new SmartDocument(gcsPath);
        String result = smartDocument.parse();
        dbConnection.dbPostQuery(
                "INSERT INTO rc_table values ('" + result+
                "', '" + gcsPath + "')");
        return result;
    }
}
