package upt.magic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ContraseniaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasenia);
        String codigo = (String) getIntent().getSerializableExtra("codigo");
    }
}