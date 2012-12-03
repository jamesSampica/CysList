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
 *
 * This class defines the user action for deleting a post
 */
public class DeletePostAction extends org.apache.struts.action.Action {

	/**
	 * @param mapping Actionmapping for struts
	 * @param form Actionform for the form object
	 * @param request Request object 
	 * @param response Response object
	 */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        HttpSession httpSession = request.getSession(true);

        HibernateUtil.deletePostByKey(httpSession.getAttribute("postkey").toString());

		return mapping.findForward("deletesuccess");
    }
}
