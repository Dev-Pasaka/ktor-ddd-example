package com.example.domain.customer.usecases

import com.example.domain.customer.Customer
import com.example.domain.customer.CustomerId
import com.example.domain.customer.CustomerRepository
import events.EventPublisher

class GetCustomerUseCase(
    private val customerRepository: CustomerRepository,
) {

    operator fun invoke(id: Long): Customer? {
        val customerId = CustomerId(id)
        return customerRepository.findById(customerId)
    }

}
