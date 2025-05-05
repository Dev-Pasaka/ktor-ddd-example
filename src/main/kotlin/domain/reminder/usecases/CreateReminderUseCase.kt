package com.example.domain.reminder.usecases

import com.example.domain.customer.CustomerId
import com.example.domain.customer.NoteId
import domain.reminder.Reminder
import domain.reminder.ReminderId
import domain.reminder.ReminderRepository
import java.time.LocalDateTime

class CreateReminderUseCase(
    private val reminderRepository: ReminderRepository
) {
    fun execute(customerId: CustomerId, noteId: Long?, remindAt: LocalDateTime, message: String): Reminder {
        val reminder = Reminder(
            id = ReminderId(value = (1000_000_000..1_899_999_999_999).random()),
            customerId = customerId,
            noteId = noteId?.let { NoteId(it) },
            remindAt = remindAt,
            message = message
        )
        reminderRepository.save(reminder)
        return reminder
    }
}

