package vids.spring.service;

import vids.spring.model.Device;
import vids.spring.model.Purchase;
import vids.spring.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseService {
    public Purchase save(Purchase purchase);

   //public List<PurchaseItem> findPurchaseItemOfUser(Long userId);
     public List<Purchase>  findPurchaseDeviceOfUser(Long userId);
}
