package com.web.userPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import util.HibernateUtil;

/**
 * 
 * @author James Sampica
 * Defines the action for when a post is edited and the edit button is clicked
 */
public class UpdatePostAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    	ManagePostForm mupf = (ManagePostForm) form;
        HttpSession httpSession = request.getSession(true);
        
        System.out.println("Updating: " + mupf.topic + " " + mupf.content + " " + mupf.title + " " + mupf);
        
        HibernateUtil.updatePostByKey(httpSession.getAttribute("postkey").toString(), mupf.email, mupf.title, mupf.content);
		 
		return mapping.findForward("postsuccess");
    }
}
