package application.DrugInfo.bootstrap;

import java.math.BigDecimal;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import application.DrugInfo.entity.Product;
import application.DrugInfo.repository.ProductRepository;


@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;

	private Logger log = LogManager.getLogger(ProductLoader.class);

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Product tShirtRoundBlack = new Product();
		tShirtRoundBlack.setDescription("T-Shirt (RoundNeck,Black)");
		tShirtRoundBlack.setPrice(new BigDecimal("18.95"));
		tShirtRoundBlack.setImageUrl(
				"https://www.publicdomainpictures.net/pictures/40000/velka/t-shirt.jpg");
		tShirtRoundBlack.setProductId("235268845711068308");
		productRepository.save(tShirtRoundBlack);

		log.info("Saved T-Shirt - id: " + tShirtRoundBlack.getId());

		Product tShirtCollared_BY = new Product();
		tShirtCollared_BY.setDescription("T-Shirt (CollaredNeck,Black-Yellow)");
		tShirtCollared_BY.setImageUrl(
				"https://www.publicdomainpictures.net/pictures/190000/velka/t-shirt-illustration-1471190364BwV.jpg");
		tShirtCollared_BY.setProductId("168639393495335947");
		tShirtCollared_BY.setPrice(new BigDecimal("11.95"));
		productRepository.save(tShirtCollared_BY);

		log.info("Saved T-Shirt - id:" + tShirtCollared_BY.getId());
		
		Product tShirtCollared_BBl = new Product();
		tShirtCollared_BBl.setDescription("T-Shirt (CollaredNeck,Black-Blue)");
		tShirtCollared_BBl.setImageUrl(
				"https://www.publicdomainpictures.net/pictures/190000/velka/t-shirt-illustration.jpg");
		tShirtCollared_BBl.setProductId("168639393495335948");
		tShirtCollared_BBl.setPrice(new BigDecimal("11.95"));
		productRepository.save(tShirtCollared_BBl);

		log.info("Saved T-Shirt - id:" + tShirtCollared_BBl.getId());
		
		Product tShirtCollared_BR = new Product();
		tShirtCollared_BR.setDescription("T-Shirt (CollaredNeck,Black-Red)");
		tShirtCollared_BR.setImageUrl(
				"https://www.publicdomainpictures.net/pictures/190000/velka/t-shirt-illustration-1471190269XGw.jpg");
		tShirtCollared_BR.setProductId("168639393495335949");
		tShirtCollared_BR.setPrice(new BigDecimal("11.95"));
		productRepository.save(tShirtCollared_BR);

		log.info("Saved T-Shirt - id:" + tShirtCollared_BR.getId());
	}
}
