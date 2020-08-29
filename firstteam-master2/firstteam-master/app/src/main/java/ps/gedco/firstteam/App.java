package ps.gedco.firstteam;

import android.app.Application;

import com.orm.SugarContext;
import com.orm.SugarDb;
import com.orm.SugarRecord;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("App initialization from here ");
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
