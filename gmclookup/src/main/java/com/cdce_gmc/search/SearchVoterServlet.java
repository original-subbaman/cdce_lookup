package com.cdce_gmc.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdce_gmc.db.VoterDao;
import com.cdce_gmc.model.*;
import java.util.*;
/**
 * Servlet implementation class SearchVoterServlet
 */
public class SearchVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchVoterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); 
		String relation = request.getParameter("relation");
		String epic = request.getParameter("epic"); 
		String ward = request.getParameter("ward"); 
		
		HttpSession session = request.getSession(); 
		
		if(!name.isBlank() || !name.isEmpty() ||
				!epic.isBlank() || !epic.isEmpty() || !relation.isBlank() || !relation.isEmpty()) {
			//query db
			HashMap<String, String> searchStrings = addToHashMap(name, relation, epic, ward); 
			List<Voter> voterList = VoterDao.getInstance().getVoter(searchStrings, ward); 
			if(voterList.size() > 0) {
				//add to session object; 
				session.setAttribute("result", voterList);
				session.setAttribute("search_success", true); 
				session.setAttribute("empty_input", false);
			}else {
				//return none; 
				session.setAttribute("result", voterList);
				session.setAttribute("search_success", false);	
				session.setAttribute("empty_input", false);
			}
		}else {
			//return with error
			session.setAttribute("empty_input", true);
			session.setAttribute("search_success", false);
		}
				
		response.sendRedirect("index.jsp");
	}
	
	public HashMap<String, String> addToHashMap(String name, String relation, String epic, String ward){
		HashMap<String, String> map = new HashMap<String, String>(); 
		map.put("name", name); 
		map.put("relation", relation); 
		map.put("epic", epic); 
		map.put("ward", ward); 
		return map; 
	}

}
