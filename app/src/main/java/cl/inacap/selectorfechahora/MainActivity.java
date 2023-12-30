package cl.inacap.selectorfechahora;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button fechaBtn, horaBtn;
    EditText fechaTxt, horaTxt;
    private int dia, mes, year, hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fechaBtn = (Button)findViewById(R.id.fechaBtn);
        horaBtn = (Button)findViewById(R.id.horaBtn);
        fechaTxt = (EditText)findViewById(R.id.fechaTxt);
        horaTxt = (EditText)findViewById(R.id.horaTxt);
        fechaBtn.setOnClickListener(this);
        horaBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == fechaBtn) {
            final Calendar ca = Calendar.getInstance();
            dia = ca.get(Calendar.DAY_OF_MONTH);
            mes = ca.get(Calendar.MONTH);
            year= ca.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int mes, int dia) {
                    fechaTxt.setText(dia + "/" + (mes + 1) + "/" + year);
                }
            }, dia, mes, year);
        datePickerDialog.show(); //Aca es donde se hace visible el DatePickerDialog.
        }
        if (view == horaBtn) {
            final Calendar ca = Calendar.getInstance();
            hora = ca.get(Calendar.HOUR_OF_DAY);
            minutos = ca.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hora, int minutos) {
                    horaTxt.setText(hora + ":" + minutos);
                }
            }, hora, minutos, false);
            timePickerDialog.show(); //Aca es donde se hace visible el TimePickerDialog.
        }
    }
}
