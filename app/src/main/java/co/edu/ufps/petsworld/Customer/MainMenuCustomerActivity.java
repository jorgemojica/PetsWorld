package co.edu.ufps.petsworld.Customer;

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

public class MainMenuCustomerActivity extends AppCompatActivity {

    ImageButton btnCitas, btnNotificaciones, btnMascotas, btnNovedades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenucustomer);

        btnCitas = findViewById(R.id.btnCitas);
        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCitas();
            }
        });

        btnNotificaciones = findViewById(R.id.btnNotificaciones);
        btnNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNotificaciones();
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

    }

    private void goCitas(){
        Intent intent = new Intent(this, CitasActivity.class);
        startActivity(intent);
    }

    private void goNotificaciones(){
        Intent intent = new Intent(this, AlertasActivity.class);
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

}
