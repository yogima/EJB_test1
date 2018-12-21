<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javax.naming.*, java.util.Properties, java.util.Hashtable"%> 
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
		
		//jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming"); 
		
		final Context context = new InitialContext(jndiProperties); 
		final String appName = ""; 
		final String moduleName = "EJB-prj1"; 
		final String distinctName = ""; 
		final String beanName = "UserService"; 
		final String viewClassName=UserServiceRemote.class.getName(); 
		final String namespace = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName; 
		
		UserServiceRemote usBean =(UserServiceRemote) context.lookup(namespace);
		System.out.println(usBean); 
		if(usBean.login("zjut","zjut")) 
			out.println("login ok!");
		else 
			out.println("login failed!");

	}catch(NamingException e){
		e.printStackTrace();
	}
%>

</body>
</html>