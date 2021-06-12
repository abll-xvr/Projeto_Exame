package mz.ac.isutc.projeto_exame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

import static mz.ac.isutc.projeto_exame.UtilitariosCalendario.arrayDiasNaSemana;
import static mz.ac.isutc.projeto_exame.UtilitariosCalendario.arrayDiasNoMes;
import static mz.ac.isutc.projeto_exame.UtilitariosCalendario.dataSelecionada;
import static mz.ac.isutc.projeto_exame.UtilitariosCalendario.mesAnoDeData;

public class ActivityViewSemana extends AppCompatActivity implements CalendarioAdapter.OnItemListener {

    private TextView textoMesAno;
    private RecyclerView calendarioRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_semana);
        inicializarwidgets();
        setViewSemana();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setViewSemana() {
        textoMesAno.setText(mesAnoDeData(dataSelecionada));
        ArrayList<LocalDate> diasNaSemana= arrayDiasNaSemana(dataSelecionada);

        CalendarioAdapter calendarioAdapter = new CalendarioAdapter(diasNaSemana, this);
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getApplicationContext(), 7);
        calendarioRecyclerView.setLayoutManager(layoutManager);
        calendarioRecyclerView.setAdapter(calendarioAdapter);
    }



    private void inicializarwidgets() {
        calendarioRecyclerView = findViewById(R.id.ReciclerViewCalendario);
        textoMesAno = findViewById(R.id.tv_mesAno);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void acaoSemanaAnterior(View view) {
        dataSelecionada = dataSelecionada.minusWeeks(1);
        setViewSemana();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void acaoProximaSemana(View view) {
        dataSelecionada = dataSelecionada.plusWeeks(1);
        setViewSemana();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onItemClick(int position, String textoDia) {
            String mensagem = "Data Selecionada " + textoDia + " " + mesAnoDeData(dataSelecionada);
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    public void acaoNovoEvento(View view) {
    }
}