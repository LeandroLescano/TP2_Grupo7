package utn.frgp.tusi.tp2_grupo_7;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListContacts extends OptionMenu {
    private static final String FILE_NAME = "example.txt";
    private ListView Lista;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_contacts);
        Lista = (ListView)findViewById(R.id.lvcontactos);
        load();
    }

    public void load() {
        FileInputStream fis = null;
        ArrayList<String> Contactos = new ArrayList<>();
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            Contactos.add(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Contactos);
        Lista.setAdapter(adap);
    }
    
}