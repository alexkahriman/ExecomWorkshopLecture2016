package eu.execom.workshops.workshoplecture.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import eu.execom.workshops.workshoplecture.R;
import eu.execom.workshops.workshoplecture.adapter.StudentsAdapter;
import eu.execom.workshops.workshoplecture.model.Student;

/**
 * A simple {@link Fragment} subclass.
 * Created by Alex on 10/24/16.
 */
public class StudentsFragment extends Fragment {

    private View view;

    public StudentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Getting a reference to this fragment's view.
        view = inflater.inflate(R.layout.fragment_students, container, false);

        initList();

        return view;
    }

    /**
     * Initiate {@link ListView ListView} with it's {@link StudentsAdapter adapter}.
     */
    private void initList() {
        final ListView listView = (ListView) view.findViewById(R.id.list_view);
        final List<Student> students = new ArrayList<>();
        // Generate dummy data
        for (int i = 0; i < 100; i++) {
            students.add(new Student(i % 2 == 0 ? "John Doe" : "JaneDoe",
                    i % 2 == 0 ? "FTN" : "PMF", i % 5 + 1));
        }
        final StudentsAdapter adapter = new StudentsAdapter(getActivity(), students);
        listView.setAdapter(adapter);
    }

}
