package com.spit.spy.infant.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.DialogFragment;
import com.spit.spy.R;

import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BirthVaccinationFragment extends Fragment {

    @Bind(R.id.toggleButton1) ToggleButton toggleButton1;
    @Bind(R.id.toggleButton2) ToggleButton toggleButton2;
    @Bind(R.id.toggleButton3) ToggleButton toggleButton3;

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

        final DatePickerDialog.Builder datePickerDialogBuilder = new DatePickerDialog.Builder(R.style.Material_App_Dialog_DatePicker_Light){
            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                DatePickerDialog dialog = (DatePickerDialog)fragment.getDialog();
                String date = dialog.getFormattedDate(SimpleDateFormat.getDateInstance());
                Toast.makeText(getActivity(), "Date is " + date, Toast.LENGTH_SHORT).show();
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
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);
                    fragment.show(getFragmentManager(), null);
                }
            }
        });

        toggleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton2.isChecked()){
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);
                    fragment.show(getFragmentManager(), null);
                }
            }
        });

        toggleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton3.isChecked()){
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);
                    fragment.show(getFragmentManager(), null);
                }
            }
        });

        return rootView;
    }

}
