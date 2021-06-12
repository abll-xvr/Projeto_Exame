package mz.ac.isutc.projeto_exame;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public final View parentView;
    public final TextView diaDoMes;
    private final CalendarioAdapter.OnItemListener onItemListener;


    public CalendarioViewHolder(@NonNull View itemView, CalendarioAdapter.OnItemListener onItemListener) {
        super(itemView);
        parentView = itemView.findViewById(R.id.parentView);;
        diaDoMes=itemView.findViewById(R.id.celulaDia);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onItemListener.onItemClick(getAdapterPosition(),(String)diaDoMes.getText());
    }
}
