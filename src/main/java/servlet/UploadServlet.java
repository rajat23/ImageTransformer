package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class UploadServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private final int MAXFILESIZE = 1024*10*1024;
    private final int MAXMEMSIZE = 4 * 1024;
    private File file ;
    private String directory;
    private final String UPLOADHOME = "http://imsite.herokuapp.com/homes/dashboard";


    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                        throws ServletException, java.io.IOException {

        directory=request.getParameter("directory");
        filePath =System.getProperty("user.dir")+"/upload/"+directory+"/";
        File f = new File(filePath);
        if(!f.exists()) {
            new File(System.getProperty("user.dir") + "/upload/" + directory + "/").mkdir();
            filePath = System.getProperty("user.dir") + "/upload/" + directory+"/";
        }

        System.out.println(filePath);


        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter( );
        if( !isMultipart ){
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(MAXMEMSIZE);

        factory.setRepository(new File(System.getProperty("user.dir")+"/upload/"));


        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setSizeMax(MAXFILESIZE);

        try{

            List fileItems = upload.parseRequest(request);


            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            while ( i.hasNext () )
            {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () )
                {
                    String fileName = fi.getName();
                    if( fileName.lastIndexOf("\\") >= 0 ){
                        file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
                    }else{
                        file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                    }
                    fi.write( file ) ;
                    out.println("Uploaded Filename: " + fileName + "<br>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }catch(Exception ex) {
            System.out.println(ex);
        }
        response.sendRedirect(UPLOADHOME);
    }

}
