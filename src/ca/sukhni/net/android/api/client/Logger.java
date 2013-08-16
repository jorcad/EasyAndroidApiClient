package ca.sukhni.net.android.api.client;

import android.util.Log;

public class Logger
{
	private enum DebugMode
	{
		ON, OFF
	};

	private static DebugMode mode = DebugMode.ON;
	private static final String LOG_TAG = "AndroidApiClient";

	public static final String TAG = Logger.class.getSimpleName();

	final public static void debug(String msg)
	{
		debug(LOG_TAG, msg);
	}
	
	final public static void debug(String tag,String msg)
	{
		if (mode == DebugMode.ON)
			Log.d(tag, msg);
	}

	final public static void error(String msg)
	{
		error(LOG_TAG, msg);
	}
	
	final public static void error(String tag, String msg)
	{
		if (mode == DebugMode.ON)
			Log.e(tag, msg);
	}

	final public static void verbose(String msg)
	{
		verbose(LOG_TAG, msg);
	}
	
	final public static void verbose(String tag,String msg)
	{
		if (mode == DebugMode.ON)
			Log.v(tag, msg);
	}
	
	final public static void info(String msg)
	{
		info(LOG_TAG, msg);
	}
	
	final public static void info(String tag,String msg)
	{
		if (mode == DebugMode.ON)
			Log.i(tag, msg);
	}

	public static void printStackTrace(Exception ex)
	{
		if (mode == DebugMode.ON)
			ex.printStackTrace();
	}

	final public static void error(String msg, Throwable tr)
	{
		error(LOG_TAG, msg, tr);
	}
	
	final public static void error(String tag,String msg, Throwable tr)
	{
		if (mode == DebugMode.ON)
			Log.e(tag, msg, tr);
	}

}
