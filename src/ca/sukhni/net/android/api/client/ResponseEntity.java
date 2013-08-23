package ca.sukhni.net.android.api.client;

import org.apache.http.HeaderElement;

public interface ResponseEntity
{
	public abstract long getContentLength();
	public abstract boolean isChuncked();
	public abstract boolean isStreaming();
	public abstract boolean isRepeatable();
	public abstract String getResponseContentAsString();
	public abstract ResponseHeader getContentType();
	public abstract ResponseHeader getContentEncoding();
}
interface ResponseHeader
{
	public abstract String getName();
	public abstract String getValue();
	public abstract HeaderElement[] getElements();
}
class ResponseEntityImpt implements ResponseEntity
{
	private long 				contentLength;
	private boolean 			isChuncked;
	private boolean 			isRepeatable;
	private boolean 			isStreaming;
	private String				strEntity;
	private ResponseHeaderImpt 	responseHeaderImpt;
	
	public ResponseEntityImpt()
	{
		responseHeaderImpt = new ResponseHeaderImpt();
	}
	public class ResponseHeaderImpt implements ResponseHeader
	{
		private String 				name;
		private String 				value;
		private HeaderElement[] 	elements;
		@Override
		public String getName()
		{
			return name;
		}
		@Override
		public String getValue()
		{
			return value;
		}
		@Override
		public HeaderElement[] getElements()
		{
			return elements;
		}
		public void setName(String name)
		{
			this.name = name;
		}
		public void setValue(String value)
		{
			this.value = value;
		}
		public void setElements(HeaderElement[] elements)
		{
			this.elements = elements;
		}
		
	}

	@Override
	public long getContentLength()
	{
		return contentLength;
	}

	@Override
	public boolean isChuncked()
	{
		return isChuncked;
	}

	@Override
	public boolean isStreaming()
	{
		return isStreaming;
	}

	@Override
	public boolean isRepeatable()
	{
		return isRepeatable;
	}

	@Override
	public ResponseHeader getContentType()
	{
		return responseHeaderImpt;
	}

	@Override
	public ResponseHeader getContentEncoding()
	{
		return responseHeaderImpt;
	}

	@Override
	public String getResponseContentAsString()
	{
		return strEntity;
	}

	public void setContentLength(long contentLength)
	{
		this.contentLength = contentLength;
	}

	public void setChuncked(boolean isChuncked)
	{
		this.isChuncked = isChuncked;
	}

	public void setRepeatable(boolean isRepeatable)
	{
		this.isRepeatable = isRepeatable;
	}

	public void setStreaming(boolean isStreaming)
	{
		this.isStreaming = isStreaming;
	}

	public void setStrEntity(String strEntity)
	{
		this.strEntity = strEntity;
	}

	public void setResponseHeaderImpt(ResponseHeaderImpt responseHeaderImpt)
	{
		this.responseHeaderImpt = responseHeaderImpt;
	}

	public ResponseHeaderImpt getResponseHeaderImpt()
	{
		return responseHeaderImpt;
	}
	
	
}
