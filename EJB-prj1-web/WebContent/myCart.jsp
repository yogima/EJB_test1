<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javax.naming.*, java.util.Properties, java.util.Hashtable, java.util.List"%> 
<%@ page import="com.homework.ejb.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	try{
		final Hashtable jndiProperties = new Hashtable(); 
		
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming"); 
		
		final Context context = new InitialContext(jndiProperties); 
		final String appName = ""; 
		final String moduleName = "EJB-prj1"; 
		final String distinctName = ""; 
		//注意下面两句和之前是不一样的 之前是UserService,现在是ProductCart
		final String beanName = "ProductCartBean";  
		final String viewClassName = ProductCartRemote.class.getName(); 
		final String namespace = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful";
		
		ProductCartRemote cart = null; 
		cart = (ProductCartRemote)session.getAttribute("cart"); 
		if(cart == null){ 
			cart = (ProductCartRemote) context.lookup(namespace); 
			session.setAttribute("cart",cart); 
		}else{ 
			String productName=request.getParameter("product"); 
			String sPrice=request.getParameter("price");
			int price=0; 
			if(sPrice!=null) 
				price=Integer.parseInt(sPrice); 
			cart.addProduct(productName, price);
			List<String> myProducts = cart.listProducts(); 
			out.println("Total Price:"+cart.totalPrice()+"<br>"); 
			out.println("My Products:<br>"+myProducts);
		}

	}catch(NamingException e){
		e.printStackTrace();
	}
%>

<table border=1>
	<tr><td><a href="myCart.jsp?product=fridge&price=3000">fridge buy</a></td></tr> 
	<tr><td><a href="myCart.jsp?product=ledtv&price=5000">ledtv buy</a></td></tr> 
	<tr><td><a href="myCart.jsp?product=waterheater&price=2800">waterheater buy</a></td></tr> 
	<tr><td><a href="myCart.jsp?product=car&price=300000">car buy</a></td></tr>
</table>
</body>
</html>