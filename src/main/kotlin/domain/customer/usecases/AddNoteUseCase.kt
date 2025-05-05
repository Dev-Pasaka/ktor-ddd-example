package com.example.domain.customer.usecases

import com.example.domain.customer.*
import com.example.events.NoteAddedEvent
import events.EventPublisher

class AddNoteUseCase(
    private val customerRepository: CustomerRepository,
    private val eventPublisher: EventPublisher
) {
    fun execute(customerId: CustomerId, note: Note):Customer?{
        val customer = customerRepository.findById(customerId)
            ?: return null

        val updatedCustomer = customer.withNote(note)
        customerRepository.save(updatedCustomer)

        // Publish a domain event to signal about a new note
        eventPublisher.publish(NoteAddedEvent(customerId, note))

        return updatedCustomer
    }
}