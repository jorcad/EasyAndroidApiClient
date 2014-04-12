package ca.sukhni.net.android.api.client;

public abstract class BaseClient
{
	public final static int DEFAULT_CONNECTION_TIME_OUT = 31000;
	public final static int DEFAULT_SOCKET_TIME_OUT = 31000;
	protected HttpRequest httpRequest;
	protected HttpResponseResult httpResponseResult;
	protected int connectionTimeout;
	protected int socketTimeout;
	
	public abstract HttpResponseResult execute() throws Exception;
	
	protected BaseClient()
	{
		this.connectionTimeout = DEFAULT_CONNECTION_TIME_OUT;
		this.socketTimeout = DEFAULT_SOCKET_TIME_OUT;
	}
	protected BaseClient(HttpRequest httpRequest)
	{
		this.httpRequest = httpRequest;
		this.connectionTimeout = DEFAULT_CONNECTION_TIME_OUT;
		this.socketTimeout = DEFAULT_SOCKET_TIME_OUT;
	}
	
	protected BaseClient(HttpRequest httpRequest, int connectionTimeout, int socketTimeout)
	{
		super();
		this.httpRequest = httpRequest;
		this.connectionTimeout = connectionTimeout;
		this.socketTimeout = socketTimeout;
	}
	
	/**
	 * @return the connectionTimeout
	 */
	public int getConnectionTimeout()
	{
		return connectionTimeout;
	}
	/**
	 * @param connectionTimeout the connectionTimeout to set
	 */
	public void setConnectionTimeout(int connectionTimeout)
	{
		this.connectionTimeout = connectionTimeout;
	}
	/**
	 * @return the socketTimeout
	 */
	public int getSocketTimeout()
	{
		return socketTimeout;
	}
	/**
	 * @param socketTimeout the socketTimeout to set
	 */
	public void setSocketTimeout(int socketTimeout)
	{
		this.socketTimeout = socketTimeout;
	}
	/**
	 * @return the httpRequest
	 */
	public HttpRequest getHttpRequest()
	{
		return httpRequest;
	}
}
