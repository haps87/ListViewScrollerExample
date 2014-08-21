package com.testing.searchinlist;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

@SuppressLint("DefaultLocale")
public class MainActivity extends Activity {


	List<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_main);

		String[] exp = { "Abc", "Bcd", "Cde", "Def", "Efg", "Fgh", "Ghi",
				"Hij", "Ijk", "Jkl", "Klm", "Lmn", "Mno", "Nop", "Opq", "Pqr",
				"Qrs", "Rst", "Stv", "Tvx" };

		for (int i = 0; i < exp.length; i++) {

			for (int x = 0; x < 5; x++)
				list.add(exp[i]);
		}

		EditText search = (EditText) findViewById(R.id.search);
		final ListView listView = (ListView) findViewById(R.id.list);
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(), android.R.layout.simple_dropdown_item_1line,
				list);
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();

		search.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// adapter.getFilter().filter(s);

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).toLowerCase()
							.contains(s.toString().toLowerCase())) {
						listView.setSelection(i);
						break;

					} else {
						listView.setSelection(0);
					}

				}

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start,
					int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable text) {

			}
		});
	}
}
