package com.mohra.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mohra.common.CodeGenerator;
import com.mohra.common.staticdata.CodeType;
import com.mohra.common.staticdata.ROLES;
import com.mohra.common.staticdata.UserType;
import com.mohra.dto.BaseInfo;
import com.mohra.dto.CustomerInfo;
import com.mohra.dto.EmployeeInfo;
import com.mohra.dto.VendorInfo;
import com.mohra.entity.*;
import com.mohra.exception.InvalidInputException;
import com.mohra.mapper.CustomerMapper;
import com.mohra.mapper.EmployeeMapper;
import com.mohra.mapper.VendorMapper;
import com.mohra.messages.ResponseMessage;
import com.mohra.repository.RoleRepository;
import com.mohra.service.BillingBaseService;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Suresh Stalin on 20 / Oct / 2020.
 */

@Service
public class RegistrationService {

    @Autowired
    private BillingBaseService billingBaseService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${default.role}")
    private String defaultRole;


    public ResponseMessage<BaseInfo> doRegistration(BaseInfo baseInfo) throws Exception {

        ResponseMessage<BaseInfo> responseMessage = null;
        String type = baseInfo.getType();
        try {
            if (type.equalsIgnoreCase(UserType.EMPLOYEE.name())) {
                Employee employee = EmployeeMapper.INSTANCE.employeeInfoToEmployee((EmployeeInfo) baseInfo);
                Role role = roleRepository.findByName(ROLES.EMPLOYEE_ROLE.name()).orElse(null);
                List<Role> roleList = new ArrayList<>();
                roleList.add(role);
                employee.getUser().setRoles(roleList);
                if (employee.getId() == null) {
                    employee.setEmployeeCode(codeGenerator.newCode(CodeType.EMPLOYEE_CODE));
                }
                employee.getUser().getAddressList().get(0).setUser(employee.getUser());
                employee.getUser().setUserType(UserType.EMPLOYEE.name());
//                employee.getUser().setPassword(passwordEncoder.encode(employee.getUser().getPassword()));
                employee.getUser().setPassword(employee.getUser().getPassword());
                BaseObject newObject = billingBaseService.save(employee); // Holds the reference of Employee object
                EmployeeInfo employeeDto = EmployeeMapper.INSTANCE.employeeToEmployeeInfo((Employee) newObject);
                responseMessage = ResponseMessage.withResponseData(employeeDto, "Employee Created Successfully", "message");
            } else if (type.equalsIgnoreCase(UserType.CUSTOMER.name())) {
                Customer customer = CustomerMapper.INSTANCE.customerInfoToCustomer((CustomerInfo) baseInfo);
                Role role = roleRepository.findByName(ROLES.CUSTOMER_ROLE.name()).orElse(null);
                List<Role> roleList = new ArrayList<>();
                roleList.add(role);
                customer.getUser().setRoles(roleList);
                if (customer.getId() == null) {
                    customer.setCustomerCode(codeGenerator.newCode(CodeType.CUSTOMER_CODE));
                }
                if(customer.getUser().getAddressList() != null && customer.getUser().getAddressList().size() > 0) {
                    customer.getUser().getAddressList().get(0).setUser(customer.getUser());
                }
                customer.getUser().setUserType(UserType.CUSTOMER.name());
                customer.getUser().setPassword(customer.getUser().getMobileNo());
                BaseObject newObject = billingBaseService.save(customer);
                CustomerInfo customerDto = CustomerMapper.INSTANCE.customerToCustomerInfo((Customer) newObject);
                responseMessage = ResponseMessage.withResponseData(customerDto, "Customer Created Successfully", "message");
            } else if (type.equalsIgnoreCase(UserType.VENDOR.name())) {
                Vendor vendor = VendorMapper.INSTANCE.vendorInfoToVendor((VendorInfo) baseInfo);
                Role role = roleRepository.findByName(ROLES.VENDOR_ROLE.name()).orElse(null);
                List<Role> roleList = new ArrayList<>();
                roleList.add(role);
                vendor.getUser().setRoles(roleList);
                if (vendor.getId() == null) {
                    vendor.setVendorCode(codeGenerator.newCode(CodeType.VENDOR_CODE));
                }
//                vendor.getUser().setPassword(passwordEncoder.encode(vendor.getUser().getPassword()));
                vendor.getUser().setPassword(vendor.getUser().getPassword());
                vendor.getUser().getAddressList().get(0).setUser(vendor.getUser());
                vendor.getUser().setUserType(UserType.VENDOR.name());
                BaseObject newObject = billingBaseService.save(vendor);
                VendorInfo vendorInfo = VendorMapper.INSTANCE.vendorToVendorInfo((Vendor) newObject);
                responseMessage = ResponseMessage.withResponseData(vendorInfo, "Vendor Created Successfully", "message");
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException(String.format("Invalid user type %s ", type));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return responseMessage;
    }

    public ResponseMessage<BaseInfo> createSuperAdmin(BaseInfo baseInfo) throws Exception {

        ResponseMessage<BaseInfo> responseMessage = null;
        String type = baseInfo.getType();
        try {
            if (type.equalsIgnoreCase(UserType.EMPLOYEE.name())) {
                Employee employee = EmployeeMapper.INSTANCE.employeeInfoToEmployee((EmployeeInfo) baseInfo);
                if (employee.getId() == null) {
                    employee.setEmployeeCode(codeGenerator.newCode(CodeType.EMPLOYEE_CODE));
                }
                employee.getUser().getAddressList().get(0).setUser(employee.getUser());
                employee.getUser().setUserType(UserType.EMPLOYEE.name());
//                employee.getUser().setPassword(passwordEncoder.encode(employee.getUser().getPassword()));
                employee.getUser().setPassword(employee.getUser().getPassword());
                BaseObject newObject = billingBaseService.save(employee); // Holds the reference of Employee object
                Role role = roleRepository.findByName(ROLES.SUPER_ADMIN_ROLE.name()).orElse(null);
                Employee employee1 = (Employee)newObject;
                ArrayList<Role> arrayList = new ArrayList<>();
                arrayList.add(role);
                employee1.getUser().setRoles(arrayList);
                billingBaseService.save(employee1);
                EmployeeInfo employeeDto = EmployeeMapper.INSTANCE.employeeToEmployeeInfo((Employee) newObject);
                responseMessage = ResponseMessage.withResponseData(employeeDto, "Employee Created Successfully", "message");
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException(String.format("Invalid user type %s ", type));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return responseMessage;
    }

}

