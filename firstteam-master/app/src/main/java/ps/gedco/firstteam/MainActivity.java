package ps.gedco.firstteam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ps.gedco.firstteam.activities.BasicActivity;
import ps.gedco.firstteam.activities.ScondActivity;
import ps.gedco.firstteam.models.Users;

public class MainActivity extends BasicActivity {


    private EditText username;
    private EditText password;
    private Button login;
    private Button resetPassword;
    private Button forgetPassword;

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

        Users user = new Users();
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

                //move to other activity
                Intent intent = new Intent(getCurrentActivity(), ScondActivity.class);
                startActivity(intent);

                //remove this from stack
                finish();

                //Toast.makeText(getCurrentActivity(),username.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getCurrentActivity(), ScondActivity.class);
                startActivity(intent);
            }
        },3000);
    }


}