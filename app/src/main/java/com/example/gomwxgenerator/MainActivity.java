package com.example.gomwxgenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements
        SeasonFragment.SeasonListener,
        SeasonFragment.SummerListener {

    private static final String TAG_ISSUE_TIME_FRAG = "ISSUE TIME FRAGMENT";

    private SeasonFragment seasonFragment;

    private String seasonQuestion;
    private String spring;
    private String summer;
    private String fall;
    private String winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seasonQuestion = getString(R.string.what_season_is_it);
        spring = getString(R.string.spring);
        summer = getString(R.string.summer);
        fall = getString(R.string.fall);
        winter = getString(R.string.winter);

        // Create Season fragment
        seasonFragment = SeasonFragment.newInstance(seasonQuestion, spring, summer, fall, winter);

        // Show the two created fragments
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.season_question_fragment_container, seasonFragment);
        ft.commit();
    }

    @Override
    public void seasonSelection(String season, String spring, String summer, String fall, String winter) {

        seasonQuestion = season;
        this.spring = spring;
        this.summer = summer;
        this.fall = fall;
        this.winter = winter;

        // Make brand new season Fragment Activity by replacing existing activity
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        seasonFragment = SeasonFragment.newInstance(season, spring, summer, fall, winter);
        ft.replace(R.id.season_question_fragment_container, seasonFragment);

        Log.d("Main Activity", "Season Selection");

        ft.commit();
    }

    @Override
    public void summerSelected() {

//        // Make brand new season Fragment Activity by replacing existing activity
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        summerFragment = com.example.gomwxgenerator.SummerFragment.newInstance();
//        ft.replace(R.id.season_question_fragment_container, seasonFragment);
//
//        Log.d("Main Activity", "Save Edits");
//
//        ft.commit();
    }

/**
 * Finish later
 */
//    @Override
//    public void editSurveyButtonPressed() {
//
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//
//        // Make brand new ConfigureSurvey Fragment Activity by replacing ResultsFragment
//        IssueTimeFragment issueTimeFragment = IssueTimeFragment.newInstance();
//        ft.replace(R.id.survey_question_fragment_container, issueTimeFragment);
//        ft.addToBackStack(TAG_ISSUE_TIME_FRAG);
//
//        ft.commit();
//    }

//    @Override
//    public void resetResults(int answerOneCount, int answerTwoCount) {
//
//        // Make brand new results Fragment Activity by replacing existing activity
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//
//        mSurveyQuestionFragment = SurveyQuestionFragment.newInstance(mQuestion, mAnswerOne, mAnswerTwo);
//        ft.replace(R.id.survey_question_fragment_container, mSurveyQuestionFragment);
//
//        mResultsFragment = ResultsFragment.newInstance(answerOneCount, answerTwoCount);
//        ft.replace(R.id.results_fragment_container, mResultsFragment);
//
//        ft.commit();
//    }
//
//    // Opens ConfigureSurveyFragment
//    public void editSurveyButtonPressed() {
//
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//
//        // Make brand new ConfigureSurvey Fragment Activity by replacing ResultsFragment
//        ConfigureSurveyFragment mConfigureSurveyFragment = ConfigureSurveyFragment.newInstance();
//        ft.replace(R.id.results_fragment_container, mConfigureSurveyFragment);
//        ft.addToBackStack(TAG_CONFIG_FRAG);
//
//        ft.commit();
//    }
}

