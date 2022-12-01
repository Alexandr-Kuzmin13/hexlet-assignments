package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {

    private final TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        System.out.println("connected");
        TcpConnection t = this.tcpConnection;
        t.setConnection(new Connected(t));
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection is broken!");
    }

    @Override
    public void write(String data) {
        System.out.println("Error! Writing is not possible to a broken connection!");
    }
}
// END
