package com.web.userPost;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;

import util.HibernateUtil;

/**
 * 
 * @author James Sampica
 * Defines the action that occurs when the user fills out a new post form and clicks post
 */
public class UserPostAction extends org.apache.struts.action.Action {
	
	/**
	 * @param mapping Actionmapping for struts
	 * @param form Actionform for the form object
	 * @param request Request object 
	 * @param response Response object
	 */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    	UserPostForm upf = (UserPostForm) form;
        HttpSession httpSession = request.getSession(true);
        
        System.out.println(upf.getTopic() + " " + upf.getContent() + " " + upf.getTitle() + " " + upf.getImage());
        
        String key = HibernateUtil.createAndStorePost(upf.getTopic(), upf.getContent(), upf.getTitle(), upf.getEmail(), upf.getImage());
        
        //Save image
        String ext = "";
        if(upf.getImage() != null){
            try{
            	ext = "." + getExtension(upf.getImage());
            	System.out.println(request.getSession().getServletContext().getRealPath("/")
            			+ "images\\" + key.substring(12) + ext);
            	
            	FileOutputStream fos = new FileOutputStream(request.getSession().getServletContext().getRealPath("/")
            			+ "images\\" + key.substring(12) + ext);
                fos.write(upf.getImage().getFileData()); 
                fos.close();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        httpSession.setAttribute("imageExt", ext);
        httpSession.setAttribute("postkey", key);
		 
		return mapping.findForward("postsuccess");
    }
    
    private static String getExtension(FormFile f)
    {
    	String ext = null;
    	System.out.println(f.getFileName());
    	String s = f.getFileName();
    	int i = s.lastIndexOf('.');

    	if (i > 0 && i < s.length() - 1)
    		ext = s.substring(i+1).toLowerCase();

    	if(ext == null)
    		return "";
    	return ext;
    }
}