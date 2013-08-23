package ca.sukhni.net.android.api.client;

public enum ExceptionStatus
{
	CLIENT_PROTOCOL_EXCEPTION(0x0001,"Signals an error in the HTTP protocol. "),
	UNRESOLVED_ADDRESS_EXCEPTION(0x0002,"Unchecked exception thrown when an attempt is made to invoke a network operation upon an unresolved socket address."),
	UNKNOWN_HOST_EXCEPTION(0x0004,"Thrown to indicate that the IP address of a host could not be determined."),
	NO_ROUTE_TO_HOST_EXCEPTION(0x0008,"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the remote host cannot be reached because of an intervening firewall, or if an intermediate router is down."),
	PORT_UNREACHABLE_EXCEPTION(0x0010," Signals that an ICMP Port Unreachable message has been received on a connected datagram. "),
	CONNECT_TIMEOUT_EXCEPTION(0x0020,"A timeout while connecting to an HTTP server or waiting for an available connection from an HttpConnectionManager."),
	SOCKET_TIMEOUT_EXCEPTION(0x0040,"Signals that a timeout has occurred on a socket read or accept."),
	CONNECTION_CLOSED_EXCEPTION(0x0080,"Signals that the connection has been closed unexpectedly."),
	FILE_NOT_FOUND_EXCEPTION(0x0100," Signals that an attempt to open the file denoted by a specified pathname has failed."),
	UNSUPPORTED_ENCODING_EXCEPTION(0x0200,"The Character Encoding is not supported."),
	IO_EXCEPTION(0x0400," Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations."),
	EXCEPTION(0x0800,"Generic Exception.");
	
	private final int code;
	private final String desc;
	ExceptionStatus(int code,String desc)
	{
		this.code = code;
		this.desc = desc;
	}
	/**
	 * get the status code value
	 * @return integer value of the code 
	 */
	public int code(){return this.code;}
	/**
	 * get a short description of the status
	 * @return string
	 */
	public String desc(){return this.desc;}
}
