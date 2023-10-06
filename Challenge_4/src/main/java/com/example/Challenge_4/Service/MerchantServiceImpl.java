package com.example.Challenge_4.Service;

import com.example.Challenge_4.Model.Merchant;
import com.example.Challenge_4.Repository.MerchantRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService{
    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public Merchant addMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant updateMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public void deleteMerchant(String MerchantCode) {
        merchantRepository.deleteById(MerchantCode);
    }

    @Override
    public List<Merchant> getAllMerchant() {
        return merchantRepository.findAll();
    }
}
