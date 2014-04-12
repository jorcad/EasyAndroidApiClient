package ca.sukhni.net.android.api.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpRequest
{
	private String baseUri;
	private HttpMethod httpMethod;
	private List<String> paths;
	private Map<String,String> params;
	private Map<String,String> headers;
	private String charSetType;
	private String contentType;
	private byte[] requestBody;
	
	public HttpRequest()
	{
		this.params = new HashMap<String, String>();
		this.headers = new HashMap<String, String>();
		this.paths = new ArrayList<String>();
		this.charSetType = CharSetType.UTF_8;
		this.httpMethod = HttpMethod.GET;
	}
	
	public HttpRequest(String baseUri, HttpMethod method, List<String> paths, Map<String, String> params, Map<String, String> headers, String charSetType,String contentType,
			byte[] requestBody)
	{
		
		this.baseUri = baseUri;
		this.httpMethod = method;
		this.paths = paths;
		this.params = params;
		this.headers = headers;
		this.charSetType = charSetType;
		this.contentType = contentType;
		this.requestBody = requestBody;
	}
	/**
	 * @return the baseUri
	 */
	public String getBaseUri()
	{
		return baseUri;
	}
	/**
	 * @param baseUri the baseUri to set
	 */
	public void setBaseUri(String baseUri)
	{
		this.baseUri = baseUri;
	}
	/**
	 * @return the method
	 */
	public HttpMethod getHttpMethod()
	{
		return httpMethod;
	}
	/**
	 * @param method the method to set
	 */
	public void setHttpMethod(HttpMethod method)
	{
		this.httpMethod = method;
	}
	/**
	 * @return the paths
	 */
	public List<String> getPaths()
	{
		return paths;
	}
	/**
	 * @param paths the paths to set
	 */
	public void setPaths(List<String> paths)
	{
		this.paths = paths;
	}
	/**
	 * @return the params
	 */
	public Map<String, String> getParams()
	{
		return params;
	}
	/**
	 * @param params the params to set
	 */
	public void setParams(Map<String, String> params)
	{
		this.params = params;
	}
	/**
	 * @return the headers
	 */
	public Map<String, String> getHeaders()
	{
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(Map<String, String> headers)
	{
		this.headers = headers;
	}
	/**
	 * @return the charSetType
	 */
	public String getCharSetType()
	{
		return charSetType;
	}
	/**
	 * @param charSetType the charSetType to set
	 */
	public void setCharSetType(String charSetType)
	{
		this.charSetType = charSetType;
	}
	/**
	 * @return the contentType
	 */
	public String getContentType()
	{
		return contentType;
	}
	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	/**
	 * @return the requestBody
	 */
	public byte[] getRequestBody()
	{
		return requestBody;
	}
	/**
	 * @param requestBody the requestBody to set
	 */
	public void setRequestBody(byte[] requestBody)
	{
		this.requestBody = requestBody;
	}
	
	public void addParam(String key,String value)
	{
		params.put(key, value);
	}
	
	public void addHeader(String key,String value)
	{
		headers.put(key, value);
	}
	
	public void addPath(String... paths)
	{
		for(int i=0;i<paths.length;i++)
		{
			String[] splitPath = paths[i].split("/");
			for(int j=0;j<splitPath.length;j++)
				this.paths.add(splitPath[j]);
		}
	}
	
	public void addPath(String path)
	{
		this.paths.add(path);
	}
	
	public String getCombinedPath()
	{
		StringBuilder pathBuilder = new StringBuilder();
		if(paths!=null)
		{
			int size = paths.size();
			for(int i=0;i<size;i++)
			{
				String path = paths.get(i).replace("/", "").replace("\\", "");
				if(i<size) pathBuilder.append("/");
				pathBuilder.append(path);
			}
		}
		return pathBuilder.toString();
	}
	
	public String getCombinedParams() throws UnsupportedEncodingException
	{
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = params.keySet().iterator();
		if(params.size()>0) sb.append("?");
		while(it.hasNext())
		{
			String key = it.next();
			String value = params.get(key);
			
			String paramString = key + "=" + URLEncoder.encode(value, CharSetType.UTF_8);
			
			sb.append(paramString);
			if(it.hasNext()) sb.append("&");
		}
		
		return sb.toString();
	}
	
	public String constructUri() throws UnsupportedEncodingException
	{
		String fullUri = baseUri + getCombinedPath() + getCombinedParams();
		return fullUri;
	}
} 
