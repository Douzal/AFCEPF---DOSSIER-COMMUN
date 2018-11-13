$(function() {
	//debut de code js/jquery déclenché dès le chargement de la page
	 $('#btnRechercherBlagues').on('click',function(){
		 //debut de la fonction callback anonyme enregistrée 
		 //sur le click sur le bouton dont l'id est btnRechercherBlagues
		 console.log("click sur btnRechercherBlagues");
		 var valNoteMini = $('#txtNoteMini').val();
		 $.ajax({
			 type : "GET",
			 url : "./rest/blagues" + ((valNoteMini==null) ? "" : "?noteMini="+valNoteMini) ,
			 success: function (data,status,xhr){
				 //dans cette version "jquery" , pas besoin de JSON.parse()
				 //c'est déja déclenché en interne si réponse application/json
				 console.log("data:"+data);
				 var listeBlagues = data; 
				 $('#zoneListe').html("");//vider "<ul></ul>" avant de re-remplir
				 for(var i=0; i< listeBlagues.length; i++){
					 $('#zoneListe').append("<li>"+listeBlagues[i].texte+"</li>");
				 }
				 $('#spanMessage').html(JSON.stringify(listeBlagues));
				 //fin callback en cas de success
			 }
		 });
		 //fin du comportement on click
	 });
	 
	$('#btnAjouterBlague').on('click',function(){
			 //debut de la fonction callback anonyme enregistrée 
			 //sur le click sur le bouton dont l'id est btnAjouterBlague
			 var nouvelleBlague = { titre : "?" , texte : "?" };
			 nouvelleBlague.titre = $('#txtTitre').val();
			 nouvelleBlague.texte = $('#txtTexte').val();
			 
			 $.ajax({
				 type : "POST",
				 url : "./rest/blagues"  ,
				 data : JSON.stringify(nouvelleBlague),
				 dataType : "json",
				 contentType : "application/json",
				 success: function (data,status,xhr){
					 $('#spanMessage').html("blague ajoutee: " + JSON.stringify(data));
				 }
			 });
			 //fin du comportement on click
	 });
	//fin du code js/jquery déclenché dès le chargement de la page
});
