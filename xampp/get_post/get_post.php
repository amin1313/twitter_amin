<?php
include ("connect.php");
//$sql="select * from post;";
$sql="SELECT `post`, `author` FROM `post`";
$result=$connect->query($sql);

$response['post']=array();

foreach($result as $rows)
{
    array_push( $response['post'] , $rows );
}
echo json_encode($response,JSON_PRETTY_PRINT);
/*while($rows=$result->fetch(PDO::FETCH_ASSOC))
{
	echo $rows["name"]."<br>";
}*/
?>