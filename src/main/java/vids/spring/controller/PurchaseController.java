package vids.spring.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vids.spring.model.Purchase;
import vids.spring.service.PurchaseService;
import vids.spring.utils.UserPrincipal;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase){
        UserPrincipal up=(UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(up.getId().equals(purchase.getUserId())){
                    return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);

        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    /*@GetMapping
    public ResponseEntity<?> getAllPurchaseAuthenticatedUser(){
        UserPrincipal userPricipal= (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      

       return ResponseEntity.ok(purchaseService.findPurchaseDeviceOfUser(userPrincipal.getId()));   

       
        
    }
    

    @GetMapping
    public ResponseEntity<?> getAllPurchaseAuthenticatedUser(HttpServletRequest request ){
       // UserPrincipal userPricipal= (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPrincipal principal=(UserPrincipal)request.getUserPrincipal();// le caste pas sure
    
      

       return ResponseEntity.ok(purchaseService.findPurchaseDeviceOfUser(userPrincipal.getId()));   

       
        
    }*/

    @GetMapping
    public ResponseEntity<?> getAllPurchaseAuthenticatedUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
       // UserPrincipal userPricipal= (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      

       return ResponseEntity.ok(purchaseService.findPurchaseDeviceOfUser(userPrincipal.getId()));   

       
        
    }
}
