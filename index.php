<?php
	// if (!empty($_SERVER['HTTPS']) && ('on' == $_SERVER['HTTPS'])) {
	// 	$uri = 'https://';
	// } else {
	// 	$uri = 'http://';
	// }
	// $uri .= $_SERVER['HTTP_HOST'];
	// header('Location: '.$uri.'/dashboard/');
	// exit;
	$email = filter_input(INPUT_POST, 'email');
	$subject = filter_input(INPUT_POST, 'courseSubject');
	$nb = filter_input(INPUT_POST, 'courseNb');


	$host = "localhost";
	$username = "root";
	$password = "";
	$database = "savemyspotConcordia";$mysqli = new mysqli($host, $username, $password, $database);
	if ($mysqli->connect_errno) {
	echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
	}else{
		$sql = "INSERT INTO StudentCourseList (Email, Waitlist, Course_Catalog, Course_Code, Email_Sent)
		values ('$email', '0', '$subject', '$nb', '0')";
		if ($mysqli->query($sql)){
			echo "New record is inserted successfully";
		}
		else{
			echo "Error: ". $sql . "<br>". $mysqli->error;
		}
	}$mysqli->close();
?>
