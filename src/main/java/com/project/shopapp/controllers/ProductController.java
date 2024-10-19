package com.project.shopapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import com.project.shopapp.dtos.ProductDTO;

import jakarta.validation.Valid;
import java.security.SecureRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    // @PostMapping()
    // POST http://localhost:8088/v1/api/products
    // public ResponseEntity<?> createProduct(
    // @Valid @RequestBody ProductDTO productDTO,
    // @RequestPart("file") MultipartFile file,
    // BindingResult result) {
    // try {
    // if (result.hasErrors()) {
    // List<String> errorMessages = result.getFieldErrors()
    // .stream()
    // .map(FieldError::getDefaultMessage)
    // .toList();
    // return ResponseEntity.badRequest().body(errorMessages);
    // }
    // if (file != null) {
    // // kiem tra kich thuoc va dinh dang
    // if (file.getSize() > 10 * 1024 * 1024) { // Kích thước > 10MB
    // return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
    // .body(" file is too large");
    // }
    // String contentType = file.getContentType();
    // if (contentType == null || !contentType.startsWith("image/")) {
    // return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    // .body(" file must be an image");
    // }
    // }

    // return ResponseEntity.ok(" product created sucssesss");
    // } catch (Exception e) {
    // return ResponseEntity.badRequest().body(e.getMessage());
    // }
    // }

    // private String storeFile(MultipartFile file) throws IOException {
    // if (!isImageFile(file) || file.getOriginalFilename() == null) {
    // throw new IOException("Invalid image format");
    // }
    // String filename =
    // StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
    // // Thêm UUID vào trước tên file để đảm bảo tên file là duy nhất
    // String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;
    // // Đường dẫn đến thư mục mà bạn muốn lưu file
    // java.nio.file.Path uploadDir = Paths.get("uploads");
    // // Kiểm tra và tạo thư mục nếu nó không tồn tại
    // if (!Files.exists(uploadDir)) {
    // Files.createDirectories(uploadDir);
    // }
    // // Đường dẫn đầy đủ đến file
    // java.nio.file.Path destination = Paths.get(uploadDir.toString(),
    // uniqueFilename);
    // // Sao chép file vào thư mục đích
    // Files.copy(file.getInputStream(), destination,
    // StandardCopyOption.REPLACE_EXISTING);
    // return uniqueFilename;
    // }

    // private boolean isImageFile(MultipartFile file) {
    // String contentType = file.getContentType();
    // return contentType != null && contentType.startsWith("image/");
    // }

    @GetMapping("")
    public ResponseEntity<String> getProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit) {
        return ResponseEntity.ok("getProducts here");
    }

    // http://localhost:8088/api/v1/products/6

    @GetMapping("/{id}")

    public ResponseEntity<String> getProductById(
            @PathVariable("id") String productId

    ) {
        return ResponseEntity.ok("Product with ID:" + productId);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteProduct(@PathVariable long id) {

        return ResponseEntity.ok(String.format("Product with id = %d deleted successfully", id));

    }
}
