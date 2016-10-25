package eu.execom.workshops.workshoplecture.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import eu.execom.workshops.workshoplecture.R;
import eu.execom.workshops.workshoplecture.model.Student;

/**
 * {@link BaseAdapter Adapter} that provides a data source to a {@link android.widget.ListView ListView}.
 * Created by Alex on 10/24/16.
 */

public class StudentsAdapter extends BaseAdapter {

    private static final String DUMMY_IMAGE_URL = "http://www.msuv.org/assets/media/arhitektura/arhitektura_2013_02.jpg";

    /**
     * {@link List List} of {@link Student students}.
     */
    private final List<Student> students;

    /**
     * Used to inflate layouts.
     */
    private final LayoutInflater layoutInflater;

    /**
     * Used for localization in this class.
     */
    private final Context context;

    public StudentsAdapter(Context context, List<Student> students) {
        this.students = students;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        // If convertView is null, it hasn't been inflated yet
        if (convertView == null) {
            // Since we are about to create a new view, we need a new ViewHolder to hold children
            // references.
            viewHolder = new ViewHolder();
            // Inflate layout
            convertView = layoutInflater.inflate(R.layout.item_student, parent, false);
            // Get references, store them in viewHolder
            viewHolder.fullName = (TextView) convertView.findViewById(R.id.full_name);
            viewHolder.faculty = (TextView) convertView.findViewById(R.id.faculty);
            viewHolder.yearOfStudy = (TextView) convertView.findViewById(R.id.year_of_study);
            viewHolder.image = (SimpleDraweeView) convertView.findViewById(R.id.image);
            // Set this instance of ViewHolder as a tag for this view
            // This way, we can get the holder and all the references faster when
            // this view comes back for reuse.
            convertView.setTag(viewHolder);
        } else {
            // If convertView is not null, the view is already inflated and ready for reuse.
            // We just need to extract the viewHolder from it in order to have references to
            // it's child views.
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the students for this position
        final Student student = (Student) getItem(position);

        // Populate views with data from this student
        viewHolder.fullName.setText(student.getFullName());
        viewHolder.faculty.setText(student.getFaculty());
        viewHolder.yearOfStudy.setText(context.getString(R.string.year_of_study, student.getYearOfStudy()));

        final Uri uri = Uri.parse(DUMMY_IMAGE_URL);
        viewHolder.image.setImageURI(uri);

        return convertView;
    }

    /**
     * Holder for view references.
     */
    private static class ViewHolder {

        TextView fullName;

        TextView faculty;

        TextView yearOfStudy;

        SimpleDraweeView image;
    }
}
