package com.android.s19110266;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<String> listMessage = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            listMessage.removeIf(n -> n.equals(""));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Toast.makeText(getApplicationContext(),"Toppings: " + String.join(" ",listMessage),
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void onCheckBoxClicked(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.choco:
                if (checked)
                    listMessage.add("Chocolate syrup");
                else listMessage.remove("Chocolate syrup");
                break;
            case R.id.sprinkles:
                if (checked)
                    listMessage.add("Sprinkles");
                else listMessage.remove( "Sprinkles");
                break;
            case R.id.crush:
                if (checked)
                    listMessage.add("Crushed nuts");
                else listMessage.remove( "Crushed nuts");
                break;
            case R.id.cherries:
                if (checked)
                    listMessage.add("Cherries");
                else listMessage.remove( "Cherries");
                break;
            case R.id.orio:
                if (checked)
                    listMessage.add("Orio cookie crumbles");
                else listMessage.remove( "Orio cookie crumbles");
                break;
            default:
                // Do nothing.
                break;
        }
    }
}