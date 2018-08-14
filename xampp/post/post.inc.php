<?php

     include ("config.inc.php");

   $params="amin";




    // Check whether username or password is set from android
     if(isset($_POST['post']) && isset($_POST['author']))
     {

          // Innitialize Variable
	   	  $post = $_POST['post'];
          $author = $_POST['author'];

		  // Query database for row exist or not
          //$sql = 'SELECT * FROM login WHERE  username = :username AND password = :password';
          $sql = 'INSERT INTO `post`(`post`, `author`) VALUES (:post,:author)';
          $stmt = $conn->prepare($sql);
          $stmt->bindParam(':post', $post, PDO::PARAM_STR);
          $stmt->bindParam(':author', $author, PDO::PARAM_STR);
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