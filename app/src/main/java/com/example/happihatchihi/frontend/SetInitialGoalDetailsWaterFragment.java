package com.example.happihatchihi.frontend;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.happihatchihi.R;

import java.util.Locale;
import java.util.Objects;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import java.util.Locale;


public class SetInitialGoalDetailsWaterFragment extends Fragment {
    int hour, minute;

    /**
     * Default constructor for SetInitialGoalsFragment.
     * Required empty public constructor.
     */
    public SetInitialGoalDetailsWaterFragment() {
        // Required empty public constructor
    }

    public static SetInitialGoalsFragment newInstance() {
        SetInitialGoalsFragment fragment = new SetInitialGoalsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

        };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setgoaldetailswater, container, false);

        Button timePickerButton1 = view.findViewById(R.id.timePickerButton1);
        timePickerButton1.setVisibility(View.GONE);
        Button timePickerButton2 = view.findViewById(R.id.timePickerButton2);
        timePickerButton2.setVisibility(View.GONE);
        Button timePickerButton3 = view.findViewById(R.id.timePickerButton3);
        timePickerButton3.setVisibility(View.GONE);
        Button timePickerButton4 = view.findViewById(R.id.timePickerButton4);
        timePickerButton4.setVisibility(View.GONE);
        Button timePickerButton5 = view.findViewById(R.id.timePickerButton5);
        timePickerButton5.setVisibility(View.GONE);

        Spinner spinner = (Spinner) view.findViewById(R.id.frequencySpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                view.getContext(),
                R.array.day_array,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);

        Spinner recurrencespinner = (Spinner) view.findViewById(R.id.recurrenceSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> recurrenceadapter = ArrayAdapter.createFromResource(
                view.getContext(),
                R.array.recurrence_array,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        recurrenceadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        recurrencespinner.setAdapter(recurrenceadapter);

        Spinner notificationspinner = (Spinner) view.findViewById(R.id.notificationSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> notificationadapter = ArrayAdapter.createFromResource(
                view.getContext(),
                R.array.notification_array,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        notificationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        notificationspinner.setAdapter(notificationadapter);

        // Add onClick listener for backButton ImageView
        ImageView backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SetInitialGoalsFragment
                Fragment setInitialGoalsFragment = new SetInitialGoalsFragment();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, setInitialGoalsFragment)
                        .commit();
            }
        });

        timePickerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //popTimePicker(v);
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        timePickerButton1.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                    }
                };

                TimePickerDialog timePickerDialog= new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, true);

                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();    }
        });

        timePickerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //popTimePicker(v);
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        timePickerButton2.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                    }
                };

                TimePickerDialog timePickerDialog= new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, true);

                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();    }
        });

        timePickerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //popTimePicker(v);
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        timePickerButton3.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                    }
                };

                TimePickerDialog timePickerDialog= new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, true);

                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();    }
        });

        // Add onClick listener for addAnotherGoalButton
        Button addAnotherGoalButton = view.findViewById(R.id.anotherGoalButton);
        addAnotherGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SetInitialGoalsFragment
                Fragment setInitialGoalsFragment = new SetInitialGoalsFragment();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, setInitialGoalsFragment)
                        .commit();
            }
        });

        timePickerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //popTimePicker(v);
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        timePickerButton4.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                    }
                };

                TimePickerDialog timePickerDialog= new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, true);

                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();    }
        });

        // Add onClick listener for nextButton
        Button nextButton = view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to GoalsSummaryFragment
                Fragment goalsSummaryFragment = new GoalSummaryFragment();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, goalsSummaryFragment)
                        .commit();
            }
        });

        timePickerButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //popTimePicker(v);
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        timePickerButton5.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                    }
                };

                TimePickerDialog timePickerDialog= new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, true);

                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();    }
        });

        recurrencespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedNumber = (String) recurrencespinner.getItemAtPosition(position);
                String selectedOption = (String) notificationspinner.getSelectedItem();
                if (selectedOption.equals("On")) {
                    int number = Integer.parseInt(selectedNumber);
                    for (int i = 1; i <= number; i++) {
                        switch (i) {
                            case 1:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.GONE);
                                timePickerButton3.setVisibility(View.GONE);
                                timePickerButton4.setVisibility(View.GONE);
                                timePickerButton5.setVisibility(View.GONE);
                                break;
                            case 2:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.VISIBLE);
                                timePickerButton3.setVisibility(View.GONE);
                                timePickerButton4.setVisibility(View.GONE);
                                timePickerButton5.setVisibility(View.GONE);
                                break;
                            case 3:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.VISIBLE);
                                timePickerButton3.setVisibility(View.VISIBLE);
                                timePickerButton4.setVisibility(View.GONE);
                                timePickerButton5.setVisibility(View.GONE);
                                break;
                            case 4:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.VISIBLE);
                                timePickerButton3.setVisibility(View.VISIBLE);
                                timePickerButton4.setVisibility(View.VISIBLE);
                                timePickerButton5.setVisibility(View.GONE);
                                break;
                            case 5:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.VISIBLE);
                                timePickerButton3.setVisibility(View.VISIBLE);
                                timePickerButton4.setVisibility(View.VISIBLE);
                                timePickerButton5.setVisibility(View.VISIBLE);
                                break;
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });


        notificationspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedNumber = (String) recurrencespinner.getSelectedItem();
                if (position == 1) {
                    int number = Integer.parseInt(selectedNumber);
                    for (int i = 1; i <= number; i++) {
                        switch (i) {
                            case 1:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.GONE);
                                timePickerButton3.setVisibility(View.GONE);
                                timePickerButton4.setVisibility(View.GONE);
                                timePickerButton5.setVisibility(View.GONE);
                                break;
                            case 2:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.VISIBLE);
                                timePickerButton3.setVisibility(View.GONE);
                                timePickerButton4.setVisibility(View.GONE);
                                timePickerButton5.setVisibility(View.GONE);
                                break;
                            case 3:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.VISIBLE);
                                timePickerButton3.setVisibility(View.VISIBLE);
                                timePickerButton4.setVisibility(View.GONE);
                                timePickerButton5.setVisibility(View.GONE);
                                break;
                            case 4:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.VISIBLE);
                                timePickerButton3.setVisibility(View.VISIBLE);
                                timePickerButton4.setVisibility(View.VISIBLE);
                                timePickerButton5.setVisibility(View.GONE);
                                break;
                            case 5:
                                timePickerButton1.setVisibility(View.VISIBLE);
                                timePickerButton2.setVisibility(View.VISIBLE);
                                timePickerButton3.setVisibility(View.VISIBLE);
                                timePickerButton4.setVisibility(View.VISIBLE);
                                timePickerButton5.setVisibility(View.VISIBLE);
                                break;
                        }
                    }
                }
                if (position == 2) {
                    timePickerButton1.setVisibility(View.GONE);
                    timePickerButton2.setVisibility(View.GONE);
                    timePickerButton3.setVisibility(View.GONE);
                    timePickerButton4.setVisibility(View.GONE);
                    timePickerButton5.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        return view;
    }

}