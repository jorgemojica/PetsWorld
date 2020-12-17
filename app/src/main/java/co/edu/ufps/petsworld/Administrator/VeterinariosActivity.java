package co.edu.ufps.petsworld.Administrator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import co.edu.ufps.petsworld.Administrator.Model.Citas;
import co.edu.ufps.petsworld.Administrator.Model.Veterinarios;
import co.edu.ufps.petsworld.R;
import co.edu.ufps.petsworld.RegistrarCitasActivity;
import co.edu.ufps.petsworld.RegistrarVeterinariosActivity;

public class VeterinariosActivity extends AppCompatActivity {

    RecyclerView contenedorVeterinarios;
    FloatingActionButton registrarVeterinarios;
    VeterinariosAdapter veterinariosAdapter;
    private static final String TAG = "VeterinariosActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinarios);
        contenedorVeterinarios = findViewById(R.id.contenedorVeterinarios);
        veterinariosAdapter = new VeterinariosAdapter(cargarDatosFirebase());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(VeterinariosActivity.this);
        contenedorVeterinarios.setLayoutManager(layoutManager);
        contenedorVeterinarios.setAdapter(veterinariosAdapter);
        registrarVeterinarios = findViewById(R.id.registrarVeterinarios);
        registrarVeterinarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarVeterinarios();
            }
        });
    }

    private void registrarVeterinarios() {
        Intent intent = new Intent(this, RegistrarVeterinariosActivity.class);
        startActivity(intent);
    }

    public ArrayList<Veterinarios> cargarDatosFirebase(){

        final ArrayList<Veterinarios> veterinarios = new ArrayList<>();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        // Read from the database
        myRef.child("veterinarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()) {
                    veterinarios.clear();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Veterinarios veterinario = data.getValue(Veterinarios.class);
                        veterinarios.add(veterinario);
                        veterinariosAdapter.notifyDataSetChanged();
                    }
                    //Log.d(TAG, "Value is: ");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return veterinarios;

    }

}