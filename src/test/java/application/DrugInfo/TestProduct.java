package application.DrugInfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import application.DrugInfo.entity.Product;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProduct {

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
