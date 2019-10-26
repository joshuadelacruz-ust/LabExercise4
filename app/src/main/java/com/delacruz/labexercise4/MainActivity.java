package com.delacruz.labexercise4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] cName, cCountry, cIndustry, cCeo, cInfo;
    int[] cLogo = {R.drawable.icbc
            ,R.drawable.jpmorganchase,R.drawable.chinaconstructionbank,
            R.drawable.agriculturalbankofchina,R.drawable.bankofamerica,R.drawable.apple,R.drawable.pingan,R.drawable.chinaconstructionbank,
            R.drawable.royaldutchshell,R.drawable.wellsfargo,R.drawable.exxonmobil,R.drawable.att,R.drawable.samsungelectronics,R.drawable.citigroup};
    ArrayList<Company> companies= new ArrayList<>();
    ListView listCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cName = getResources().getStringArray(R.array.cName);
        cCountry = getResources().getStringArray(R.array.cCountry);
        cIndustry = getResources().getStringArray(R.array.cIndustry);
        cCeo = getResources().getStringArray(R.array.cCeo);
        cInfo = getResources().getStringArray(R.array.cInfo);

        for(int i = 0; i < cName.length; i++){
            companies.add(new Company(cLogo[i], cName[i], cCountry[i], cIndustry[i], cCeo[i], cInfo[i]));

        }

        CompanyAdapter adapter = new CompanyAdapter(this, R.layout.item, companies);

        listCompanies = findViewById(R.id.lvCompany);

        listCompanies.setAdapter(adapter);

        listCompanies.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(cLogo[i]);
        dialog.setTitle(cName[i]);
        dialog.setMessage(cInfo[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, cName[i], Toast.LENGTH_LONG).show();
            }
        });

        dialog.create().show();
    }
}