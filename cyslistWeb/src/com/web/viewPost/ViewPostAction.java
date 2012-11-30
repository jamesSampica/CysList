package com.web.viewPost;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ViewPostAction extends org.apache.struts.action.Action {

	    public ActionForward execute(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	    	HttpSession httpSession =request.getSession(true);
	        ViewPostForm vpf = (ViewPostForm) form;
	        
	        System.out.println(vpf.postNum);
	        
	        List<String> postList = (List<String>) httpSession.getAttribute("postResults");
	        
	        httpSession.setAttribute("post", postList.get(Integer.valueOf(vpf.postNum)-1));
			 
			return mapping.findForward("viewpost");
	    }
}
