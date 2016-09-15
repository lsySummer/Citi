package edu.nju.action;

import org.springframework.stereotype.Controller;

@Controller
public class PurchaseAction extends BaseAction{
	 public String buy() {
		String propid= request.getParameter("propid");
		String proname= request.getParameter("proname");
		String protype= request.getParameter("protype");
		String proprice= request.getParameter("proprice");
		String priceType=request.getParameter("priceType");
		request.setAttribute("propid", propid);
		request.setAttribute("proname", proname);
		request.setAttribute("protype", protype);
		request.setAttribute("proprice", proprice);
		request.setAttribute("priceType", priceType);
		 return SUCCESS;
	 }
	 
	 public String buyAction(){
		 String value=request.getParameter("submitValue");
		 String pid=request.getParameter("propid");
		 //TODO
		 System.out.println(value+" "+pid);
		 request.setAttribute("tipMessage", "购买成功！");
		 return SUCCESS;
	 }
}
