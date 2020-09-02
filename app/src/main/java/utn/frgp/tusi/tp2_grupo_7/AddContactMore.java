package utn.frgp.tusi.tp2_grupo_7;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class AddContactMore extends OptionMenu {

    private RadioButton primarioInc, primarioCom, secundarioInc, secundarioCom, otroEstudio;
    private CheckBox deporte, arte, musica, tecnologia;


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
    }

}