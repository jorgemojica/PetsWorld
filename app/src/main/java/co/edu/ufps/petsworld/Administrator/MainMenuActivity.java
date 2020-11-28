package co.edu.ufps.petsworld.Administrator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import co.edu.ufps.petsworld.R;

public class MainMenuActivity extends AppCompatActivity {

    ImageButton btnVeterinary, btnCustomers, btnMascotas, btnReminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenuadministrator);

        btnVeterinary = findViewById(R.id.btnVeterinary);
        btnVeterinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goVeterinary();
            }
        });
//
//        btnCustomers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goCustomers();
//            }
//        });
//
//        btnMascotas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goPets();
//            }
//        });
//
//        btnReminders.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goReminders();
//            }
//        });

    }

    private void goVeterinary(){
        Intent intent = new Intent(this, VeterinariosActivity.class);
        startActivity(intent);
    }
//
//    private void goCustomers(){
//        Intent intent = new Intent(this, ClientesActivity.class);
//        startActivity(intent);
//    }
//
//    private void goPets(){
//        Intent intent = new Intent(this, MascotasActivity.class);
//        startActivity(intent);
//    }
//
//    private void goReminders(){
//        Intent intent = new Intent(this, RecordatoriosActivity.class);
//        startActivity(intent);
//    }

}
