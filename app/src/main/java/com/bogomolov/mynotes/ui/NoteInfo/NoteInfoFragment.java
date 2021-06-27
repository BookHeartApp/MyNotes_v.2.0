package com.bogomolov.mynotes.ui.NoteInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bogomolov.mynotes.R;
import com.bogomolov.mynotes.domain.Note;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NoteInfoFragment extends Fragment {

    public static final String ARG_NOTE = "ARG_NOTE";

    public NoteInfoFragment() {
    }

    public static NoteInfoFragment newInstance(Note note) {
        NoteInfoFragment f = new NoteInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Note note = getArguments().getParcelable(ARG_NOTE);

        TextView heading = view.findViewById(R.id.task_name);
        TextView description = view.findViewById(R.id.task_description);

        heading.setText(note.getName());
        description.setText(note.getDescription());
    }

}
