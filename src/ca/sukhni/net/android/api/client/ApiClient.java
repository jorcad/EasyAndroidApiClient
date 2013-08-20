package ca.sukhni.net.android.api.client;

interface ApiClientInterfacer
{
	public abstract void executeAndBlock();
	public abstract void executeOnThread(ApiClientHandler handler);
	public abstract void executeOnAsyncTask(ApiClientHandler handler);
}
public class ApiClient extends RestClient implements ApiClientInterfacer
{

	@Override
	public void executeAndBlock()
	{
		
	}

	@Override
	public void executeOnThread(ApiClientHandler handler)
	{
		
	}

	@Override
	public void executeOnAsyncTask(ApiClientHandler handler)
	{
		
	}
	
}
