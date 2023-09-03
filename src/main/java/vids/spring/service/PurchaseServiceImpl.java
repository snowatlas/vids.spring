package vids.spring.service;


import org.springframework.stereotype.Service;

import vids.spring.model.Device;
import vids.spring.model.Purchase;
import vids.spring.repository.PurchaseRepository;
import vids.spring.repository.projection.PurchaseItem;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{

   
   private final PurchaseRepository purchaseRepository;
   
   public PurchaseServiceImpl(PurchaseRepository purchaseRepository){
    this.purchaseRepository=purchaseRepository;

   }
    @Override
    public Purchase save(Purchase purchase){
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }
   /*  @Override
    public List<PurchaseItem> findPurchaseItemOfUser(Long userId){
        return purchaseRepository.findAllPurchasesOfusers(userId);
    }*/
    public List<Purchase> findPurchaseDeviceOfUser(Long userId){
        return purchaseRepository.findPurchasesByUserId(userId);
    }
}
