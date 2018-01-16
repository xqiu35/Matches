package WebUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import RiotError.StatusCode;

public class RequestCreator
{

	private String baseUrl;
	private String file;
	private URL url;
	private HttpURLConnection connection;
	private ParameterBuilder pbuilder;
	
	
	
	public RequestCreator()
	{
		pbuilder = new ParameterBuilder();
	}
	
	public RequestCreator(String baseUrl)
	{
		this.baseUrl = baseUrl;
		pbuilder = new ParameterBuilder();
	}
	
	public void addFile(String file)
	{
		this.file = file;
	}
	
	public void connect()
	{
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addParameter(String key, String value)
	{
		pbuilder.addParameter(key,value);
	}
	
	public void addParameter(HashMap<String,String> map)
	{
		pbuilder.addParameter(map);
	}
	
	public void openGetconnection()
	{
		try {
			url = new URL(getUrlString());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.setRequestProperty("Content-Type", "application/json");
	}
	
	public void openPostConnection()
	{
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUrlString()
	{
		return "https://"+baseUrl+file+pbuilder.getParameterString();
	}
	
	public int getReturnCode()
	{
		try {
			return connection.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public JsonObject readJsonContent()
	{
		int statusCode = getReturnCode();
		
		if(statusCode == StatusCode.SUCCESS_OK)
		{
			System.out.println("Status: " + StatusCode.getCodeDesc(statusCode));
			
			BufferedReader in=null;
			try {
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String inputLine=null;
			StringBuffer content = new StringBuffer();
			try {
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JsonParser parser = new JsonParser();
			JsonObject obj = (JsonObject)parser.parse(content.toString());
			return obj;
		}
		else
		{
			System.err.println(StatusCode.getCodeDesc(statusCode));
			return null;
		}
	}
}
