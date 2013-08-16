package ca.sukhni.net.android.api.client;

public abstract class BaseClient
{
	public static String		TAG								= BaseClient.class.getSimpleName();
	protected int  				mConnectionTimeout				= 2000;
	protected int 				mSocketTimeout					= 2000;
	protected int				mConnectionTimeoutRetry			= 0;
	protected int				mSocketTimeoutRetry				= 0;
	
	protected abstract void addParam(String name,String value);
	protected abstract void AddHeader(String name, String value);
	protected abstract void AddTextContent(String name, String value);
	
	public BaseClient()
	{
		TAG = this.getClass().getSimpleName();
	}

	/**
	 * @return the mConnectionTimeout
	 */
	public int getmConnectionTimeout()
	{
		return mConnectionTimeout;
	}

	/**
	 * @param mConnectionTimeout the mConnectionTimeout to set
	 */
	public void setmConnectionTimeout(int mConnectionTimeout)
	{
		this.mConnectionTimeout = mConnectionTimeout;
	}

	/**
	 * @return the mSocketTimeout
	 */
	public int getmSocketTimeout()
	{
		return mSocketTimeout;
	}

	/**
	 * @param mSocketTimeout the mSocketTimeout to set
	 */
	public void setmSocketTimeout(int mSocketTimeout)
	{
		this.mSocketTimeout = mSocketTimeout;
	}

	/**
	 * @return the mConnectionTimeoutRetry
	 */
	public int getmConnectionTimeoutRetry()
	{
		return mConnectionTimeoutRetry;
	}

	/**
	 * @param mConnectionTimeoutRetry the mConnectionTimeoutRetry to set
	 */
	public void setmConnectionTimeoutRetry(int mConnectionTimeoutRetry)
	{
		this.mConnectionTimeoutRetry = mConnectionTimeoutRetry;
	}

	/**
	 * @return the mSocketTimeoutRetry
	 */
	public int getmSocketTimeoutRetry()
	{
		return mSocketTimeoutRetry;
	}

	/**
	 * @param mSocketTimeoutRetry the mSocketTimeoutRetry to set
	 */
	public void setmSocketTimeoutRetry(int mSocketTimeoutRetry)
	{
		this.mSocketTimeoutRetry = mSocketTimeoutRetry;
	}
	
	
}
