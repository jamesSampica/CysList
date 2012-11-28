package com.web.userPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import util.HibernateUtil;

public class ManagePostQueryAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    	ManagePostQueryForm mpqf = (ManagePostQueryForm) form;
        HttpSession httpSession = request.getSession(true);
        
        
        Post queriedPost = HibernateUtil.getPostByKey(mpqf.key);
        
        if(queriedPost != null){
        	httpSession.setAttribute("post", queriedPost);
   		 
    		return mapping.findForward("querysuccess");
        }
        else{
        	return mapping.findForward("queryfailure");
        }
    }
}

