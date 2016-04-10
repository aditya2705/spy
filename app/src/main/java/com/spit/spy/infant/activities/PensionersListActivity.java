package com.spit.spy.infant.activities;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.inqbarna.tablefixheaders.TableFixHeaders;

import com.spit.spy.R;
import com.spit.spy.infant.adapters.DefaultTableAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PensionersListActivity extends AppCompatActivity {

	@Bind(R.id.table) TableFixHeaders tableFixHeaders;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pensioners_list);
		ButterKnife.bind(this);

		tableFixHeaders.setAdapter(new ContentTableAdapter(this));

	}

	public class ContentTableAdapter extends DefaultTableAdapter {

		private final int width;
		private final int height;

		public ContentTableAdapter(Context context) {
			super(context);

			Resources resources = context.getResources();

			width = resources.getDimensionPixelSize(R.dimen._80sdp);
			height = resources.getDimensionPixelSize(R.dimen._50sdp);
		}

		@Override
		public int getRowCount() {
			return 5;
		}

		@Override
		public int getColumnCount() {
			return 6;
		}

		@Override
		public int getWidth(int column) {
			return width;
		}

		@Override
		public int getHeight(int row) {
			return height;
		}

		@Override
		public String getCellString(int row, int column) {
			return "Lorem (" + row + ", " + column + ")";
		}

		@Override
		public int getLayoutResource(int row, int column) {
			final int layoutResource;
			switch (getItemViewType(row, column)) {
				case 0:
					layoutResource = R.layout.item_table_header;
				break;
				case 1:
					layoutResource = R.layout.item_table;
				break;
				default:
					throw new RuntimeException("wtf?");
			}
			return layoutResource;
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
