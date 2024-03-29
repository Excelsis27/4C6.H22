package ca.qc.cstj.s05localdatasource.presentation.ui.main

import android.app.Application
import androidx.lifecycle.*
import ca.qc.cstj.s05localdatasource.data.AppDatabase
import ca.qc.cstj.s05localdatasource.data.repositories.ContactRepository
import ca.qc.cstj.s05localdatasource.domain.models.Contact
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>> get() = _contacts

    private val contactRepository = AppDatabase.getDatabase(application).contactRepository()

    init {
        // collect == await
        viewModelScope.launch {
            contactRepository.retrieveAll().collect {
                _contacts.value = it
            }
        }
    }

    fun addContact(contact: Contact) {
        viewModelScope.launch {
            contactRepository.create(contact)
        }
    }
}