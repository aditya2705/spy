package com.spit.spy.infant.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.DialogFragment;
import com.spit.spy.R;
import com.spit.spy.infant.activities.StepsActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BirthVaccinationFragment extends Fragment {

    @Bind(R.id.toggleButton1) ToggleButton toggleButton1;
    @Bind(R.id.toggleButton2) ToggleButton toggleButton2;
    @Bind(R.id.toggleButton3) ToggleButton toggleButton3;
    @Bind(R.id.OPV) TextView OPV;
    @Bind(R.id.HB) TextView HB;
    @Bind(R.id.BCG) TextView BCG;
    int count,mm,dd,yy;

    String date;
int check_button;
    private View rootView;

    public BirthVaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_birth_vaccination_infant, container, false);
        ButterKnife.bind(this,rootView);

        count=StepsActivity.position_1;





        final DatePickerDialog.Builder datePickerDialogBuilder = new DatePickerDialog.Builder(R.style.Material_App_Dialog_DatePicker_Light){
            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                final Calendar cal = Calendar.getInstance();
                 dd = cal.get(Calendar.DAY_OF_MONTH);
                 mm = cal.get(Calendar.MONTH);
                 yy = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = (DatePickerDialog)fragment.getDialog();
               date = dialog.getFormattedDate(SimpleDateFormat.getDateInstance());
                if(check_button==1)
                {

                    OPV.setText(date);
                }

                 else if(check_button==2)
                    HB.setText(date);
                else
                BCG.setText(date);
                super.onPositiveActionClicked(fragment);
            }

            @Override
            public void onNegativeActionClicked(DialogFragment fragment) {
                super.onNegativeActionClicked(fragment);
            }
        };

        datePickerDialogBuilder
                .positiveAction("OK")
                .negativeAction("CANCEL");


        toggleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton1.isChecked()){
                 check_button=1;
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);

                    fragment.show(getFragmentManager(), null);

                }
            }
        });

        toggleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton2.isChecked()){
                    check_button=2;
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);
                    fragment.show(getFragmentManager(), null);
                }
            }
        });

        toggleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton3.isChecked()){
                    check_button=3;
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);
                    fragment.show(getFragmentManager(), null);
                }
            }
        });

        return rootView;
    }

}
