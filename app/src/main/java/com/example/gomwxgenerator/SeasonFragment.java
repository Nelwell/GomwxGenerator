package com.example.gomwxgenerator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import static android.content.ContentValues.TAG;

/**
 * Where user chooses current season
 */
public class SeasonFragment extends Fragment {
//    private int mAnswerOneCount = 0;
//    private int mAnswerTwoCount = 0;
    private String season;
    private String summer;
    private String fall;
    private String winter;
    private String spring;

    private static final String ARG_SEASON = "arg_season_question";
    private static final String ARG_SUMMER = "arg_summer";
    private static final String ARG_FALL = "arg_fall";
    private static final String ARG_WINTER = "arg_winter";
    private static final String ARG_SPRING = "arg_spring";

    interface SeasonListener {
        void seasonSelection(String season, String summer, String fall, String winter, String spring);
    }

    private SeasonListener seasonListener;

    interface SummerListener {
        void summerSelected();
    }

    private SummerListener summerListener;

    public SeasonFragment() {
        // Required empty public constructor
    }

    public static SeasonFragment newInstance(String question, String spring, String summer,
                                             String fall, String winter) {
        SeasonFragment fragment = new SeasonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SEASON, question);
        args.putString(ARG_FALL, spring);
        args.putString(ARG_SUMMER, summer);
        args.putString(ARG_FALL, fall);
        args.putString(ARG_FALL, winter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            season = getArguments().getString(ARG_SEASON);
            spring = getArguments().getString(ARG_SPRING);
            summer = getArguments().getString(ARG_SUMMER);
            fall = getArguments().getString(ARG_FALL);
            winter = getArguments().getString(ARG_WINTER);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.d(TAG, "onAttach");

        // Verifies it's a listener
        if (context instanceof SeasonListener){  // Context is the hosting Activity.
            seasonListener = (SeasonListener) context;
            Log.d(TAG, "Listener set");
        } else  {
            throw new RuntimeException(context.toString() + " must implement SeasonListener");
        }

        if (context instanceof SummerListener){  // Context is the hosting Activity.
            summerListener = (SummerListener) context;
            Log.d(TAG, "Listener set");
        } else {
            throw new RuntimeException(context.toString() + " must implement SummerListener");
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_season, container, false);

        TextView seasonQuestion = view.findViewById(R.id.survey_question);
        seasonQuestion.setText(season);
        // Get button IDs and TextView String resource ID
        Button springButton = view.findViewById(R.id.spring_button);
        springButton.setText(spring);
        Button summerButton = view.findViewById(R.id.summer_button);
        summerButton.setText(summer);
        Button fallButton = view.findViewById(R.id.fall_button);
        fallButton.setText(fall);
        Button winterButton = view.findViewById(R.id.winter_button);
        winterButton.setText(winter);

        summerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Season", "Summer selected");
                summerListener.summerSelected();
            }
        });
//
//        mAnswerTwoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("SURVEY", "Second answer " + mAnswerTwoCount);
//                mAnswerTwoCount++; // Adds one vote per click
//                mResultsListener.surveyResults(mAnswerOneCount, mAnswerTwoCount);
//            }
//        });

        return view;
    }
}
