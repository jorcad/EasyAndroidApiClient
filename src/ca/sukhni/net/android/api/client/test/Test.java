package ca.sukhni.net.android.api.client.test;

import org.apache.http.HttpEntity;

import ca.sukhni.net.android.api.client.ApiClient;
import ca.sukhni.net.android.api.client.ApiClientBuilder;
import ca.sukhni.net.android.api.client.ApiClientHandler;
import ca.sukhni.net.android.api.client.ExceptionStatus;
import ca.sukhni.net.android.api.client.Method;
import ca.sukhni.net.android.api.client.Status;

public class Test
{

	public static void main(String[] args)
	{
		System.out.println("Welcome to API android client TEST");
		//http://192.168.2.146:7979/Ais/User/Session/Verify?
		//ApiKey={APIKEY}&SimID={SIMID}&AndroidID={ANDROIDID}&SessionID={SESSIONID}&Imei={IMEI}&Language={LANGUAGE}&MobirooAppVersion={MOBIROOAPPVERSION
		ApiClient apiClient = new ApiClientBuilder()
		.setBaseUri("http://api.mobaroo.com")
		.addPath("Ais")
		.addPath("User")
		.addPath("Session")
		.addPath("Verify")
		.addParam("ApiKey", "f01c3556-e03d-47d1-a6cc-73949fcfc181")
		.addParam("AndroidID", "12345679")
		.addParam("SessionID", null)
		.addParam("Language", "en-US")
		.addParam("MobirooAppVersion", "1.0.0.0")
		.setMethod(Method.GET)
		.build();
		
		apiClient.executeOnAsyncTask(new ApiClientHandler()
		{

			@Override
			public void onInformational(Status status, String responseStatus, HttpEntity entity)
			{
				
			}
			
			@Override
			public void onSuccessful(Status status, String responseStatus, HttpEntity entity)
			{
				
			}

			@Override
			public void onClientError(Status status, String responseStatus, HttpEntity entity)
			{
				
			}

			@Override
			public void onRedirection(Status status, String responseStatus, HttpEntity entity)
			{
				
			}

			@Override
			public void onServerError(Status status, String responseStatus, HttpEntity entity)
			{
				
			}

			@Override
			public void onException(ExceptionStatus exceptionStatus, Exception ex)
			{
				
			}
			
		});
	}

}
