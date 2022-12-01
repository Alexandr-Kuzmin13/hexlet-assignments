package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection implements Connection {

    private final String ip;

    private final int port;

    private Connection connection;

    TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getCurrentState() {
        return getConnection().getCurrentState();
    }

    @Override
    public void connect() {
        getConnection().connect();
    }

    @Override
    public void disconnect() {
        getConnection().disconnect();
    }

    @Override
    public void write(String data) {
        getConnection().write(data);
    }
}
// END
