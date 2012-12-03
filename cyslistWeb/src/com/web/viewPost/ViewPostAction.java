package com.web.viewPost;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * @author James Sampica
 * Defines the action for when the user clicks on a single post to view
 */
public class ViewPostAction extends org.apache.struts.action.Action {

	/**
	 * @param mapping Actionmapping for struts
	 * @param form Actionform for the form object
	 * @param request Request object 
	 * @param response Response object
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		HttpSession httpSession =request.getSession(true);
		ViewPostForm vpf = (ViewPostForm) form;

		System.out.println(vpf.getPostNum());

		@SuppressWarnings("unchecked")
		List<String> postList = (List<String>) httpSession.getAttribute("postResults");

		httpSession.setAttribute("post", postList.get(Integer.valueOf(vpf.getPostNum())-1));

		return mapping.findForward("viewpost");
	}
}
