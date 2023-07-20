<?php
$hostname_localhost = "localhost";
$database_localhost = "vinculator_bd_externa";
$username_localhost = "root";
$password_localhost ="";

$json=array();
		$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);
		$consulta = "select nom_gen from genero where cod_cat = 'CI' order by nom_gen";
		mysqli_set_charset($conexion,"utf8");
		$resultado = mysqli_query($conexion,$consulta);

		while($registro=mysqli_fetch_array($resultado)){
			$json['generos'][]=$registro;
		}
		mysqli_close($conexion);
		echo json_encode($json)

?>