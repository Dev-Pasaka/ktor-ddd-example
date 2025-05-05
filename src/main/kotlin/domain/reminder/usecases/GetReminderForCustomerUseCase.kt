package com.example.domain.reminder.usecases

import com.example.domain.customer.CustomerId
import domain.reminder.Reminder
import domain.reminder.ReminderRepository

class GetReminderForCustomerUseCase(
    private val reminderRepository: ReminderRepository
) {
    fun execute(customerId: CustomerId):List<Reminder> =  reminderRepository.findByContact(customerId)

}