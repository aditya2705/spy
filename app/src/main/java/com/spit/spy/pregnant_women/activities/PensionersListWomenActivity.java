package com.spit.spy.pregnant_women.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;
import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.objects.InfantObject;
import com.spit.spy.objects.MemberListObject;
import com.spit.spy.objects.PensionObject;
import com.spit.spy.objects.Pensioner;
import com.spit.spy.objects.PensionerObject;
import com.spit.spy.objects.PregnentWomenObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PensionersListWomenActivity extends AppCompatActivity
		implements Database.DataReceiver<ArrayList<MemberListObject>>
{

	@Bind(R.id.table) TableFixHeaders tableFixHeaders;
	ArrayList<MemberListObject> women;
	private MaterialDialog searchDialog;
	private ContentTableAdapter m1ContentTableAdapter;
	MemberListObject pr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pensioners_list);
		ButterKnife.bind(this);

		getSupportActionBar().setTitle("Pregnant Women Records");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//From here search dialog starts.............

//		searchDialog = new MaterialDialog.Builder(this)
//				.theme(Theme.LIGHT)
//				.customView(R.layout.search_dialog,true)
//				.title("Samajwadi Pensioner's List")
//				.positiveText("SEARCH")
//				.negativeText("CANCEL")
//				.negativeColor(getResources().getColor(R.color.appThemeColorDark))
//				.positiveColor(getResources().getColor(R.color.appThemeColorDark))
//				.titleColor(getResources().getColor(R.color.appThemeColorDark))
//				.onPositive(new MaterialDialog.SingleButtonCallback() {
//					@Override
//					public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//						EditText et = (EditText)searchDialog.findViewById(R.id.select);
//						String sel=et.getText().toString();
//						filter(sel);
//					}
//				})
//
//
//				.onNegative(new MaterialDialog.SingleButtonCallback() {
//					@Override
//					public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//						dialog.dismiss();
//					}
//				})
//				.canceledOnTouchOutside(false)
//				.build();
//

		// Till here................

		//searchDialog.show();

		/*add_member.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PensionersListWomenActivity.this, Add_women.class);
				startActivity(intent);
			}
		});*/



		women = new ArrayList<>();
		MemberListObject.getAll(this,this);

		m1ContentTableAdapter = new ContentTableAdapter(PensionersListWomenActivity.this,women);
		tableFixHeaders.setAdapter(m1ContentTableAdapter);
	}
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		MenuItem register = menu.findItem(R.id.action_add);
		register.setVisible(false);
		return true;
	}
	public void filter(String sel)
	{
		MemberListObject.getDetails(PensionersListWomenActivity.this,this,sel);
		searchDialog.dismiss();

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_search, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		switch (id){
			case R.id.action_search:
				searchDialog.show();
				break;
			case android.R.id.home:
				finish();
		}

		return super.onOptionsItemSelected(item);
	}

	public class ContentTableAdapter extends BaseTableAdapter {

		private Activity context;
		private ArrayList<MemberListObject> pregnantWomenArrayList;

		private final String[] headers = new String[]{"क्रम संख्या", "लाभार्थी आईडी","लाभार्थी का नाम", "लिंग","आयु","वर्ग"};

		private int[] widths;

		private final int height;

		public ContentTableAdapter(Activity context, ArrayList<MemberListObject> pregnantWomenArrayList) {

			this.context = context;
			this.pregnantWomenArrayList = pregnantWomenArrayList;

			height = context.getResources().getDimensionPixelSize(R.dimen._50sdp);

			widths  = new int[]{
					context.getResources().getDimensionPixelSize(R.dimen._55sdp),
					context.getResources().getDimensionPixelSize(R.dimen._100sdp),
					context.getResources().getDimensionPixelSize(R.dimen._110sdp),
					context.getResources().getDimensionPixelSize(R.dimen._110sdp),
					context.getResources().getDimensionPixelSize(R.dimen._60sdp),
					context.getResources().getDimensionPixelSize(R.dimen._65sdp),
					context.getResources().getDimensionPixelSize(R.dimen._80sdp),
			};

		}

		@Override
		public int getRowCount() {
			return pregnantWomenArrayList.size();
		}

		@Override
		public int getColumnCount() {
			return 5;
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
						Intent intent = new Intent(context, WomanDetailsUpdateActivity.class);
						pr = pregnantWomenArrayList.get(row);
						String id=pr.getID_FORIDCARD();
						String name=pr.getApplicant_Name();
						String age=pr.getAge();
						intent.putExtra("id",id);
						intent.putExtra("name",name);
						intent.putExtra("age",age);
						Log.d("id in List",id);
						startActivity(intent);
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
			MemberListObject p = pregnantWomenArrayList.get(row);
			switch (column){
				case -1:
					s = p.getId()+"";
					break;
				case 0:
					textView.setTypeface(Typeface.DEFAULT_BOLD);
					textView.setTextColor(context.getResources().getColor(R.color.appThemeColorDark));
					s= p.getID_FORIDCARD();
					break;
				case 1:
					s = p.getApplicant_Name();
					break;

				case 2:
					s=p.getGender();
					break;
				case 3:
					s=p.getAge();
					break;
				case 4:
					s=p.getCategory_name();
					break;
				default:
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



	public void onDataReceived(ArrayList<MemberListObject> data)
	{

		m1ContentTableAdapter = new ContentTableAdapter(this, data);
		tableFixHeaders.setAdapter(m1ContentTableAdapter);
	}

}
