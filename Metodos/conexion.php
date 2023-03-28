<?php
  $mysql = new mysqli("localhost", "root", "", "MyUca");
    if($mysql->connect_error){
        echo "error: ";
        die("Error de conexion");
    }
    else {
        echo "La conexion es exitosa";
    }
?>