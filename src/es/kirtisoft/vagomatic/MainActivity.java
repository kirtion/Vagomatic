package es.kirtisoft.vagomatic;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener
{
	private Button btn_servers_list, btn_idni1, btn_idni2, btn_connect;
	private EditText et_ip, et_port;
	private TextView tv_log;
	private boolean isConnected;
	private String ip, port, errorConnection, errorGettingValues;
	private int iPort;
	private Socket socket = null;
	
	//Application Life
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		chargeComponents();
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
		isConnected = false;
	}
	
	//Main Methods
	private void chargeComponents()
	{
		tv_log = (TextView) findViewById(R.id.tv_log);
		et_ip = (EditText) findViewById(R.id.et_ip);
		et_port = (EditText) findViewById(R.id.et_port);
		btn_servers_list = (Button) findViewById(R.id.btn_list_servers);
		btn_idni1 = (Button) findViewById(R.id.idnwbi1);
		btn_idni2 = (Button) findViewById(R.id.idnwbi2);
		btn_connect = (Button) findViewById(R.id.btn_connect);
		btn_servers_list.setOnClickListener(this);
		btn_idni1.setOnClickListener(this);
		btn_idni2.setOnClickListener(this);
		btn_connect.setOnClickListener(this);
	}
	
	private void getValues()
	{
		errorGettingValues = "";
		try {
			ip = et_ip.getText().toString();
			port = et_port.getText().toString();
			iPort = Integer.parseInt(port);
		} catch(Exception e) {
			errorGettingValues = e.getMessage();
		}
	}
	
	private void executeClient()
	{
		errorConnection = "";
		try {
			socket = new Socket(ip, iPort);
		} catch (UnknownHostException e) {
			errorConnection = e.getMessage();
		} catch (IOException e) {
			errorConnection = e.getMessage();
		}
	}
	
	private void log(String s)
	{
		tv_log.setText(s);
	}
	
	public Socket getSocket()
	{
		return socket;
	}
	
	//MenuOptions
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	//OnClickListener
	@Override
	public void onClick(View v) 
	{
		String s = null;
		
		if(v.equals(btn_servers_list))
		{
			s = "Servers List";
		}
		
		else if(v.equals(btn_idni1))
			s = "Idnwbii1";
		
		else if(v.equals(btn_idni2))
			s = "Idnwbii2";
		
		else if(v.equals(btn_connect))
		{
			new Connexion().execute();
		}
		
		log(s);
	}
	
	//Class Thread
	private class Connexion extends AsyncTask <Void, Void, Void>
	{
		private ProgressDialog pd = null;;
		
		@Override
		protected void onPreExecute()
		{
			pd = ProgressDialog.show(MainActivity.this, null, getString(R.string.waiting_message));
		}
		
		@Override
		protected Void doInBackground(Void... arg0) 
		{
			getValues();
			executeClient();
			return null;
		}
		
		@Override
		protected void onPostExecute(Void unused)
		{
			pd.dismiss();
			if(!errorGettingValues.equals(""))
				log(errorGettingValues);
			if(!errorConnection.equals(""))
				log(errorConnection);
			else
				isConnected = true;
			
			if(isConnected)
			{
				Intent intent = new Intent(getApplicationContext(), OptionsActivity.class);
				startActivity(intent);
				isConnected = false;
			}
		}
	}

}