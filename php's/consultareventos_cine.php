<?php
$hostname_localhost = "localhost";
$database_localhost = "vinculator_bd_externa";
$username_localhost = "root";
$password_localhost ="";
$preferencias = $_GET["gustos"];
$json=array();
		$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);
		$consulta = "select * from evento where cod_cat = 'CI' and nom_even like '%{$preferencias}%' or descripcion_e like '%{$preferencias}%' or cod_even = any(select cod_even from even_gen where cod_gen = (select cod_gen from genero where nom_gen like '%{$preferencias}%' LIMIT 0,1)); ";
		mysqli_set_charset($conexion,"utf8");
		$resultado = mysqli_query($conexion,$consulta);


		while($registro=mysqli_fetch_array($resultado)){
		    $json['spinner'][]=$registro;
	  }
		mysqli_close($conexion);

		echo json_encode($json)

?>