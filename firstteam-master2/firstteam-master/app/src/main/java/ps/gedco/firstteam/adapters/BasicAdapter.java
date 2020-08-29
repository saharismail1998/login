package ps.gedco.firstteam.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ps.gedco.firstteam.R;
import ps.gedco.firstteam.models.Users;

public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.ViewHolder> {

    private List<Users> usersList;

    public BasicAdapter(List<Users> list) {
        this.usersList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_row_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Users user = usersList.get(i);
        viewHolder.username.setText(user.Username);
        viewHolder.password.setText(user.Password);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        TextView password;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.UsernameText);
            password = itemView.findViewById(R.id.PasswordText);
        }
    }
}
