package ca.sukhni.net.android.api.client;

import android.annotation.SuppressLint;
import android.os.AsyncTask;


public class ApiClient extends RestClient implements ApiClientInterface
{

	protected ApiClient()
	{
		super();
	}

	protected ApiClient(HttpRequest httpRequest, int connectionTimeout, int socketTimeout)
	{
		super(httpRequest, connectionTimeout, socketTimeout);
	}

	protected ApiClient(HttpRequest httpRequest)
	{
		super(httpRequest);
	}

	private ExecuterTask executerTask = null; 
	@Override
	public void executeAndBlock(ApiClientHandler handler)
	{
		try
		{
			HttpResponseResult result = this.execute();
			if(result!=null)
			{
				int responseCode = result.getResponseCode();
				if(responseCode>=100 && responseCode<200)
				{
					handler.onInformational(responseCode, result.getResponseStatusLine(), result);
				}
				else if(responseCode>=200 && responseCode<300)
				{
					handler.onSuccessful(responseCode, result.getResponseStatusLine(), result);
				}
				else if(responseCode>=300 && responseCode<400)
				{
					handler.onRedirection(responseCode, result.getResponseStatusLine(), result);
				}
				else if(responseCode>=400 && responseCode<500)
				{
					handler.onClientError(responseCode, result.getResponseStatusLine(), result);
				}
				else if(responseCode>=500)
				{
					handler.onServerError(responseCode, result.getResponseStatusLine(), result);
				}
			}
			else
			{
				handler.onException(new NullPointerException());
			}
		}
		catch (Exception e)
		{
			handler.onException(e);
		}
	}

	@Override
	public void executeOnThread(final ApiClientHandler handler)
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				executeAndBlock(handler);
			}
			
		}).start();
	}

	@SuppressLint("NewApi")
	@Override
	public void executeOnAsyncTask(ApiClientHandler handler)
	{
		if (android.os.Build.VERSION.SDK_INT >= 11)
		{
			executerTask = new ExecuterTask(handler);
			executerTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void) null);
		}
		else
		{
			executerTask = new ExecuterTask(handler);
			executerTask.execute();
		}
		
	}

	@Override
	public void cancelAsyncTask()
	{
		cancelAsyncTask(true);
	}
	
	@Override
	public void cancelAsyncTask(boolean mayInterruptIfRunning)
	{
		if(executerTask!=null) 
			executerTask.cancel(mayInterruptIfRunning);
	}
	
	private class ExecuterTask extends AsyncTask<Void, Void, HttpResponseResult>
	{

		private ApiClientHandler handler = null;
		private Exception exception = null;
		public ExecuterTask(ApiClientHandler handler)
		{
			this.handler = handler;
		}
		@Override
		protected HttpResponseResult doInBackground(Void... arg0)
		{
			try
			{
				return ApiClient.this.execute();
			}
			catch (Exception e)
			{
				this.exception = new Exception(e);
				return null;
			}
		}

		@Override
		protected void onPostExecute(HttpResponseResult result)
		{
			if(result!=null)
			{
				int responseCode = result.getResponseCode();
				if(responseCode>=100 && responseCode<200)
				{
					handler.onInformational(responseCode, result.getResponseStatusLine(), result);
				}
				else if(responseCode>=200 && responseCode<300)
				{
					handler.onSuccessful(responseCode, result.getResponseStatusLine(), result);
				}
				else if(responseCode>=300 && responseCode<400)
				{
					handler.onRedirection(responseCode, result.getResponseStatusLine(), result);
				}
				else if(responseCode>=400 && responseCode<500)
				{
					handler.onClientError(responseCode, result.getResponseStatusLine(), result);
				}
				else if(responseCode>=500)
				{
					handler.onServerError(responseCode, result.getResponseStatusLine(), result);
				}
			}
			else
			{
				if(exception!=null)
					handler.onException(exception);
				else 
					handler.onException(new NullPointerException());
			}
		}
	}
}