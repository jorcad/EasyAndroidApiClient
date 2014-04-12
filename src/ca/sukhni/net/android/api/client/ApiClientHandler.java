package ca.sukhni.net.android.api.client;

/**
 * interface to Api client response handler
 * @author malsukhni
 *
 */
public interface ApiClientHandler
{
	/**
	 * this event triggered when the response code in the range [100,199]
	 * @param status response status code
	 * @param responseStatus response status line
	 * @param response the http response, SEE {@link HttpResponse}
	 */
	public abstract void onInformational(int responseCode,String responseStatus,HttpResponseResult response);
	/**
	 * this event triggered when the response code in the range [200,299]
	 * @param status response status code
	 * @param responseStatus response status line
	 * @param response the http response, SEE {@link HttpResponse}
	 */
	public abstract void onSuccessful(int responseCode,String responseStatus,HttpResponseResult response);
	/**
	 * this event triggered when the response code in the range [300,399]
	 * @param status response status code
	 * @param responseStatus response status line
	 * @param response the http response, SEE {@link HttpResponse}
	 */
	public abstract void onRedirection(int responseCode,String responseStatus,HttpResponseResult response);
	/**
	 * this event triggered when the response code in the range [400,499]
	 * @param status response status code
	 * @param responseStatus response status line
	 * @param response the http response, SEE {@link HttpResponse}
	 */
	public abstract void onClientError(int responseCode,String responseStatus,HttpResponseResult response);
	/**
	 * this event triggered when the response code is >= 500
	 * @param status response status code
	 * @param responseStatus response status line
	 * @param response the http response, SEE {@link HttpResponse}
	 */
	public abstract void onServerError(int responseCode,String responseStatus,HttpResponseResult response);
	/**
	 * this event triggered when an exception happens when executing the request
	 * @param exceptionStatus the exception status. SEE {@link Exception}
	 * @param e
	 */
	public abstract void onException(Exception e);
}
