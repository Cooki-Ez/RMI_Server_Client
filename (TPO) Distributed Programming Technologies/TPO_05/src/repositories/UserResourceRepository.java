package repositories;

import exceptions.Tpo_05_exception;
import models.*;
import org.postgresql.core.SqlCommandType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserResourceRepository {

    public static User getUserByLoginPassword(String login, String password, DataSource dataSource) {
        try (Connection con = getConnection(dataSource)) {
            PreparedStatement userStatement = null;
            ResultSet userResultSet = null;
            try {
                userStatement = con.prepareStatement(
                        "SELECT id_usr, usr_login, usr_password " +
                                "FROM Users " +
                                "WHERE usr_login = ? AND usr_password = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                userStatement.setString(1, login);
                userStatement.setString(2, password);

                userResultSet = userStatement.executeQuery();
                if (!userResultSet.next()) {//checking if the resultSet is empty
                    return null;
                }
                return new User(userResultSet.getInt(1), userResultSet.getString(2), userResultSet.getString(3));

            } catch (SQLException e) {
                throw new Tpo_05_exception("Database connection error", e);
            } finally {
                try {
                    userStatement.close();
                    userResultSet.close();
                } catch (SQLException e) {
                    throw new Tpo_05_exception("Database connection error", e);
                }
            }
        } catch (SQLException e) {
            throw new Tpo_05_exception("Database connection error", e);
        }
    }

    public static List<Resource> getAvailableResources(User usr, DataSource dataSource) {
        List<Resource> result = null;
        try (Connection con = getConnection(dataSource)) {
            PreparedStatement usrResourceStatement = null;
            ResultSet usrResourceResultSet = null;
            try {
                //find users with the name
                usrResourceStatement = con.prepareStatement(
                        "SELECT Resources.id_resource, resource_name, content " +
                                "FROM Resources, UserResource " +
                                "WHERE Resources.id_resource = UserResource.id_resource AND id_usr = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                usrResourceStatement.setInt(1, usr.getId());

                usrResourceResultSet = usrResourceStatement.executeQuery();
                if (!usrResourceResultSet.next()) {//checking if the resultSet is empty
                    return null;
                }
                usrResourceResultSet.beforeFirst();//set cursor to initial position
                while (usrResourceResultSet.next()) {
                    if (result == null) {
                        result = new LinkedList<>();
                    }
                    result.add(new Resource(usrResourceResultSet.getInt(1), usrResourceResultSet.getString(2)));
                }
            } catch (SQLException e) {
                throw new Tpo_05_exception("Database connection error", e);
            } finally {
                //noinspection Duplicates
                try {
                    if (usrResourceStatement != null) {
                        usrResourceStatement.close();
                    }
                    if (usrResourceResultSet != null) {
                        usrResourceResultSet.close();
                    }
                } catch (SQLException e) {
                    throw new Tpo_05_exception("Database connection error", e);
                }
            }
        } catch (SQLException e) {
            throw new Tpo_05_exception("Database connetion error", e);
        }
        return result;
    }

    public static ResourceDetails getResourceDetails(int id, DataSource dataSource) {
        try (Connection con = getConnection(dataSource)) {
            PreparedStatement resourceStatement = null;
            ResultSet resourceResultSet = null;
            try {
                resourceStatement = con.prepareStatement(
                        "SELECT id_resource, resource_name, content " +
                                "FROM Resources " +
                                "WHERE id_resource = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                resourceStatement.setInt(1, id);

                resourceResultSet = resourceStatement.executeQuery();
                if (!resourceResultSet.next()) {//checking if the resultSet is empty
                    return null;
                }
                return new ResourceDetails(resourceResultSet.getInt(1), resourceResultSet.getString(2), resourceResultSet.getString(3));

            } catch (SQLException e) {
                throw new Tpo_05_exception("Database connection error", e);
            } finally {
                //noinspection Duplicates
                try {
                    if (resourceStatement != null) {
                        resourceStatement.close();
                    }
                    if (resourceResultSet != null) {
                        resourceResultSet.close();
                    }
                } catch (SQLException e) {
                    throw new Tpo_05_exception("Database connection error", e);
                }
            }
        } catch (SQLException e) {
            throw new Tpo_05_exception("Database connection error", e);
        }
    }

    private static Connection getConnection(DataSource dataSource) throws SQLException {
        synchronized (dataSource) {
            return dataSource.getConnection();
        }
    }

}
