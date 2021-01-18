package com.example.flagquiz;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FirstFragment extends Fragment {

    private static final String TAG = "FlagQuiz Activity";
    private static final int FLAGS_IN_QUIZ = 10;

    private List<String> fileNameList;
    private List<String> quizCountriesList;
    private Set<String> regionsSet;
    private String correctAnswer;
    private int totalGuesses;
    private int correctAnswers;
    private int guessRows;
    private SecureRandom random;
    private Handler handler;
    private Animation shakeAnimation;

    private LinearLayout quizLinearLayout;
    private TextView questionNumberTextView;
    private ImageView flagImageView;
    private LinearLayout[] guessLinearLayout;
    private TextView answerTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        fileNameList = new ArrayList<>();
        quizCountriesList = new ArrayList<>();
        random = new SecureRandom();
        handler = new Handler();

        shakeAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.incorrect_shake);
        shakeAnimation.setRepeatCount(3);

        quizLinearLayout = view.findViewById(R.id.quizLinearLayout);
        questionNumberTextView = view.findViewById(R.id.questionNumberTextView);
        flagImageView = view .findViewById(R.id.flagImageView);
        guessLinearLayout = new LinearLayout[4];
        guessLinearLayout[0] = view.findViewById(R.id.row1LinearLayout);
        guessLinearLayout[1] = view.findViewById(R.id.row2LinearLayout);
        guessLinearLayout[2] = view.findViewById(R.id.row3LinearLayout);
        guessLinearLayout[3] = view.findViewById(R.id.row4LinearLayout);
        answerTextView = view.findViewById(R.id.answerTextView);

        questionNumberTextView.setText(getString(R.string.question, 1, FLAGS_IN_QUIZ));
        // Inflate the layout for this fragment
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}