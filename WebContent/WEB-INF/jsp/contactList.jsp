<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Gestion des contacts</title>
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
    <script>
    function recherche(){
    var nom=document.getElementById('nom');
    var prenom=document.getElementById('prenom');
    var email=document.getElementById('email');
    
    window.location='<c:out value="${pageContext.servletContext.contextPath}" />/contactList.html?nom='+nom.value+'&prenom='+prenom.value+'&email='+email.value;
    }
    </script>
    
    
    
    <div class="container">
    
<div  class="row">
    <div class="col-md-12">
        



<div class="panel panel-primary">
  
  
  <div class="panel-heading">
    <h3 class="panel-title">Critères de recherche</h3>
  </div>
  
  <div class="panel-body">
  <div class="form-inline well" role="form">
  <div class="form-group">
    <label class="sr-only" for="nom">Nom</label>
    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom">
  </div>
  <div class="form-group">
    <label class="sr-only" for="prenom">Prénom</label>
    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom">
  </div>
  <div class="form-group">
    <label class="sr-only" for="email">Email</label>
    <input type="email" class="form-control" id="email" name="email" placeholder="email">
  </div>
    	 
    		
    	</div> 
  </div>
  
  </div>
  </div>
  </div>

 <div  class="row">
    <div class="col-md-12">
        



<div class="panel panel-primary">
  
  
  <div class="panel-heading">
    <h3 class="panel-title">La liste des contacts</h3>
  </div>
  
  <div class="panel-body">
    <table class="table  table-condensed table-striped">
		    <thead>   
			    <tr>
			    	<th>Id </th><th>Nom</th><th>Prénom</th><th>Email</th><th>Date de naissance</th><th>#</th>
			    </tr>
		    </thead>
		    <tbody>



  <c:forEach items="${contacts}" var="contact" >
 
    <tr>
    
    <td>  ${contact.key}  </td>
    <td>  ${contact.value.nom}  </td>
    <td>  ${contact.value.prenom}  </td>
    <td>  ${contact.value.email}  </td>
    <td> <fmt:formatDate pattern="dd/MM/yyyy" 
            value="${contact.value.dateNaissance}" />   </td>
    <td>
				<button class="btn btn-default btn-xs glyphicon glyphicon-remove" onclick="window.location='<c:out value="${pageContext.servletContext.contextPath}" />/rudContactAction.html?id=<c:out value="${contact.key}" />&action=delete'"></button>
				<button class="btn btn-default btn-xs glyphicon glyphicon-pencil" onclick="window.location='<c:out value="${pageContext.servletContext.contextPath}" />/rudContactAction.html?id=<c:out value="${contact.key}" />&action=update'"></button>
				<button class="btn btn-default btn-xs glyphicon glyphicon-book" onclick="window.location='<c:out value="${pageContext.servletContext.contextPath}" />/rudContactAction.html?id=<c:out value="${contact.key}" />&action=display'"></button>
	</td>
        
    </tr>
   </c:forEach>
</table>
  </div>
   <div class="panel-footer">
    
  
  <div class="btn-group">
  <button type="button" class="btn btn-default btn-primary" onclick="window.location='<c:out value="${pageContext.servletContext.contextPath}" />/ajouterContactForm.html?mode=create'">Ajouter</button>
  <button type="button" class="btn btn-default "  onclick="window.location='<c:out value="${pageContext.servletContext.contextPath}" />/rudContactAction.html?action=deleteAll'">Supprimer tout</button>
  <button type="button" class="btn btn-default "  onclick="recherche();">Rechercher</button>
</div>

   </div>
</div>



</div>
</div>
</div>

</body>
</html>