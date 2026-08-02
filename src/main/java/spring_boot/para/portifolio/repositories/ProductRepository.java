package spring_boot.para.portifolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot.para.portifolio.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
