package com.example.older_serv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;













import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class mytools {
	
	/**
	 * 向api发送get请求，url需按照api要求写，返回从服务器取得的信息。
	 * 
	 * @param url
	 * @return String
	 */
	protected String GetRequest(String url) throws Exception {
		return getRequest(url, new DefaultHttpClient(new BasicHttpParams()));
	}

	protected String getRequest(String url, DefaultHttpClient client)
			throws Exception {
		String result = null;
		int statusCode = 0;
		HttpGet getMethod = new HttpGet(url);
		try {
			getMethod.setHeader("User-Agent", "Mozilla/4.5");
			HttpResponse httpResponse = client.execute(getMethod);
			statusCode = httpResponse.getStatusLine().getStatusCode();
			result = retrieveInputStream(httpResponse.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getMethod.abort();
		}
		return result;
	}
	
	protected String retrieveInputStream(HttpEntity httpEntity) {
		Long l = httpEntity.getContentLength();
		int length = (int) httpEntity.getContentLength();
		if (length < 0)
			length = 10000;
		StringBuffer stringBuffer = new StringBuffer(length);
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(
					httpEntity.getContent(), HTTP.UTF_8);
			char buffer[] = new char[length];
			int count;
			while ((count = inputStreamReader.read(buffer, 0, length - 1)) > 0) {
				stringBuffer.append(buffer, 0, count);
			}
		} catch (UnsupportedEncodingException e) {
		} catch (IllegalStateException e) {
		} catch (IOException e) {
		}
		return stringBuffer.toString();
	}
	
	// 通过url发送post请求，返回请求结果

		
	
	
	/**
	 * 判断手机号码*/
	public static boolean isMobileNO(String mobiles){
		
		Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
		Matcher matcher = pattern.matcher(mobiles);  
		
		return matcher.matches();
		
	}
	
	
	 public ArrayList<String> inputStreamtovaluelist(InputStream in, String MonthsName) throws IOException {  
	        StringBuffer out = new StringBuffer();  
	        String s1 = "";  
	        byte[] b = new byte[4096];  
	        ArrayList<String> Values = new ArrayList<String>();  
	        Values.clear();  
	  
	        for (int n; (n = in.read(b)) != -1;) {  
	            s1 = new String(b, 0, n);  
	            out.append(s1);  
	        }  
	        String[] s13 = s1.split("><");  
	        String ifString = MonthsName + "Result";  
	        String TS = "";  
	        String vs = "";  
	  
	        Boolean getValueBoolean = false;  
	        for (int i = 0; i < s13.length; i++) {  
	            TS = s13[i];  
	            int j, k, l;  
	            j = TS.indexOf(ifString);  
	            k = TS.lastIndexOf(ifString);  
	  
	            if (j >= 0) {  
	                if (getValueBoolean == false) {  
	                    getValueBoolean = true;  
	                } else {  
	  
	                }  
	  
	                if ((j >= 0) && (k > j)) {  
	                    l = ifString.length() + 1;  
	                    vs = TS.substring(j + l, k - 2);  
	                    Values.add(vs);  
	                    System.out.println("退出" + vs);  
	                    getValueBoolean = false;  
	                    return Values;  
	                }  
	  
	            }  
	            if (TS.lastIndexOf("/" + ifString) >= 0) {  
	                getValueBoolean = false;  
	                return Values;  
	            }  
	            if ((getValueBoolean) && (TS.lastIndexOf("/" + ifString) < 0) && (j < 0)) {  
	                k = TS.length();  
	                vs = TS.substring(7, k - 8);  
	                Values.add(vs);  
	            }  
	  
	        }  
	  
	        return Values;  
	    }  

}
