<?php


try {
    	$conn = new PDO("mysql:host=localhost;dbname=twitter_amin","root","");
    	$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    }
catch(PDOException $e)
    {
    	die("OOPs something went wrong");
    }
 
?>
