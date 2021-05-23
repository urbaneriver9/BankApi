import db.DataSource;
import db.H2DataSourceImpl;
import server.http.impl.LocalHttpServerImpl;

public class Main {

    public static void main(String[] args){
        H2DataSourceImpl.initDb();
        LocalHttpServerImpl localHttpServer = new LocalHttpServerImpl();
    }
}
