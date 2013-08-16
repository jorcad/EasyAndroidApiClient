package ca.sukhni.net.android.api.client;

public enum Status
{
	//1xx Informational
	CONTINUE(100,"The client SHOULD continue with its request."),
	SWITCHING_PROTOCOLS(101," the requester has asked the server to switch protocols and the server is acknowledging that it will do so."),
	PROCESSING(102,"This code indicates that the server has received and is processing the request, but no response is available yet."),
	
	//2xx Success
	OK(200,"The request has succeeded"),
	CREATED(201,"The request has been fulfilled and resulted in a new resource being created."),
	ACCEPTED(202,"The request has been accepted for processing, but the processing has not been completed."),
	NON_AUTHORITATIVE_INFORMATION(203,"The server successfully processed the request, but is returning information that may be from another source."),
	NO_CONTENT(204,"The server successfully processed the request, but is not returning any content."),
	RESET_CONTENT(205,"The server successfully processed the request, but is not returning any content."),
	PARTIAL_CONTENT(206,"The server is delivering only part of the resource due to a range header sent by the client."),
	MULTI_STATUS(207,"The message body that follows is an XML message and can contain a number of separate response codes, depending on how many sub-requests were made."),
	ALREADY_REPORTED(208,"The members of a DAV binding have already been enumerated in a previous reply to this request, and are not being included again."),
	IM_USED(226,"The server has fulfilled a GET request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance."),
	
	//3xx Redirection
	MULTIPLE_CHOICES(300,"Indicates multiple options for the resource that the client may follow."),
	MOVED_PERMANENTLY(301,"This and all future requests should be directed to the given URI."),
	FOUND(302,"The requested resource resides temporarily under a different URI. Since the redirection might be altered on occasion, the client SHOULD continue to use the Request-URI for future requests."),
	SEE_OTHER(303,"The response to the request can be found under a different URI and SHOULD be retrieved using a GET method on that resource."),
	NOT_MODIFIED(304,"Indicates that the resource has not been modified since the version specified by the request headers If-Modified-Since or If-Match."),
	USE_PROXY(305,"The requested resource MUST be accessed through the proxy given by the Location field. The Location field gives the URI of the proxy."),
	SWITCH_PROXY(306,"Subsequent requests should use the specified proxy. DEVELOPER NOTE: THIS CODE NO LONGER USED."),
	TEMPORARY_REDIRECT(307,"The requested resource resides temporarily under a different URI. Since the redirection MAY be altered on occasion, the client SHOULD continue to use the Request-URI for future requests."),
	PERMANENT_REDIRECT(308,"The request, and all future requests should be repeated using another URI."),
	
	//4xx Client Error
	BAD_REQUEST(400,"The request could not be understood by the server due to malformed syntax."),
	UNAUTHORIZED(401,"Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided"),
	PAYMENT_REQUIRED(402,"DEVELOPER NOTE: This code is reserved for future use. "),
	FORBIDDEN(403,"The request was a valid request, but the server is refusing to respond to it."),
	NOT_FOUND(404,"The server has not found anything matching the Request-URI. No indication is given of whether the condition is temporary or permanent."),
	METHOD_NOT_ALLOWED(405,"The method specified in the Request-Line is not allowed for the resource identified by the Request-URI."),
	NOT_ACCEPTABLE(406,"The resource identified by the request is only capable of generating response entities which have content characteristics not acceptable according to the accept headers sent in the request."),
	PROXY_AUTHENTICATION_REQUIRED(407,"The client must first authenticate itself with the proxy."),
	REQUEST_TIMEOUT(408,"The client did not produce a request within the time that the server was prepared to wait."),
	CONFLICT(409,"The request could not be completed due to a conflict with the current state of the resource. "),
	GONE(410,"The requested resource is no longer available at the server and no forwarding address is known."),
	LENGTH_REQUIRED(411,"The request did not specify the length of its content, which is required by the requested resource."),
	PRECONDITION_FAILED(412,"The server does not meet one of the preconditions that the requester put on the request."),
	REQUEST_ENTITY_TOO_LARGE(413,"The request is larger than the server is willing or able to process."),
	REQUEST_URI_TOO_LONG(414,"The URI provided was too long for the server to process."),
	UNSUPPORTED_MEDIA_TYPE(415,"The request entity has a media type which the server or resource does not support."),
	REQUESTED_RANGE_NOT_SATISFIABLE(416,"The client has asked for a portion of the file, but the server cannot supply that portion."),
	EXPECTATION_FAILED(417,"The server cannot meet the requirements of the Expect request-header field."),
	UNPROCESSABLE_ENTITY(422,"The request was well-formed but was unable to be followed due to semantic errors."),
	LOCKED(423,"The resource that is being accessed is locked."),
	FAILED_DEPENDENCY(424,"The request failed due to failure of a previous request."),
	METHOD_FAILURE(424,"Indicates the method was not executed on a particular resource within its scope because some part of the method's execution failed causing the entire method to be aborted."),
	UPGRADE_REQUIRED(426,"The client should switch to a different protocol."),
	PRECONDITION_REQUIRED(428,"The origin server requires the request to be conditional"),
	TOO_MANY_REQUESTS(429,"The user has sent too many requests in a given amount of time. Intended for use with rate limiting schemes."),
	REQUEST_HEADER_FIELDS_TOO_LARGE(431,"The server is unwilling to process the request because either an individual header field, or all the header fields collectively, are too large.["),
	
	
	//5xx Server Error
	INTERNAL_SERVER_ERROR(500,"The server encountered an unexpected condition which prevented it from fulfilling the request. "),
	NOT_IMPLEMENTED(501,"The server does not support the functionality required to fulfill the request."),
	BAD_GATEWAY(502,"The server, while acting as a gateway or proxy, received an invalid response from the upstream server it accessed in attempting to fulfill the request."),
	SERVICE_UNAVAILABLE(503,"The server is currently unable to handle the request due to a temporary overloading or maintenance of the server."),
	GATEWAY_TIMEOUT(504,"The server, while acting as a gateway or proxy, did not receive a timely response from the upstream server specified by the URI (e.g. HTTP, FTP, LDAP) or some other auxiliary server (e.g. DNS) it needed to access in attempting to complete the request. "),
	HTTP_VERSION_NOT_SUPPORTED(505,"The server does not support, or refuses to support, the HTTP protocol version that was used in the request message."),
	VARIANT_ALSO_NEGOTIATES(506,"Transparent content negotiation for the request results in a circular reference."),
	INSUFFICIENT_STORAGE(507,"The server is unable to store the representation needed to complete the request."),
	LOOP_DETECTED(508,"The server detected an infinite loop while processing the request."),
	BANDWIDTH_LIMIT_EXCEEDED(509,"This status code, while used by many servers, is not specified in any RFCs."),
	NOT_EXTENDED(510,"Further extensions to the request are required for the server to fulfil it."),
	NETWORK_AUTHENTICATION_REQUIRED(511,"The client needs to authenticate to gain network access.");
	
	private final int code;
	private final String desc;
	Status(int code,String desc)
	{
		this.code = code;
		this.desc = desc;
	}
	
	public int code(){return this.code;}
	public String desc(){return this.desc;}
	
}
