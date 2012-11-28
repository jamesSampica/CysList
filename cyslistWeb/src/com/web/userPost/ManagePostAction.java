package com.web.userPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import util.HibernateUtil;

public class ManagePostAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    	UserPostForm upf = (UserPostForm) form;
        HttpSession httpSession = request.getSession(true);
        System.out.println(upf.topic + " " + upf.content + " " + upf.title);
        
        
        
        //httpSession.setAttribute("postKey", key);
			
		 
		return mapping.findForward("postsuccess");
    }
}
