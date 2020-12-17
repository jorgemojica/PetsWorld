package co.edu.ufps.petsworld.Administrator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import co.edu.ufps.petsworld.Administrator.Model.Clientes;
import co.edu.ufps.petsworld.R;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>{

    private ArrayList<Clientes> clientes;

    public ClienteAdapter(ArrayList<Clientes> clientes) {

        this.clientes = clientes;

    }

    @NonNull
    @Override
    public ClienteAdapter.ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.clientes, parent, false);

        return new ClienteAdapter.ClienteViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.ClienteViewHolder holder, int position) {

        Picasso.get().load(clientes.get(position).getImagen()).into(holder.imagenCliente);
        holder.idNombreCliente.setText(clientes.get(position).getNombre());
        holder.idIdentificacionCliente.setText(clientes.get(position).getIdentificacion());
        holder.idTelefonoCliente.setText(clientes.get(position).getTelefono());
        holder.idCorreoCliente.setText(clientes.get(position).getCorreo());
        holder.idMascotaCliente.setText(clientes.get(position).getMascotas());
        holder.idDireccionCliente.setText(clientes.get(position).getDireccion());

    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    class ClienteViewHolder extends RecyclerView.ViewHolder{

        TextView idNombreCliente, idIdentificacionCliente, idTelefonoCliente, idCorreoCliente, idMascotaCliente, idDireccionCliente;
        ImageView imagenCliente;

        public ClienteViewHolder(@NonNull View itemView){

            super(itemView);
            idNombreCliente = itemView.findViewById(R.id.idNombreCliente);
            idIdentificacionCliente = itemView.findViewById(R.id.idIdentificacionCliente);
            idTelefonoCliente = itemView.findViewById(R.id.idTelefonoCliente);
            idCorreoCliente = itemView.findViewById(R.id.idCorreoCliente);
            idMascotaCliente = itemView.findViewById(R.id.idMascotaCliente);
            idDireccionCliente = itemView.findViewById(R.id.idDireccionCliente);
            imagenCliente = itemView.findViewById(R.id.imagenCliente);

        }

    }

}
