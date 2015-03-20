import servlet.TranformServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class StartFile  {


    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new TranformServlet()),"/image/transform/*");
        server.start();
        server.join();   
    }
}
