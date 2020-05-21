import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    static final String USER = "sa";
    static final String PASS = "";

    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        this.schemaName = schemaName;
        String sql = "CREATE SCHEMA " + schemaName + ";";
        statement.executeUpdate(sql);
    }

    public void dropSchema() throws SQLException {
        String sql = "DROP SCHEMA" + this.schemaName + ";";
        statement.executeUpdate(sql);
    }

    public void useSchema() throws SQLException {
        String sql = "USE " + this.schemaName + ";";
        statement.executeUpdate(sql);
    }

    public void createTableRoles() throws SQLException {
        String sql = "CREATE TABLE Roles (" + " id INT NOT NULL AUTO_INCREMENT," + " roleName VARCHAR(20) NOT NULL,"
                + " PRIMARY KEY (`id`)," + " UNIQUE INDEX id_ROLES (`id` ASC));";
        statement.executeUpdate(sql);
    }

    public void createTableDirections() throws SQLException {
        String sql = "CREATE TABLE Directions (" + " id INT NOT NULL AUTO_INCREMENT,"
                + " directionName VARCHAR(20) NOT NULL," + " PRIMARY KEY (`id`),"
                + " UNIQUE INDEX id_DIRECTIONS (`id` ASC));";
        statement.executeUpdate(sql);
    }

    public void createTableProjects() throws SQLException {
        String sql = "CREATE TABLE Projects (" + " id INT NOT NULL AUTO_INCREMENT," + " direction_id INT NOT NULL,"
                + " projectName VARCHAR(20) NOT NULL," + " FOREIGN KEY (direction_id) REFERENCES Directions(id),"
                + " PRIMARY KEY (`id`)," + " UNIQUE INDEX id_PROJECTS (`id` ASC));";
        statement.executeUpdate(sql);
    }

    public void createTableEmployee() throws SQLException {
        String sql = "CREATE TABLE Employee (" + " id INT NOT NULL AUTO_INCREMENT," + " role_id INT NOT NULL,"
                + " project_id INT NOT NULL," + " firstName VARCHAR(20) NOT NULL,"
                + " FOREIGN KEY (role_id) REFERENCES Roles(id)," + " FOREIGN KEY (project_id) REFERENCES Projects(id),"
                + " PRIMARY KEY (`id`)," + " UNIQUE INDEX id_EMPLOYEE (`id` ASC));";
        statement.executeUpdate(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String str = "DROP TABLE [ IF EXISTS ] " + schemaName + ";";
        statement.executeUpdate(str);
    }

    public void insertTableRoles(String roleName) throws SQLException {
        String str = "INSERT INTO Roles(roleName) " + "VALUES ('" + roleName + "')";
        statement.executeUpdate(str);
    }

    public void insertTableDirections(String directionName) throws SQLException {
        String str = "INSERT INTO Directions(directionName) " + "VALUES ('" + directionName + "')";
        statement.executeUpdate(str);
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        int id = getDirectionId(directionName);
        String str = "INSERT INTO Projects(projectName, direction_id) " + "VALUES ('" + projectName + "', '" + id
                + "')";
        statement.executeUpdate(str);
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        int roleId = getRoleId(roleName);
        int projectId = getProjectId(projectName);
        String str = "INSERT INTO Employee(role_id, project_id, firstName) " + "VALUES ('" + roleId + "', '" + projectId
                + "', '" + firstName + "')";
        statement.executeUpdate(str);
    }

    public int getRoleId(String roleName) throws SQLException {
        String sql = "SELECT id, roleName FROM Roles";
        ResultSet result = statement.executeQuery(sql);
        int id = 0;
        while (result.next()) {
            id = result.getInt("id");
            String role = result.getString("roleName");

            if (roleName.equals(role)) {
                break;
            } else {
                continue;
            }
        }
        return id;
    }

    public int getDirectionId(String directionName) throws SQLException {
        String sql = "SELECT id, directionName FROM Directions";
        ResultSet result = statement.executeQuery(sql);
        int id = 0;
        while (result.next()) {
            id = result.getInt("id");
            String direction = result.getString("directionName");

            if (directionName.equals(direction)) {
                break;
            } else {
                continue;
            }
        }
        return id;
    }

    public int getProjectId(String projectName) throws SQLException {
        String sql = "SELECT id, projectName FROM Projects";
        ResultSet result = statement.executeQuery(sql);
        int id = 0;
        while (result.next()) {
            id = result.getInt("id");
            String project = result.getString("projectName");

            if (projectName.equals(project)) {
                break;
            } else {
                continue;
            }
        }
        return id;
    }

    public int getEmployeeId(String firstName) throws SQLException {
        String sql = "SELECT id, firstName FROM Employee";
        ResultSet result = statement.executeQuery(sql);
        int id = 0;
        while (result.next()) {
            id = result.getInt("id");
            String name = result.getString("firstName");

            if (firstName.equals(name)) {
                break;
            } else {
                continue;
            }
        }
        return id;
    }

    public List<String> getAllRoles() throws SQLException {
        String sql = "SELECT id, roleName FROM Roles";
        ResultSet result = statement.executeQuery(sql);
        List<String> listOfRoles = new ArrayList<>();
        while (result.next()) {
            listOfRoles.add(result.getString("roleName"));
        }
        return listOfRoles;
    }

    public List<String> getAllDirestion() throws SQLException {
        String sql = "SELECT id, directionName FROM Directions";
        ResultSet result = statement.executeQuery(sql);
        List<String> listOfDirections = new ArrayList<>();
        while (result.next()) {
            listOfDirections.add(result.getString("directionName"));
        }
        return listOfDirections;
    }

    public List<String> getAllProjects() throws SQLException {
        String sql = "SELECT id, projectName FROM Projects";
        ResultSet result = statement.executeQuery(sql);
        List<String> listOfProjects = new ArrayList<>();
        while (result.next()) {
            listOfProjects.add(result.getString("projectName"));
        }
        return listOfProjects;
    }

    public List<String> getAllEmployee() throws SQLException {
        String sql = "SELECT id, firstName FROM Employee";
        ResultSet result = statement.executeQuery(sql);
        List<String> listOfEmployee = new ArrayList<>();
        while (result.next()) {
            listOfEmployee.add(result.getString("firstName"));
        }
        return listOfEmployee;
    }

    public List<String> getAllDevelopers() throws SQLException {
        int developerId = getRoleId("Developer");
        String sql = "SELECT role_id, firstName FROM Employee";
        ResultSet result = statement.executeQuery(sql);
        List<String> listOfDevelopers = new ArrayList<>();
        while (result.next()) {
            if(result.getInt("role_id") == developerId) {
                listOfDevelopers.add(result.getString("firstName"));
            }
        }
        return listOfDevelopers;
    }

    public List<String> getAllJavaProjects() throws SQLException {
        int javaId = getDirectionId("Java");
        String sql = "SELECT direction_id, projectName FROM Projects";
        ResultSet result = statement.executeQuery(sql);
        List<String> listOfJavaProjects = new ArrayList<>();
        while (result.next()) {
            if(result.getInt("direction_id") == javaId) {
                listOfJavaProjects.add(result.getString("projectName"));
            }
        }
        return listOfJavaProjects;
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        int javaId = getDirectionId("Java");
        int developerId = getRoleId("Developer"); 
        String sql = "SELECT role_id, project_id, firstName FROM Employee";
        List<String> listOfJavaProjects = getAllJavaProjects();
        List<Integer> listOfJavaProjectIntegers = new ArrayList<>();
        List<String> listOfAllJavaDevelopers = new ArrayList<>();
        for(String project:listOfJavaProjects) {
            listOfJavaProjectIntegers.add(getProjectId(project));
        }
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            if(result.getInt("role_id") == developerId) {
                if(listOfJavaProjectIntegers.contains(result.getInt("project_id"))) {
                    listOfAllJavaDevelopers.add(result.getString("firstName"));
                }
            }
        }
        return listOfAllJavaDevelopers;
    }
}
