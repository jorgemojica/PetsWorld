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
import co.edu.ufps.petsworld.Administrator.Model.Clientes;
import co.edu.ufps.petsworld.R;
import co.edu.ufps.petsworld.RegistrarClientesActivity;

public class ClientesActivity extends AppCompatActivity {

    RecyclerView contenedorClientes;
    FloatingActionButton registrarClientes;
    ClienteAdapter clienteAdapter;
    private static final String TAG = "ClientesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        contenedorClientes = findViewById(R.id.contenedorClientes);
        clienteAdapter = new ClienteAdapter(cargarDatosFirebase());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ClientesActivity.this);
        contenedorClientes.setLayoutManager(layoutManager);
        contenedorClientes.setAdapter(clienteAdapter);
        registrarClientes = findViewById(R.id.registrarClientes);
        registrarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarClientes();
            }
        });

    }

    private void registrarClientes() {
        Intent intent = new Intent(this, RegistrarClientesActivity.class);
        startActivity(intent);
    }

    public ArrayList<Clientes> cargarDatosFirebase(){

        final ArrayList<Clientes> clientes = new ArrayList<>();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        // Read from the database
        myRef.child("clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()) {
                    clientes.clear();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Clientes cliente = data.getValue(Clientes.class);
                        clientes.add(cliente);
                        clienteAdapter.notifyDataSetChanged();
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

        return clientes;

    }

}