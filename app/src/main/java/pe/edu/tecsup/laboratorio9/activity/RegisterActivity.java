package pe.edu.tecsup.laboratorio9.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.tecsup.laboratorio9.R;
import pe.edu.tecsup.laboratorio9.repository.UserRepository;
public class RegisterActivity extends AppCompatActivity {
    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullnameInput = findViewById(R.id.fullname_input);
        emailInput =findViewById(R.id.email_input);
        passwordInput =findViewById(R.id.password_input);
    }
    public void callRegister(View view){
        String fullname = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(fullname.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }
        UserRepository.create(fullname, email, password);
        finish();
    }
}
