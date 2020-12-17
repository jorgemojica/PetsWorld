package co.edu.ufps.petsworld.Administrator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import co.edu.ufps.petsworld.Administrator.Model.Citas;
import co.edu.ufps.petsworld.R;
import co.edu.ufps.petsworld.RegistrarCitasActivity;

public class CitasActivity extends AppCompatActivity {

    RecyclerView contenedorCitas;
    FloatingActionButton registrarCitas;
    CitasAdapter citasAdapter;
    private static final String TAG = "CitasActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
        contenedorCitas = findViewById(R.id.contenedorCitas);
        citasAdapter = new CitasAdapter(cargarDatosFirebase());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CitasActivity.this);
        contenedorCitas.setLayoutManager(layoutManager);
        contenedorCitas.setAdapter(citasAdapter);
        registrarCitas = findViewById(R.id.registrarCitas);
        registrarCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarCitas();
            }
        });

    }

    private void registrarCitas() {
        Intent intent = new Intent(this, RegistrarCitasActivity.class);
        startActivity(intent);
    }

    public ArrayList<Citas> cargarDatos(){
        ArrayList<Citas> citas = new ArrayList<>();
        citas.add(new Citas("1", "1", "1", "1","https://images.hive.blog/p/3W72119s5BjVs3Hye1oHX44R9EcpQD5C9xXzj68nJaq3CeJN4wNM2W3Jo8zECeBYgoBmur39yZV9adeYAHhpAynq2tszKfg4EqjGLdQ7LcTbDVTL83g3N6/?format=match&width=1920&height=1440", "9/12/2020", "8:00 a.m."));
        citas.add(new Citas("2","2", "2", "2","https://images.hive.blog/p/3W72119s5BjVs3Hye1oHX44R9EcpQD5C9xXzj68nJaq3CeJN4wNM2W3Jo8zECeBYgoBmur39yZV9adeYAHhpAynq2tszKfg4EqjGLdQ7LcTbDVTL83g3N6/?format=match&width=1920&height=1440", "10/12/2020", "9:00 a.m."));
        citas.add(new Citas("3", "3", "3", "3","https://images.hive.blog/p/3W72119s5BjVs3Hye1oHX44R9EcpQD5C9xXzj68nJaq3CeJN4wNM2W3Jo8zECeBYgoBmur39yZV9adeYAHhpAynq2tszKfg4EqjGLdQ7LcTbDVTL83g3N6/?format=match&width=1920&height=1440", "11/12/2020", "10:00 a.m."));
        return citas;
    }

    public ArrayList<Citas> cargarDatosFirebase(){

        final ArrayList<Citas> citas = new ArrayList<>();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        // Read from the database
        myRef.child("citas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()) {
                    citas.clear();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Citas cita = data.getValue(Citas.class);
                        citas.add(cita);
                        citasAdapter.notifyDataSetChanged();
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

        return citas;

    }

}