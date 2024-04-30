package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import eventos.ConexionBBDD;

public class MateriaPrima {
	private String Nombre;
	private int IdMateriaPrima;
	private HashMap<Integer, HashMap<Double, Integer>> Stock; //id tabla precios, precio, stock
	
	public MateriaPrima(int IdMateriaPrima, String Nombre, HashMap<Integer, HashMap<Double, Integer>> Stock) {
		this.IdMateriaPrima = IdMateriaPrima;
		this.Nombre = Nombre;
		this.Stock = Stock;
	}
	
	public int getIdMateriaPrima() {
		return IdMateriaPrima;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public int getStock() {
		int retorno = 0;
		for (HashMap<Double, Integer> interno : Stock.values()) {
			for (int valor : interno.values()) {
				retorno += valor;
			}
		}
		return retorno;
	}
	
	public void setStock(int stock) throws SQLException {
		Connection conexion = new ConexionBBDD().init();
		String sql = "UPDATE PrecioMateriaPrima SET Stock = ? WHERE IdPrecio = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, stock);
            statement.setInt(2, this.IdMateriaPrima);
            statement.executeUpdate();
        }
        conexion.close();
	}
	
	

}
