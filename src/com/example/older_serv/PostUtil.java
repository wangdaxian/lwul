package com.example.older_serv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;


public class PostUtil {
	
	
	public static Void sendHttpRequst(String apiUrl) {
		
		   HttpURLConnection conn = null;
		    InputStream is = null;
		    
		    try {
		        URL url = new URL(apiUrl);
		        conn = (HttpURLConnection) url.openConnection();
		        conn.connect();
		        is = conn.getInputStream();
		        
		   } catch (MalformedURLException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		           
		           if (is != null) is.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        if (conn != null) conn.disconnect();
		    }
		    return null;
		}

			

	public static String sendPost(String url,String params)
	{
		PrintWriter out=null;
		BufferedReader in = null;
		String result = "";
		try{
			URL realUrl= new URL(url);
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
		 
			System.out.println("����POST��������쳣"+e);
			e.printStackTrace();
		    }
		finally
		{
			try
			{if(in!=null)
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

/*public static String sendPostMessage(Map<String, String> params,  
            String encode) {  
        StringBuilder stringBuilder = new StringBuilder();  
        if (params != null && !params.isEmpty()) {  
            for (Map.Entry<String, String> entry : params.entrySet()) {  
                try {  
                    stringBuilder  
                            .append(entry.getKey())  
                            .append("=")  
                            .append(URLEncoder.encode(entry.getValue(), encode))  
                            .append("&");  
                } catch (UnsupportedEncodingException e) {  
                    e.printStackTrace();  
                }  
            }  
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);  
            try {  
                HttpURLConnection urlConnection = (HttpURLConnection) url  
                        .openConnection();  
                urlConnection.setConnectTimeout(3000);  
                urlConnection.setRequestMethod("POST"); // ��post����ʽ�ύ  
                urlConnection.setDoInput(true); // ��ȡ����  
                urlConnection.setDoOutput(true); // �������д����  
                // ��ȡ�ϴ���Ϣ�Ĵ�С�ͳ���  
                byte[] myData = stringBuilder.toString().getBytes();  
                // ������������������ı�����,��ʾ��ǰ�ύ�����ı�����  
                urlConnection.setRequestProperty("Content-Type",  
                        "application/x-www-form-urlencoded");  
                urlConnection.setRequestProperty("Content-Length",  
                        String.valueOf(myData.length));  
                // ������������������������  
                OutputStream outputStream = urlConnection.getOutputStream();  
                // д������  
                outputStream.write(myData, 0, myData.length);  
                outputStream.close();  
                // ��÷�������Ӧ�����״̬��  
                int responseCode = urlConnection.getResponseCode();  
                if (responseCode == 200) {  
                    // ȡ����Ӧ�Ľ��  
                    return changeInputStream(urlConnection.getInputStream(),  
                            encode);  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
  
        }  
        return "";  
    }  
  

*/



public static void sendpostexecute(String urlStr,  Map<String, Object> params, String encode){


OutputStream outputStream = null;
HttpURLConnection urlConnection = null;
try {
StringBuffer param = new StringBuffer("");
byte[] myData = null;
if(params == null){
myData = param.toString().getBytes();


}
else{
for(String key : params.keySet()){
param.append("&").append(key).append("=")
  .append("param".equals(key) ? params.get(key) : URLEncoder.encode((String) params.get(key), encode));
}
param.deleteCharAt(0);
myData = param.toString().getBytes();
}

URL url = new URL(urlStr);
//if(getAPNType(Config.getAppContext()) == CMWAP){
//      Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress("10.0.0.172", 80));
//      urlConnection = (HttpURLConnection) url.openConnection(proxy);
//}else{
urlConnection = (HttpURLConnection) url.openConnection();
//}
urlConnection.setConnectTimeout(2000);
urlConnection.setReadTimeout(3000);

urlConnection.setRequestMethod("POST");

urlConnection.setDoInput(true); // ��ȡ����
urlConnection.setDoOutput(true); // �������д����

// ������������������ı�����,��ʾ��ǰ�ύ�����ı�����
urlConnection.setRequestProperty("Content-Type",
"application/x-www-form-urlencoded");
urlConnection.setRequestProperty("Content-Length",
String.valueOf(myData.length));




// ������������������������
outputStream = urlConnection.getOutputStream();
// д������
outputStream.write(myData, 0, myData.length);


outputStream.close(); 


// ��÷�������Ӧ�����״̬��
int responseCode = urlConnection.getResponseCode();






} catch (Exception e) {
e.printStackTrace();

}


}

	}
	

