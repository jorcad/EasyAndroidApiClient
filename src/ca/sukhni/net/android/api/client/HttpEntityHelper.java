package ca.sukhni.net.android.api.client;
import ca.sukhni.net.android.api.client.logger.Logger;


public class HttpEntityHelper
{
	/**
	 * read the response entity as string
	 * @param entity
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String readEntityAsString(org.apache.http.HttpEntity entity) throws IllegalStateException, java.io.IOException 
	{
		java.io.InputStream inputStream  = null;
		StringBuilder stringBuilder = new StringBuilder();
		try
		{
			inputStream = entity.getContent();
			java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
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
		catch(java.io.IOException ex)
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
	
	public static byte[] readEntity(org.apache.http.HttpEntity entity) throws java.io.IOException
	{
		java.io.InputStream is = null;
		try
		{
			is = entity.getContent();

			java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();

			int nRead;
			byte[] data = new byte[16384];

			while ((nRead = is.read(data, 0, data.length)) != -1)
			{
				buffer.write(data, 0, nRead);
			}

			buffer.flush();

			return buffer.toByteArray();
		}
		catch (IllegalStateException e)
		{
			throw e;
		}
		catch (java.io.IOException e)
		{
			throw e;
		}
	}
}
