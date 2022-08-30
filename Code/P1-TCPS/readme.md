  **Transmission Control Protocol** is a connection-oriented protocol and requires handshaking to set up end-to-end communications.
   Once a connection is set up, user data may be sent bi-directionally over the connection. (*Wikipedia*)
  
   This program:
1.    Configures a Server
2.    Configures a connection with a Client

The configuration of the server includeds
- identification of the IP adddress
- choice of a port
- creation of a server socket and binding it to a specific port number.

The client connection configuration consists of
- listening to the socket for incoming connection and creating a client socket for it
- creating and binding two streams to the client socket: one for input and one for output of messages that arrive to and being sent from this server
- reading incoming data from the client via an `InputStream` obtained from the client socket, and then processing it
- sending data back to the client via the client socket’s `OutputStream`.
- closing the connection with the client.
   
   The steps 3 and 4 can be repeated many times depending on the protocol agreed between the server and the client.
   
The main() method manages the overall process and exceptions.
 
