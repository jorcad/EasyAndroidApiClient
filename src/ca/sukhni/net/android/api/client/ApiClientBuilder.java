package ca.sukhni.net.android.api.client;

interface BuilderInterface
{
	public abstract ApiClientBuilder setMethod(Method method);
	public abstract ApiClientBuilder setBaseUri(String baseUri);
	public abstract ApiClientBuilder setConnectionTimeout(int connectionTimeout);
	public abstract ApiClientBuilder setSocketTimeout(int socketTimeout);
	public abstract ApiClientBuilder setConnectionTimeoutRetry(int connectionTimeoutRetry);
	public abstract ApiClientBuilder setSocketTimeoutRetry(int socketTimeoutRetry);
	public abstract ApiClientBuilder setEnableConntectionTimeoutRetry(boolean enableConntectionTimeoutRetry);
	public abstract ApiClientBuilder setEnableSocketTimeoutRetry(boolean enableSocketTimeoutRetry);
	public abstract ApiClientBuilder addPath(String path);
	public abstract ApiClientBuilder addPaths(String paths);
	public abstract ApiClientBuilder addParam(String name, String value);
	public abstract ApiClientBuilder addHeader(String name, String value);
	public abstract ApiClientBuilder addTextContent(String name, String value);
	
	public ApiClient build();
	
}
public class ApiClientBuilder implements BuilderInterface
{
	private ApiClient apiClient;

	public ApiClientBuilder()
	{
		apiClient = new ApiClient();
	}
	@Override
	public ApiClientBuilder setMethod(Method method)
	{
		apiClient.setMethod(method);
		return this;
	}

	@Override
	public ApiClientBuilder setBaseUri(String baseUri)
	{
		apiClient.setBaseUri(baseUri);
		return this;
	}

	@Override
	public ApiClientBuilder addParam(String name, String value)
	{
		apiClient.addParam(name, value);
		return this;
	}

	@Override
	public ApiClientBuilder addHeader(String name, String value)
	{
		apiClient.addHeader(name, value);
		return this;
	}

	@Override
	public ApiClientBuilder addTextContent(String name, String value)
	{
		apiClient.addTextContent(name, value);
		return this;
	}
	@Override
	public ApiClient build()
	{
		return apiClient;
	}
	@Override
	public ApiClientBuilder setConnectionTimeout(int connectionTimeout)
	{
		apiClient.setConnectionTimeout(connectionTimeout);
		return this;
	}
	@Override
	public ApiClientBuilder setSocketTimeout(int socketTimeout)
	{
		apiClient.setSocketTimeout(socketTimeout);
		return this;
	}
	@Override
	public ApiClientBuilder setConnectionTimeoutRetry(int connectionTimeoutRetry)
	{
		apiClient.setConnectionTimeoutRetry(connectionTimeoutRetry);
		return this;
	}
	@Override
	public ApiClientBuilder setSocketTimeoutRetry(int socketTimeoutRetry)
	{
		apiClient.setSocketTimeoutRetry(socketTimeoutRetry);
		return this;
	}
	@Override
	public ApiClientBuilder setEnableConntectionTimeoutRetry(boolean enableConntectionTimeoutRetry)
	{
		apiClient.setEnableConntectionTimeoutRetry(enableConntectionTimeoutRetry);
		return this;
	}
	@Override
	public ApiClientBuilder setEnableSocketTimeoutRetry(boolean enableSocketTimeoutRetry)
	{
		apiClient.setEnableSocketTimeoutRetry(enableSocketTimeoutRetry);
		return this;
	}
	@Override
	public ApiClientBuilder addPath(String path)
	{
		apiClient.addPath(path);
		return this;
	}
	@Override
	public ApiClientBuilder addPaths(String paths)
	{
		apiClient.addPaths(paths);
		return this;
	}
	
}
