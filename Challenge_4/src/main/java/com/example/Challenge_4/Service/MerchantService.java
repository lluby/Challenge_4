package com.example.Challenge_4.Service;

import com.example.Challenge_4.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MerchantService {

    static Merchant addMerchant(Merchant merchant);
    Merchant updateMerchant(Merchant merchant);
    void deleteMerchant(String MerchantCode);
    List<Merchant> getAllMerchant();
}
