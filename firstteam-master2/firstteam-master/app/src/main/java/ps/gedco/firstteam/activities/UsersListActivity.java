package ps.gedco.firstteam.activities;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.orm.query.Select;

import java.util.List;

import ps.gedco.firstteam.R;
import ps.gedco.firstteam.adapters.BasicAdapter;
import ps.gedco.firstteam.databinding.UsersListLayoutBinding;
import ps.gedco.firstteam.models.Users;

public class UsersListActivity extends BasicActivity{
    private UsersListLayoutBinding db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.users_list_layout);
       db =  DataBindingUtil.setContentView(this,R.layout.users_list_layout);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        GridLayoutManager gm = new GridLayoutManager(this,3);
        db.rv.setLayoutManager(gm);

        List<Users> usersList = Select.from(Users.class)
                .orderBy("No desc")
                .list();

        db.rv.setAdapter(new BasicAdapter(usersList));


    }
}
