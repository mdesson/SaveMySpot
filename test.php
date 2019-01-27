<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
    
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="saveMySpot.css">
    <script type = "text/javascript" src="saveMySpot.js"></script>
    <title>Save My Spot</title>
</head>

<body id="bg">


<div class='table'>
 
    <div class='cell'>
 
        <div class="container">
 
            <form id="login" method="post" action="index.php" onsubmit="validity(); return false">
                <img src="pictures/help_icon.png" title="Help" alt="Help" class="icon" onclick="alert('Welcome to SaveMySpot for Concordia!\nThis website is to help you get notifications on classes you are interested to join.\nEnter the required information to receive a daily email about the interested class.')">  
                <br/>
                        <label class="containerInput">Enter Your Email:</label> <br />
                        <input class="inputBox" required="required" type="email" id="emailCR" name="email"/> <br />
                        <label class="containerInput">Enter Course Subject :</label> <br />
                         <input class="inputBox" required="required" type="text" id="courseSubject" name="courseSubject"/>
                         <br />
                         <label class="containerInput">Course  Number :</label><br />
                         <input class="inputBox" required="required" type="text" id="courseNb" name="courseNb"/>
                         <br />
                         <input class="button" type="submit" name="Submit" onsubmit="index.php; return false"> 
                         <input class="button" type="reset" value="Cancel"/>
                     </form>
                 </div>
             </div>
         </div>
         <div class="footer">
  <p>Powered by SaveMySpot</p>
</div>

<?php
echo "Hi";

$servername = "localhost:3306";
$username = "root";
$password  = "";
$email = $_POST['emailCR'];
$courseSubject = $_POST['courseSubject'];
$courseNb = $_POST['courseNb'];


try {
    $conn = new PDO("mysql:host=$servername;dbname=savemyspot", $username, $password);

    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $sql = "INSERT INTO classStudentList ('Email', 'Waitlist', 'Course_Catalog', 'Course_Code', 'Email_sent')
    VALUES ($email, '1', $courseSubject, $courseNb, '0'))";
    }
    catch(PDOException $e)
    {
        echo $sql . "<br>" . $e->getMessage();
    }

 // use exec() because no results are returned
    $conn->exec($sql);
    echo "New record created successfully";
    
    


// Connection closes automatically at end of script
// To close with PDO set it to null
$conn = null;
?>

</body>
</html>