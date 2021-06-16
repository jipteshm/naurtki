package com.mohrait.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.mohrait.common.staticdata.CodeType;

/*
 * Created by Suresh Stalin on 20 / Oct / 2020.
 */

@Getter
@Setter
@Entity
@Table(name = "app_entity_code")
public class AppEntityCode extends BaseObject {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "code_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CodeType codeType;
}
