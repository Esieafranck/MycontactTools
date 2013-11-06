<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html>
<html>
  <head>
    <title>Ajouter - modifier Contact</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="bootstrap-3.0.0/css/bootstrap.min.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    

    
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3.0.0/js/bootstrap.min.js"></script>
  
  
  
  <div class="container">	
	
	<div class="row" >
		
		<div class="panel panel-primary">
  
  
  <div class="panel-heading">
    <h3 class="panel-title">Ajouter un contact</h3>
  </div>
  
  <div class="panel-body">
  
		<div class="col-md-6 col-lg-offset-3">
		
	<form:form class="form-horizontal" role="form" method="post" action="ajouterContactAction.html?mode=${mode}"  commandName="contactForm">
	<c:if test="${mode=='edit'}">
		<input type="hidden" id="id" name="id" value="${contact.id}"/>
	</c:if>
	
	<spring:bind path="nom">
	<div class="form-group ${status.error ? 'has-error' : ''}">
    <label for="nom" class="col-lg-2 control-label">Nom</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom"   ${mode=='edit' ? 'readonly ' : ''} value='${contact.nom}'/>      
    </div>    
  </div>
  
    </spring:bind>
	<spring:bind path="prenom">
	<div class="form-group ${status.error ? 'has-error' : ''} ">
    <label for="prenom" class="col-lg-2 control-label">Prénom</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" ${mode=='edit' ? 'readonly ' : ''} value="${contact.prenom}"/>
    </div>
  </div>
  </spring:bind>
  <div class="form-group">
    <label for="dateNaissance" class="col-lg-2 control-label">Date de naissance</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="dateNaissance"  name="dateNaissance" placeholder="jj/mm/aaaa" ${mode=='edit' ? 'readonly' : ''} 
      value='<fmt:formatDate pattern="dd/MM/yyyy" 
            value="${contact.dateNaissance}" />'>
    </div>
  </div>
  
  
	<spring:bind path="email">
  <div class="form-group ${status.error ? 'has-error' : ''}">
    <label for="email" class="col-lg-2 control-label">Email</label>
    <div class="col-lg-10">
      <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${contact.email}">
    </div>
  </div>
    </spring:bind>
  <div class="form-group">
    <div class="col-lg-offset-2 col-lg-10">
    	<div class="btn-group">
     		 <button type="submit" class="btn btn-default btn-primary "> <span class="glyphicon glyphicon-saved"></span>&nbsp;Enregistrer</button>
     		  <button type="button" class="btn btn-default"  onclick="window.location='<c:out value="${pageContext.servletContext.contextPath}" />/contactList.html'">Annuler</button>
    	</div>
    </div>
  </div>
  
  	<form:errors path="*" cssClass="alert alert-danger col-lg-offset-2 col-lg-10" element="div" />  	
  
  
</form:form>
	</div>
	</div>
  </div>
		
		
	</div>
	</div>
  
  
</html>