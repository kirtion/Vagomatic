package es.kirtisoft.vagomatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver 
{
	private BufferedReader in;
	
	public Receiver(Socket sk)
	{
		try {
			in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		} catch (IOException e) {
			
		}
	}
	
	public void reveive()
	{
		try {
			in.readLine();
		} catch (IOException e) {
			
		}
	}
}
