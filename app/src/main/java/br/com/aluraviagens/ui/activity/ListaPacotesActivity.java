package br.com.aluraviagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import br.com.alura.viagem.R;
import br.com.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        listaDePacotes.setAdapter(new ListaPacotesAdapter());
    }
}
