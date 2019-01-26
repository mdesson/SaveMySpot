

function validity(){
  var input = document.getElementById("courseSubject").value;
  var input2 = document.getElementById("courseNb").value;

  if((validateSubject(input) == true) && (validateCourse(input2) == true)){
    alert('Submit button pressed' + input + " and " + input2);
    window.open('mailto:test@example.com');
    return false;
  }
}

//check if the input for Course Subject is a 4 letter word
function validateSubject(input){
  var letters = /^[A-Za-z]+$/i;
  if((input.length == 4) && (input.match(letters))){
    return true;
  }
  else{
    alert("Please enter a valid course subject!");
    return false; 
  }
}

//check if the input for Course Subject is a 3 integers or more
function validateCourse(input2){
  if((input2.length > 2) && (isNaN(input2) == false)){
    return true;
  }
  else{
    alert("Please enter a valid course number!");
    return false; 
  }
}
