package br.ici.treinamento.minhasanotaes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textoRecuperado = editAnotacao.getText().toString();
                if(textoRecuperado.equals("")){

                    Snackbar.make(view, "Preencha a anotação! ", Snackbar.LENGTH_LONG).show();

                }else{
                    preferencias.salvarAnotacoes(textoRecuperado);

                    Snackbar.make(view, "Anotação salva!! ", Snackbar.LENGTH_LONG).show();
                }


            }
        });

        //recuperar anotação
       String anotacao = preferencias.recuperarAnotacao();
       if (!anotacao.equals("")){
            editAnotacao.setText(anotacao);
       }
    }


}
