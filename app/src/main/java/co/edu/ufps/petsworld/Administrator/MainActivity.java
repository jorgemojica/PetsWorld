package co.edu.ufps.petsworld.Administrator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;

import co.edu.ufps.petsworld.Customer.DisplayedMenuCustActivity;
import co.edu.ufps.petsworld.R;
import co.edu.ufps.petsworld.SignUpActivity;
import co.edu.ufps.petsworld.Veterinary.DisplayedMenuVetActivity;
import co.edu.ufps.petsworld.Veterinary.MainMenuVeterinaryActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    EditText email, password;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(email.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }
    
    private void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            if(email.equals("jorgeandresmv@ufps.edu.co")){
                                goMainMenuAdministrator();
                            }
                            if(email.equals("jesusalfredorv@ufps.edu.co")){
                                goMainMenuVeterinary();
                            }
                            if(email.equals("camiloandreshm@ufps.edu.co")){
                                goMainMenuCustomer();
                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void goMainMenuAdministrator(){
        Intent intent = new Intent(this, DisplayedMenuAdminActivity.class);
        startActivity(intent);
    }

    private void goMainMenuVeterinary(){
        Intent intent = new Intent(this, DisplayedMenuVetActivity.class);
        startActivity(intent);
    }

    private void goMainMenuCustomer(){
        Intent intent = new Intent(this, DisplayedMenuCustActivity.class);
        startActivity(intent);
    }

    public void goSignUp(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}