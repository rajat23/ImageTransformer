import servlet.Images;
import servlet.TranformServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import servlet.UploadServlet;

public class StartFile  {


    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new TranformServlet()), "/image/transform/*");
        context.addServlet(new ServletHolder(new Images()),"/images/*");
        context.addServlet(new ServletHolder(new UploadServlet()),"/upload/*");
        server.start();
        server.join();   
    }
}
