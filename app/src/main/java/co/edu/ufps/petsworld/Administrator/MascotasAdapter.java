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
import co.edu.ufps.petsworld.Administrator.Model.Mascotas;
import co.edu.ufps.petsworld.R;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotasViewHolder>{

    private ArrayList<Mascotas> mascotas;

    public MascotasAdapter(ArrayList<Mascotas> mascotas) {

        this.mascotas = mascotas;

    }

    @NonNull
    @Override
    public MascotasAdapter.MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mascotas, parent, false);

        return new MascotasAdapter.MascotasViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MascotasAdapter.MascotasViewHolder holder, int position) {

        Picasso.get().load(mascotas.get(position).getImagen()).into(holder.idImagenMascota);
        holder.idNombreMascota.setText(mascotas.get(position).getNombre());
        holder.idRazaMascota.setText(mascotas.get(position).getRaza());
        holder.idSexoMascota.setText(mascotas.get(position).getSexo());
        holder.idEdadMascota.setText(mascotas.get(position).getEdad());
        holder.idPropietarioMascota.setText(mascotas.get(position).getPropietario());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    class MascotasViewHolder extends RecyclerView.ViewHolder{

        TextView idNombreMascota, idRazaMascota, idSexoMascota, idEdadMascota, idPropietarioMascota;
        ImageView idImagenMascota;

        public MascotasViewHolder(@NonNull View itemView){

            super(itemView);
            idNombreMascota = itemView.findViewById(R.id.idNombreMascota);
            idRazaMascota = itemView.findViewById(R.id.idRazaMascota);
            idSexoMascota = itemView.findViewById(R.id.idSexoMascota);
            idEdadMascota = itemView.findViewById(R.id.idEdadMascota);
            idPropietarioMascota = itemView.findViewById(R.id.idPropietarioMascota);
            idImagenMascota = itemView.findViewById(R.id.idImagenMascota);

        }

    }

}
