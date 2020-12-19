package co.edu.ufps.petsworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import co.edu.ufps.petsworld.Administrator.Model.Citas;
import co.edu.ufps.petsworld.Administrator.Model.Clientes;

public class RegistrarClientesActivity extends AppCompatActivity {

    EditText idNombreCliente, idSexoCliente, idIdentificacionCliente, idTelefonoCliente, idCorreoCliente, idMascotasCliente, idDireccionCliente, imagenCliente;
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarclientes);
        idNombreCliente = findViewById(R.id.idNombreCliente);
        idSexoCliente = findViewById(R.id.idSexoCliente);
        idIdentificacionCliente = findViewById(R.id.idIdentificacionCliente);
        idTelefonoCliente = findViewById(R.id.idTelefonoCliente);
        idCorreoCliente = findViewById(R.id.idCorreoCliente);
        idMascotasCliente = findViewById(R.id.idMascotasCliente);
        idDireccionCliente = findViewById(R.id.idDireccionCliente);
        imagenCliente = findViewById(R.id.imagenCliente);
        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCliente();
            }
        });
    }

    public void guardarCliente(){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Clientes cliente = new Clientes(myRef.push().getKey(), idIdentificacionCliente.getText().toString(), idNombreCliente.getText().toString(), idSexoCliente.getText().toString(), idCorreoCliente.getText().toString(), idTelefonoCliente.getText().toString(), imagenCliente.getText().toString(), idMascotasCliente.getText().toString(), idDireccionCliente.getText().toString());
        myRef.child("clientes").child(cliente.getId()).setValue(cliente);
        finish();

    }


}