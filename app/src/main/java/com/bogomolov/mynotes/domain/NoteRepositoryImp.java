package com.bogomolov.mynotes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class NoteRepositoryImp implements NoteRepository, Parcelable {

    public static final NoteRepositoryImp INSTANCE = new NoteRepositoryImp();
    public ArrayList<Note> result = new ArrayList<>();

    public NoteRepositoryImp() {
        result.clear();
        result.add(new Note("Чтение", "Уделить чтению 1 час. Чужак в стране чужой", "Дата создания: 26.02.2021", true));
        result.add(new Note("Уборка", "Убраться дома", "Дата создания: 25.02.2021", true));
        result.add(new Note("Зарядка", "Сделать комплекс физических упражнений", "Дата создания: 26.02.2021", true));
        result.add(new Note("Поход в магазин", "Купить продукты: хлеб, молоко, фрукты, овощи", "Дата создания: 26.02.2021", true));
        result.add(new Note("Прогулка", "Пройтись вечером в парке", "Дата создания: 26.02.2021", false));
        result.add(new Note("Ужин", "Приготовить курицу в духовке, на гарнир макароны", "Дата создания: 26.02.2021", false));
        result.add(new Note("Сон", "Лечь не позже 22.00", "Дата создания: 26.02.2021", false));
    }


    protected NoteRepositoryImp(Parcel in) {
        result = in.createTypedArrayList(Note.CREATOR);
    }

    public static final Creator<NoteRepositoryImp> CREATOR = new Creator<NoteRepositoryImp>() {
        @Override
        public NoteRepositoryImp createFromParcel(Parcel in) {
            return new NoteRepositoryImp(in);
        }

        @Override
        public NoteRepositoryImp[] newArray(int size) {
            return new NoteRepositoryImp[size];
        }
    };

    public ArrayList<Note> getNotes() {
        return result;
    }

    @Override
    public void deleteElement(Note note) {
        result.remove(note);
    }

    @Override
    public void deleteAll() {
        result.clear();
    }

    @Override
    public Note addNote(String name, String description, String dateCreation, boolean isCompleted) {
        Note note = new Note(name, description, dateCreation, true);
        result.add(note);
        return note;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(result);
    }
}
