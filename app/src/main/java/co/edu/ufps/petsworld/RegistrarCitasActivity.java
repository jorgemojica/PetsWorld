package co.edu.ufps.petsworld;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import co.edu.ufps.petsworld.Administrator.Model.Citas;

public class RegistrarCitasActivity extends AppCompatActivity {

    EditText idCita, idCliente, idMascota, imagenMascota, fecha, hora;
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarcitas);
        idCita = findViewById(R.id.idCita);
        idCliente = findViewById(R.id.idCliente);
        idMascota = findViewById(R.id.idMascota);
        imagenMascota = findViewById(R.id.imagenMascota);
        fecha = findViewById(R.id.fecha);
        hora = findViewById(R.id.hora);
        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCita();
            }
        });
    }

    public void guardarCita(){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Citas cita = new Citas(myRef.push().getKey(), idCita.getText().toString(), idCliente.getText().toString(), idMascota.getText().toString(), imagenMascota.getText().toString(), fecha.getText().toString(), hora.getText().toString());
        myRef.child("citas").child(cita.getId()).setValue(cita);
        finish();

    }

}
