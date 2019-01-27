

function validity(){
  var courseSubject = document.getElementById("courseSubject").value;
  var courseNb = document.getElementById("courseNb").value;
  var email = document.getElementById("emailCR").value;


  if((validateSubject(courseSubject) == true) && (validateCourse(courseNb) == true)){
    alert('Form was sent! For ' + courseSubject + " and " + courseNb + " for the email " + email );
    return false;
  }
}

//check if the input for Course Subject is a 4 letter word
function validateSubject(courseSubject){
  var letters = /^[A-Za-z]+$/i;
  if((courseSubject.length == 4) && (courseSubject.match(letters))){
    return true;
  }
  else{
    alert("Please enter a valid course subject!");
    return false; 
  }
}

//check if the input for Course Subject is a 3 integers or more
function validateCourse(courseNb){
  if((courseNb.length > 2) && (isNaN(courseNb) == false)){
    return true;
  }
  else{
    alert("Please enter a valid course number!");
    return false; 
  }
}
