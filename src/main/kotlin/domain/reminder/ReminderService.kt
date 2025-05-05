package com.example.domain.reminder

import com.example.domain.customer.CustomerId
import com.example.domain.reminder.usecases.CreateReminderUseCase
import com.example.domain.reminder.usecases.GetReminderForCustomerUseCase
import com.example.domain.reminder.usecases.GetReminderUseCase
import domain.reminder.Reminder
import domain.reminder.ReminderRepository
import java.time.LocalDateTime

// ReminderService encapsulates the business logic for creating and retrieving reminders.
class ReminderService(private val reminderRepository: ReminderRepository) {

    fun createReminder(customerId: CustomerId, noteId: Long?, remindAt: LocalDateTime, message: String)
    : Reminder = CreateReminderUseCase(reminderRepository).execute(customerId, noteId, remindAt, message)

    fun getReminder(id: Long): Reminder? = GetReminderUseCase(reminderRepository).execute(id)

    fun getRemindersForCustomer(customerId: CustomerId): List<Reminder> = GetReminderForCustomerUseCase(reminderRepository).execute(customerId)
}