package Applications;

import com.google.gson.JsonObject;
import WebUtils.RequestCreator;

public class Example
{
	public static void main(String args[])
	{
		RequestCreator r = new RequestCreator("na1.api.riotgames.com");
		r.addFile("/lol/summoner/v3/summoners/by-name/Nathannnn");
		r.addParameter("api_key", "RGAPI-94776f13-fea0-4cfc-8065-8977fc05cff9");
		
		r.openGetconnection();
		JsonObject j = r.readJsonContent();
		System.out.println(j.toString());
	}
}
