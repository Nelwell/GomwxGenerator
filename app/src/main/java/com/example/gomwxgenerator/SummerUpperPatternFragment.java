//package com.example.gomwxgenerator;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//
//import static android.content.ContentValues.TAG;
//
//public class SummerUpperPatternFragment {
//
//    interface UpperPatternListener {
//        void summerSelected();
//    }
//
//    private UpperPatternListener upperPatternListener;
//
//    public SummerUpperPatternFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        Log.d(TAG, "onAttach");
//
//        // Verifies it's a listener
//        if (context instanceof UpperPatternListener) {  // Context is the hosting Activity.
//            upperPatternListener = (UpperPatternListener) context;
//            Log.d(TAG, "Listener set");
//        } else {
//            throw new RuntimeException(context.toString() + " must implement UpperPatternListener");
//        }
//    }
//
//    @Override
//    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_season, container, false);
//
//        TextView seasonQuestion = view.findViewById(R.id.survey_question);
//        seasonQuestion.setText(season);
//        // Get button IDs and TextView String resource ID
//        Button springButton = view.findViewById(R.id.spring_button);
//        springButton.setText(spring);
//        Button summerButton = view.findViewById(R.id.summer_button);
//        summerButton.setText(summer);
//        Button fallButton = view.findViewById(R.id.fall_button);
//        fallButton.setText(fall);
//        Button winterButton = view.findViewById(R.id.winter_button);
//        winterButton.setText(winter);
//
//        summerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Season", "Summer selected");
//                upperPatternListener.summerSelected();
//            }
//        });
//
//        return view;
//    }
//
//}
