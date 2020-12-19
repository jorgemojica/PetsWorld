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
import co.edu.ufps.petsworld.Administrator.Model.Recordatorios;
import co.edu.ufps.petsworld.R;
import co.edu.ufps.petsworld.RegistrarRecordatoriosActivity;

public class RecordatoriosActivity extends AppCompatActivity {

    RecyclerView contenedorRecordatorios;
    FloatingActionButton registrarRecordatorios;
    RecordatoriosAdapter recordatoriosAdapter;
    private static final String TAG = "RecordatoriosActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);
        contenedorRecordatorios = findViewById(R.id.contenedorRecordatorios);
        recordatoriosAdapter = new RecordatoriosAdapter(cargarDatosFirebase());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecordatoriosActivity.this);
        contenedorRecordatorios.setLayoutManager(layoutManager);
        contenedorRecordatorios.setAdapter(recordatoriosAdapter);
        registrarRecordatorios = findViewById(R.id.registrarRecordatorios);
        registrarRecordatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarRecordatorios();
            }
        });

    }

    private void registrarRecordatorios() {
        Intent intent = new Intent(this, RegistrarRecordatoriosActivity.class);
        startActivity(intent);
    }

    public ArrayList<Recordatorios> cargarDatosFirebase() {

        final ArrayList<Recordatorios> recordatorios = new ArrayList<>();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        // Read from the database
        myRef.child("recordatorios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()) {
                    recordatorios.clear();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Recordatorios recordatorio = data.getValue(Recordatorios.class);
                        recordatorios.add(recordatorio);
                        recordatoriosAdapter.notifyDataSetChanged();
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

        return recordatorios;

    }
}