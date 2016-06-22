package com.spit.spy.infant.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.widget.DatePicker;
import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.infant.activities.StepsActivity;
import com.spit.spy.objects.InfantObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoosterFragment extends Fragment {

    @Bind(R.id.toggleButton1)
    ToggleButton toggleButton1;
    @Bind(R.id.toggleButton2)
    ToggleButton toggleButton2;
    @Bind(R.id.toggleButton3)
    ToggleButton toggleButton3;
    @Bind(R.id.OPV)
    TextView OPV;
    @Bind(R.id.DPT)
    TextView DPT;
    @Bind(R.id.khasra)
    TextView khasra;
    @Bind(R.id.btn_update)
    AppCompatButton update;
    Context context;
    Database.DataReceiver receiver;
    String date1, date_dpt, date2, date3;
    int check_button;
    private View rootView;
    int mm, dd, yy;
    StepsActivity obj;
    String child_name_spinner;
int position_tab;
    public BoosterFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.booster_fragment, container, false);
        obj = (StepsActivity) getActivity();
        ButterKnife.bind(this, rootView);
        final int position = obj.Position_frag();
        child_name_spinner = obj.Child_name();
        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.viewpager);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {

                position_tab = position;
                Log.i("position in booster :", "" + position_tab);

            }
        });


        final DatePickerDialog.Builder datePickerDialogBuilder = new DatePickerDialog.Builder(R.style.Material_App_Dialog_DatePicker_Light) {


            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                final Calendar cal = Calendar.getInstance();
                dd = cal.get(Calendar.DAY_OF_MONTH);
                mm = cal.get(Calendar.MONTH);
                yy = cal.get(Calendar.YEAR);


                DatePickerDialog dialog = (DatePickerDialog) fragment.getDialog();
                date1 = dialog.getFormattedDate(SimpleDateFormat.getDateInstance());

                if (check_button == 1) {


                    DPT.setText(date1);
                    Date parsedDate = null;

                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date_dpt = print1.format(parsedDate);

                    Log.i("date1", date_dpt);

                } else if (check_button == 2) {
                    OPV.setText(date1);
                    Date parsedDate = null;

                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date2 = print1.format(parsedDate);


                } else {
                    khasra.setText(date1);
                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date3 = print1.format(parsedDate);


                }
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
//                child_name_spinner = obj.Child_name();
                if (toggleButton1.isChecked()) {
                    check_button = 1;
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);
                    fragment.show(getFragmentManager(), null);

                }
            }
        });

        toggleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                child_name_spinner = obj.Child_name();
                if (toggleButton2.isChecked()) {
                    check_button = 2;
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);
                    fragment.show(getFragmentManager(), null);
                }
            }
        });

        toggleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                child_name_spinner = obj.Child_name();
                if (toggleButton3.isChecked()) {
                    check_button = 3;
                    DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);
                    fragment.show(getFragmentManager(), null);
                }
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child_name_spinner = obj.Child_name();

                try {
//
                    Log.d("CHILD-BIRTH", child_name_spinner);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                new Database.StoreDate().execute(5,date_dpt, date2, date3, child_name_spinner);


            }
        });


        return rootView;
    }

}
