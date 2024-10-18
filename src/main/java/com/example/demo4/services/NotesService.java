package com.example.demo4.services;

import com.example.demo4.models.Notes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {
    private List<Notes> notesList = new ArrayList<>();

    public List<Notes> getNotes() {
        return notesList;
    }

    public void addNotes(Notes notes) {
        notesList.add(notes);
    }

    public void editNotes(int id, String title,String text) {
        notesList.get(id).setTitle(title);
        notesList.get(id).setText(text);
    }

    public void deleteNotes(int id) {
        notesList.remove(id);
    }
}
