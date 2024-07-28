<!doctype html>
<head> </head>
<title> MyScript </title>

<body>
<?php
    $first_name = $_POST["firstName"];
    echo "Hello, " . $first_name . " " . "the server has received your form submission successfully";
?>
<hr>

<?php
    $first_name = $_POST["firstName"];
    $last_name = $_POST["lastName"];

    echo "Welcome " . $first_name . " " . $last_name . "<br>";
?>

<?php
    $email = $_POST["email"];
    echo "Your email address is: " . $email . "<br>";
?>

<?php
    $major = $_POST["program"];
    echo "Your Program is: " . $major . "<br>";
?>

<?php
    $year = $_POST["year"];
    echo "You are in year: " . $year . "<br>";

?>

<?php
    echo "Your Hobbies: ";
    foreach($_POST["hobby"] as $value){
        echo $value." ";
    }
    echo "<br>";
?>
    
<?php
    $comment = $_POST["comment"];
    echo "Your Comments: " . $comment . "<br>";
?>
<hr>

<?php
    echo "Good Luck with your studies in the 23SU term, " . $first_name. "<br>";

?>

</body>
</html>