package cs.utec.consumer.insures.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConstants {
    public static final int DB_DNI_LENGTH = 8;
    public static final int DB_CARD_LENGTH =16;
    public static final int DB_NAME_LENGTH = 255;
    public static final int POINTEMAILACTIVE =3;
    public static final int POINTEMAILNOTACTIVE = 2;
    public static final String PSQL = "Postgres";
    public static final String Oracle = "Oracle";
    public static final String MySQL = "MySQL";
    public static final String SQLServer = "SQLServer";

    private GlobalConstants(){
        //DEFAULT CONSTRUCTOR
    }

}
