package co.edu.ufps.petsworld;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import co.edu.ufps.petsworld.Administrator.Model.Citas;
import co.edu.ufps.petsworld.Administrator.Model.Veterinarios;

public class RegistrarVeterinariosActivity extends AppCompatActivity {

    EditText idIdentificacion, idNombre, idSexo, idTelefono, idCorreo, idEspecialidad, idConsultorio, imagenVeterinario;
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarveterinarios);
        idNombre = findViewById(R.id.idNombre);
        idSexo = findViewById(R.id.idSexo);
        idIdentificacion = findViewById(R.id.idIdentificacion);
        idTelefono = findViewById(R.id.idTelefono);
        idCorreo = findViewById(R.id.idCorreo);
        idEspecialidad = findViewById(R.id.idEspecialidad);
        idConsultorio = findViewById(R.id.idConsultorio);
        imagenVeterinario = findViewById(R.id.imagenVeterinario);
        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarVeterinario();
            }
        });
    }

    public void guardarVeterinario(){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Veterinarios veterinario = new Veterinarios(myRef.push().getKey(), idIdentificacion.getText().toString(), idNombre.getText().toString(), idSexo.getText().toString(), idCorreo.getText().toString(), idTelefono.getText().toString(), idEspecialidad.getText().toString(), idConsultorio.getText().toString(), imagenVeterinario.getText().toString());
        myRef.child("veterinarios").child(veterinario.getId()).setValue(veterinario);
        finish();

    }

}
