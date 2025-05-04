package com.example.domain.customer.usecases

import com.example.domain.customer.Contact
import com.example.domain.customer.Customer
import com.example.domain.customer.CustomerId
import com.example.domain.customer.CustomerRepository
import com.example.events.ContactAddedEvent
import events.EventPublisher

class AddContactUseCase(
    private val customerRepository: CustomerRepository,
    private val eventPublisher: EventPublisher
) {
    operator fun invoke(customerId: CustomerId, contact: Contact):Customer?{
        val customer = customerRepository.findById(customerId)
            ?: return null

        // Business logic to add a contact (could be a method on Customer entity)
        val updatedCustomer = customer.withContact(contact)
        customerRepository.save(updatedCustomer)

        // Publish a domain event to signal that a new contact has been added
        eventPublisher.publish(ContactAddedEvent(customerId, contact))

        return updatedCustomer
    }
}