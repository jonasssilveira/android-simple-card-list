package com.viagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.viagens.R;
import com.viagens.models.Pacote;
import com.viagens.models.PacoteDAO;
import com.viagens.ui.activity.adapters.PacoteAdapter;

import java.util.List;

public class ListaPacotes extends AppCompatActivity {

    public static final String APP_TASKBAR = "Pacotes";
    ListView listViewPacotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(APP_TASKBAR);
        getSupportActionBar().setElevation(0);
        listViewPacotes = findViewById(R.id.activity_lista_pacotes_list);
        listViewPacotes.setAdapter(new PacoteAdapter(PacoteDAO.lista(),this));
    }
}