package com.example.gomwxgenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements
        SeasonFragment.EditSurveyButtonListener,
        IssueTimeFragment.ResetResultsListener {
//        ConfigureSurveyFragment.NewSurveyListener {

    private static final String TAG_ISSUE_TIME_FRAG = "ISSUE TIME FRAGMENT";

    private SeasonFragment seasonFragment;

    private String seasonQuestion;
    private String summer;
    private String fall;
    private String winter;
    private String spring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seasonQuestion = getString(R.string.what_season_is_it);
        summer = getString(R.string.summer);
        fall = getString(R.string.fall);
        winter = getString(R.string.winter);
        spring = getString(R.string.spring);

        // Create Season fragment
        seasonFragment = SeasonFragment.newInstance(seasonQuestion, summer, fall, winter, spring);

        // Show the two created fragments
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.survey_question_fragment_container, seasonFragment);
        ft.commit();
    }

    @Override
    public void saveEdits(String season, String summer, String fall,
                          String winter, String spring) {

        seasonQuestion = season;
        this.summer = summer;
        this.fall = fall;
        this.winter = winter;
        this.spring = spring;

        // Make brand new survey Fragment Activity by replacing existing activity
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        seasonFragment = SeasonFragment.newInstance(season, summer, fall, winter, spring);
        ft.replace(R.id.survey_question_fragment_container, seasonFragment);

        Log.d("Main Activity", "Save Edits");

        ft.commit();
    }

    @Override
    public void editSurveyButtonPressed() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Make brand new ConfigureSurvey Fragment Activity by replacing ResultsFragment
        IssueTimeFragment issueTimeFragment = IssueTimeFragment.newInstance();
        ft.replace(R.id.survey_question_fragment_container, issueTimeFragment);
        ft.addToBackStack(TAG_ISSUE_TIME_FRAG);

        ft.commit();
    }

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

