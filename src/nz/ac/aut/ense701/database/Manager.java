package nz.ac.aut.ense701.database;


import nz.ac.aut.ense701.gameModel.Score;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Michael Jordan (14868336)
 */
public class Manager {
    public Integer lowestScore;
    private static String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final String URL;
    private final String TABLE;
    private static final int TOTAL = 10;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private int rowCount;
    
    public Manager(String name, String table){
        URL = "jdbc:derby:"+name+"; create=true";
        TABLE = table.toUpperCase();
        try {
            initialize();
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: "+ex);
        } catch (SQLException ex) {
            System.err.println("Error: "+ex);
        }
        
    }
    
    public void initialize() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL);
        stmt = conn.createStatement();
        if(!tableExists()){
            createTable();
            rowCount = 0;
        }else {
            rowCount = getRowCount();
            if(rowCount > 0){
                rs = stmt.executeQuery("SELECT * FROM "+TABLE+" WHERE ID="+getLowestID());
                rs.next();
                lowestScore = rs.getInt(3);
                rs.close();
            }
        }
    }
    
    public Score getScore(int index) throws SQLException{
        ArrayList<Score> data = getData();
        Score score = data.get(index-1);
        return score;
    }
    //Checks if the 'SCORES' table exists.
    private boolean tableExists() throws SQLException{
        boolean exists = false;
        ResultSet rs = this.conn.getMetaData().getTables(null, null, TABLE, null);
        while(rs.next()){
            String name = rs.getString("TABLE_NAME");
            if(name != null && name.equals(TABLE)){
                exists = true;
                break;
            }
        }
        rs.close();
        return exists;
    }
    /**
     * Add/update a record in the database.
     * @param record Score to be added to the database.
     * @throws SQLException 
     */
    public void pushToDB(Score record) throws SQLException{
        int id;
        if(rowCount >= TOTAL){
            id = getLowestID();
            stmt.executeUpdate("UPDATE "+TABLE
                + " SET NAME='"+record.name+"', SCOREVAL="+record.score+", "
                + "KIWICOUNT="+record.kiwi+", PREDATORCOUNT="+record.predator+", "
                + "STAMINA="+record.stamina+", ITEM="+record.items
                + " WHERE ID="+id);
        } else {
            id = rowCount;
            stmt.executeUpdate("INSERT INTO "+TABLE+" (ID,NAME,SCOREVAL,KIWICOUNT,PREDATORCOUNT,STAMINA,ITEM)"
                + " VALUES("+id+",'"+record.name+"',"+record.score+","+record.kiwi+","+record.predator+","+record.stamina+","+record.items+")");
            rowCount++;
        }
    }
    /**
     * Read the database for a collection of all the scores.
     * @return A sorted array (Descending) of all the scores in the database.
     * @throws SQLException 
     */
    public ArrayList<Score> getData() throws SQLException{
        ArrayList<Score> data = new ArrayList();
        rs = stmt.executeQuery("SELECT * FROM "+TABLE+" ORDER BY SCOREVAL DESC");
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int kiwi = rs.getInt(4);
            int predator = rs.getInt(5);
            int stamina = rs.getInt(6);
            int items = rs.getInt(7);
            data.add(new Score(name, kiwi, predator, stamina, items));
        }
        return data;
    }
    private void createTable() throws SQLException{
        //ID, Name, ScoreVal, KiwiCount, PredatorCount, Stamina
        stmt.executeUpdate("CREATE TABLE SCORES(ID INTEGER, "
                    + "Name VARCHAR(25), ScoreVal INTEGER, KiwiCount INTEGER,"
                    + " PredatorCount INTEGER, Stamina INTEGER, Item INTEGER, PRIMARY KEY(ID))");
    }
    //Clears the table;
    public void clearTable() throws SQLException{
        stmt.executeUpdate("DELETE FROM "+TABLE);
    }
    private int getRowCount() throws SQLException{
        rs = stmt.executeQuery("SELECT count(*) FROM "+TABLE);
        rs.next();
        int val = rs.getInt(1);
        return val;
    }
    
    private int getLowestID() throws SQLException{
        rs = stmt.executeQuery("SELECT * FROM "+TABLE+" ORDER BY SCOREVAL ASC");
        rs.next();
        int id = rs.getInt(1);
        rs.close();
        return id;
    }
    
    /**
     * Close the connection with the a database.
     * @throws SQLException 
     */
    public void close() throws SQLException{
        if(stmt != null && conn == null){
            stmt.close();
            conn.close();
        }
    }
    
}
