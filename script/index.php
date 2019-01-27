<?php

	//variables declaration
	$errorCourse = $errorNb  = $allGood = false;
	$courseErr = $NnbError = "";
	$pattern = '/^[A-Za-z]{4}+$/';

	$email = filter_input(INPUT_POST, 'email');
	$subject = filter_input(INPUT_POST, 'courseSubject');
	$nb = filter_input(INPUT_POST, 'courseNb');
	$waitlist = filter_input(INPUT_POST, 'selectionBox');

	if ($_SERVER["REQUEST_METHOD"] == "POST") {
	//check if course subject is a 4 letter word
		if(preg_match($pattern, $subject)){
			$errorCourseSubject = false;
		}
		else{
			$errorCourseSubject = true;
		}
	//check if course number is a 3 digits
		if(preg_match('/^[0-9]{3}+$/', $nb)){
			$errorCourseNumber = false;
		}
		else{
			$errorCourseNumber = true;
		}
	//checks if everything is valid to send the form
		if(($errorCourseNumber == false) && ($errorCourseSubject == false)){
			$allGood = true;
		}
	}

	if($allGood == true){
		$host = "localhost";
		$username = "root";
		$password = "";
		$database = "savemyspotConcordia";$mysqli = new mysqli($host, $username, $password, $database);
		if ($mysqli->connect_errno) {
			echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
		}
		else{
			$sql = "INSERT INTO StudentCourseList (Email, Waitlist, Course_Catalog, Course_Code, Email_Sent)
			values ('$email', '$waitlist', '$subject', '$nb', '0')";
			if ($mysqli->query($sql)){
				echo "You will receive an email shortly confirming your subscription.";
			}
			else{
				echo "Error: ". $sql . "<br>". $mysqli->error;
			}
		}$mysqli->close();
	}
	else{
		if ($errorCourseNumber = true || $errorCourseSubject = true) {
			echo "Record not added. Error detected.";
		}
	}
?>
