package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import eventos.ConexionBBDD;

public class Producto {
	private String Nombre;
	private int Stock;
	private double Beneficio;
	private int IdProducto;
	private HashMap<MateriaPrima, Integer> Materiales;
	
	public Producto(int IdProducto, String Nombre, int Stock, double Beneficio, HashMap<MateriaPrima, Integer> Materiales) {
		this.Nombre = Nombre;
		this.Stock = Stock;
		this.Beneficio = Beneficio;
		this.IdProducto = IdProducto;
		this.Materiales = Materiales;
	}
	
	public double getBeneficio() {
		return Beneficio;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public int getStock() {
		return Stock;
	}
	
	public int getIdProducto() {
		return IdProducto;
	}
	
	public HashMap<MateriaPrima, Integer> getMateriales() {
		HashMap<MateriaPrima, Integer> retorno = new HashMap<>(Materiales);
		return retorno;
	}
	
	public void setStock(int stock) throws SQLException {
		Connection conexion = new ConexionBBDD().init();
		String sql = "UPDATE Producto SET Stock = ? WHERE IdProducto = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, stock);
            statement.setInt(2, this.IdProducto);
            statement.executeUpdate();
        }
        conexion.close();
	}
	

}
