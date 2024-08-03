package com.h20.shop.service.impl;

import com.h20.shop.entity.*;
import com.h20.shop.entity.dto.*;
import com.h20.shop.exception.InvalidFieldsForProductTypeException;
import com.h20.shop.exception.ProductNotFoundException;
import com.h20.shop.repository.ProductRepo;
import com.h20.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductsByType(String type) {
        List<Product> allProducts = productRepo.findAll();
        return allProducts.stream()
                .filter(product -> product.getClass().getSimpleName().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public Product getProduct(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product addProduct(ProductDTO createProductDTO) {
        Product product = convertToEntity(createProductDTO);
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(ProductDTO product, Long id) {
        Optional<Product> existingProductOptional = productRepo.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            if (!validateUpdate(existingProduct, product)) {
                throw new InvalidFieldsForProductTypeException("Invalid fields for product type");
            }
            updateFields(existingProduct, product);
            return productRepo.save(existingProduct);
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProduct(id);
        productRepo.delete(product);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        if (productDTO instanceof PersonalComputerDTO) {
            PersonalComputer desktop = new PersonalComputer();
            desktop.setFormFactor(((PersonalComputerDTO) productDTO).getFormFactor());
            setCommonFields(desktop, productDTO);
            return desktop;
        } else if (productDTO instanceof LaptopDTO) {
            Laptop laptop = new Laptop();
            laptop.setSize(((LaptopDTO) productDTO).getSize());
            setCommonFields(laptop, productDTO);
            return laptop;
        } else if (productDTO instanceof MonitorDTO) {
            Monitor monitor = new Monitor();
            monitor.setDiagonal(((MonitorDTO) productDTO).getDiagonal());
            setCommonFields(monitor, productDTO);
            return monitor;
        } else if (productDTO instanceof HardDriveDTO) {
            HardDrive hardDrive = new HardDrive();
            hardDrive.setCapacity(((HardDriveDTO) productDTO).getCapacity());
            setCommonFields(hardDrive, productDTO);
            return hardDrive;
        }
        throw new InvalidFieldsForProductTypeException("Unknown product type");
    }

    private void setCommonFields(Product product, ProductDTO productDTO) {
        product.setSeries_number(productDTO.getSeriesNumber());
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
    }

    private boolean validateUpdate(Product existingProduct, ProductDTO productDTO) {
        if (existingProduct instanceof PersonalComputer && productDTO instanceof PersonalComputerDTO) {
            return true;
        } else if (existingProduct instanceof Laptop && productDTO instanceof LaptopDTO) {
            return true;
        } else if (existingProduct instanceof Monitor && productDTO instanceof MonitorDTO) {
            return true;
        } else if (existingProduct instanceof HardDrive && productDTO instanceof HardDriveDTO) {
            return true;
        }
        return false;
    }

    private void updateFields(Product existingProduct, ProductDTO productDTO) {
        existingProduct.setSeries_number(productDTO.getSeriesNumber());
        existingProduct.setBrand(productDTO.getBrand());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());

        if (existingProduct instanceof PersonalComputer && productDTO instanceof PersonalComputerDTO) {
            ((PersonalComputer) existingProduct).setFormFactor(((PersonalComputerDTO) productDTO).getFormFactor());
        } else if (existingProduct instanceof Laptop && productDTO instanceof LaptopDTO) {
            ((Laptop) existingProduct).setSize(((LaptopDTO) productDTO).getSize());
        } else if (existingProduct instanceof Monitor && productDTO instanceof MonitorDTO) {
            ((Monitor) existingProduct).setDiagonal(((MonitorDTO) productDTO).getDiagonal());
        } else if (existingProduct instanceof HardDrive && productDTO instanceof HardDriveDTO) {
            ((HardDrive) existingProduct).setCapacity(((HardDriveDTO) productDTO).getCapacity());
        }
    }
}
