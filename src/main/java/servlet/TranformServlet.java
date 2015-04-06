package servlet;



import effect.Effectible;
import effect.EffectFactory;
import helper.ImageReader;
import helper.Response;
import helper.Rounder;
import mode.Mode;
import mode.ModeFactory;
import UserRequest.RequestList;
import rotate.Rotable;
import rotate.RotatorFactory;
import utility.ImageCompressor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;


public class TranformServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getParameter("path");
        ImageReader imageReader = new ImageReader();
        BufferedImage image;
        try {
            image = imageReader.readImage(path);
        } catch (IOException ioException) {
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("<html><body>" + ioException.getStackTrace() + "</body><html>");
            return;
        }
        RequestList requestList = new RequestList(image,request.getParameterMap());

        ModeFactory modeFactory = new ModeFactory();
        Mode mode = modeFactory.create(requestList.getMode());

        image = mode.getScaledImage(requestList);
        image = Rounder.makeRoundedCorner(image, requestList.getRadius());

        Effectible effectible =new EffectFactory().create(requestList.getEffect());
        image= effectible.getEffect(image);

        Rotable rotable =new RotatorFactory().create(requestList.getAngle());
        image= rotable.rotateImage(image);

        ImageCompressor imageCompresser=new ImageCompressor();
        image=imageCompresser.getCompressImage(image, requestList.getQuality());

        Response servletResponse = new Response();
        servletResponse.setResponse(response, image, requestList.getFormat());
    }


}
