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
import co.edu.ufps.petsworld.Administrator.Model.Mascotas;
import co.edu.ufps.petsworld.R;
import co.edu.ufps.petsworld.RegistrarMascotasActivity;

public class MascotasActivity extends AppCompatActivity {

    RecyclerView contenedorMascotas;
    FloatingActionButton registrarMascotas;
    MascotasAdapter mascotasAdapter;
    private static final String TAG = "MascotasActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);
        contenedorMascotas = findViewById(R.id.contenedorMascotas);
        mascotasAdapter = new MascotasAdapter(cargarDatosFirebase());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MascotasActivity.this);
        contenedorMascotas.setLayoutManager(layoutManager);
        contenedorMascotas.setAdapter(mascotasAdapter);
        registrarMascotas = findViewById(R.id.registrarMascotas);
        registrarMascotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarMascotas();
            }
        });

    }

    private void registrarMascotas() {
        Intent intent = new Intent(this, RegistrarMascotasActivity.class);
        startActivity(intent);
    }

    public ArrayList<Mascotas> cargarDatosFirebase(){

        final ArrayList<Mascotas> mascotas = new ArrayList<>();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        // Read from the database
        myRef.child("mascotas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()) {
                    mascotas.clear();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Mascotas mascota = data.getValue(Mascotas.class);
                        mascotas.add(mascota);
                        mascotasAdapter.notifyDataSetChanged();
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

        return mascotas;

    }

}