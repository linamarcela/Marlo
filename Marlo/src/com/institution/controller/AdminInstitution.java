package com.institution.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.institution.dao.InstitutionDAO;
import com.institution.model.Institucion;
import com.institution.model.InstitutionType;
import com.institution.model.LocElements;
import com.institution.model.Location;

/*
 * @autor: Lina Marcela Colorado Vivas
 * Ingteniera de sistemas
 * Servlet implementation class AdminInstitution
 */

@WebServlet("/institutions")
public class AdminInstitution extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InstitutionDAO institutionDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			institutionDAO = new InstitutionDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminInstitution() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "mostrarInstitution":
				mostrarInstitution(request, response);
				break;
			case "showedit":				
				showEditar(request, response);
				break;
			case "edit":				
				edit(request, response);
				break;
			case "showLocations":				
				showLocations(request, response);
				break;			
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		doGet(request, response);
	}
	
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{		
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	//consult institutions
	private void mostrarInstitution(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{	
		System.out.println("ingresa mostrarInstitution");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrarInstitution.jsp");		
		List<Institucion> listInstitucion= institutionDAO.listInstitucion();		
		request.setAttribute("list", listInstitucion);		
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {		
		Institucion institution = institutionDAO.getInstitutionId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("institution", institution);
		
		List<Location> listLocations= institutionDAO.listLocations(Integer.parseInt(request.getParameter("id")));		
		request.setAttribute("list", listLocations);	
		
		List<InstitutionType> listInstitutionType= institutionDAO.listInstitutionType();		
		request.setAttribute("listInts", listInstitutionType);
		
		List<Location> listLocationSel= institutionDAO.listLocations();		
		request.setAttribute("listSel", listLocationSel);
		
		List<LocElements> listElements= institutionDAO.listElements();		
		request.setAttribute("listEle", listElements);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Institucion institution = new Institucion(Integer.parseInt(request.getParameter("id")), request.getParameter("acronym"), request.getParameter("nam"), request.getParameter("web"), request.getParameter("insti"));
		institutionDAO.update(institution);
		System.out.print("idLoca"+request.getParameter("idLoca"));
		if (!request.getParameter("loca").isEmpty())		
		{			
			institutionDAO.insertLocation(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("elem")), request.getParameter("loca"));
			showEditar(request, response);
		}else if(!request.getParameter("idLoca").isEmpty())
		{
			institutionDAO.DeleteLocation(Integer.parseInt(request.getParameter("idLoca")));
			showEditar(request, response);
		}
		else {
			mostrarInstitution(request, response);
		}
		
	}
	
	private void showLocations(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/showLocation.jsp");		
		List<Location> listLocation= institutionDAO.listLocations();		
		request.setAttribute("list", listLocation);		
		dispatcher.forward(request, response);
	}
}
