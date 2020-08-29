package ps.gedco.firstteam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import ps.gedco.firstteam.activities.BasicActivity;
import ps.gedco.firstteam.activities.ScondActivity;
import ps.gedco.firstteam.activities.UsersActivity;
import ps.gedco.firstteam.activities.UsersListActivity;
import ps.gedco.firstteam.interfaces.APICallback;
import ps.gedco.firstteam.models.Users;
import ps.gedco.firstteam.models.WeatherData;
import ps.gedco.firstteam.services.HubService;

public class MainActivity extends BasicActivity {


    private EditText username;
    private EditText password;
    private Button login;
    private Button resetPassword;
    private Button forgetPassword;
    private Users user;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        this for loading this main activity layout
        content ...
         */
        setContentView(R.layout.activity_main);

        //edittexts
        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);

        user = new Users();
        user.Username = "Ahmed";
        user.Password = "Passeword";

        username.setText(user.Username);
        password.setText(user.Password);
        //for error
        /*TextView splash = findViewById(R.id.splash);
        splash.setText(R.string.app_name); // ("text")*/

        //buttons
        login = findViewById(R.id.loginBtn);
        resetPassword = findViewById(R.id.resetPasswordBtn);
        forgetPassword = findViewById(R.id.forgetPasswordBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // //move to other activity
                // Intent intent = new Intent(getCurrentActivity(), UsersListActivity.class);
                // startActivity(intent);
//
                // //remove this from stack
                // finish();
//
                //Toast.makeText(getCurrentActivity(),username.getText().toString(),Toast.LENGTH_LONG).show();

                // new HubService().getWeather("London,uk");

                //printLog(new Gson().toJson(user));

                //printLog(new Gson().fromJson("{\"No\":0,\"Password\":\"Passeword\",\"Username\":\"Ahmed\"}",Users.class).Username);


                dialog = ProgressDialog.show(getCurrentActivity(), "",
                        "Loading. Please wait...", true);

                //forth step calling
                new HubService().getWeather("London,uk", new APICallback() {
                    @Override
                    public void onCallBack(Object o) {

                        dialog.dismiss();
                        WeatherData data = (WeatherData) o;

                        if (data != null)
                            Toast.makeText(getCurrentActivity(), data.main.pressure + "", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getCurrentActivity(), ScondActivity.class);
                startActivity(intent);
            }
        },3000);*/
    }


}