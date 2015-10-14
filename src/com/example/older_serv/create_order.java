package com.example.older_serv;




import java.util.ArrayList;
import java.util.List;






import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;







import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class create_order extends Activity{
	
	EditText time_long,things,fee,location,memo;
	Button bt_submit;
	String orthings,ormemo,orlocation,orfee,ortil;
	HttpClient httpClient   ;
	
	//LiteHttp liteHttp = LiteHttp.newApacheHttpClient(null);
	
	String BASE_URL = "http://1.sitetest.sinaapp.com/create_order.php";
protected void onCreate(Bundle savedInstanceState) {
		
	
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_order);
		httpClient = new DefaultHttpClient();
		initVeiws();
		
		//url1 = BASE_URL+"create_order.php?"+"orthings="+orthings+"&"+"ortil="+ortil;
		//Log.i("u", url1);
		initListeners();
		
}

public void initVeiws(){
	
	
	time_long = (EditText) findViewById(R.id.editText_long);
	things = (EditText) findViewById(R.id.editText_things);
	fee = (EditText) findViewById(R.id.editText_fee);
	location = (EditText) findViewById(R.id.editText_location);
	memo = (EditText) findViewById(R.id.editText_memo);
	
	
	
}



public void initListeners() {
	// TODO Auto-generated method stub
	bt_submit = (Button) findViewById(R.id.button_submit);
	 bt_submit.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View v) {
				
				
				 new Thread(){  
			          public void run(){  
			        	
			      			
			      		   // Log.i("ss",params.toString());
			        	//sends(BASE_URL, params);
			      		  
			      			  try {
			      				List<NameValuePair> paramts=new ArrayList<NameValuePair>();
			      				 BasicNameValuePair pa1;
			      				BasicNameValuePair pa2;
			      				BasicNameValuePair pa3;
			      				BasicNameValuePair pa4;
			      				BasicNameValuePair pa5;
			      				
			      				orfee = fee.getText().toString();
			      				orthings = things.getText().toString();
			      				orlocation = location.getText().toString();
			      				ormemo = memo.getText().toString();
			      				ortil = time_long.getText().toString();
									
			      					//ress=ss.GetRequest("http://1.sitetest.sinaapp.com/create_order.php?orthings="
									//+ orthings + "&ortil=" + ortil);
			      				pa2= new BasicNameValuePair("orthings",orthings);
			      				pa1= new BasicNameValuePair("orfee",orfee);
			      				pa3= new BasicNameValuePair("orlocation",orlocation);
			      				pa4= new BasicNameValuePair("ormemo",ormemo);


			      			   pa5= new BasicNameValuePair("ortil", ortil);
			      			    paramts.add(pa1);
			      			    paramts.add(pa2);
			      			  paramts.add(pa3);
			      			    paramts.add(pa4);
			      			    paramts.add(pa5);
			      			 
			      		    	 HttpPost post = new HttpPost(BASE_URL);
			      		   post.setEntity(new UrlEncodedFormEntity(paramts,HTTP.UTF_8));
			      		   HttpResponse response = httpClient.execute(post);
			      		    // en = new UrlEncodedFormEntity(params,HTTP.UTF_8);
			      		     //request.setEntity(en);
			      		    // HttpResponse response = dhc.execute(request);
			      		    
			      		    
			      			    
			      			  Log.i("ss",paramts.toString());
			      			
			      					//ress=sendparam(paramts);
			      					//Log.i("ss",ress);
			      					if (response.getStatusLine().getStatusCode()==200) {
										Toast.makeText(create_order.this,
												"恭喜您成功,转入登录页面!", Toast.LENGTH_SHORT)
												.show();
										
										finish();
									}
			      					else{
			      						Toast.makeText(create_order.this,
												"增加订单失败!", Toast.LENGTH_SHORT)
												.show();
			      						 
			      					}
			      					
			      					//ss.httpclientsend(orthings, ortil);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			        	  
			        	 
			           }  
			        }.start();  

		
		
		
	}
});
				
			
}





}
