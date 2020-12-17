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
import co.edu.ufps.petsworld.Administrator.Model.Citas;
import co.edu.ufps.petsworld.R;

public class CitasAdapter extends RecyclerView.Adapter<CitasAdapter.CitasViewHolder> {

    private ArrayList<Citas> citas;

    public CitasAdapter(ArrayList<Citas> citas) {

        this.citas = citas;

    }

    @NonNull
    @Override
    public CitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.citas, parent, false);

        return new CitasViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CitasViewHolder holder, int position) {

        Picasso.get().load(citas.get(position).getImagenMascota()).into(holder.imagenMascota);
        holder.idCita.setText(citas.get(position).getIdCita());
        holder.idCliente.setText(citas.get(position).getIdCliente());
        holder.idMascota.setText(citas.get(position).getIdMascota());
        holder.fecha.setText(citas.get(position).getFecha());
        holder.hora.setText(citas.get(position).getHora());

    }

    @Override
    public int getItemCount() {
        return citas.size();
    }

    class CitasViewHolder extends RecyclerView.ViewHolder{

        TextView idCita, idCliente, idMascota, fecha, hora;
        ImageView imagenMascota;

        public CitasViewHolder(@NonNull View itemView){

            super(itemView);
            idCita = itemView.findViewById(R.id.idCita);
            idCliente = itemView.findViewById(R.id.idCliente);
            idMascota = itemView.findViewById(R.id.idMascota);
            imagenMascota = itemView.findViewById(R.id.imagenMascota);
            fecha = itemView.findViewById(R.id.fecha);
            hora = itemView.findViewById(R.id.hora);

        }

    }

}
