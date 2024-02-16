package es.iessoterohernandez.daw.endes.ShoppingCart;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit test for simple App.
 */
public class ShoppingCartTest{
	
	private ShoppingCart sc;
	private Product p1,p2;
	
	@BeforeEach
	public void constructorShoppingCart() {
		sc= new ShoppingCart();
		p1= new Product("Reloj",89.99);
		p2= new Product("Pulsera",45.36);
	}
	
	@Test
	public void ceroElementos() {
		assertEquals(0, sc.getItemCount());
	}
	
	@Test
	public void carroVacio() throws ProductNotFoundException {
		sc.addItem(p1);
		sc.empty();
		assertEquals(0,sc.getItemCount());
		
	}
	
	@Test
	public void sumaProducto() {
		int num= sc.getItemCount()+1;
		sc.addItem(p2);
		
		assertEquals(num,sc.getItemCount());
		
	}
	
	@Test
	public void balance() {
		double nuevoBalance= sc.getBalance()+p1.getPrice();
		sc.addItem(p1);
		
		assertEquals(nuevoBalance,sc.getBalance());
		
	}
	
	@Test
	public void restaProducto() throws ProductNotFoundException {
		sc.addItem(p2);
		int num= sc.getItemCount()-1;
		sc.removeItem(p2);
		
		assertEquals(num,sc.getItemCount());
		
	}
	
	
	@Test
	public void borrarElemento(){
	   
	    
	    try {
	        sc.removeItem(p2);
	        fail("Error");
	    } catch (ProductNotFoundException e) {
	     
	    }    
	}

	
	
	
	
	
}
