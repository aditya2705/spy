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
import com.spit.spy.objects.MemberDetailObject;
import com.spit.spy.objects.PensionerObject;
import com.spit.spy.objects.PregnentWomenObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MembersListStep2Activity extends AppCompatActivity
        implements Database.DataReceiver <ArrayList<PregnentWomenObject>>{
Intent intent;
    String name,app_name;
    @Bind(R.id.table) TableFixHeaders tableFixHeaders;
    @Bind(R.id.close_list_view) ImageView closeViewIcon;
    @Bind(R.id.btn_add_member)
    Button btn_add_member;
    Database.DataReceiver rec;
    ArrayList<PregnentWomenObject> members;
    PregnentWomenObject p;


    ContentTableAdapter mContentTableAdapter1;
    private MaterialDialog updateDialog;
String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_members_list_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rec= (Database.DataReceiver) this;
        ButterKnife.bind(this);
        Intent intent1=getIntent();
        id= intent1.getStringExtra("id");
        app_name=intent1.getStringExtra("app_name");


        members = new ArrayList<>();
        PregnentWomenObject.getAll(this, rec, id);


        mContentTableAdapter1 = new ContentTableAdapter(MembersListStep2Activity.this, members);
        tableFixHeaders.setAdapter(mContentTableAdapter1);


        btn_add_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                intent = new Intent(MembersListStep2Activity.this, AddMember2.class);
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
                MembersListStep2Activity.this.finish();

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
                        Intent i=new Intent(MembersListStep2Activity.this,AddMember2.class);
                        i.putExtra("name", name);
                        i.putExtra("app_name",app_name);
                        i.putExtra("id", id);
                        i.putExtra("upOrAdd", "up");
                        startActivity(i);




                        dialog.dismiss();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        new Database.Delete_Step2().execute(id, name);
                        finish();
                        Intent i=new Intent(getApplicationContext(),MembersListStep2Activity.class);
                        i.putExtra("id", id);
                        startActivity(i);



                        dialog.dismiss();
                    }
                })
                .canceledOnTouchOutside(false)
                .build();


    }

    @Override
    public void onDataReceived(ArrayList<PregnentWomenObject> data) {
        members = data;
        mContentTableAdapter1 = new ContentTableAdapter(this,members);
        tableFixHeaders.setAdapter(mContentTableAdapter1);
    }


    public class ContentTableAdapter extends BaseTableAdapter {

        private Activity context;
        private ArrayList<PregnentWomenObject> memberList;

        private final String[] headers = new String[]{"क्रम संख्या", "गर्भवती महिला का नाम","गर्भवती महिला की उम्र"};

        private int[] widths;

        private final int height;

        public ContentTableAdapter(Activity context, ArrayList<PregnentWomenObject> data) {

            this.context = context;
            this.memberList = data;

            height = context.getResources().getDimensionPixelSize(R.dimen._50sdp);

            widths  = new int[]{
                    context.getResources().getDimensionPixelSize(R.dimen._55sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._110sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._90sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._60sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._70sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._85sdp),
                    context.getResources().getDimensionPixelSize(R.dimen._90sdp)
            };

        }

        @Override
        public int getRowCount() {
            return memberList.size();
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
                        p =memberList.get(row);
                        name=p.getPregnentwomen_name();
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
            PregnentWomenObject p = memberList.get(row);
            switch (column){
                case -1:
                    s = p.getId()+"";
                    break;
                case 0:
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                    textView.setTextColor(context.getResources().getColor(R.color.appThemeColorDark));
                    s= p.getPregnentwomen_name();
                    break;
                case 1:
                    s = p.getPregnentwomen_age();
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
