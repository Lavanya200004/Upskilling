import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT)");
            statement.executeUpdate(
                    "INSERT OR IGNORE INTO students (id, name) VALUES (1, 'Aman')");

            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM students");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("JDBC error. Add a SQLite JDBC driver before running this program.");
            System.out.println(e.getMessage());
        }
    }
}
