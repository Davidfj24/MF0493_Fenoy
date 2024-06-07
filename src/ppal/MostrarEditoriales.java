package ppal;

public class MostrarEditoriales {

public static void main(String[] args) {
		
		ConexionBD conexion = new ConexionBD();
		
		
		System.out.println("Conectando a la base de datos...");
		// Paso 1. Obtener la conexion
		Connection con =conexion.getConexion();
		
		//Objetos necesarios para hacer una consulta
		Statement sentencia = null;
		ResultSet resultado = null;
		
		// Algún procesamiento con la base de datos
		// Paso 2. Obtener el Statement
		try {
			sentencia=con.createStatement();
			
			// Paso 3. Ejecutar sentencia
			resultado=sentencia.executeQuery("select * from editoriales");
			System.out.println("Anio\t Codigo Editorial\t Nombre");
			
			
			// Paso 4. Recorrer el resultado
			while(resultado.next()) {
				int codEditorial = resultado.getInt("codEditorial");
				String nombre = resultado.getString("nombre");
				int anio = resultado.getInt("anio");
				
				
				System.out.println(codEditorial+"\t"+nombre+"\t"+anio);
				}
			
		} catch (SQLException e) {
			System.out.println("Error al consultar los datos. "+e.getMessage());
		}	finally {
			try {
				resultado.close();
				sentencia.close();
			} catch (SQLException e) {
				System.out.println("Error al liberar los recursos");
			}
		}
		
		
		// Liberamos la conexion
		
		System.out.println("Desconectando de la base de datos");
		conexion.desconectar();
	}





		
	}

	
	
}
