package com.example.ejemplo06_layouts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnRotar;

    private int valor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRotar = findViewById(R.id.btnRotarPantalla);

        btnRotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor += 1;
                //RequestOrientation -> get/set
                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                else
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });
        Log.d("ROTAR", "01 - onCreate " + valor);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ROTAR", "02 - onStart " + valor);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ROTAR", "03 - onResume " + valor);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ROTAR", "04 - onPause " + valor);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ROTAR", "05 - onStop " + valor);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ROTAR", "06 - onRestart " + valor);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ROTAR", "07 - onDestroy " + valor);
    }

    /**
     * Metodos para guardar info temporal
     */

    /**
     * Se ejecuta antes de destruir la actividad
     * @param outState: sirve para almacenar lo que no queremos perder
     */

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ROTAR", "08 - onSaveInstanceState "+valor);
        outState.putInt("VALOR", valor);
    }

    /**
     * Se ejecuta siempre que se haya ejecutado onSave
     * @param savedInstanceState: tengo los datos para recuperarlos
     */

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        valor = savedInstanceState.getInt("VALOR");
        Log.d("ROTAR", "09 - onRestoreInstanceState"+valor);

    }
}

















