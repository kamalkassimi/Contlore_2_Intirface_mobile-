package com.elmernissi.myrestufinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.elmernissi.myrestufinder.MyAdapter.MyAdapter;
import com.elmernissi.myrestufinder.model.Magasin;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<Magasin> magasins;
    private Spinner citySpinner;
    String[] villes = {"safi", "casa", "jadida", "tanja"};

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toolber);
        setSupportActionBar(toolbar);
        citySpinner = findViewById(R.id.citySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.priority, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        // Exemple de données pour le RecyclerView
        magasins = new ArrayList<>();

//        Declarer le Adapter et passer les données magasins
        MyAdapter  adapter1 = new MyAdapter(magasins) ;
        recyclerView.setAdapter(adapter1);

        //setAdapter(adapter) a le recyclerView

           citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
               @Override
               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   data();
                   recycleadd(citySpinner.getSelectedItem().toString());
               }

               @Override
               public void onNothingSelected(AdapterView<?> parent) {

               }

               private void data() {
                   magasins.add(new Magasin("name","safi","069490"));
                   magasins.add(new Magasin("name1","casa","069490"));
                   magasins.add(new Magasin("name","safi","069490"));
                   magasins.add(new Magasin("name1","casa","069490"));
               }

               private void recycleadd(String key){
               ArrayList<Magasin> magasinArrayList = new ArrayList<>();
                   for (Magasin magasin : magasins) {
                       if (magasin.getAddrese().equals(key)){
                           magasinArrayList.add(magasin);
                       }
                   }
               }

           });
           adapter1.setchange(magasins);
           adapter1.notifyDataSetChanged();




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Gérer les actions du menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_contact_us) {
            Toast.makeText(this, "Aide", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_help) {
            Toast.makeText(this, "action", Toast.LENGTH_SHORT).show();
            return  true;
        }
      else {
            return super.onOptionsItemSelected(item);
        }

        }

}