package application.DrugInfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import application.DrugInfo.controller.ProductController;
import application.DrugInfo.entity.Product;
import application.DrugInfo.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugInfoApplicationTests {

	@Test
	public void contextLoads() {
	}
	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductService productService;

	@Mock
	private Model model;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testIndex() {
		ProductController productController = new ProductController();
		String indexResult = productController.index();
		assertEquals("index", indexResult);
	}

	@Test
	public void testList() {
		List<Product> productsList = new ArrayList<Product>();
		when(productService.listAllProducts()).thenReturn(productsList);
		String listResult = productController.list(model);
		verify(productService).listAllProducts();
		assertEquals("products", listResult);
	}

	@Test
	public void testShowProduct() {
		Integer value = 8;
		Product pr = new Product();
		when(productService.getProductById(value)).thenReturn(pr);
		String showProductResult = productController.showProduct(value, model);
		verify(productService).getProductById(value);
		assertEquals("productshow", showProductResult);
	}

	@Test
	public void testEdit() {
		Integer value = 8;
		Product pr = new Product();
		when(productService.getProductById(value)).thenReturn(pr);
		String editProductResult = productController.edit(value, model);
		verify(productService).getProductById(value);
		assertEquals("productform", editProductResult);
	}

	@Test
	public void testNewProduct() {
		String newProductResult = productController.newProduct(model);
		assertEquals("productform", newProductResult);
	}

	@Test
	public void testSaveProduct() {
		Product pr = new Product();
		when(productService.saveProduct(pr)).thenReturn(pr);
		String saveProductResult = productController.saveProduct(pr);
		verify(productService).saveProduct(pr);
		assertEquals("redirect:/products", saveProductResult);
	}

	@Test
	public void testDeleteProduct() {
		Integer value = 8;
		doNothing().when(productService).deleteProductById(isA(Integer.class));
		String deleteProductResult = productController.deleteProduct(value, model);
		verify(productService, times(1)).deleteProductById(value);
		assertEquals("redirect:/products", deleteProductResult);
	}
	
	@Test
	public void tesProduct() {
		String productDescription = "desc";
		BigDecimal productPrice = new BigDecimal("18.95");
		String productImageURL = "https://www.publicdomainpictures.net/pictures/40000/velka/t-shirt.jpg";
		String ProductId = "235268845711068308";
		Integer productVersion = 2;
		Integer tableId = null;

		Product tShirtRoundBlack = new Product();
		tShirtRoundBlack.setDescription(productDescription);
		tShirtRoundBlack.setPrice(productPrice);
		tShirtRoundBlack.setImageUrl(productImageURL);
		tShirtRoundBlack.setProductId(ProductId);
		tShirtRoundBlack.setVersion(productVersion);
		tShirtRoundBlack.setId(tableId);

		assertNotNull("null object passed", tShirtRoundBlack);
		assertTrue("Object is not instanceof Product", tShirtRoundBlack instanceof Product);
		assertEquals("Product price Mismatched", productPrice, tShirtRoundBlack.getPrice());
		assertFalse("Product Version Mismacthed", productVersion != tShirtRoundBlack.getVersion());
		assertTrue("Description ends with different content",
				tShirtRoundBlack.getDescription().endsWith(productDescription));
		assertNull("Table Id not null", tShirtRoundBlack.getId());
		assertTrue("Product Id is empty", !tShirtRoundBlack.getProductId().isEmpty());
		assertNotEquals("Image URL is matched with unexpected value", "Welcome", tShirtRoundBlack.getImageUrl());

	}

	
	

}
