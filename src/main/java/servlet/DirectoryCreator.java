package servlet;

import helper.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DirectoryCreator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String directory = req.getParameter("directoryName");
        new File(System.getProperty("user.dir")+"/upload/"+directory).mkdir();
    }
}
