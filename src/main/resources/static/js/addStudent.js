// A $( document ).ready() block.
$( document ).ready(function() {
    console.log( "ready!" );
   // alert("Hello")
});



$(function() { //shorthand document.ready function
    $('#addStudent').on('submit', function(e) { 
		 
		 debugger;
		 
		 var name=document.getElementById("Name").value;
		 
		 if(name==""){
			 $("#nameError").text("Please enter name");
		 }
		 
		 var mail=document.getElementById("Email").value;
		 var flag2= looksLikeMail(mail);
		 
		 if(flag2==false){
			 $("#emailError").text("Please enter valid email id");
		 }
	  
	     var flag1=isValidString(name);
	     debugger;
	     if(flag1==false){
			  e.preventDefault();
			 return false
		 }
		 return true;
       
       
    });
});

function looksLikeMail(str) {
    var lastAtPos = str.lastIndexOf('@');
    var lastDotPos = str.lastIndexOf('.');
    return (lastAtPos < lastDotPos && lastAtPos > 0 && str.indexOf('@@') == -1 && lastDotPos > 2 && (str.length - lastDotPos) > 2);
}





function isValidString(str1) {
	debugger;
  return str1 != null && typeof str1 === "string" && str1.length > 0;
}