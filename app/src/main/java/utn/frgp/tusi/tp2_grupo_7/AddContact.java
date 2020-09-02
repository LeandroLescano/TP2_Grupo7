package utn.frgp.tusi.tp2_grupo_7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

public class AddContact extends Fragment {

    private EditText name;
    private EditText surname;
    private EditText phone;
    private Spinner phoneType;
    private EditText email;
    private Spinner emailType;
    private EditText direction;
    private EditText fechnac;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View v = inflater.inflate(R.layout.add_contact, container, false);
        phoneType = (Spinner) v.findViewById(R.id.sp_telefono);
        emailType = (Spinner) v.findViewById(R.id.sp_email);
        String[] arraySpinnerPhone = new String[] {"Casa", "Trabajo", "Móvil"};
        ArrayAdapter<String> adapterPhone = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,   arraySpinnerPhone);
        adapterPhone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneType.setAdapter(adapterPhone);

        String[] arraySpinnerEmail = new String[] {"Particular", "Trabajo"};
        ArrayAdapter<String> adapterEmail = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,   arraySpinnerEmail);
        adapterEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emailType.setAdapter(adapterEmail);

        name = v.findViewById(R.id.et_nombre);
        surname = v.findViewById(R.id.et_apellido);
        phone = v.findViewById(R.id.et_telefono);
        email = v.findViewById(R.id.et_email);
        direction = v.findViewById(R.id.et_direccion);
        fechnac = v.findViewById(R.id.et_fechnac);

        // Inflate the layout for this fragment
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_continuar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
    }

    public void sendData(){
        Bundle data = new Bundle();
        data.putString("nombre", name.getText().toString());
        data.putString("apellido", surname.getText().toString());
        data.putString("telefono", phone.getText().toString());
        data.putString("tipo_telefono", phoneType.getSelectedItem().toString());
        data.putString("email", email.getText().toString());
        data.putString("tipo_email", emailType.getSelectedItem().toString());
        data.putString("direccion", direction.getText().toString());
        data.putString("fechnac", fechnac.getText().toString());

        Fragment more_data = new AddContactMore();
        more_data.setArguments(data);
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
  //      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    //    fragmentTransaction.replace(this.getId(), more_data);
     //   fragmentTransaction.addToBackStack(null);

       // fragmentTransaction.commit();
        NavHostFragment.findNavController(AddContact.this)
              .navigate(R.id.action_to_more_info);
    }
}