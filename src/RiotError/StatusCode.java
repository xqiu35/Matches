package RiotError;

import java.util.HashMap;

public class StatusCode
{
	private static StatusCode statusCode = new StatusCode();
	
	private HashMap<Integer,String> map;
	
	private StatusCode()
	{
		map = new HashMap<>();
		map.put(200, "SUCCESS_OK");
		map.put(204, "SUCCESS_NO_CONTENT");
		map.put(400, "ERROR_BAD_REQUEST");
		map.put(401, "ERROR_UNAUTHORIZED");
		map.put(403, "ERROR_FORBIDDEN");
		map.put(404, "ERROR_NOT_FOUND");
		map.put(405, "ERROR_METHOD_NOT_ALLOWED");
		map.put(415, "ERROR_UNSUPPORTED_MEDIA_TYPE");
		map.put(422, "ERROR_UNPROCESSABLE_ENTITY");
		map.put(429, "ERROR_RATE_LIMITED");
		map.put(500, "ERROR_SERVER_ERROR");
		map.put(502, "ERROR_BAD_GATEWAY");
		map.put(503, "ERROR_SERVICE_UNAVAILABLE");
		map.put(504, "ERROR_GATEWAY_TIMEOUT");
	}
	
	public static String getCodeDesc(int code)
	{
		if(statusCode==null)
		{
			statusCode = new StatusCode();
		}
		return statusCode.map.get(code);
	}
	
	public static final int SUCCESS_OK = 200;
	public static final int SUCCESS_NO_CONTENT = 204;
	public static final int ERROR_BAD_REQUEST = 400;
	public static final int ERROR_UNAUTHORIZED = 401;
	public static final int ERROR_FORBIDDEN = 403;
	public static final int ERROR_NOT_FOUND = 404;
	public static final int ERROR_METHOD_NOT_ALLOWED = 405;
	public static final int ERROR_UNSUPPORTED_MEDIA_TYPE = 415;
	public static final int ERROR_UNPROCESSABLE_ENTITY = 422;
	public static final int ERROR_RATE_LIMITED = 429;
	public static final int ERROR_SERVER_ERROR = 500;
	public static final int ERROR_BAD_GATEWAY = 502;
	public static final int ERROR_SERVICE_UNAVAILABLE = 503;
	public static final int ERROR_GATEWAY_TIMEOUT = 504;
}
