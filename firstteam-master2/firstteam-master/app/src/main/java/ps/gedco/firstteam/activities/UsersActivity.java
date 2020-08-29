package ps.gedco.firstteam.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.orm.query.Select;

import java.util.List;

import ps.gedco.firstteam.R;
import ps.gedco.firstteam.databinding.UsersActivityBinding;
import ps.gedco.firstteam.interfaces.CallBack;
import ps.gedco.firstteam.models.Users;

public class UsersActivity extends BasicActivity {

    private UsersActivityBinding db;
    private Users user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = DataBindingUtil.setContentView(this, R.layout.users_activity);

        user = new Users();
        db.setUser(user);

        //db.setHl(callBack);
        db.setHl(new CallBack() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.ResetBtn) {
                    user.Username = "";
                    user.Password = "";
                    db.setUser(user);


                }



            }

            @Override
            public void onClick(View v, Object o) {

                Users userObj = (Users) o;
                if(o != null) {

                    if(v.getId() == R.id.SaveBtn) {
                        userObj.No = (int) Math.random();
                        userObj.save();

                        printLog(userObj.Username);
                    } else {

                        userObj.delete();
                    }
                }
            }

        });
        //select col3 ,col1, col2 from table

        //insert new user
        //Users user = new Users();
        //user.No = 1;
        //user.Username = "Username";
        //user.Password = "Password";
        //user.save();

        //update
        //Users user = Users.first(Users.class);
        //Users user = Users
        //        .find(Users.class," No = ? ",new String[] { "1" },null,null,null )
        //        .get(0);

        //user.Username = "Ahmed";
        //user.Password = "new password ";
        //user.save();

        //List<Users> usersList = Users.listAll(Users.class);
        //for (Users user : usersList) {
        //    printLog(user.Username + " password : " + user.Password + " id , " + user.getId());
        //}

        //for (int i= 0 ; i < 100; i++){
        //    Users user = new Users();
        //    user.No = i * 20;
        //    user.Username = "User- "+i;
        //    user.Password = "Pass&*"+i;
        //    user.save();
        //}

        List<Users> usersList = Select.from(Users.class)
                .orderBy("No desc")
                .where("No >= 80 and  No < 300")
                .offset("3")
                .limit("3")
                .list();

        /*printLog(String.valueOf(usersList.size()));
        printLog(Users.count(Users.class,"No >= 80 and  No < 300",null)+"");
        printLog(String.valueOf( Select.from(Users.class)
                .orderBy("No desc")
                .where("No >= 80 and  No < 300").count()));

       for (Users user : usersList) {
           printLog(user.Username + " password : " + user.Password + " id , " + user.getId());
       }*/

        //db.SaveBtn.setOnClickListener();
    }


    CallBack callBack = new CallBack() {
        @Override
        public void onClick(View v) {

        }

        @Override
        public void onClick(View v, Object o) {

        }
    };
}
