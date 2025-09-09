package negocio;

import java.util.ArrayList;
import java.util.List;
import javabean.Familia;
import javabean.Producto;
import javabean.Proveedor;

public class CatalogoProductosImpl implements ICatalogo{
	
	private ArrayList<Producto> Lista;
	
	

	public CatalogoProductosImpl() {
		Lista = new ArrayList<Producto>();
		cargarDatos();
	}

	private void cargarDatos() {
		
		Familia familia = new Familia(1,"Normal");
		Proveedor proveedor = new Proveedor("101", "Carlos", "Ventas", "b@b.es", "España");
		
		Lista.add(new Producto(1, "Camiseta", "Camiseta negra hombre talla M", "Nike", "Negro", 40.00, familia , proveedor));
		Lista.add(new Producto(2, "Pantalón", "Pantalón de Hombre negro", "Levi's", "Azul", 60.00,familia , proveedor));
		Lista.add(new Producto(3, "Zapatillas", "Zapatillas deportivas de Mujer talla 37", "Adidas", "Blanco", 80.00,familia , proveedor));
		Lista.add(new Producto(4, "Sudadera", "Sudadera con capucha de mujer", "Puma", "Gris", 55.00,familia , proveedor));
		Lista.add(new Producto(5, "Chaqueta", "Chaqueta de cuero de mujer talla M", "Zara", "Negro", 120.00, familia , proveedor));

	}

	@Override
	public Producto buscarUno(long idProducto) {
		// TODO Auto-generated method stub
		for (Producto p : Lista) {
            if (p.getIdProducto() == idProducto) {
                return p;
            }
        }
        return null;
    }
	
	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return Lista;
	}

	@Override
	public List<Producto> productosPorFamilia(int idFamilia) {
		// TODO Auto-generated method stub
		List<Producto> aux = new ArrayList<>();
        for (Producto p : Lista) {
        	if (p.getFamilia().getIdFamilia() == idFamilia) {
                aux.add(p);
            }
        }
        return aux;
    }

	@Override
	public List<Producto> productosPorPrecioMayorQue(double precio) {
		// TODO Auto-generated method stub
		List<Producto> aux = new ArrayList<>();
        for (Producto p : Lista) {
            if (p.getPrecio() > precio) {
                aux.add(p);
            }
        }
        return aux;
    }

	@Override
	public List<Producto> productosPorDescripcionLarga(String subCadena) {
		// TODO Auto-generated method stub
		List<Producto> aux = new ArrayList<>();
        for (Producto p : Lista) {
            if (p.getDescripcionLarga().contains(subCadena)) {
                aux.add(p);
            }
        }
        return aux;
    }

	@Override
	public List<Producto> productosPorProveedor(String cif) {
		// TODO Auto-generated method stub
		List<Producto> aux = new ArrayList<>();
        for (Producto p : Lista) {
        	if (p.getProveedor().getCif().equalsIgnoreCase(cif)) {
                aux.add(p);
            }
        }
        return aux;
    }

	@Override
	public boolean altaProducto(Producto producto) {
		// TODO Auto-generated method stub
		if (Lista.contains(producto)) {
            return false;  
        }
        Lista.add(producto);
        return true;
    }

	@Override
	public boolean eliminarProducto(long idProducto) {
		// TODO Auto-generated method stub
		Producto p = buscarUno(idProducto);
	    Lista.remove(p);
	    return true;
	}

	@Override
	public boolean modificarProducto(Producto producto) {
		// TODO Auto-generated method stub
		int posicion = Lista.indexOf(producto);
        if (posicion != -1) {
            Lista.set(posicion, producto);
            return true;
        }
        return false;
    }


	
}


