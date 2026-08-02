package spring_boot.para.portifolio.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot.para.portifolio.dto.ProductDto;
import spring_boot.para.portifolio.model.Product;
import spring_boot.para.portifolio.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping("get")
    public ResponseEntity  getAll(){
        List<Product> listProducts = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProducts);
    }


    @PostMapping("list_products")
    public ResponseEntity listProducts(@RequestBody ProductDto dto){

        var product = new Product();
        BeanUtils.copyProperties(dto, product);

        return  ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));

    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id")  Integer id ){

        Optional <Product> product = repository.findById(id);

        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.FOUND).body("Nao existe");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(product);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable(value = "id") Integer id){

        Optional <Product> product = repository.findById(id);

        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.FOUND).body("Nao existe");
        }

        repository.delete(product.get());



        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id ,@RequestBody ProductDto dto){

        Optional <Product> product = repository.findById(id);

        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao existe");
        }

        var productDelete = product.get();

        BeanUtils.copyProperties(dto, productDelete);

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(productDelete));

    }

}
