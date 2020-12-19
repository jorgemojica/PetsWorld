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
import co.edu.ufps.petsworld.Administrator.Model.Recordatorios;
import co.edu.ufps.petsworld.R;

public class RecordatoriosAdapter extends RecyclerView.Adapter<RecordatoriosAdapter.RecordatoriosViewHolder>{

    private ArrayList<Recordatorios> recordatorios;

    public RecordatoriosAdapter(ArrayList<Recordatorios> recordatorios) {

        this.recordatorios = recordatorios;

    }

    @NonNull
    @Override
    public RecordatoriosAdapter.RecordatoriosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recordatorios, parent, false);

        return new RecordatoriosAdapter.RecordatoriosViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecordatoriosAdapter.RecordatoriosViewHolder holder, int position) {

        Picasso.get().load(recordatorios.get(position).getImagen()).into(holder.idImagenRecordatorio);
        holder.idAsuntoRecordatorio.setText(recordatorios.get(position).getAsunto());
        holder.idHoraRecordatorio.setText(recordatorios.get(position).getHora());
        holder.idFechaRecordatorio.setText(recordatorios.get(position).getFecha());
        holder.idMensajeRecordatorio.setText(recordatorios.get(position).getMensaje());

    }

    @Override
    public int getItemCount() {
        return recordatorios.size();
    }

    class RecordatoriosViewHolder extends RecyclerView.ViewHolder{

        TextView idAsuntoRecordatorio, idHoraRecordatorio, idFechaRecordatorio, idMensajeRecordatorio;
        ImageView idImagenRecordatorio;

        public RecordatoriosViewHolder(@NonNull View itemView){

            super(itemView);
            idAsuntoRecordatorio = itemView.findViewById(R.id.idAsuntoRecordatorio);
            idHoraRecordatorio = itemView.findViewById(R.id.idHoraRecordatorio);
            idFechaRecordatorio = itemView.findViewById(R.id.idFechaRecordatorio);
            idMensajeRecordatorio = itemView.findViewById(R.id.idMensajeRecordatorio);
            idImagenRecordatorio = itemView.findViewById(R.id.idImagenRecordatorio);

        }

    }

}
