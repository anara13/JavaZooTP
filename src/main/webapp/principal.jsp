<!DOCTYPE html>
<%@page import="org.formation.rasolofoharison.zoo.service.CagePOJO"%>
<%@page import="org.formation.rasolofoharison.zoo.controleur.Zoo"%>
<%@page import="java.util.List"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue DANS le ZOO</title>
<link rel="stylesheet" type="text/css" href="style.css"></link>
</head>
<body>
<header>
<img class="logoGauche" alt="" src="images/logo.png"/>
<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
</header>

<form name="fzoo" action="servlet.html" method="GET">
<nav>
<ul class="m">
	<li class="m"><a href="#" action=<%=Zoo.getInstance().nourrir() %>>TOUT le monde mange (defaut)</a></li>
	<li class="m"><a href="#" onClick="fzoo.submit();">FAIRE manger les animaux selectionnes</a></li>
	<li class="m"><a href="#">Ajouter un animal</a></li>
	<li class="m"><a href="#">Supprimer un animal</a></li>
</ul>
</nav>
<article>

<img alt="mon zoo" src="images/plan.gif">
<%= List<CagePOJO> liste = (List<CagePOJO>) request.getAttribute("modele");
Zoo.getInstance().afficherZoo(liste) %>

<div class="afficheAnimal" >GagaZeleZele 3 ans 48.3 kg</div>
</div>
</article>
<footer>
Etat en temps reel...
</footer>
</form>
</body>
</html>
