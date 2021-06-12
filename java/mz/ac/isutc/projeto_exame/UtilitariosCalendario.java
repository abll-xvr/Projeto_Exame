package mz.ac.isutc.projeto_exame;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UtilitariosCalendario {

    public static LocalDate dataSelecionada;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<LocalDate> arrayDiasNoMes(LocalDate dataSelecionada) {
        ArrayList<LocalDate> arrayDiasNoMes = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(dataSelecionada);

        int diasNoMes = yearMonth.lengthOfMonth();
        LocalDate primeiroDoMes = dataSelecionada.withDayOfMonth(1);
        int diaDaSemana = primeiroDoMes.getDayOfWeek().getValue();

        for (int i = 1; i <= 42; i++) {
            if (i <= diaDaSemana || i > diasNoMes + diaDaSemana) {
                arrayDiasNoMes.add(null);
            } else {
                arrayDiasNoMes.add(LocalDate.of(dataSelecionada.getYear(), dataSelecionada.getMonth(), i - diaDaSemana));
            }
        }
        return arrayDiasNoMes;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String mesAnoDeData(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<LocalDate> arrayDiasNaSemana(LocalDate dataSelecionada) {
        ArrayList<LocalDate> dias = new ArrayList<>();
        LocalDate atual = domingoParaData(dataSelecionada);
        LocalDate fimData = atual.plusWeeks(1);

        while(atual.isBefore(fimData)){
            dias.add(atual);
            atual= atual.plusDays(1);
        }

        return dias;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static LocalDate domingoParaData(LocalDate atual) {
        LocalDate umaSemanaAtras = atual.minusWeeks(1);

        while(atual.isAfter(umaSemanaAtras)){
            if(atual.getDayOfWeek() == DayOfWeek.SUNDAY)
                return atual;

                atual= atual.minusDays(1);

        }
        return null;
    }

}
