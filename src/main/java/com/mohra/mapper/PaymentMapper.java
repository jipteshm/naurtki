package com.mohra.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.dto.PaymentInfo;
import com.mohra.entity.Payment;

@Mapper(implementationPackage = "mapper.impl")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment paymentInfoToPayment(PaymentInfo paymentInfo);

    @InheritInverseConfiguration
    PaymentInfo paymentToPaymentInfo(Payment payment);
}
