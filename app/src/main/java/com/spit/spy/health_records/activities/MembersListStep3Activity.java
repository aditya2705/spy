package com.spit.spy.health_records.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;
import com.spit.spy.R;
import com.spit.spy.objects.PensionerObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MembersListStep3Activity extends AppCompatActivity {

    @Bind(R.id.table) TableFixHeaders tableFixHeaders;
    @Bind(R.id.close_list_view) ImageView closeViewIcon;

    private MaterialDialog updateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_members_list_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ButterKnife.bind(this);

        ArrayList<PensionerObject> pensionerObjectArrayList = new ArrayList<>();
        for(int i = 1; i < 5 ; i++)
            pensionerObjectArrayList.add(new PensionerObject(i,"152336"+i,"SUPERMAN", "BATMAN","Dummy data",25,"General"));

        tableFixHeaders.setAdapter(new ContentTableAdapter(MembersListStep3Activity.this, pensionerObjectArrayList));

        closeViewIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MembersListStep3Activity.this.finish();
            }
        });

        updateDialog = new MaterialDialog.Builder(this)
                .theme(Theme.LIGHT)
                .content("Update / Delete")
                .title("Update / Delete Record")
                .positiveText("UPDATE")
                .negativeText("DELETE")
                .negativeColor(getResources().getColor(R.color.appThemeColorDark))
                .positiveColor(getResources().getColor(R.color.appThemeColorDark))
                .titleColor(getResources().getColor(R.color.appThemeColorDark))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .canceledOnTouchOutside(false)
                .build();


    }

    public class ContentTableAdapter extends BaseTableAdapter {

        private Activity context;
        private ArrayList<PensionerObject> pensionerObjectArrayList;

        private final String[] headers = new String[]{"क्रम संख्या", "बच्चों का नाम","Health Card हैं/नहीं",
                "यदि हैं तो Health Card नंबर", "नियमित टीकाकरण हुआ हैं / \nमात्र बी. सी. जी. का टिका लगा हैं /\nटिका लगनेके जानकारी नहीं हैं / \nजानकारी हैं पर अनियमित / \nकोई टिका नै लगा हैं "};

        private int[] widths;

        private final int height;

        public ContentTableAdapter(Activity context, ArrayList<PensionerObject> pensionerObjectArrayList) {

            this.context = context;
            this.pensionerObjectArrayList = pensionerObjectArrayList;

            height = context.getResources().getDimensionPixelSize(R.dimen._70sdp);

            widths  = new int[]{
                    context.getResources().getDimensionPixelSize(R.dimen._55sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._110sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._70sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._110sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._150sdp)
            };

        }

        @Override
        public int getRowCount() {
            return pensionerObjectArrayList.size();
        }

        @Override
        public int getColumnCount() {
            return headers.length-1;
        }

        @Override
        public int getWidth(int column) {
            return widths[column+1];
        }

        @Override
        public int getHeight(int row) {
            return height;
        }

        @Override
        public View getView(final int row, int column, View convertView, ViewGroup parent) {
            final View view;
            switch (getItemViewType(row, column)) {
                case 0:
                    view = getHeader(row, column, convertView, parent);
                    break;
                case 1:
                    view = getBody(row, column, convertView, parent);
                    break;
                default:
                    throw new RuntimeException("View fetching exception");
            }

            if(getItemViewType(row,column)!=0) {

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateDialog.show();
                    }
                });
            }

            return view;
        }

        private View getHeader(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_table_header, parent, false);
            }
            ((TextView) convertView.findViewById(android.R.id.text1)).setText(headers[column + 1]);
            return convertView;
        }

        private View getBody(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_table, parent, false);
            }
            convertView.setBackgroundResource(row % 2 == 0 ? R.color.md_grey_50 : R.color.md_grey_200);
            TextView textView = ((TextView) convertView.findViewById(android.R.id.text1));
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextColor(context.getResources().getColor(R.color.md_grey_700));
            String s = "";
            PensionerObject p = pensionerObjectArrayList.get(row);
            switch (column){
                case -1:
                    s = p.getId()+"";
                    break;
                case 0:
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                    textView.setTextColor(context.getResources().getColor(R.color.appThemeColorDark));
                    s= p.getLabharti_id();
                    break;
                case 1:
                    s = p.getLabharti_name();
                    break;
                case 2:
                    s=p.getFather_name();
                    break;
                case 3:
                    s=p.getGender();
                    break;
                case 4:
                    s=p.getAge()+"";
                    break;
                case 5:
                    s=p.getCategory();
                    break;
            }

            textView.setText(s);

            return convertView;
        }


        @Override
        public int getItemViewType(int row, int column) {
            if (row < 0) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }
    }

}
