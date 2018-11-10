package e.danieltemtayo.aad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import static e.danieltemtayo.aad.Constants.KEY_NAME;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etProfession;
    private TextView txvName, txvProfession;
    private Switch pageColorSwitch;
    private RelativeLayout pageLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etProfession = findViewById(R.id.etProfession);
        txvName = findViewById(R.id.txvName);
        txvProfession = findViewById(R.id.txvProfession);
        pageLayout = findViewById(R.id.pageLayout);
        pageColorSwitch = findViewById(R.id.pageColorSwitch);
    }


    public void saveAccountData(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences(getPackageName()+Constants.FILE_NAME
                ,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_NAME,etName.getText().toString());
        editor.putString(Constants.KEY_PROFESSION,etProfession.getText().toString());
        editor.apply();

    }

    public void loadAccountData(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences(
                getPackageName()+Constants.FILE_NAME,Context.MODE_PRIVATE);
        String name=sharedPreferences.getString(KEY_NAME,"N/A");
        String profession=sharedPreferences.getString(Constants.KEY_PROFESSION,"N/A");

        txvName.setText(name);
        txvProfession.setText(profession);
    }

    public void openSecondActivity(View view) {
        Intent intent= new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
