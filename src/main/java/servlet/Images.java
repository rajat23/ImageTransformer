package servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

public class Images extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String directory=req.getParameter("directory");
        List<String> results = new ArrayList<String>();
        JSONObject imageNames = new JSONObject();
        File[] files = new File(System.getProperty("user.dir")+"/upload/"+directory).listFiles();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        try {
            for (File file : files) {
                if (file.isFile()) {
                    results.add(file.getName());
                }
            }
        }
        catch (Exception e){

        }

        imageNames.put("names", results);
        out.print(""+imageNames);
        out.flush();

    }
}
