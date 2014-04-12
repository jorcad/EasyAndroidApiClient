package ca.sukhni.net.android.api.client;

import java.io.IOException;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import ca.sukhni.net.android.api.client.HttpResponseResult.ResponseEntity;
import ca.sukhni.net.android.api.client.logger.Logger;
import ca.sukhni.net.android.api.client.utils.HttpUtils;


public class RestClient extends BaseClient
{

	public final static String TAG					= RestClient.class.getSimpleName();
	protected RestClient()
	{
		super();
	}
	
	protected RestClient(HttpRequest httpRequest)
	{
		super(httpRequest);
	}

	protected RestClient(HttpRequest httpRequest,int connectionTimeout, int socketTimeout)
	{
		super(httpRequest, connectionTimeout, socketTimeout);
	}
	
	@Override
	public HttpResponseResult execute() throws Exception
	{
		switch(httpRequest.getHttpMethod())
		{
			case DELETE:
				return executeDelete();
			case GET:
				return  executeGet();
			case POST:
				return  executePost();
			case PUT:
				return  executePut();
			default:
				return  executeGet();
		}
	}
	
	public HttpResponseResult executeGet() throws Exception
	{
		String fullUrl = getHttpRequest().constructUri();
		HttpGet request = new HttpGet(fullUrl);
		return executeRequest(request);
	}
	
	public HttpResponseResult executePost() throws Exception
	{
		String fullUrl = httpRequest.constructUri();
		HttpPost request = new HttpPost(fullUrl);
		
		if (httpRequest.getRequestBody()!=null)
		{
			String content = new String(httpRequest.getRequestBody());
			
			StringEntity entity = new StringEntity(content, httpRequest.getCharSetType());
			entity.setContentEncoding(httpRequest.getCharSetType());
			entity.setContentType(httpRequest.getContentType());
			request.setEntity(entity);
		}
		
		return executeRequest(request);
	}
	
	public HttpResponseResult executePut() throws Exception
	{
		String fullUrl = getHttpRequest().constructUri();
		HttpPut request = new HttpPut(fullUrl);
		
		if (httpRequest.getRequestBody()!=null)
		{
			String content = new String(httpRequest.getRequestBody());
			
			StringEntity entity = new StringEntity(content, httpRequest.getCharSetType());
			entity.setContentEncoding(httpRequest.getCharSetType());
			entity.setContentType(httpRequest.getContentType());
			request.setEntity(entity);
		}
		
		return executeRequest(request);
	}
	
	public HttpResponseResult executeDelete() throws Exception
	{
		String fullUrl = getHttpRequest().constructUri();
		HttpDelete request = new HttpDelete(fullUrl);
		return executeRequest(request);
	}
	
	public HttpResponseResult executeRequest(HttpUriRequest request) throws Exception
	{
		Logger.debug(TAG + ": executeRequest: " + request.getURI().toASCIIString());
		Logger.debug(TAG + ": executeRequest: " + request.getMethod());
		Iterator<String> it = httpRequest.getHeaders().keySet().iterator();
		while(it.hasNext())
		{
			String key = it.next();
			String value = httpRequest.getHeaders().get(key);
			request.addHeader(key, value);
		}
		
		HttpParams conParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(conParams, connectionTimeout);
        HttpConnectionParams.setSoTimeout(conParams, socketTimeout);
        HttpClient client = HttpUtils.getNewHttpClient(conParams);
        
		HttpResponse httpResponse = client.execute(request);
		
		int status = httpResponse.getStatusLine().getStatusCode();
		String statusLine = httpResponse.getStatusLine().getReasonPhrase();
		ResponseEntity responseEntity = iniResponseEntity(httpResponse.getEntity());
		
		Logger.debug(TAG + ": executeRequest: status= "  + status);
		
		HttpResponseResult httpResponseResult = new HttpResponseResult(status, statusLine, responseEntity); 
		
		return httpResponseResult;
	}
	
	private ResponseEntity iniResponseEntity(HttpEntity httpEntity) throws IOException
	{
		ResponseEntity responseEntity = null;
		if(httpEntity!=null)
		{
			 long contentLength  = httpEntity.getContentLength() ;
			 boolean isChuncked = httpEntity.isChunked();
			 boolean isRepeatable = httpEntity.isRepeatable();
			 boolean isStreaming = httpEntity.isStreaming();
			 HttpResponseResult.ResponseHeader responseHeader = null;
			 
			 Header header = httpEntity.getContentType();
			 if(header!=null)
			 {
				 responseHeader = new HttpResponseResult.ResponseHeader(header.getName(), header.getValue(), header.getElements());
			 }
			 
			 byte[] entity = HttpEntityHelper.readEntity(httpEntity);
			 
			 responseEntity = new ResponseEntity(contentLength, isChuncked, isRepeatable, isStreaming, responseHeader, entity);
			 
			 return responseEntity;
		}
		else 
		{
			 return null;
		}
	}
}
