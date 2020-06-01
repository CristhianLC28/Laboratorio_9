package pe.edu.tecsup.laboratorio9.activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import pe.edu.tecsup.laboratorio9.R;
import pe.edu.tecsup.laboratorio9.adapter.UserAdapter;
import pe.edu.tecsup.laboratorio9.models.User;
import pe.edu.tecsup.laboratorio9.repository.UserRepository;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView usersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersList = (RecyclerView) findViewById(R.id.user_list);
        usersList.setLayoutManager(new LinearLayoutManager(this));
        List<User> users = UserRepository.list();
        usersList.setAdapter(new UserAdapter(users));
    }
    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UserAdapter adapter = (UserAdapter)usersList.getAdapter();
        List<User> users = UserRepository.list();
        adapter.setUsers(users);
        adapter.notifyDataSetChanged();
    }
}
