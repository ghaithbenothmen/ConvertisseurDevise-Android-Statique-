package com.example.convertisseurdevise;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
   ;


    Button btnConv;
    Spinner sp1,sp2;
    EditText textMontant;
    TextView textMontantConv;




    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Double conv;
           Double montCon = Double.parseDouble(textMontant.getText().toString());
            if(sp1.getSelectedItem().toString()=="EUR" && sp2.getSelectedItem().toString()=="TND"){
                conv=montCon*3.22;
                DecimalFormat df = new DecimalFormat("0.00");
                textMontantConv.setText(df.format(conv));

            }

            if(sp1.getSelectedItem().toString()=="EUR" && sp2.getSelectedItem().toString()=="USD"){
                conv=montCon*0.98;
                DecimalFormat df = new DecimalFormat("0.00");
                textMontantConv.setText(df.format(conv));

            }

            if(sp1.getSelectedItem().toString()=="TND" && sp2.getSelectedItem().toString()=="USD"){
                conv=montCon*0.30;
                DecimalFormat df = new DecimalFormat("0.00");
                textMontantConv.setText(df.format(conv));

            }

            if(sp1.getSelectedItem().toString()=="TND" && sp2.getSelectedItem().toString()=="EUR"){
                conv=montCon*0.30;
                DecimalFormat df = new DecimalFormat("0.00");
                textMontantConv.setText(df.format(conv));

            }

            if(sp1.getSelectedItem().toString()=="USD" && sp2.getSelectedItem().toString()=="TND"){
                conv=montCon*3.27;
                DecimalFormat df = new DecimalFormat("0.00");
                textMontantConv.setText(df.format(conv));

            }

            if(sp1.getSelectedItem().toString()=="USD" && sp2.getSelectedItem().toString()=="EUR"){
                conv=montCon*1.01;
                DecimalFormat df = new DecimalFormat("0.00");
                textMontantConv.setText(df.format(conv));

            }


        }
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnConv = findViewById(R.id.btnCon);
        btnConv.setOnClickListener(listener);
        textMontant = findViewById(R.id.txtMontant);
        sp1= findViewById(R.id.spinnerDe);
        sp2= findViewById(R.id.spinnerVers);
        textMontantConv = findViewById(R.id.montConv);

        String[] de ={"EUR","TND","USD"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,de);
        sp1.setAdapter(ad);

        String[] vers ={"TND","EUR","USD"};
        ArrayAdapter ad2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,vers);
        sp2.setAdapter(ad2);

    }


}
/*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/

