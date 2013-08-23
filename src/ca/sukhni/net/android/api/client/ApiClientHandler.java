package ca.sukhni.net.android.api.client;

import org.apache.http.HttpEntity;

public interface ApiClientHandler
{
	public abstract void onInformational(Status status,String responseStatus,HttpEntity entity);
	public abstract void onSuccessful(Status status,String responseStatus,HttpEntity entity);
	public abstract void onClientError(Status status,String responseStatus,HttpEntity entity);
	public abstract void onRedirection(Status status,String responseStatus,HttpEntity entity);
	public abstract void onServerError(Status status,String responseStatus,HttpEntity entity);
	public abstract void onException(ExceptionStatus exceptionStatus,Exception e);
}
