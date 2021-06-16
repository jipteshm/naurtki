package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.PaymentInfo;
import com.mohrait.entity.Payment;

@Mapper(implementationPackage = "mapper.impl")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment paymentInfoToPayment(PaymentInfo paymentInfo);

    @InheritInverseConfiguration
    PaymentInfo paymentToPaymentInfo(Payment payment);
}
