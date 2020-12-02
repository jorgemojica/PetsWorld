package co.edu.ufps.petsworld.Administrator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import co.edu.ufps.petsworld.R;

public class MainMenuAdministratorActivity extends AppCompatActivity {

    ImageButton btnCitas, btnVeterinary, btnCustomers, btnMascotas, btnNovedades, btnReminders, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenuadministrator);

        btnCitas = findViewById(R.id.btnCitas);
        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCitas();
            }
        });

        btnVeterinary = findViewById(R.id.btnVeterinary);
        btnVeterinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goVeterinary();
            }
        });

        btnCustomers = findViewById(R.id.btnCustomers);
        btnCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCustomers();
            }
        });

        btnMascotas = findViewById(R.id.btnMascotas);
        btnMascotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goPets();
            }
        });

        btnNovedades = findViewById(R.id.btnNovedades);
        btnNovedades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNovedades();
            }
        });

        btnReminders = findViewById(R.id.btnReminders);
        btnReminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goReminders();
            }
        });

        btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goInfo();
            }
        });

    }

    private void goCitas(){
        Intent intent = new Intent(this, CitasActivity.class);
        startActivity(intent);
    }

    private void goVeterinary(){
        Intent intent = new Intent(this, VeterinariosActivity.class);
        startActivity(intent);
    }

    private void goCustomers(){
        Intent intent = new Intent(this, ClientesActivity.class);
        startActivity(intent);
    }

    private void goPets(){
        Intent intent = new Intent(this, MascotasActivity.class);
        startActivity(intent);
    }

    private void goNovedades(){
        Intent intent = new Intent(this, NovedadesActivity.class);
        startActivity(intent);
    }

    private void goReminders(){
        Intent intent = new Intent(this, RecordatoriosActivity.class);
        startActivity(intent);
    }

    private void goInfo(){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

}
