package WebUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ParameterBuilder
{
	private HashMap<String, String> map;
	
	
	public ParameterBuilder()
	{
		map = new HashMap<String, String>();
	}
	
	
	public void addParameter(String key,String value)
	{
		map.put(key, value);
	}
	
	public void addParameter(HashMap<String,String> params)
	{
		map = params;
	}
	
	
	public String getParameterString()  
	{
		if(map==null || map.size()==0)
		{
			return "";
		}
		
        StringBuilder result = new StringBuilder();
 
        for (Map.Entry<String, String> entry : map.entrySet())
        {
          try {
			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          result.append("=");
          try {
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          result.append("&");
        }
 
        String resultString = "?" + result.toString();
        
        return resultString.length() > 0
          ? resultString.substring(0, resultString.length() - 1)
          : resultString;
	}
}
