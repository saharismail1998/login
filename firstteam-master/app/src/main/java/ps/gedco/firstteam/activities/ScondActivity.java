package ps.gedco.firstteam.activities;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import ps.gedco.firstteam.R;
import ps.gedco.firstteam.databinding.ActivityMainBinding;
import ps.gedco.firstteam.models.Users;

public class ScondActivity extends BasicActivity {

    private ActivityMainBinding db;
    private Users user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //editing this line
        db.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*user.Username = "Other user";
               user.Password = "Passeword";
               db.setUser(user);*/

                Toast.makeText(getCurrentActivity(),
                       user.Username,
                        Toast.LENGTH_LONG).show();
            }
        });


        user = new Users();
        user.Username = "Ahmed Barakat";
        user.Password = "Passeword";

        db.setUser(user);


    }
}
