package ca.sukhni.net.android.api.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.UnresolvedAddressException;

import org.apache.http.ConnectionClosedException;
import org.apache.http.conn.ConnectTimeoutException;

import ca.sukhni.net.android.logger.Logger;
import android.os.AsyncTask;

public class ApiClient extends RestClient
{
	public void executeAndBlock() throws UnresolvedAddressException, NoRouteToHostException, ConnectTimeoutException, SocketTimeoutException, UnsupportedEncodingException, UnknownHostException, ConnectionClosedException, FileNotFoundException, IOException, Exception
	{
		execute();
	}

	public void executeOnThread(final ApiClientHandler handler)
	{
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				try
				{
					executeAndBlock();
					int responseCode = getResponseCode();
					if(handler!=null)
					{
						if(responseCode>=100 && responseCode<200)
						{
							handler.onInformational(Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
						}
						else if(responseCode>=200 && responseCode<300)
						{
							handler.onSuccessful(Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
						}
						else if(responseCode>=300 && responseCode<400)
						{
							handler.onClientError(Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
						}
						else if(responseCode>=500)
						{
							handler.onServerError(Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
						}
					}
				}
				catch (UnresolvedAddressException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.UNRESOLVED_ADDRESS_EXCEPTION, e);
					}
				}
				catch (NoRouteToHostException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.NO_ROUTE_TO_HOST_EXCEPTION, e);
					}
				}
				catch (ConnectTimeoutException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.CONNECT_TIMEOUT_EXCEPTION, e);
					}
				}
				catch (SocketTimeoutException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.SOCKET_TIMEOUT_EXCEPTION, e);
					}
				}
				catch (UnsupportedEncodingException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.UNSUPPORTED_ENCODING_EXCEPTION, e);
					}
				}
				catch (UnknownHostException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.UNKNOWN_HOST_EXCEPTION, e);
					}
				}
				catch (ConnectionClosedException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.CONNECTION_CLOSED_EXCEPTION, e);
					}
				}
				catch (FileNotFoundException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.FILE_NOT_FOUND_EXCEPTION, e);
					}
				}
				catch (IOException e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.IO_EXCEPTION, e);
					}
				}
				catch (Exception e)
				{
					Logger.printStackTrace(e);
					if(handler!=null)
					{
						handler.onException(ExceptionStatus.EXCEPTION, e);
					}
				}
				
			}
		}).start();
	}

	public void executeOnAsyncTask(ApiClientHandler handler)
	{
		new ExecuterTask(handler).execute();
	}
	
	private class ExecuterTask extends AsyncTask<Void, Void, Integer>
	{
		public final String EXECUTER_TASK_TAG = ExecuterTask.class.getSimpleName();
		private Exception exception = null;
		private ExceptionStatus exceptionStatus = null;
		private ApiClientHandler handler = null;
		public ExecuterTask(ApiClientHandler handler)
		{
			Logger.debug(EXECUTER_TASK_TAG + ": Constructor");
			this.handler = handler;
		}
		@Override
		protected Integer doInBackground(Void... params)
		{
			Logger.debug(TAG + ": Background");
			try
			{
				executeAndBlock();
				return getResponseCode();
			}
			catch (UnresolvedAddressException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.UNRESOLVED_ADDRESS_EXCEPTION;
			}
			catch (NoRouteToHostException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.NO_ROUTE_TO_HOST_EXCEPTION;
			}
			catch (ConnectTimeoutException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.CONNECT_TIMEOUT_EXCEPTION;
			}
			catch (SocketTimeoutException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.SOCKET_TIMEOUT_EXCEPTION;
			}
			catch (UnsupportedEncodingException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.UNSUPPORTED_ENCODING_EXCEPTION;
			}
			catch (UnknownHostException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.UNKNOWN_HOST_EXCEPTION;
			}
			catch (ConnectionClosedException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.CONNECTION_CLOSED_EXCEPTION;
			}
			catch (FileNotFoundException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.FILE_NOT_FOUND_EXCEPTION;
			}
			catch (IOException e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.IO_EXCEPTION;
			}
			catch (Exception e)
			{
				Logger.printStackTrace(e);
				exception = e;
				exceptionStatus = ExceptionStatus.EXCEPTION;
			}
			return null;
		}

		@Override
		protected void onPostExecute(Integer result)
		{
			Logger.debug(TAG + ": PostExecute");
			if(handler!=null)
			{
				if(result!=null)
				{
					int responseCode = result.intValue();
					if(responseCode>=100 && responseCode<200)
					{
						handler.onInformational(ca.sukhni.net.android.api.client.Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
					}
					else if(responseCode>=200 && responseCode<300)
					{
						handler.onSuccessful(ca.sukhni.net.android.api.client.Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
					}
					else if(responseCode>=300 && responseCode<400)
					{
						handler.onRedirection(ca.sukhni.net.android.api.client.Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
					}
					else if(responseCode>=400 && responseCode<500)
					{
						handler.onClientError(ca.sukhni.net.android.api.client.Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
					}
					else if(responseCode>=500)
					{
						handler.onServerError(ca.sukhni.net.android.api.client.Status.fromStatusCode(responseCode), getResponseStatusLine(), getResponseEntity());
					}
				}
				else
				{
					handler.onException(exceptionStatus, exception);
				}
			}
		}

		
	}
}
