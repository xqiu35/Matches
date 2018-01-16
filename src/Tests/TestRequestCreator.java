package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import WebUtils.RequestCreator;

class TestRequestCreator {

	@Test
	void test() {
		RequestCreator r = new RequestCreator("na1.api.riotgames.com");
		r.addFile("/lol/summoner/v3/summoners/by-name/RiotSchmick");
		r.addParameter("api_key", "RGAPI-94776f13-fea0-4cfc-8065-8977fc05cff9");
	
		String actual = "https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/RiotSchmick?api_key=RGAPI-94776f13-fea0-4cfc-8065-8977fc05cff9";
		
		assertEquals(r.getUrlString(), actual);
		System.out.println("Pass");
	}

}
