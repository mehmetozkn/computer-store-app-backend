package com.marketapp.MarketApp.service;

import com.marketapp.MarketApp.dto.ProductDto;
import com.marketapp.MarketApp.dto.converter.ProductDtoConverter;
import com.marketapp.MarketApp.exception.ProductNotFoundException;
import com.marketapp.MarketApp.model.Product;
import com.marketapp.MarketApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;

    public ProductService(ProductRepository productRepository, ProductDtoConverter productDtoConverter) {
        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;

    }

    public ProductDto createProduct(Product product) {
        return productDtoConverter.convertProductToProductDto(productRepository.save(product));
    }

    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productDtoConverter::convertProductToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) {
        return productDtoConverter.convertProductToProductDto(findProductById(id));
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product updateProduct = findProductById(id);
        updateProduct.setName(productDto.getName());
        updateProduct.setPrice(productDto.getPrice());
        return productDtoConverter.convertProductToProductDto(productRepository.save(updateProduct));
    }

    public ProductDto deleteProduct(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
        return productDtoConverter.convertProductToProductDto(product);

    }

    protected Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product could not find by id: " + id));
    }

}
