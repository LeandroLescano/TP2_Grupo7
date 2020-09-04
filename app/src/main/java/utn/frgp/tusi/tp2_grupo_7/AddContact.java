package utn.frgp.tusi.tp2_grupo_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AddContact extends OptionMenu {

    private EditText name;
    private EditText surname;
    private EditText phone;
    private Spinner phoneType;
    private EditText email;
    private Spinner emailType;
    private EditText direction;
    private EditText fechNac;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        phoneType = (Spinner) findViewById(R.id.sp_telefono);
        emailType = (Spinner) findViewById(R.id.sp_email);
        String[] arraySpinnerPhone = new String[] {"Casa", "Trabajo", "Móvil"};
        ArrayAdapter<String> adapterPhone = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,   arraySpinnerPhone);
        adapterPhone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneType.setAdapter(adapterPhone);

        String[] arraySpinnerEmail = new String[] {"Particular", "Trabajo"};
        ArrayAdapter<String> adapterEmail = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,   arraySpinnerEmail);
        adapterEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emailType.setAdapter(adapterEmail);

        name = findViewById(R.id.et_nombre);
        surname = findViewById(R.id.et_apellido);
        phone = findViewById(R.id.et_telefono);
        email = findViewById(R.id.et_email);
        direction = findViewById(R.id.et_direccion);
        fechNac = findViewById(R.id.et_fechnac);
    }

    public void sendData(View view){
        if(validarCampos()==true) {
            Intent i = new Intent(this, AddContactMore.class);
            i.putExtra("nombre", name.getText().toString());
            i.putExtra("apellido", surname.getText().toString());
            i.putExtra("telefono", phone.getText().toString());
            i.putExtra("tipo_telefono", phoneType.getSelectedItem().toString());
            i.putExtra("email", email.getText().toString());
            i.putExtra("tipo_email", emailType.getSelectedItem().toString());
            i.putExtra("direccion", direction.getText().toString());
            i.putExtra("fechnac", fechNac.getText().toString());
            startActivity(i);
        }
    }

    public boolean validarCampos(){
        if(name.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"El Nombre no puede estar vacio",Toast.LENGTH_LONG).show();
            return false;
        }
        if(surname.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"El Apellido no puede estar vacio",Toast.LENGTH_LONG).show();
            return false;
        }
        if(phone.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"El Teléfono no puede estar vacio",Toast.LENGTH_LONG).show();
            return false;
        }
        if(email.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"El Email no puede estar vacio",Toast.LENGTH_LONG).show();
            return false;
        }
        if(direction.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"El Dirección no puede estar vacio",Toast.LENGTH_LONG).show();
            return false;
        }
        if(fechNac.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"El Fecha de Nacimiento no puede estar vacio",Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            int num = Integer.parseInt(name.getText().toString());
            Toast.makeText(getApplicationContext(),"Error el Nombre posee numeros",Toast.LENGTH_LONG).show();
            return false;

        } catch (NumberFormatException e) {
        }

        try {
            int num = Integer.parseInt(surname.getText().toString());
            Toast.makeText(getApplicationContext(),"Error el Apellido posee numeros",Toast.LENGTH_LONG).show();
            return false;
        } catch (NumberFormatException e) {
        }
        return true;
}

}