package com.spit.spy.health_records.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

public class HealthRecordsListActivity extends AppCompatActivity {

	@Bind(R.id.table) TableFixHeaders tableFixHeaders;

	private MaterialDialog searchDialog;
	int records_type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_health_records_list);
		ButterKnife.bind(this);

		records_type = getIntent().getIntExtra("records_type",0);

		getSupportActionBar().setTitle("Health Records - " + ((records_type==0)?"Rural":"Urban"));
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		searchDialog = new MaterialDialog.Builder(this)
				.theme(Theme.LIGHT)
				.customView(R.layout.health_records_list_dialog,true)
				.title("Samajwadi Pensioner's List")
				.positiveText("SEARCH")
				.negativeText("CANCEL")
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

		searchDialog.show();




		ArrayList<PensionerObject> pensionerObjectArrayList = new ArrayList<>();
		for(int i = 1; i < 13 ; i++)
			pensionerObjectArrayList.add(new PensionerObject(i,"343427"+i,"MEMBER"+i, "MEMBER"+i,"M",28,"GENERAL"));

		tableFixHeaders.setAdapter(new ContentTableAdapter(HealthRecordsListActivity.this, pensionerObjectArrayList));

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
		private ArrayList<PensionerObject> pensionerObjectArrayList;

		private final String[] headers = new String[]{"क्रम संख्या", "लाभार्थी आईडी","लाभार्थी का नाम","पिता का नाम", "लिंग","आयु","वर्ग"};

		private int[] widths;

		private final int height;

		public ContentTableAdapter(Activity context, ArrayList<PensionerObject> pensionerObjectArrayList) {
			this.context = context;
			this.pensionerObjectArrayList = pensionerObjectArrayList;

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
							Intent intent;
							if(records_type == 0) {
								intent = new Intent(context, HRStepsRuralActivity.class);
							}
							else
								intent = new Intent(context, HRStepsUrbanActivity.class);

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
