package com.example.domain.reminder.usecases

import com.example.domain.customer.CustomerId
import com.example.domain.customer.NoteId
import domain.reminder.Reminder
import domain.reminder.ReminderId
import domain.reminder.ReminderRepository
import java.time.LocalDateTime

class GetReminderForCustomerUseCase(
    private val reminderRepository: ReminderRepository
) {
    operator fun invoke(customerId: CustomerId):List<Reminder> =  reminderRepository.findByContact(customerId)

}