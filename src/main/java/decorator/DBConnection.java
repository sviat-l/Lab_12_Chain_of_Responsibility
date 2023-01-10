package decorator;


import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;

    @SneakyThrows
    private DBConnection(){
        connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
    }

    @SneakyThrows
    public static DBConnection getInstance(){
        if (dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    @SneakyThrows
    public void dbPostQuery(String dbQuery){
        Statement statement = connection.createStatement();
        statement.executeUpdate(dbQuery);
        statement.close();
    }

    @SneakyThrows
    public String dbGetQuery(String dbQuery){
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(dbQuery);
        statement.close();

        if(result.next()){
            return result.getString("IMGdata");
        }
        return null;
    }
}

