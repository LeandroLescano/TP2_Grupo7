package utn.frgp.tusi.tp2_grupo_7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddContactMore extends OptionMenu {

    private RadioButton primarioInc, primarioCom, secundarioInc, secundarioCom, otroEstudio;
    private CheckBox deporte, arte, musica, tecnologia;
    private String nombre, apellido, telefono, tipo_telefono, tipo_email, email, direccion, fechnac;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_more);

        primarioInc = (RadioButton) findViewById(R.id.rbt_primario_inc);
        primarioCom = (RadioButton) findViewById(R.id.rbt_primario_com);
        secundarioInc = (RadioButton) findViewById(R.id.rbt_secundario_inc);
        secundarioCom = (RadioButton) findViewById(R.id.rbt_secundario_com);
        otroEstudio = (RadioButton) findViewById(R.id.rbt_otro);

        deporte = (CheckBox) findViewById(R.id.chk_deporte);
        arte = (CheckBox) findViewById(R.id.chk_arte);
        musica = (CheckBox) findViewById(R.id.chk_musica);
        tecnologia = (CheckBox) findViewById(R.id.chk_tecnologia);

        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String telefono = getIntent().getStringExtra("telefono");
        String tipo_telefono = getIntent().getStringExtra("tipo_telefono");
        String tipo_email = getIntent().getStringExtra("tipo_email");
        String email = getIntent().getStringExtra("email");
        String direccion = getIntent().getStringExtra("direccion");
        String fechnac = getIntent().getStringExtra("fechnac");



        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

    }



    public void guardarYFinalizar(View view){
        //método para crear contacto

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferences.edit();
        Obj_editor.putString("nombre", nombre);
        Obj_editor.putString("apellido", apellido);
        Obj_editor.putString("telefono", telefono);
        Obj_editor.putString("tipo_email", tipo_email);
        Obj_editor.putString("email", email);
        Obj_editor.putString("direccion", direccion);
        Obj_editor.putString("fechnac", email);

        //agregar segunda pantalla de datos

        Obj_editor.commit();
        Toast.makeText(this, "El contacto fue guardado con éxito", Toast.LENGTH_SHORT).show();

        Intent fin = new Intent(this, ListContacts.class);
        startActivity(fin);
    }
}