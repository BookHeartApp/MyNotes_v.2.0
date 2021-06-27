package com.bogomolov.mynotes.domain;

import java.util.ArrayList;

public interface NoteRepository {

    ArrayList<Note> getNotes();

    void deleteElement(Note note);

    void deleteAll();

    Note addNote(String name, String description, String dateCreation, boolean isCompleted);
}