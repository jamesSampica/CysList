package com.web.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.HibernateUtil;

public class SearchAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Setup vars.
		SearchForm sForm = (SearchForm) form;
		List<Post> posts = null;
		List<Post> search_results = new ArrayList<Post>();

		// If topic is all, get all posts.  Otherwise get all posts for a specific topic.
		if (sForm.getCategory().equals("all")) {
			posts = HibernateUtil.getAllPosts();
		} else {
			posts = HibernateUtil.getAllPostsByTopic(sForm.getCategory());
		}

		// Filter the posts by the searched for value.
		for (Post p : posts) {
			if (p.getTitle().contains(sForm.getValue().toLowerCase())) {
				search_results.add(p);
			}
		}
		
		request.getSession().setAttribute("postResults", search_results);
		request.getSession().setAttribute("postResultsSize", search_results.size());
		return mapping.findForward("success");
	}
}
