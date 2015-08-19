package com.compareglobal.service.transformer;

import com.compareglobal.service.model.*;
import java.util.List;

public class CreditCardPublicTransformer {

    public static CreditCardPublic valueOfDefault(CreditCard creditCard) {
        CreditCardPublic creditCardPublic = new CreditCardPublic();
        creditCardPublic.setId(creditCard.getId());
        creditCardPublic.setLocale(creditCard.getLocale());
        creditCardPublic.setName(creditCard.getName());

        List<Fee> feeList = creditCard.getFees();
        creditCardPublic.setFees(feeList);

        List<Reward> rewardList = creditCard.getRewards();
        creditCardPublic.setRewards(rewardList);

        List<Benefit> benefitList = creditCard.getBenefits();
        creditCardPublic.setBenefits(benefitList);

        List<Promotion> promotionList = creditCard.getPromotions();
        creditCardPublic.setPromotions(promotionList);

        List<Criteria> criteriaList = creditCard.getCriterias();
        creditCardPublic.setCriterias(criteriaList);

        List<GeneralInfo> generalList = creditCard.getGeneralInfos();
        creditCardPublic.setGeneralInfos(generalList);

        return creditCardPublic;
    }
}
