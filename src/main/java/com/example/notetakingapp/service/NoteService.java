package com.example.notetakingapp.service;

import com.example.notetakingapp.model.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private List<Note> notes = new ArrayList<>();
    private Long nextId = 1L;

    // Not ekleme
    public Note addNote(String title, String content) {
        Note note = new Note(nextId++, title, content);
        notes.add(note);
        return note;
    }

    // Notları listeleme
    public List<Note> getAllNotes() {
        return notes;
    }

    // ID ile not bulma
    public Optional<Note> getNoteById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

}
