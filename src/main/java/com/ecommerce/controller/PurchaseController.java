package com.ecommerce.controller;

import com.ecommerce.dto.PurchaseDTO;
import com.ecommerce.dto.PurchaseRequestDTO;
import com.ecommerce.service.PurchaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/create")
    public ResponseEntity<PurchaseDTO> createPurchase(@Valid @RequestBody
                                                      PurchaseRequestDTO purchaseRequestDTO) {

        PurchaseDTO newPurchase = purchaseService.createPurchase(purchaseRequestDTO);

        return new ResponseEntity<>(newPurchase, HttpStatus.CREATED);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PurchaseDTO> getPurchaseById(@Valid @PathVariable("id") Long id) {

        PurchaseDTO purchase = purchaseService.getPurchaseById(id);

        return ResponseEntity.ok(purchase);

    }

    @GetMapping("/{username}")
    public ResponseEntity<List<PurchaseDTO>> findByUserName(@PathVariable("username") String username) {

        List<PurchaseDTO> findPurchases = purchaseService.findByUserName(username);

        return ResponseEntity.ok(findPurchases);

    }


}
