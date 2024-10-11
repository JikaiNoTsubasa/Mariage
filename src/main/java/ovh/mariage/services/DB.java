package ovh.mariage.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ovh.mariage.model.User;
import ovh.mariage.security.SPassword;

public class DB {

	Logger log = LoggerFactory.getLogger(DB.class);

    private static DB instance;
    private Connection connection;

    private DB(){}

    public static DB getInstance(){
        if (instance == null){
            instance = new DB();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            resetConnection();
        }
        return connection;
    }

    public void resetConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        SPassword pwd = new SPassword("c2JpLSRiaXVzZXJTIzg4");
        String host = "localhost";
        if (System.getProperty("host") != null){
            host = System.getProperty("host");
        }
        connection = DriverManager.getConnection("jdbc:mysql://"+host+"/amadeus","amadeus",pwd.getDecrypted());
        log.debug("DB connection reset");
    }
    
    public User loadUserByCode(String code) throws SQLException{
        String sql = "select * from mariage_user where code=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1,code);
        ResultSet res = stmt.executeQuery();
        User u = null;
        if (res.next()){
            u = createUser(res);
        }
        res.close();
        stmt.close();
        return u;
    }
    
    private User createUser(ResultSet res) throws SQLException {
        if (res == null)
            return null;
        User u = new User();
        u.setId(res.getInt("id"));
        u.setName(res.getString("name"));
        u.setCode(res.getString("code"));
        u.setType(res.getString("type"));
        u.setLang(res.getString("lang"));
        u.setSolo(res.getBoolean("solo"));
        return u;
    }
    
    public void storeUser(User user) throws SQLException {
    	String sql = "insert into mariage_user(name,code,type,lang,solo)values(?,?,?,?,?)";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getCode());
        stmt.setString(3, user.getType());
        stmt.setString(4, user.getLang());
        stmt.setBoolean(5, user.isSolo());
        stmt.executeUpdate();
        stmt.close();
    }
}
