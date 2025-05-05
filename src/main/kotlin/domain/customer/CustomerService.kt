package com.example.domain.customer

import com.example.domain.customer.usecases.AddContactUseCase
import com.example.domain.customer.usecases.AddNoteUseCase
import com.example.domain.customer.usecases.CreateCustomerUseCase
import com.example.domain.customer.usecases.GetCustomerUseCase
import events.EventPublisher

class CustomerService(
    private val customerRepository: CustomerRepository,
    private val eventPublisher: EventPublisher
) {

    fun createCustomer(name: String): Customer  = CreateCustomerUseCase(customerRepository).execute(name)

    fun getCustomer(id: Long): Customer? = GetCustomerUseCase(customerRepository).execute(id)

    fun addContact(customerId: CustomerId, contact: Contact):
            Customer?  = AddContactUseCase(customerRepository, eventPublisher).execute(customerId,contact)

    fun addNote(customerId: CustomerId, note: Note): Customer? = AddNoteUseCase(customerRepository,eventPublisher).execute(customerId,note)
}