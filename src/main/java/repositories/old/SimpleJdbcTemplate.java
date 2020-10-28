//package repositories.old;
//
//import repositories.interfaces.RowMapper;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SimpleJdbcTemplate {
//
//    private DataSource dataSource;
//
//    public SimpleJdbcTemplate(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public <T> List<T> query(String SQL, RowMapper<T> rowMapper, Object... args) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = dataSource.getConnection();
//            statement = connection.prepareStatement(SQL);
//
//            List<T> result = new ArrayList<>();
//
//            for (int i = 0; i < args.length; i++) {
//                statement.setObject(i + 1, args[i]);
//            }
//
//            resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                result.add(rowMapper.mapRow(resultSet));
//            }
//
//            return result;
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    //ignore
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    //ignore
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    //ignore
//                }
//            }
//        }
//    }
//
//    public void queryInsert(String SQL, Object... args) {
//        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL)) {
//
//            for (int i = 0; i < args.length; i++) {
//                statement.setObject(i + 1, args[i]);
//            }
//
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//}
