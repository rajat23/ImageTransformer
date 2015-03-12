package com.servlet;


import com.effect.Effect;
import com.effect.EffectFactory;
import com.helper.ImageReader;
import com.helper.Response;
import com.helper.Rounder;
import com.mode.Mode;
import com.mode.ModeFactory;
import com.helper.RequestStructure;
import com.rotate.Angle;
import com.rotate.AngleFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


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
        RequestStructure requestStructure = new RequestStructure();
        requestStructure.setImage(image);
        Map<String, String[]> map = request.getParameterMap();
        requestStructure.setParameters(map);

        ModeFactory modeFactory = new ModeFactory();
        Mode mode = modeFactory.create(requestStructure.getMode());

        image = mode.getScaledImage(requestStructure);
        image = Rounder.makeRoundedCorner(image, requestStructure.getRadius());

        Effect effect=new EffectFactory().create(requestStructure.getEffect());
        image=effect.getEffect(image);

        Angle angle=new AngleFactory().create(requestStructure.getAngle());
        image=angle.rotateImage(image,requestStructure.getAngle());

        Response servletResponse = new Response();
        servletResponse.setResponse(response, image, requestStructure.getFormat());
    }


}
