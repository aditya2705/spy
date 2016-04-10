package com.spit.spy.infant.adapters;

import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This class implements the main functionalities of the TableAdapter in
 * Mutuactivos.
 * 
 * 
 * @author Brais Gabín
 */
public abstract class DefaultTableAdapter extends BaseTableAdapter {
	private final Context context;
	private final LayoutInflater inflater;

	/**
	 * Constructor
	 * 
	 * @param context
	 *            The current context.
	 */
	public DefaultTableAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	/**
	 * Returns the context associated with this array adapter. The context is
	 * used to create views from the resource passed to the constructor.
	 * 
	 * @return The Context associated with this adapter.
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * Quick access to the LayoutInflater instance that this Adapter retreived
	 * from its Context.
	 * 
	 * @return The shared LayoutInflater.
	 */
	public LayoutInflater getInflater() {
		return inflater;
	}

	@Override
	public View getView(int row, int column, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(getLayoutResource(row, column), parent, false);
		}
		setText(convertView, getCellString(row, column));
		return convertView;
	}

	/**
	 * Sets the text to the view.
	 * 
	 * @param view
	 * @param text
	 */
	private void setText(View view, String text) {
		((TextView) view.findViewById(android.R.id.text1)).setText(text);
	}

	/**
	 * @param row
	 *            the title of the row of this header. If the column is -1
	 *            returns the title of the row header.
	 * @param column
	 *            the title of the column of this header. If the column is -1
	 *            returns the title of the column header.
	 * @return the string for the cell [row, column]
	 */
	public abstract String getCellString(int row, int column);

	public abstract int getLayoutResource(int row, int column);
}
