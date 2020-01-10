package com.calculator.database;

import com.calculator.Merchant;
import com.calculator.database.exceptions.MerchantDoesNotExist;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MerchantAdapter implements IMerchantAdapter {
    List<Merchant> merchants;

    public MerchantAdapter() {
        merchants = new ArrayList<>();
        merchants.add(new Merchant(1, "DTU Canteen"));
        merchants.add(new Merchant(2, "DTU Library"));
    }

    @Override
    public Merchant getMerchantByMerchantId(int id) throws MerchantDoesNotExist {
        for (Merchant m : merchants) {
            if (m.getId() == id) return m;
        }

        throw new MerchantDoesNotExist(MessageFormat.format(
                "Merchant id {0} was not found in customer list.", id));
    }

    @Override
    public Merchant createMerchant(Merchant merchant) {
        merchants.add(merchant);
        return merchant;
    }

    @Override
    public Merchant updateMerchant(Merchant merchant) throws MerchantDoesNotExist {
        deleteMerchantByMerchantId(merchant.getId());
        return createMerchant(merchant);
    }

    @Override
    public void deleteMerchantByMerchantId(int id) throws MerchantDoesNotExist {
        Merchant merchant = getMerchantByMerchantId(id);
        merchants.remove(merchant);
    }
}
