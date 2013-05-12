package es.kirtisoft.vagomatic;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Sender 
{
	private PrintWriter out;
	
	public Sender(Socket sk)
	{
		try {
			out = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()));
		} catch (IOException e) {
			
		}
	}
	
	public void send(String s)
	{
		out.println(s);
	}
}
