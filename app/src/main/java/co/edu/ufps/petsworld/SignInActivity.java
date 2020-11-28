package co.edu.ufps.petsworld;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.ufps.petsworld.Administrator.MainActivity;

public class SignInActivity extends AppCompatActivity {

    Button btnSignUp, btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSignUp();
            }
        });
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSignIn();
            }
        });
    }

    private void goSignUp(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void goSignIn(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
