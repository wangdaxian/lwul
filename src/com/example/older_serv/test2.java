package com.example.older_serv;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;






import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import junit.framework.TestCase;

public class test2 extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}
	
	
	public void test() {
		
		 List<NameValuePair> parameters = new ArrayList<NameValuePair>();

		    BasicNameValuePair  things = new BasicNameValuePair("orthings","eee") ;


		    
		    BasicNameValuePair fee_p = new BasicNameValuePair("ortil", "20");

		    
		    parameters.add(things);


		    parameters.add(fee_p);
		assertTrue(new up_data().send("http://1.sitetest.sinaapp.com/create_order.php", parameters).equals(null)); 
		fail("Not yet implemented");
	}

}
