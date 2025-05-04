package com.example.domain.customer

import com.example.domain.customer.usecases.AddContactUseCase
import com.example.domain.customer.usecases.AddNoteUseCase
import com.example.domain.customer.usecases.CreateCustomerUseCase
import com.example.domain.customer.usecases.GetCustomerUseCase
import com.example.events.ContactAddedEvent
import com.example.events.NoteAddedEvent
import events.EventPublisher

class CustomerService(
    private val customerRepository: CustomerRepository,
    private val eventPublisher: EventPublisher
) {

    fun createCustomer(name: String): Customer  = CreateCustomerUseCase(customerRepository).invoke(name)

    fun getCustomer(id: Long): Customer? = GetCustomerUseCase(customerRepository).invoke(id)

    fun addContact(customerId: CustomerId, contact: Contact):
            Customer?  = AddContactUseCase(customerRepository, eventPublisher).invoke(customerId,contact)

    fun addNote(customerId: CustomerId, note: Note): Customer? = AddNoteUseCase(customerRepository,eventPublisher).invoke(customerId,note)
}