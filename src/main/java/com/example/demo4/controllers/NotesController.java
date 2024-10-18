package com.example.demo4.controllers;

import com.example.demo4.models.Notes;
import com.example.demo4.services.NotesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class NotesController {
    private NotesService notesService;

    @GetMapping("/notes")
    private String getNotes(Model model) {
        model.addAttribute("notes", notesService.getNotes());
        return "notes";
    }

    @GetMapping("create-note")
    private String noteCreationScreen() {
        return "create-note";
    }

    @PostMapping("create-note")
    private String createNote(Notes n) {
        notesService.addNotes(n);
        return "redirect:/notes";
    }

    @GetMapping("edit-note")
    private String noteEditScreen(){
        return "edit-note";
    }

    @PostMapping("edit-note")
    private String editNote(int id, String title, String text){
        notesService.editNotes(id, title, text);
        return "redirect:/notes";
    }

    @GetMapping("delete-note")
    private String noteDeleteScreen(){
        return "delete-note";
    }

    @PostMapping("delete-note")
    private String DeleteNote(int id){
        notesService.deleteNotes(id);
        return "redirect:/notes";
    }
}
