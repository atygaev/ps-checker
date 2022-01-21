import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {

    private static String db = "postgres";
    private static String u = "postgres";
    private static String p = "postgres";

    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/" + db
		+ "?user=" + u
		+ "&password=" + p;

        Connection connection = DriverManager.getConnection(url);

        ResultSet resultSet = connection.getMetaData().getTables(null, null, null, null);

        while (resultSet.next()) {
            for (int columnIndex = 1; columnIndex <= resultSet.getMetaData().getColumnCount(); columnIndex++) {
                System.out.println(resultSet.getMetaData().getColumnName(columnIndex) + ": " + resultSet.getObject(columnIndex));
            }
        }
    }
}
