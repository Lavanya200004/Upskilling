import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class StudentDAOExample {
    private final String url = "jdbc:sqlite:students.db";

    void insertStudent(int id, String name) throws Exception {
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeUpdate();
        }
    }

    void updateStudent(int id, String name) throws Exception {
        String sql = "UPDATE students SET name = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }
}

class JDBCInsertUpdate {
    public static void main(String[] args) {
        StudentDAOExample dao = new StudentDAOExample();

        try {
            dao.insertStudent(2, "Riya");
            dao.updateStudent(2, "Riya Sharma");
            System.out.println("Insert and update completed.");
        } catch (Exception e) {
            System.out.println("JDBC error. Create the students table and add a JDBC driver before running.");
            System.out.println(e.getMessage());
        }
    }
}
