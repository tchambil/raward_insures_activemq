package cs.utec.consumer.insures.data.repositories;

import cs.utec.consumer.insures.dao.DBFactory;
import cs.utec.consumer.insures.dao.IDBAdapter;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepository implements IAccountRepository {
    @Override
    public void updateSavings(BigDecimal psavings, String accountNumber) {
        IDBAdapter adapter = DBFactory.getDBAdapter();
        Connection connection = adapter.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT SP_ACCOUNT_UPSAVING(?,?)");
            stmt.setBigDecimal (1,psavings);
            stmt.setString (2,accountNumber );
            stmt.execute();
        }
        catch(Exception err)
        {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            err.printStackTrace();
        }
    }
}
/*
set search_path = 'reward2'
CREATE OR REPLACE FUNCTION SP_ACCOUNT_UPSAVING(
	psavings numeric,
	pnumber varchar
)
RETURNS void AS $$
DECLARE dsaving numeric;
BEGIN
	
    SELECT savings FROM t_account INTO dsaving  WHERE number = pnumber;	
	UPDATE t_account SET savings = dsaving + psavings WHERE number = pnumber;
END;
$$ LANGUAGE plpgsql;

--select * from t_account
--SELECT SP_ACCOUNT_UPSAVING(100,'480112451450012')
* */