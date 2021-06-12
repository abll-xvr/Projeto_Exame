package mz.ac.isutc.projeto_exame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static mz.ac.isutc.projeto_exame.UtilitariosCalendario.arrayDiasNoMes;
import static mz.ac.isutc.projeto_exame.UtilitariosCalendario.dataSelecionada;
import static mz.ac.isutc.projeto_exame.UtilitariosCalendario.mesAnoDeData;

public class MainActivity extends AppCompatActivity implements CalendarioAdapter.OnItemListener {

    private TextView textoMesAno;
    private RecyclerView calendarioRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarwidgets();
        dataSelecionada= LocalDate.now();
        setViewMes();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setViewMes() {
        textoMesAno.setText(mesAnoDeData(dataSelecionada));
        ArrayList<LocalDate> diasNoMes= arrayDiasNoMes(dataSelecionada);

        CalendarioAdapter calendarioAdapter = new CalendarioAdapter(diasNoMes, this);
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getApplicationContext(), 7);
        calendarioRecyclerView.setLayoutManager(layoutManager);
        calendarioRecyclerView.setAdapter(calendarioAdapter);
    }


    private void inicializarwidgets() {
        calendarioRecyclerView = findViewById(R.id.ReciclerViewCalendario);
        textoMesAno = findViewById(R.id.tv_mesAno);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void acaoMesAnterior(View view) {
        dataSelecionada = dataSelecionada.minusMonths(1);
        setViewMes();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void acaoProximoMes(View view) {
        dataSelecionada = dataSelecionada.plusMonths(1);
        setViewMes();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, String textoDia) {
        if (textoDia.equals("")){
            String mensagem = "Data Selecionada " + textoDia + " " + mesAnoDeData(dataSelecionada);
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        }
    }

    public void acaoSemanal(View view) {
        startActivity(new Intent(this, ActivityViewSemana.class));
    }
}