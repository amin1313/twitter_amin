<?php
try
{
$connect=new PDO("mysql:host=localhost;dbname=twitter_amin","root","");
return $connect;
}
catch(PDOException $error)
{
echo "Error in Connect";	
}
?>

