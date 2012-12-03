package com.web.userPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import util.HibernateUtil;

/**
 * 
 * @author James Sampica
 * Defines the action that occurs when a key has been entered and search clicked
 */
public class ManagePostQueryAction extends org.apache.struts.action.Action {

	/**
	 * @param mapping Actionmapping for struts
	 * @param form Actionform for the form object
	 * @param request Request object 
	 * @param response Response object
	 */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    	ManagePostQueryForm mpqf = (ManagePostQueryForm) form;
        HttpSession httpSession = request.getSession(true);
        
        
        Post queriedPost = HibernateUtil.getPostByKey(mpqf.key);
        
        if(queriedPost != null){
        	httpSession.setAttribute("post", queriedPost);
   		 	httpSession.setAttribute("postkey", mpqf.key);
   		 	
    		return mapping.findForward("querysuccess");
        }
        else{
        	return mapping.findForward("queryfailure");
        }
    }
}

