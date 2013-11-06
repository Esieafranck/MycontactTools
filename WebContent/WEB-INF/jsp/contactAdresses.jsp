<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html>
<html>
  <head>
    <title>Contact - Adresses</title>
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





    
	<div  class="row">
    	<div class="col-md-12">
    		<div class="panel panel-primary">
  				<div class="panel-heading">
    				<h3 class="panel-title">Information contact</h3>
  				</div>
  				<div class="panel-body">
					<div class="col-md-6 col-lg-offset-3">
						<c:if test="${mode=='edit'}">
							<input type="hidden" id="id" name="id" value="${contact.id}"/>
						</c:if>
						<div class="col-lg-10">
						<h2>Informations personnelles</h2>
    					       
        				</div>   	
						<div class="col-lg-10">
    					Nom :      ${contact.nom}      
        				</div>   	
						<div class="col-lg-10">
    					Prénom :   ${contact.prenom}
    					</div>
  						<div class="col-lg-10">
  						Date de naissance : <fmt:formatDate pattern="dd/MM/yyyy"    value="${contact.dateNaissance}" />    
  						</div>
  						<div class="col-lg-10">
    					Email :      ${contact.email}
    					</div>
    				
    					<div class="col-lg-10">
    					<h2>Adresses</h2>
    					</div>
    					
  

    <table class="table  table-condensed table-striped">
		    <thead>   
			    <tr>
			    	<th>Numéro</th><th>Rue</th><th>Code postal</th><th>Ville</th><th>&nbsp;</th>
			    </tr>
		    </thead>
		    <tbody>



  <c:forEach items="${contact.adresses}" var="adresse" >
    					<tr>
    					
    					<td>      ${adresse.numero}</td>
    					
    					<td>      ${adresse.rue}</td>
    					
    					<td>      ${adresse.codePostal}</td>
    					<td>    ${adresse.ville}</td>
						<td>
						<td>
							<button class="btn btn-default btn-xs glyphicon glyphicon-remove" onclick="window.location='<c:out value="${pageContext.servletContext.contextPath}" />/deleteAdresseAction.html?id=<c:out value="${adresse.id}" />'"></button>
						</td>
						
						</tr>
    					
    </c:forEach>
</table>

    				
					</div>
				</div>
   				<div class="panel-footer">
    
  
  <div  class="row">
    <div class="col-md-12">
        



<div class="panel panel-primary">
  
  
  <div class="panel-heading">
    <h3 class="panel-title">Ajouter adresse</h3>
  </div>
  
  <div class="panel-body">
  <form:form class="form-inline well" role="form" method="post" action="ajouterAdresseAction.html"  commandName="adresseForm">
  

  <div class="form-group ${status.error ? 'has-error' : ''}">
    <label class="sr-only" for="numero">Numéro</label>
    <input type="text" class="form-control" id="numero" name="numero" placeholder="Numéro">
  </div>
  
  
  <div class="form-group ${status.error ? 'has-error' : ''}">
    <label class="sr-only" for="rue">Rue</label>
    <input type="text" class="form-control" id="rue" name="rue" placeholder="Rue">
  </div>
  
  
  <div class="form-group ${status.error ? 'has-error' : ''}">
    <label class="sr-only" for="codePostal">Code postal</label>
    <input type="text" class="form-control" id="codePostal" name="codePostal" placeholder="Code postal">
  </div>
  
    	 
  <div class="form-group ${status.error ? 'has-error' : ''}">
    <label class="sr-only" for="ville">Ville</label>
    <input type="text" class="form-control" id="ville" name="ville" placeholder="Ville">
  </div>  	
  
    	<div class="btn-group">
     		 <button type="submit" class="btn btn-default btn-primary "> <span class="glyphicon glyphicon-saved"></span>&nbsp;Enregistrer</button>
     		  <button type="button" class="btn btn-default"  onclick="window.location='<c:out value="${pageContext.servletContext.contextPath}" />/contactList.html'">Annuler</button>
    	</div>
    <div class="btn-group">
    	<form:errors path="*" cssClass="alert alert-danger" element="div" />    
  	</div>  		
    </form:form> 
  
 
  </div>
  
  </div>
  </div>
  </div>

   </div>
</div>



</div>
</div>
</div>

</body>
</html>	