package com.spit.spy.infant.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.DialogFragment;
import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.infant.activities.StepsActivity;

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
public class NineTo12Fragment extends Fragment {

    @Bind(R.id.toggleButton1)
    ToggleButton toggleButton1;

    @Bind(R.id.khasra)
    TextView khasra;
    @Bind(R.id.btn_update)
    AppCompatButton update;
    Context context;
    Database.DataReceiver receiver;
    String date1, date_khasra;
    int check_button;
    private View rootView;
    int mm, dd, yy;
    StepsActivity obj;
    String child_name_spinner;
int position_tab;
    public NineTo12Fragment() {
        // Required empty public constructor
    }

    public Date date_format(String date1) {
        Date parsedDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            parsedDate = sdf.parse(date1);
            SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("date is " + print.format(parsedDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.nineto12_fragment, container, false);
        obj = (StepsActivity) getActivity();
        ButterKnife.bind(this, rootView);
        final int position = obj.Position_frag();
        child_name_spinner = obj.Child_name();
//        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.viewpager);
//        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            public void onPageScrollStateChanged(int state) {
//            }
//
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            public void onPageSelected(int position) {
//
//                position_tab = position;
//                Log.i("position in 912 :", "" + position_tab);
//
//            }
//        });

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


                    khasra.setText(date1);
                    Date parsedDate = null;

                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date_khasra = print1.format(parsedDate);

                    Log.i("date1", date_khasra);

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




        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child_name_spinner = obj.Child_name();

                try {
//                    Log.i("childddd", child_name_spinner);
                    Log.d("CHILD-BIRTH", child_name_spinner);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    new Database.StoreDate_NineTo12().execute(date_khasra, child_name_spinner);


            }
        });


        return rootView;
    }

}
