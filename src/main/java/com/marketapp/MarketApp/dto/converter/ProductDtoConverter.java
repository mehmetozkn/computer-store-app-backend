package com.marketapp.MarketApp.dto.converter;


import com.marketapp.MarketApp.dto.ProductDto;
import com.marketapp.MarketApp.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {
    private final ModelMapper modelMapper;
    public ProductDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDto convertProductToProductDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    public Product convertProductDtoToProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }

}
