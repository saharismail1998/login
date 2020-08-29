package ps.gedco.firstteam.models;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.dsl.Unique;

public class Users extends SugarRecord {


    @Unique
    public int No;
    @NotNull
    public String Username;
    public String Password;
}
