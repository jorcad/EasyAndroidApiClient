package ca.sukhni.net.android.api.client;

public class ApiClientBuilder
{
	private HttpRequest httpRequest;
	private ApiClient apiClient;
	public ApiClientBuilder()
	{
		httpRequest = new HttpRequest();
		apiClient = new ApiClient();
	}
	
	public ApiClient build()
	{
		ApiClient client = new ApiClient(httpRequest, apiClient.getConnectionTimeout(), apiClient.getSocketTimeout());
		return client;
	}
	
	public ApiClientBuilder setBaseUri(String baseUri)
	{
		httpRequest.setBaseUri(baseUri);
		return this;
	}
	
	public ApiClientBuilder setHttpMethod(HttpMethod method)
	{
		httpRequest.setHttpMethod(method);
		return this;
	}
	
	public ApiClientBuilder setCharSetType(String charSetType)
	{
		httpRequest.setCharSetType(charSetType);
		return this;
	}
	
	public ApiClientBuilder setContentType(String contentType)
	{
		httpRequest.setContentType(contentType);
		return this;
	}
	
	public ApiClientBuilder addParam(String key,String value)
	{
		httpRequest.addParam(key, value);
		return this;
	}
	
	public ApiClientBuilder addHeader(String key,String value)
	{
		httpRequest.addHeader(key, value);
		return this;
	}
	
	public ApiClientBuilder addPath(String... paths)
	{
		httpRequest.addPath(paths);
		return this;
	}
	
	public ApiClientBuilder setSocketTimeout(int socketTimeout)
	{
		apiClient.setSocketTimeout(socketTimeout);
		return this;
	}
	
	public ApiClientBuilder setConnectionTimeout(int connectionTimeout)
	{
		apiClient.setConnectionTimeout(connectionTimeout);
		return this;
	}
	
	public ApiClientBuilder setRequestBody(byte[] requestBody)
	{
		httpRequest.setRequestBody(requestBody);
		return this;
	}
	
	public ApiClientBuilder setRequestBody(String requestBody)
	{
		byte[] body = null;
		try
		{
			body = requestBody.getBytes(httpRequest.getCharSetType());
		}
		catch(Exception ex)
		{
			body = requestBody.getBytes();
		}
		httpRequest.setRequestBody(body);
		return this;
	}
}
