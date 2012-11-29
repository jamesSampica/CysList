package com.web.userPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import util.HibernateUtil;

public class DeletePostAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        HttpSession httpSession = request.getSession(true);

        HibernateUtil.deletePostByKey(httpSession.getAttribute("postkey").toString());

		return mapping.findForward("deletesuccess");
    }
}
