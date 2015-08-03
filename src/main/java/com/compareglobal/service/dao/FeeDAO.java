package com.compareglobal.service.dao;

import com.compareglobal.service.model.Fee;

import java.util.List;

public interface FeeDAO {
    List<Fee> findFees(long creditCardId);
}
