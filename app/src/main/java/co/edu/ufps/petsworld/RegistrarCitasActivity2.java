package co.edu.ufps.petsworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.petsworld.Administrator.Model.Citas;
import co.edu.ufps.petsworld.Administrator.Model.Citas2;

public class RegistrarCitasActivity2 extends AppCompatActivity {

    EditText idCita, idCliente, idMascota;
    Button btnCrear;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarcitas2);
        idCita =  findViewById(R.id.idCita);
        idCliente = findViewById(R.id.idCliente);
        idMascota = findViewById(R.id.idMascota);
        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCita();
            }
        });


        inicializarFirebase();
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

//    public void validarFormulario(){
//
//        String cita = idCita.getText().toString();
//        String cliente = idCliente.getText().toString();
//        String mascota = idMascota.getText().toString();
//
//        if(cita.equals("")){
//            idCita.setError("Required");
//        } else if(cliente.equals("")){
//            idCliente.setError("Required");
//        } else if(mascota.equals("")){
//            idMascota.setError("Required");
//        }
//        else{
//            guardarCita();
//        }
//
//    }

    public void guardarCita(){

//        String idAppointment = idCita.getText().toString();
//        String idClient = idCliente.getText().toString();
//        String idPet = idMascota.getText().toString();
//
//        String id = databaseReference.push().getKey();
//
//        Citas2 citas2 = new Citas2();
//        citas2.setId(id);
//        citas2.setIdCita(idAppointment);
//        citas2.setIdCliente(idClient);
//        citas2.setIdMascota(idPet);
//
//        databaseReference.child("citas").child(citas2.getId()).setValue(citas2);
//
//        Toast.makeText(this, "Cita añadida", Toast.LENGTH_LONG).show();

    }

}
