package ca.sukhni.net.android.api.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.UnresolvedAddressException;

import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpEntity;
import org.apache.http.conn.ConnectTimeoutException;

public abstract class BaseClient
{
	public static String		TAG									= BaseClient.class.getSimpleName();
	protected int  				mConnectionTimeout					= 2000;
	protected int 				mSocketTimeout						= 2000;
	protected boolean			mEnableConntectionTimeoutRetry		= true;
	protected boolean			mEnableSocketTimeoutRetry			= true;
	protected int				mConnectionTimeoutRetry				= 0;
	protected int				mSocketTimeoutRetry					= 0;
	
	protected abstract void addParam(String name,String value);
	protected abstract void addHeader(String name, String value);
	protected abstract void addTextContent(String name, String value);
	protected abstract void execute(Method method) throws UnsupportedEncodingException,UnresolvedAddressException,UnknownHostException,
	NoRouteToHostException,ConnectTimeoutException,SocketTimeoutException,ConnectionClosedException,FileNotFoundException,IOException,Exception;
	
	protected abstract void execute() throws UnsupportedEncodingException,UnresolvedAddressException,UnknownHostException,
	NoRouteToHostException,ConnectTimeoutException,SocketTimeoutException,ConnectionClosedException,FileNotFoundException,IOException,Exception;
	
	protected abstract Integer getResponseCode();
	protected abstract String getResponseStatusLine();
	protected abstract HttpEntity getResponseEntity();
	protected abstract InputStream getReponseContent() throws IllegalStateException, IOException;
	/**
	 * this function will read the response content every time you call it, NOTE: DATA IS NOT CACHED
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	protected abstract String getResponseContentAsString() throws IllegalStateException, IOException;
	/**
	 * if no response or null, then return -1
	 * @return
	 */
	protected abstract long getResponseContentLength();
	
	public BaseClient()
	{
		TAG = this.getClass().getSimpleName();
	}

	/**
	 * @return the mConnectionTimeout
	 */
	public int getConnectionTimeout()
	{
		return mConnectionTimeout;
	}

	/**
	 * @param mConnectionTimeout the mConnectionTimeout to set
	 */
	public void setConnectionTimeout(int connectionTimeout)
	{
		this.mConnectionTimeout = connectionTimeout;
	}

	/**
	 * @return the mSocketTimeout
	 */
	public int getSocketTimeout()
	{
		return mSocketTimeout;
	}

	/**
	 * @param mSocketTimeout the mSocketTimeout to set
	 */
	public void setSocketTimeout(int socketTimeout)
	{
		this.mSocketTimeout = socketTimeout;
	}

	/**
	 * @return the mConnectionTimeoutRetry
	 */
	public int getConnectionTimeoutRetry()
	{
		return mConnectionTimeoutRetry;
	}

	/**
	 * @param mConnectionTimeoutRetry the mConnectionTimeoutRetry to set
	 */
	public void setConnectionTimeoutRetry(int connectionTimeoutRetry)
	{
		this.mConnectionTimeoutRetry = connectionTimeoutRetry;
	}

	/**
	 * @return the mSocketTimeoutRetry
	 */
	public int getSocketTimeoutRetry()
	{
		return mSocketTimeoutRetry;
	}

	/**
	 * @param mSocketTimeoutRetry the mSocketTimeoutRetry to set
	 */
	public void setSocketTimeoutRetry(int socketTimeoutRetry)
	{
		this.mSocketTimeoutRetry = socketTimeoutRetry;
	}
	
	/**
	 * @return the mEnableConntectionTimeoutRetry
	 */
	public boolean isConntectionTimeoutRetryEnabled()
	{
		return mEnableConntectionTimeoutRetry;
	}
	
	/**
	 * @param mEnableConntectionTimeoutRetry the mEnableConntectionTimeoutRetry to set
	 */
	public void setEnableConntectionTimeoutRetry(boolean enableConntectionTimeoutRetry)
	{
		this.mEnableConntectionTimeoutRetry = enableConntectionTimeoutRetry;
	}
	
	/**
	 * @return the mEnableSocketTimeoutRetry
	 */
	public boolean isESocketTimeoutRetrynabled()
	{
		return mEnableSocketTimeoutRetry;
	}
	
	/**
	 * @param mEnableSocketTimeoutRetry the mEnableSocketTimeoutRetry to set
	 */
	public void setEnableSocketTimeoutRetry(boolean enableSocketTimeoutRetry)
	{
		this.mEnableSocketTimeoutRetry = enableSocketTimeoutRetry;
	}
	
	
}
