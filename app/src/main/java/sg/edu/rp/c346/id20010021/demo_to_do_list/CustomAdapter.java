package sg.edu.rp.c346.id20010021.demo_to_do_list;

import android.content.Context;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> versionList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView textViewm = rowView.findViewById(R.id.textViewm);
        TextView textViewd = rowView.findViewById(R.id.textViewd);

        // Obtain the Android Version information based on the position
        ToDoItem currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        textViewm.setText(currentVersion.getTitle());
        String str = currentVersion.getDate().get(Calendar.DAY_OF_MONTH) + "/" + currentVersion.getDate().get(Calendar.MONTH)
                + "/" + currentVersion.getDate().get(Calendar.YEAR) + " (" + getDay(currentVersion.getDate().get(Calendar.DAY_OF_WEEK)) + ")";
        textViewd.setText(str);

        return rowView;
    }

    private String getDay(int day) {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "";
        }
    }
}