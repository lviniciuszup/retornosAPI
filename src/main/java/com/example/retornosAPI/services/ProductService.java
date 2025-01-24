package com.example.retornosAPI.services;

import com.example.retornosAPI.dtos.ProductDTO;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public boolean validateProduct(ProductEntity productEntity){
        if (productEntity.getName() == null || productEntity.getName().isEmpty() ){
            throw new IllegalArgumentException("O nome não pode ser nulo, nem vázio");
        }
        if (productEntity.getPrice() >0){
            throw new IllegalArgumentException("O preço do produto não pode ser menor que zero");
        }
        if(productEntity.getDescription() == null || productEntity.getDescription().length() > 500){
            throw new IllegalArgumentException("O campo descrição não pode ser nulo nem maior que 500 caracteres");
        }
        if (productEntity.getQuantity() >= 0){
            throw new IllegalArgumentException("A quantidade de")
        }
    }
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity entity = new ProductEntity(null, productDTO.name(), productDTO.price(), productDTO.description(), productDTO.quantity(), productDTO.categories());
        ProductEntity savedEntity = repository.save(entity);
        return new ProductDTO(savedEntity.getId(), savedEntity.getName(), savedEntity.getPrice(), );
    }

    public ProductDTO getProductById(Long id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductDTO(entity.getId(), entity.getName(), entity.getPrice());
    }

    public List<ProductDTO> getAllProducts() {
        return repository.findAll().stream()
                .map(entity -> new ProductDTO(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    // Atualizar um produto existente
    public ProductDTO updateProduct(Long id, ProductDTO updatedProductDTO) {
        // Verificar se o produto existe
        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found"));

        // Atualizar os dados do produto
        existingEntity.setName(updatedProductDTO.name());
        existingEntity.setPrice(updatedProductDTO.price());

        // Salvar as alterações no banco de dados
        ProductEntity savedEntity = repository.save(existingEntity);

        // Retornar o produto atualizado
        return new ProductDTO(savedEntity.getId(), savedEntity.getName(), savedEntity.getPrice());
    }

    // Buscar produtos pelo nome
    public List<ProductDTO> getProductsByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }

        List<ProductEntity> entities = repository.findByNameContainingIgnoreCase(name);
        if (entities.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome: " + name);
        } else {
            System.out.println("Produtos encontrados com o nome '" + name + "': " + entities.size());
        }
        return entities.stream()
                .map(entity -> new ProductDTO(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }
}