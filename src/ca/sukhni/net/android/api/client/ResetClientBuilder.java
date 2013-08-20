package ca.sukhni.net.android.api.client;

interface BuilderInterface
{
	public ResetClientBuilder setMethod(Method method);
	public ResetClientBuilder setBaseUri(String baseUri);
	public ResetClientBuilder addParam(String name, String value);
	public ResetClientBuilder addHeader(String name, String value);
	public ResetClientBuilder addTextContent(String name, String value);
}
public class ResetClientBuilder implements BuilderInterface
{
	private RestClient resetClient;

	public ResetClientBuilder()
	{
		//resetClient = new RestClient();
	}
	@Override
	public ResetClientBuilder setMethod(Method method)
	{
		resetClient.setMethod(method);
		return this;
	}

	@Override
	public ResetClientBuilder setBaseUri(String baseUri)
	{
		resetClient.setBaseUri(baseUri);
		return this;
	}

	@Override
	public ResetClientBuilder addParam(String name, String value)
	{
		resetClient.addParam(name, value);
		return this;
	}

	@Override
	public ResetClientBuilder addHeader(String name, String value)
	{
		resetClient.addHeader(name, value);
		return this;
	}

	@Override
	public ResetClientBuilder addTextContent(String name, String value)
	{
		resetClient.addTextContent(name, value);
		return this;
	}
	
	public RestClient build()
	{
		return this.resetClient;
	}
}
