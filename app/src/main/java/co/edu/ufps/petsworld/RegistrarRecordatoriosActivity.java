package co.edu.ufps.petsworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import co.edu.ufps.petsworld.Administrator.Model.Recordatorios;

public class RegistrarRecordatoriosActivity extends AppCompatActivity {

    EditText idAsuntoRecordatorio, idHoraRecordatorio, idFechaRecordatorio, idMensajeRecordatorio, idImagenRecordatorio;
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarrecordatorios);
        idAsuntoRecordatorio = findViewById(R.id.idAsuntoRecordatorio);
        idHoraRecordatorio = findViewById(R.id.idHoraRecordatorio);
        idFechaRecordatorio = findViewById(R.id.idFechaRecordatorio);
        idMensajeRecordatorio = findViewById(R.id.idMensajeRecordatorio);
        idImagenRecordatorio = findViewById(R.id.idImagenRecordatorio);
        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarRecordatorio();
            }
        });
    }

    public void guardarRecordatorio(){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Recordatorios recordatorio = new Recordatorios(myRef.push().getKey(), idAsuntoRecordatorio.getText().toString(), idHoraRecordatorio.getText().toString(), idFechaRecordatorio.getText().toString(), idMensajeRecordatorio.getText().toString(), idImagenRecordatorio.getText().toString());
        myRef.child("recordatorios").child(recordatorio.getId()).setValue(recordatorio);
        finish();

    }

}
