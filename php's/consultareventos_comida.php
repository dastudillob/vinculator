<?php
$hostname_localhost = "localhost";
$database_localhost = "vinculator_bd_externa";
$username_localhost = "root";
$password_localhost ="";
$categoria = $_GET["categorias"];
$preferencias = $_GET["gustos"];
$json=array();
		$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);
		$consulta = "Select * from evento where  descripcion_e like '%{$preferencias}%' ";
		mysqli_set_charset($conexion,"utf8");
		$resultado = mysqli_query($conexion,$consulta);


		while($registro=mysqli_fetch_array($resultado)){
		    $json['spinner'][]=$registro;
	  }
		mysqli_close($conexion);

		echo json_encode($json)

?>