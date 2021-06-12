package cs.utec.consumer.insures.dao;

import cs.utec.consumer.insures.config.GlobalConstants;

import java.util.ResourceBundle;

public class DBFactory {
    public static IDBAdapter getDBAdapter(){
        ResourceBundle rb = ResourceBundle.getBundle("application");
        String dbType = rb.getString("dbtype");
        switch(dbType){
            case GlobalConstants.MySQL:
                return new MySQLDBAdapter();
            case GlobalConstants.Oracle:
                return new OracleDBAdapter();
            case GlobalConstants.SQLServer:
                return new SQLServerAdapter();
            case GlobalConstants.PSQL:
                return new PostgresDBAdapter();
            default:
                throw new RuntimeException("Unsupported db type");
        }
    }
}
