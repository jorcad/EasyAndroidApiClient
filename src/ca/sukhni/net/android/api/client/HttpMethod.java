package ca.sukhni.net.android.api.client;

public enum HttpMethod
{
    GET(1001), PUT(1002), POST(1003), DELETE(1004);
    
    private final int value;
    HttpMethod(int value)
    {
    	this.value = value;
    }
    /**
     * 
     * @param method if method name to exist then return GET by default
     * @return method
     */
    public static HttpMethod fromMethod(String method)
    {
    	for(HttpMethod m: HttpMethod.values())
    	{
    		if(m.name().equalsIgnoreCase(method)) return m;
    	}
    	return HttpMethod.GET;
    }
	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}
    
}
