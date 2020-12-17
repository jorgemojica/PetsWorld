package co.edu.ufps.petsworld;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import co.edu.ufps.petsworld.Administrator.Model.Citas;
import co.edu.ufps.petsworld.Administrator.Model.Mascotas;

public class RegistrarMascotasActivity extends AppCompatActivity {

    TextView idNombreMascota, idRazaMascota, idSexoMascota, idEdadMascota, idPropietarioMascota, idImagenMascota;
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarmascotas);
        idNombreMascota = findViewById(R.id.idNombreMascota);
        idRazaMascota = findViewById(R.id.idRazaMascota);
        idSexoMascota = findViewById(R.id.idSexoMascota);
        idEdadMascota = findViewById(R.id.idEdadMascota);
        idPropietarioMascota = findViewById(R.id.idPropietarioMascota);
        idImagenMascota = findViewById(R.id.idImagenMascota);
        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarMascotas();
            }
        });
    }

    public void guardarMascotas(){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Mascotas mascota = new Mascotas(myRef.push().getKey(), idNombreMascota.getText().toString(), idRazaMascota.getText().toString(), idSexoMascota.getText().toString(), idEdadMascota.getText().toString(), idPropietarioMascota.getText().toString(), idImagenMascota.getText().toString());
        myRef.child("mascotas").child(mascota.getId()).setValue(mascota);
        finish();

    }

}
