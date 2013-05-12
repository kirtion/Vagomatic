package es.kirtisoft.vagomatic;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DiferentAdapters extends BaseAdapter
{
	private ArrayList<ChargeAdapter> chargeAdapter;
	private LayoutInflater mInflater;
	
	public DiferentAdapters(Context context, ArrayList<ChargeAdapter> adapter)
	{
		mInflater = LayoutInflater.from(context);
		chargeAdapter = adapter;
	}

	//BaseAdapter Methods
	@Override
	public int getCount() 
	{
		return chargeAdapter.size();
	}

	@Override
	public ChargeAdapter getItem(int position) 
	{
		return chargeAdapter.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ViewHolder holder = null;
		if(convertView == null)
		{
			convertView = mInflater.inflate(R.layout.lista_version_item, null);
			holder = new ViewHolder();
			holder.hName = (TextView) convertView.findViewById(R.id.idName);
			holder.hDescript = (TextView) convertView.findViewById(R.id.idDescription);
			holder.hImage = (ImageView) convertView.findViewById(R.id.idLogo);
			convertView.setTag(holder);
		}
		else
			holder = (ViewHolder) convertView.getTag();
		
		ChargeAdapter chAdapt= getItem(position);
		holder.hName.setText(chAdapt.getName());
		holder.hDescript.setText(chAdapt.getDesiption());
		holder.hImage.setImageResource(chAdapt.getLogo());
		return convertView;
	}
	
	private class ViewHolder
	{
		TextView hName;
		TextView hDescript;
		ImageView hImage;
	}

}
