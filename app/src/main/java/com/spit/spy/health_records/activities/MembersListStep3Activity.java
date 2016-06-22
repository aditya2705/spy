package com.spit.spy.health_records.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;
import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.objects.Infant;
import com.spit.spy.objects.InfantObject;
import com.spit.spy.objects.PensionerObject;
import com.spit.spy.objects.PregnentWomenObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MembersListStep3Activity extends AppCompatActivity implements
        Database.DataReceiver <ArrayList<Infant>> {
Intent intent;
    @Bind(R.id.table) TableFixHeaders tableFixHeaders;
    @Bind(R.id.close_list_view) ImageView closeViewIcon;
    @Bind(R.id.btn_add_member) Button AddMember;
    String id,app_name;
    public String name;
    ContentTableAdapter mContentTableAdapter1;
    private MaterialDialog updateDialog;
    Database.DataReceiver rec;
 ;
    ArrayList<Infant> infants;
    Infant p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_members_list_dialog);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
rec=this;
        ButterKnife.bind(this);
        Intent intent1=getIntent();
        id= intent1.getStringExtra("id");
        app_name=intent1.getStringExtra("app_name");


        infants = new ArrayList<>();
        Infant.get_infantDetail(MembersListStep3Activity.this,rec,id,app_name);


        mContentTableAdapter1 = new ContentTableAdapter(MembersListStep3Activity.this,infants);
        tableFixHeaders.setAdapter(mContentTableAdapter1);



        AddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                intent = new Intent(MembersListStep3Activity.this, AddMember3.class);
                intent.putExtra("name", name);
                intent.putExtra("id", id);

                intent.putExtra("app_name",app_name);
                intent.putExtra("upOrAdd", "add");
                startActivityForResult(intent, 1);
            }
        });

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


                        finish();
                        Intent i=new Intent(MembersListStep3Activity.this,AddMember3.class);
                        i.putExtra("name", name);
                        i.putExtra("app_name",app_name);
;                        i.putExtra("id", id);
                        i.putExtra("upOrAdd","up");
                        startActivity(i);


                        dialog.dismiss();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        new Database.Delete_Step3().execute(id, name);
                        finish();
                        Intent i=new Intent(MembersListStep3Activity.this,MembersListStep3Activity.class);
                        i.putExtra("id", id);
                        i.putExtra("app_name",app_name);
                        startActivity(i);




                        dialog.dismiss();
                    }
                })
                .canceledOnTouchOutside(false)
                .build();


    }

    @Override
    public void onDataReceived(ArrayList<Infant> data) {
        int size=data.size();
        Log.i("size is",size+"");
        infants = data;
//        Log.i("child is", data.get(0).getChild_name().toString());
        mContentTableAdapter1 = new ContentTableAdapter(this,infants);
        tableFixHeaders.setAdapter(mContentTableAdapter1);

    }
    public class ContentTableAdapter extends BaseTableAdapter {

        private Activity context;
        private ArrayList<Infant> infantList;

        private final String[] headers = new String[]{"क्रम संख्या", "बच्चों का नाम","Health Card हैं/नहीं",
                "यदि हैं तो Health Card नंबर", "नियमित टीकाकरण हुआ हैं / \nमात्र बी. सी. जी. का टिका लगा हैं /\nटिका लगनेके जानकारी नहीं हैं / \nजानकारी हैं पर अनियमित / \nकोई टिका नै लगा हैं "};

        private int[] widths;

        private final int height, headerHeight;

        public ContentTableAdapter(Activity context, ArrayList<Infant> data) {

            this.context = context;
            this.infantList= data;

            height = context.getResources().getDimensionPixelSize(R.dimen._50sdp);
            headerHeight = context.getResources().getDimensionPixelSize(R.dimen._70sdp);

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
            return infantList.size();
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
            return (row!=-1) ? height : headerHeight;
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
                        p =infantList.get(row);
                        name=p.getChild_name();
                        updateDialog.show();




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
            Infant p = infantList.get(row);
            switch (column){
                case -1:
                    s = p.getId()+"";
                    break;
                case 0:
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                    textView.setTextColor(context.getResources().getColor(R.color.appThemeColorDark));
                    s= p.getChild_name();
                    break;
                case 1:
                    s = p.getIshealth_card();
                    break;
                case 2:
                    s=p.getHealth_crd_no();
                    break;
                case 3:
                    s=p.getHealth_card_type();
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
