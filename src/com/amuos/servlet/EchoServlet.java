package com.amuos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author: wangjuan on 2016/2/19.
 * @Description:
 */
public class EchoServlet {
	
}

//public class EchoServlet extends HttpServlet {
//
//    /** Http get handler
//     * wangjuan 2016/2/19
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        response.setHeader("Content-Type", "text/plain");
//        PrintWriter writer = response.getWriter();
//        Enumeration e = request.getParameterNames();
//        while (e.hasMoreElements()){
//            String parameter = String.valueOf(e.nextElement());
//            String[] values = request.getParameterValues(parameter);
//            for(int i = 0; i < values.length; i++){
//                writer.write(parameter + "=" + values[i]);
//                writer.write("\n");
//            }
//        }
//        writer.close();
//    }
//}
