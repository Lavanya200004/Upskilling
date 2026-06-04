import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class JDBCTransactionHandling {
    static void transfer(Connection connection, int fromId, int toId, double amount) throws Exception {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (PreparedStatement debit = connection.prepareStatement(debitSql);
             PreparedStatement credit = connection.prepareStatement(creditSql)) {
            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            debit.executeUpdate();

            credit.setDouble(1, amount);
            credit.setInt(2, toId);
            credit.executeUpdate();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            connection.setAutoCommit(false);

            try {
                transfer(connection, 1, 2, 500);
                connection.commit();
                System.out.println("Transfer successful.");
            } catch (Exception e) {
                connection.rollback();
                System.out.println("Transfer failed. Transaction rolled back.");
            }
        } catch (Exception e) {
            System.out.println("JDBC transaction error. Add database setup and JDBC driver before running.");
            System.out.println(e.getMessage());
        }
    }
}
