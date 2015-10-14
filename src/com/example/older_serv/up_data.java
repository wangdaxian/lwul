package com.example.older_serv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class up_data {
	/*public void send() {
		
		String uriphp = null;
		String orthings = null;
		String fee = null;
		
	    HttpPost request = new HttpPost(uriphp);
	    List<NameValuePair> parameters = new ArrayList<NameValuePair>();

	    BasicNameValuePair  things = new BasicNameValuePair("orthings",orthings) ;


	    
	    BasicNameValuePair fee_p = new BasicNameValuePair("fee", fee);

	    
	    parameters.add(things);


	    parameters.add(fee_p);

	    
	    HttpEntity en;
	    try {
	     en = new UrlEncodedFormEntity(parameters,HTTP.UTF_8);
	     request.setEntity(en);
	    } catch (UnsupportedEncodingException e1) {
	     e1.printStackTrace();
	    }
	    DefaultHttpClient dhc = new DefaultHttpClient();
	    try {
	     HttpResponse response = dhc.execute(request);
	    } catch (Exception e) {
	     e.printStackTrace();
	    }
	     }
	*/
	public static String send(String urlStr, List<NameValuePair> params) {

        PrintWriter out = null;
        BufferedReader in = null;
        String result= "";
        try{
			URL realUrl= new URL(urlStr);
			URLConnection conn=realUrl.openConnection();
			conn.setRequestProperty("accept","*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 ");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out=new PrintWriter(conn.getOutputStream());
			out.print(params);
			out.flush();
			in=new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			  String line;
			  while ((line=in.readLine())!=null)
			  {result +="\n"+line;}}
		    catch (Exception e){
		 
			System.out.println("发送POST请求出现异常"+e);
			e.printStackTrace();
		    }
		finally
		{
			try
			{
				if (out != null)
				{
					out.close();
				}
				if(in!=null)
			{
				in.close();
			}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return result;	
			
		}
	  }


