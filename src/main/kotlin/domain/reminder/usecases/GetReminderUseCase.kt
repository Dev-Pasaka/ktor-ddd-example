package com.example.domain.reminder.usecases

import domain.reminder.Reminder
import domain.reminder.ReminderId
import domain.reminder.ReminderRepository

class GetReminderUseCase(
    private val reminderRepository: ReminderRepository
) {
    fun execute(id: Long):Reminder? = reminderRepository.findById(ReminderId(id))

}