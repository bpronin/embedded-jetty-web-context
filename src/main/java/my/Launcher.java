package my;


import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Class Launcher.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class Launcher {

    public static void main(String[] args) throws Exception {
        Server server = new Server();

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);

        WebAppContext context = new WebAppContext();
        context.setDescriptor("src/webapp/WEB-INF/web.xml");
        context.setResourceBase("src/main/webapp");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);

        server.start();
        server.join();
    }

}
