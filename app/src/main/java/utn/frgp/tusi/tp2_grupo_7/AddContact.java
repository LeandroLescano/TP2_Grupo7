package utn.frgp.tusi.tp2_grupo_7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class AddContact extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View v = inflater.inflate(R.layout.add_contact, container, false);
        Spinner phoneSpinner = (Spinner) v.findViewById(R.id.sp_telefono);
        Spinner emailSpinner = (Spinner) v.findViewById(R.id.sp_email);
        String[] arraySpinnerPhone = new String[] {"Casa", "Trabajo", "Móvil"};
        ArrayAdapter<String> adapterPhone = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,   arraySpinnerPhone);
        adapterPhone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneSpinner.setAdapter(adapterPhone);

        String[] arraySpinnerEmail = new String[] {"Particular", "Trabajo"};
        ArrayAdapter<String> adapterEmail = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,   arraySpinnerEmail);
        adapterEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emailSpinner.setAdapter(adapterEmail);

        // Inflate the layout for this fragment
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_continuar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AddContact.this)
                        .navigate(R.id.action_to_more_info);
            }
        });
    }
}