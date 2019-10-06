import java.net.*;
import java.io.*;
/** A starting point for network clients. YouÅfll need to
* override handleConnection, but in many cases
* connect can remain unchanged. It uses
* SocketUtil to simplify the creation of the
* PrintWriter and BufferedReader.
*
* @see SocketUtil
*/
public class NetworkClient {
protected String host;
protected int port;
/** Register host and port. The connection wonÅft
* actually be established until you call
* connect.
*
* @see #connect
*/
public NetworkClient(String host, int port) {
this.host = host;
this.port = port;
}
/** Establishes the connection, then passes the socket
* to handleConnection.
*
* @see #handleConnection
*/
public void connect() {
try {
Socket client = new Socket(host, port);
handleConnection(client);
} catch(UnknownHostException uhe) {
System.out.println("Unknown host: " + host);
uhe.printStackTrace();
} catch(IOException ioe) {
System.out.println("IOException: " + ioe);
ioe.printStackTrace();
}
}
/** This is the method you will override when
* making a network client for your task.
* The default version sends a single line
* ("Generic Network Client") to the server,
* reads one line of response, prints it, then exits.
*/
protected void handleConnection(Socket client)
throws IOException {
PrintWriter out =
SocketUtil.getWriter(client);
BufferedReader in =
SocketUtil.getReader(client);
out.println("Generic Network Client");
System.out.println
("Generic Network Client:\n" +
"Made connection to " + host +
" and got Åf" + in.readLine() + "Åf in response");
client.close();
}
/** The hostname of the server weÅfre contacting. */
public String getHost() {
return(host);
}
/** The port connection will be made on. */
public int getPort() {
return(port);
}
}
