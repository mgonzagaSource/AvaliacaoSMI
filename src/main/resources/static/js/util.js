/* scripts paras mascaras */

function mascaraDataMysql(){

      tecla = event.charCode;
	  
	  str = document.getElementById("txtvenc").value;
	  
	  tam = str.length;
	  
	  console.log("tecla " + tecla);
	  if ( tecla < 48 || tecla > 57){
	     
	      return false;
	  }
	  else{
	   montarmascaraData();
	   return true;
	   }
}

function montarmascaraData(){

       s = document.getElementById("txtvenc").value;
	   t = s.length;
	   
	   switch(t){
	    
		   case 4:
		      s = s + "-"
		      document.getElementById("txtvenc").value = s;
		   break;
		   
		   case 7:
		      s = s + '-';
		      document.getElementById("txtvenc").value = s;
		   break;
	   }
}

function mascaraCnpj(){

    tecla = event.charCode;
	  
	  str = document.getElementById("txtcnpj").value;
	  
	  tam = str.length;
	  
	  console.log("tecla " + tecla);
	  if ( tecla < 48 || tecla > 57){
	     
	      return false;
	  }
	  else{
		  montarCnpj();
	   return true;
	   }
}

function montarCnpj(){

	   s = document.getElementById("txtcnpj").value;
	   t = s.length;
	   console.log("s " + s);
	   console.log("t " + t);
	   
	   switch(t){
	    
		   case 2:
		      s = s + "."
		      document.getElementById("txtcnpj").value = s;
		   break;
		   
		   case 6:
		      s = s + '.';
		      document.getElementById("txtcnpj").value = s;
		   break;
		   
		   case 10:
		      s = s + '/';
		      document.getElementById("txtcnpj").value = s;
		   break;
		   
		   case 15:
		      s = s + '-';
		      document.getElementById("txtcnpj").value = s;
		   break;
	   }
}
