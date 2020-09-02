package utn.frgp.tusi.tp2_grupo_7;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class OptionMenu extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_add_contact) {
            Intent intent = new Intent(this, AddContact.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_list_contacts) {
            Intent intent = new Intent(this, utn.frgp.tusi.tp2_grupo_7.ListContacts.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
