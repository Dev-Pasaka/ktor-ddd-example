package com.example.domain.customer.usecases

import com.example.domain.customer.Customer
import com.example.domain.customer.CustomerId
import com.example.domain.customer.CustomerRepository

class CreateCustomerUseCase(
    private val customerRepository: CustomerRepository,
) {
    fun execute(name:String):Customer{
        val customer = Customer(name = name, id = CustomerId(value = (1000_000_000..1_899_999_999_999).random()))
        customerRepository.save(customer)
        return customer
    }
}