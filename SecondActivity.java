package e.danieltemtayo.aad;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static e.danieltemtayo.aad.Constants.KEY_NAME;

public class SecondActivity extends AppCompatActivity {

    private TextView txvName, txvProfession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txvName = findViewById(R.id.txvName);
        txvProfession = findViewById(R.id.txvProfession);
    }

    public void loadAccountData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(
                getPackageName() + Constants.FILE_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, "N/A");
        String profession = sharedPreferences.getString(Constants.KEY_PROFESSION, "N/A");

        txvName.setText(name);
        txvProfession.setText(profession);
    }

    public void clearAccountData(View view) {
    }

    public void removeProfessionKey(View view) {
    }
}
