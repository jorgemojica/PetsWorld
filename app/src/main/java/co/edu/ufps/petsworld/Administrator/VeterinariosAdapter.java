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
import co.edu.ufps.petsworld.Administrator.Model.Veterinarios;
import co.edu.ufps.petsworld.R;

public class VeterinariosAdapter extends RecyclerView.Adapter<VeterinariosAdapter.VeterinariosViewHolder> {

    private ArrayList<Veterinarios> veterinarios;

    public VeterinariosAdapter(ArrayList<Veterinarios> veterinarios) {

        this.veterinarios = veterinarios;

    }

    @NonNull
    @Override
    public VeterinariosAdapter.VeterinariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.veterinarios, parent, false);

        return new VeterinariosAdapter.VeterinariosViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VeterinariosAdapter.VeterinariosViewHolder holder, int position) {

        Picasso.get().load(veterinarios.get(position).getImagen()).into(holder.imagenVeterinario);
        holder.nombreVeterinario.setText(veterinarios.get(position).getNombre());
        holder.identificationVeterinario.setText(veterinarios.get(position).getIdentificacion());
        holder.telefonoVeterinario.setText(veterinarios.get(position).getTelefono());
        holder.correoVeterinario.setText(veterinarios.get(position).getCorreo());
        holder.numeroConsultorio.setText(veterinarios.get(position).getConsultorio());
        holder.especialidad.setText(veterinarios.get(position).getEspecialidad());

    }

    @Override
    public int getItemCount() {
        return veterinarios.size();
    }

    class VeterinariosViewHolder extends RecyclerView.ViewHolder{

        TextView nombreVeterinario, identificationVeterinario, telefonoVeterinario, correoVeterinario, numeroConsultorio, especialidad;
        ImageView imagenVeterinario;

        public VeterinariosViewHolder(@NonNull View itemView){

            super(itemView);
            nombreVeterinario = itemView.findViewById(R.id.nombreVeterinario);
            identificationVeterinario = itemView.findViewById(R.id.identificationVeterinario);
            telefonoVeterinario = itemView.findViewById(R.id.telefonoVeterinario);
            correoVeterinario = itemView.findViewById(R.id.correoVeterinario);
            numeroConsultorio = itemView.findViewById(R.id.numeroConsultorio);
            especialidad = itemView.findViewById(R.id.especialidad);
            imagenVeterinario = itemView.findViewById(R.id.imagenVeterinario);

        }

    }

}
