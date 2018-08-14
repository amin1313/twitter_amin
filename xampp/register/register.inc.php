<?php

     include ("config.inc.php");

   $params="amin";




    // Check whether username or password is set from android
     if(isset($_POST['username']) && isset($_POST['password']))
     {

          // Innitialize Variable
	   	  $username = $_POST['username'];
          $password = $_POST['password'];

		  // Query database for row exist or not
          //$sql = 'SELECT * FROM login WHERE  username = :username AND password = :password';
          $sql = 'INSERT INTO `login`(`username`, `password`) VALUES (:username,:password)';
          $stmt = $conn->prepare($sql);
          $stmt->bindParam(':username', $username, PDO::PARAM_STR);
          $stmt->bindParam(':password', $password, PDO::PARAM_STR);
          $stmt->execute();
          if($stmt->rowCount())
          {
              $params="TRUE";
          }
          elseif(!$stmt->rowCount())
          {
              $params="ERROR";
          }

  	}


  	echo $params;
    //echo json_encode($params,JSON_PRETTY_PRINT);

	
?>