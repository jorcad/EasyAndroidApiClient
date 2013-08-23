package ca.sukhni.net.android.api.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;

import ca.sukhni.net.android.logger.Logger;

public class HttpEntityHelper
{
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String readEntityAsString(HttpEntity entity) throws IllegalStateException, IOException 
	{
		InputStream inputStream  = null;
		StringBuilder stringBuilder = new StringBuilder();
		try
		{
			inputStream = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while((line = reader.readLine())!=null)
			{
				stringBuilder.append(line);
			}
		}
		catch(IllegalStateException ex)
		{
			throw ex;
		}
		catch(IOException ex)
		{
			throw ex;
		}
		finally
		{
			try
			{
				if(inputStream!=null) inputStream.close();
			}
			catch(Exception ex)
			{
				Logger.printStackTrace(ex);
			}
		}
		
		return stringBuilder.toString();
	}
}
