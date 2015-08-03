package com.compareglobal.service.transformer;

import com.compareglobal.service.model.CreditCard;
import com.compareglobal.service.model.CreditCardPublic;
import com.compareglobal.service.model.Fee;
import com.compareglobal.service.model.FeePublic;

import java.util.LinkedList;
import java.util.List;

public class CreditCardPublicTransformer {


    public static CreditCardPublic valueOfDefault(CreditCard creditCard) {
        CreditCardPublic creditCardPublic = new CreditCardPublic();
        creditCardPublic.setId(creditCard.getId());
        creditCardPublic.setLocale(creditCard.getLocale());
        creditCardPublic.setName(creditCard.getName());

        List<FeePublic> feeList = new LinkedList<FeePublic>();
        List<Fee> fees = creditCard.getFees();
        if (!fees.isEmpty()) {
            for (Fee fee : fees) {
                FeePublic feesp =  new FeePublic(fee);
                feeList.add(feesp);
            }
        }

        creditCardPublic.setFees(feeList);
//        JSONObject productInfo = new JSONObject();
//        productInfo.put("productImage", LinkUrlHelper.getImageValue(creditCard.getImages(),
//                ProductKeys.ProductImage.getProductKey()));
//        productInfo.put("productLink", LinkUrlHelper.getLinkValue(creditCard.getLinks(),
//                ProductKeys.ProductLink.getProductKey()));
//        creditCardPublic.setProductInfo(productInfo);

        return creditCardPublic;


    }
}
