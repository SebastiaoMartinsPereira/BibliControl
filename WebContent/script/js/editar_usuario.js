

  function EditarUsuario(){
	  Inicializar();
  };
  
  this.Inicializar = function(){
	  alert("bom dia");
  };
  
  function GetQueryStringParams(sParam)
  {
      var sPageURL = window.location.search.substring(1);
      var sURLVariables = sPageURL.split('&');
      for (var i = 0; i < sURLVariables.length; i++) 
      {
          var sParameterName = sURLVariables[i].split('=');
          if (sParameterName[0] == sParam) 
          {
              return sParameterName[1];
          }
      }
  };
  