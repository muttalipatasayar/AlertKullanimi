package com.example.alertkullanimi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonNormal,buttonOzel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNormal=findViewById(R.id.buttonNormal);
        buttonOzel=findViewById(R.id.buttonOzel);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad= new AlertDialog.Builder(MainActivity.this);
                ad.setMessage("Mesaj");
                ad.setTitle("Baslik");
                ad.setIcon(R.drawable.resim);


                ad.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Tamam Tiklandi",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("Iptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Iptal Tiklandi",Toast.LENGTH_SHORT).show();

                    }
                });
                ad.create().show();
            }
        });

        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View tasarim= getLayoutInflater().inflate(R.layout.alert_tasarim,null);// root: baska bir tasarimla baglantili olmadigi icin null secildi
                EditText editTextAlert= tasarim.findViewById(R.id.editTextAlert);
                AlertDialog.Builder ad= new AlertDialog.Builder(MainActivity.this);
                ad.setMessage("Mesaj");
                ad.setView(tasarim);
                ad.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String gelenVeri= editTextAlert.getText().toString();
                        Toast.makeText(getApplicationContext(),"Alinan Veri :" + gelenVeri,Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("Iptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Ozel Iptal Secildi :",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.create().show();

            }
        });
    }
}