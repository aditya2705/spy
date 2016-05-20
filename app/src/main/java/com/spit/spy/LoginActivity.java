package com.spit.spy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.input_password) EditText passwordEditText;
    @Bind(R.id.btn_login) AppCompatButton loginButton;
    @Bind(R.id.area_type_spinner) AppCompatSpinner areaTypeSpinner;
    @Bind(R.id.area_layout) LinearLayout areaLayout;
    @Bind(R.id.town_spinner_layout) LinearLayout townSpinnerLayout;
    @Bind(R.id.rural_spinner_layout) LinearLayout ruralSpinnerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("UPSPS :Health Department - Login");

        final ProgressDialog progressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onLoginSuccess or onLoginFailed
                                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                                if (areaTypeSpinner.getSelectedItemPosition() == 0) {

                                    intent.putExtra("records_type", 0);
                                } else {

                                    intent.putExtra("records_type", 1);
                                }
                                startActivity(intent);
                                // onLoginFailed();
                                progressDialog.dismiss();
                            }
                        }, 2500);

            }
        });

        areaTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        townSpinnerLayout.setVisibility(View.GONE);
                        ruralSpinnerLayout.setVisibility(View.VISIBLE);

                        break;
                    case 1:
                        townSpinnerLayout.setVisibility(View.VISIBLE);
                        ruralSpinnerLayout.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }


}

