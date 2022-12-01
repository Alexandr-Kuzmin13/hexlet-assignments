package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {

    private final TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error! The connection is already established!");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnected");
        TcpConnection t = this.tcpConnection;
        t.setConnection(new Disconnected(t));
    }

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
// END
