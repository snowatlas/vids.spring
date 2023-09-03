package vids.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vids.spring.model.Device;
import vids.spring.model.Purchase;
import vids.spring.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
 /*  @Query("select "+
    "d.name as  name, d.device_Type as type, p.price as price, p.color as color, p.purchaseTime as purchaseTime "+
    "from purchases p left join devices d on d.id=p.device_id "+
    "where p.user_id = : userId")
    List<PurchaseItem>  findAllPurchasesOfusers(@Param("userId") Long userId);*/
   // @Query("select * from purchases")
    //List<PurchaseItem>  findAllPurchasesOfusers(@Param("userId") Long userId);
    List<Purchase>  findPurchasesByUserId(@Param("userId") Long userId);
}
