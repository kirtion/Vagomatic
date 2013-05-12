package es.kirtisoft.vagomatic;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class OptionsActivity extends ListActivity
{
	//Application Life
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options_activity_view);
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		/*list_item_one = getString(R.string.list_item_one);
		list_item_two = getString(R.string.list_item_two);
		list_item_three = getString(R.string.list_item_three);
		listado = new String[] {list_item_one, list_item_two, list_item_three};
		ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listado);
		setListAdapter(adapter);*/
		ArrayList<ChargeAdapter> chAdapter = new ArrayList<ChargeAdapter>();
		String name = getString(R.string.list_item_one);
		String description = getString(R.string.description__list_item_one);
		chAdapter.add(new ChargeAdapter(name, description, R.drawable.power));
		name = getString(R.string.list_item_two);
		description = getString(R.string.description__list_item_two);
		chAdapter.add(new ChargeAdapter(name, description, R.drawable.mouse));
		name = getString(R.string.list_item_three);
		description = getString(R.string.description__list_item_three);
		chAdapter.add(new ChargeAdapter(name, description, R.drawable.screen));
		DiferentAdapters adapter = new DiferentAdapters(OptionsActivity.this, chAdapter);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
	}
	
	//Main Methods
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);
		Intent intent = null;
		switch(position) 
		{
			case 0:
				intent = new Intent(this, PowerOff.class);
				break;
			case 1:
				
				break;
			case 2:
				
				break;
		}
		startActivity(intent);
	}
}
