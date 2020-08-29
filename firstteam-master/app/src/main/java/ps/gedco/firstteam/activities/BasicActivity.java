package ps.gedco.firstteam.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

public class BasicActivity extends AppCompatActivity {


    protected void printLog(String text){
        System.out.println("this is Log : " + text );
    }
    protected Activity getCurrentActivity(){

        return  this;
    }
}
