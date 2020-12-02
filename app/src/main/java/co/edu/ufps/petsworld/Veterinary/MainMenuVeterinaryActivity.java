package co.edu.ufps.petsworld.Veterinary;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import co.edu.ufps.petsworld.Administrator.CitasActivity;
import co.edu.ufps.petsworld.Administrator.ClientesActivity;
import co.edu.ufps.petsworld.Administrator.InfoActivity;
import co.edu.ufps.petsworld.Administrator.MascotasActivity;
import co.edu.ufps.petsworld.Administrator.NovedadesActivity;
import co.edu.ufps.petsworld.Administrator.RecordatoriosActivity;
import co.edu.ufps.petsworld.Administrator.VeterinariosActivity;
import co.edu.ufps.petsworld.R;

public class MainMenuVeterinaryActivity extends AppCompatActivity {

    ImageButton btnCitas, btnCustomers, btnPacientes, btnNovedades, btnHistorial, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenuveterinary);

        btnCitas = findViewById(R.id.btnCitas);
        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCitas();
            }
        });



        btnCustomers = findViewById(R.id.btnCustomers);
        btnCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCustomers();
            }
        });

        btnPacientes = findViewById(R.id.btnPacientes);
        btnPacientes.setOnClickListener(new View.OnClickListener() {
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



        btnHistorial = findViewById(R.id.btnHistorial);
        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHistorial();
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



    private void goHistorial(){
        Intent intent = new Intent(this, NovedadesActivity.class);
        startActivity(intent);
    }

    private void goInfo(){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

}
