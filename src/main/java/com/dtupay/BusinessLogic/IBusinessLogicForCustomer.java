package com.dtupay.BusinessLogic;

import com.dtupay.app.Customer;
import com.dtupay.database.exceptions.CustomerDoesNotExist;

public interface IBusinessLogicForCustomer {
    Customer GetCustomerByCustomerId(int id) throws CustomerDoesNotExist;
    Customer CreateCustomer(Customer customer);
    Customer UpdateCustomer(Customer customer) throws CustomerDoesNotExist;
    void DeleteCustomerByCustomerId(int id) throws CustomerDoesNotExist;
}
