package ca.sukhni.net.android.api.client;

public class HttpResponseResult
{
	private int responseCode;
	private String responseStatusLine;
	private ResponseEntity responseEntity;
	
	public HttpResponseResult(int responseCode, String responseStatusLine, ResponseEntity responseEntity)
	{
		this.responseCode = responseCode;
		this.responseStatusLine = responseStatusLine;
		this.responseEntity = responseEntity;
	}

	/**
	 * @return the responseCode
	 */
	public int getResponseCode()
	{
		return responseCode;
	}

	/**
	 * @return the responseStatusLine
	 */
	public String getResponseStatusLine()
	{
		return responseStatusLine;
	}

	/**
	 * @return the responseEntity
	 */
	public ResponseEntity getResponseEntity()
	{
		return responseEntity;
	}
	
	public static class ResponseEntity
	{
		private long contentLength;
		private boolean isChuncked;
		private boolean isRepeatable;
		private boolean isStreaming;
		private ResponseHeader responseHeader;
		private byte[] entity;
		
		public ResponseEntity(long contentLength, boolean isChuncked, boolean isRepeatable, boolean isStreaming, ResponseHeader responseHeader, byte[] entity)
		{
			super();
			this.contentLength = contentLength;
			this.isChuncked = isChuncked;
			this.isRepeatable = isRepeatable;
			this.isStreaming = isStreaming;
			this.responseHeader = responseHeader;
			this.entity = entity;
		}
		/**
		 * @return the contentLength
		 */
		public long getContentLength()
		{
			return contentLength;
		}
		/**
		 * @return the isChuncked
		 */
		public boolean isChuncked()
		{
			return isChuncked;
		}
		/**
		 * @return the isRepeatable
		 */
		public boolean isRepeatable()
		{
			return isRepeatable;
		}
		/**
		 * @return the isStreaming
		 */
		public boolean isStreaming()
		{
			return isStreaming;
		}
		/**
		 * @return the entity
		 */
		public byte[] getEntity()
		{
			return entity;
		}
		/**
		 * @return the responseHeader
		 */
		public ResponseHeader getResponseHeader()
		{
			return responseHeader;
		}
		
		public String getStringEntity()
		{
			String str = new String(entity);
			return str;
		}
	}
	
	public static class ResponseHeader
	{
		private String name;
		private String value;
		private org.apache.http.HeaderElement[] headerElements;
		
		public ResponseHeader(String name, String value, org.apache.http.HeaderElement[] headerElements)
		{
			super();
			this.name = name;
			this.value = value;
			this.headerElements = headerElements;
		}

		/**
		 * @return the name
		 */
		public String getName()
		{
			return name;
		}

		/**
		 * @return the value
		 */
		public String getValue()
		{
			return value;
		}

		/**
		 * @return the headerElements
		 */
		public org.apache.http.HeaderElement[] getHeaderElements()
		{
			return headerElements;
		}
	}
}