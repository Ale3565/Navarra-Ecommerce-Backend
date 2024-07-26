package com.alexislevano.projectspring;
import java.util.Random;
import com.alexislevano.projectspring.dao.CategoryRepository;
import com.alexislevano.projectspring.dao.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.alexislevano.projectspring.entities.Category;
import com.alexislevano.projectspring.entities.User;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class EcommerceBackendApplication implements CommandLineRunner{
	  @Autowired
	    private ProductRepository productRepository;
	    @Autowired
	    private CategoryRepository categoryRepository;
	    @Autowired
	    private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackendApplication.class, args);
		Category c = new Category();
	
	}

	 @Override
	    public void run(String... args) throws Exception {

	        repositoryRestConfiguration.exposeIdsFor(com.alexislevano.projectspring.entities.Product.class,Category.class,User.class);

	 //       categoryRepository.save(new Category(null,"Shirts",null,null,null));
		 //	          categoryRepository.save(new Category(null,"Jeans",null,null,null));
		 //       categoryRepository.save(new Category(null,"Sleepwear",null,null,null));
		 //       categoryRepository.save(new Category(null,"Jackets",null,null,null));

		 //       Random rnd=new Random();
		 //       categoryRepository.findAll().forEach(c->{
		 //           for (int i = 0; i <10 ; i++) {
		 //              com.alexislevano.projectspring.entities.Product p=new com.alexislevano.projectspring.entities.Product();
		 //           p.setName(RandomString.make(18));
		 //           p.setPrice(100+rnd.nextInt(10000));
		 //           p.setAvailable(rnd.nextBoolean());
		 //           p.setPromotion(rnd.nextBoolean());
		 //           p.setSelected(rnd.nextBoolean());
		 //           p.setCategory(c);
		 //           p.setImgURL("default.jpg");
		 //         productRepository.save(p);
		 //      }
		 //   });
	    }

}
