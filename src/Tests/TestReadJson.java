package Tests;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonObject;

import WebUtils.RequestCreator;

class TestReadJson {

	@Test
	void test() {
		RequestCreator r = new RequestCreator("na1.api.riotgames.com");
		r.addFile("/lol/summoner/v3/summoners/by-name/RiotSchmick");
		r.addParameter("api_key", "RGAPI-94776f13-fea0-4cfc-8065-8977fc05cff9");
		
		r.openGetconnection();
		JsonObject j = r.readJsonContent();
		
		if(!j.isJsonNull())
		{
			System.out.println("Pass");
		}
	}

}
