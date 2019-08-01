package application.DrugInfo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
public class TestProductController {
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

}
