<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap 101 Template</title>
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
    

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3.0.0/js/bootstrap.min.js"></script>
  
  
  
  <div class="container" style="background-color: red">
	<div class="row">
		<div class="col-md-12"  style="background-color: blue">
		<h1>Hello</h1>
		</div>	
	</div>
	
	
	<div class="row" >
		<div class="col-md-4" style="background-color: yellow">
		<form >
		<label>Nom</label>
			<input type="text" data-ng-model="firstName" data-ngRequired="true"/>
		<label>Prénom</label>
    		<input type="text" data-ng-model="lastName" data-ngRequired="true"/>
    		<div class="btn-group">
	    		<button  type="button" data-ng-click="deleteAllUsers()" class="btn btn-default glyphicon glyphicon-remove">&nbsp;Clear</button>
	    		<button type="button" data-ng-click="getAllUsers()" class="btn btn-default glyphicon glyphicon-file">&nbsp;Load</button>
	    		<button type="submit" class="btn btn-default btn-primary glyphicon glyphicon-plus active">&nbsp;Add</button>
    		</div>
		</form>
		</div>	
	</div>
	</div>
  
  <jsp:forward page="/contactList.html"></jsp:forward>
</html>