package com.example.android.courtcounter_project2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int setNumber = 1;
    private int setWonByA = 0;
    private int setWonByB = 0;

    private TextView scoreAView;
    private TextView scoreBView;
    private TextView setA1;
    private TextView setB1;
    private TextView setA2;
    private TextView setB2;
    private TextView setA3;
    private TextView setB3;
    private TextView setA4;
    private TextView setB4;
    private TextView setA5;
    private TextView setB5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //makes the link clickable
        //https://stackoverflow.com/questions/2734270/how-do-i-make-links-in-a-textview-clickable/45368503#45368503
        TextView getrules =(TextView) findViewById(R.id.getrules);
        getrules.setMovementMethod(LinkMovementMethod.getInstance());

        //View instances
        scoreAView = (TextView) findViewById(R.id.team_a_score);
        scoreBView = (TextView) findViewById(R.id.team_b_score);
        setA1 = (TextView) findViewById(R.id.team_a_set_1);
        setB1 = (TextView) findViewById(R.id.team_b_set_1);
        setA2 = (TextView) findViewById(R.id.team_a_set_2);
        setB2 = (TextView) findViewById(R.id.team_b_set_2);
        setA3 = (TextView) findViewById(R.id.team_a_set_3);
        setB3 = (TextView) findViewById(R.id.team_b_set_3);
        setA4 = (TextView) findViewById(R.id.team_a_set_4);
        setB4 = (TextView) findViewById(R.id.team_b_set_4);
        setA5 = (TextView) findViewById(R.id.team_a_set_5);
        setB5 = (TextView) findViewById(R.id.team_b_set_5);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A.
     */
    public void addForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        checkIfTeamAWinSet();
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreAView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Team B.
     */
    public void addForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        checkIfTeamBWinSet();
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        scoreBView.setText(String.valueOf(score));
    }

    /**
     * Reset set (onCLick).
     */
    public void resetSet(View v) {
        resetSet();
    }

    /**
     * Reset set.
     */
    private void resetSet() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }


    /**
     * Reset game (onClick).
     */
    public void resetGame(View v) {
        resetGame();
    }

    /**
     * Reset game.
     */
    public void resetGame() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        setNumber = 1;
        setWonByA = 0;
        setWonByB = 0;
        setNumber = 1;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        resetSetOneScores();
        resetSetTwoScores();
        resetSetThreeScores();
        resetSetFourScores();
        resetSetFiveScores();
    }

    /**
     * Check if Team A wins the set.
     */
    public void checkIfTeamAWinSet() {
        //String message = "";
        // check the winning set score based on set number
        int setWinningNumber = 0;
        if (setNumber < 5) {
            setWinningNumber = 25;
        }
        else {
            setWinningNumber = 15;
        }

        //check if team A wins the sets
        if (scoreTeamA < setWinningNumber) {}
        else {
            int diff;
            diff = scoreTeamA - scoreTeamB;
            if (diff >= 2){
                // tally number of sets won by A
                setWonByA++;

                //display the approriate set scores
                switch (setNumber){
                    case 1:
                        displaySetOneScores(scoreTeamA,scoreTeamB);
                        break;
                    case 2:
                        displaySetTwoScores(scoreTeamA,scoreTeamB);
                        break;
                    case 3:
                        displaySetThreeScores(scoreTeamA,scoreTeamB);
                        break;
                    case 4:
                        displaySetFourScores(scoreTeamA,scoreTeamB);
                        break;
                    case 5:
                        displaySetFiveScores(scoreTeamA,scoreTeamB);
                        break;
                    default:
                        break;
                }

                //https://stackoverflow.com/questions/43513919/android-alert-dialog-with-one-two-and-three-buttons
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                if (setWonByA == 3){
                    builder.setTitle("CONGRATULATION!");
                    //message = "Team A won the game!";
                    //message = message + "\n" + "Set number: " + String.valueOf(setNumber);
                    //message = message + "\n" + "Set won by Team A: " + String.valueOf(setWonByA);
                    //builder.setMessage(message);
                    builder.setMessage("Team A won the game!");
                }
                else {
                    builder.setTitle("Good Job");
                    //message = "Team A won this set!";
                    //message = message + "\n" + "Set number: " + String.valueOf(setNumber);
                    //message = message + "\n" + "Set won by Team A: " + String.valueOf(setWonByA);
                    //builder.setMessage(message);
                    builder.setMessage("Team A won this set!");
                }

                // add a button
                if (setWonByA == 3){
                    builder.setPositiveButton("Game Over", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do something like...
                            //launchMissile();
                        }
                    });
                }
                else {
                    builder.setPositiveButton("Next Set", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do something like...
                            //launchMissile();
                        }
                    });
                }

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.setCancelable(false);
                dialog.show();

                // ready for next set or game
                if (setWonByA == 3){
                    resetGame();
                }
                else {
                    setNumber++;
                    resetSet();
                }
            }
        }
    }

    /**
     * Check if Team B wins the set.
     */
    public void checkIfTeamBWinSet() {
        //String message = "";
        // check the winning set score based on set number
        int setWinningNumber = 0;
        if (setNumber < 5) {
            setWinningNumber = 25;
        }
        else {
            setWinningNumber = 15;
        }

        //check if team B wins the sets
        if (scoreTeamB < setWinningNumber) {}
        else {
            int diff;
            diff = scoreTeamB - scoreTeamA;
            if (diff >= 2){
                // tally number of sets won by B
                setWonByB++;

                //display the approriate set scores
                switch (setNumber){
                    case 1:
                        displaySetOneScores(scoreTeamA,scoreTeamB);
                        break;
                    case 2:
                        displaySetTwoScores(scoreTeamA,scoreTeamB);
                        break;
                    case 3:
                        displaySetThreeScores(scoreTeamA,scoreTeamB);
                        break;
                    case 4:
                        displaySetFourScores(scoreTeamA,scoreTeamB);
                        break;
                    case 5:
                        displaySetFiveScores(scoreTeamA,scoreTeamB);
                        break;
                    default:
                        break;
                }

                //https://stackoverflow.com/questions/43513919/android-alert-dialog-with-one-two-and-three-buttons
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                if (setWonByB == 3){
                    builder.setTitle("CONGRATULATION!");
                    //message = "Team B won the game!";
                    //message = message + "\n" + "Set number: " + String.valueOf(setNumber);
                    //message = message + "\n" + "Set won by Team B: " + String.valueOf(setWonByB);
                    //builder.setMessage(message);
                    builder.setMessage("Team B won the game!");
                }
                else {
                    builder.setTitle("Good Job");
                    //message = "Team B won this set!";
                    //message = message + "\n" + "Set number: " + String.valueOf(setNumber);
                    //message = message + "\n" + "Set won by Team B: " + String.valueOf(setWonByB);
                    //builder.setMessage(message);
                    builder.setMessage("Team B won this set!");
                }

                // add a button
                if (setWonByB == 3){
                    builder.setPositiveButton("Game Over", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do something like...
                            //launchMissile();
                        }
                    });
                }
                else {
                    builder.setPositiveButton("Next Set", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do something like...
                            //launchMissile();
                        }
                    });
                }

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.setCancelable(false);
                dialog.show();

                // ready for next set or game
                if (setWonByB == 3){
                    resetGame();
                }
                else {
                    setNumber++;
                    resetSet();
                }
            }
        }
    }


    /**
     * Displays set 1 scores.
     */
    public void displaySetOneScores(int scoreA, int scoreB) {
        setA1.setText(String.valueOf(scoreA));
        setB1.setText(String.valueOf(scoreB));
    }

    /**
     * Reset Set 1 scores.
     */
    public void resetSetOneScores() {
        setA1.setText("");
        setB1.setText("");
    }

    /**
     * Displays set 2 scores.
     */
    public void displaySetTwoScores(int scoreA, int scoreB) {
        setA2.setText(String.valueOf(scoreA));
        setB2.setText(String.valueOf(scoreB));
    }

    /**
     * Reset Set 2 scores.
     */
    public void resetSetTwoScores() {
        setA2.setText("");
        setB2.setText("");
    }

    /**
     * Displays set 3 scores.
     */
    public void displaySetThreeScores(int scoreA, int scoreB) {
        setA3.setText(String.valueOf(scoreA));
        setB3.setText(String.valueOf(scoreB));
    }

    /**
     * Reset Set 3 scores.
     */
    public void resetSetThreeScores() {
        setA3.setText("");
        setB3.setText("");
    }

    /**
     * Displays set 4 scores.
     */
    public void displaySetFourScores(int scoreA, int scoreB) {
        setA4.setText(String.valueOf(scoreA));
        setB4.setText(String.valueOf(scoreB));
    }

    /**
     * Reset Set 4 scores.
     */
    public void resetSetFourScores() {
        setA4.setText("");
        setB4.setText("");
    }

    /**
     * Displays set 5 scores.
     */
    public void displaySetFiveScores(int scoreA, int scoreB) {
        setA5.setText(String.valueOf(scoreA));
        setB5.setText(String.valueOf(scoreB));
    }

    /**
     * Reset Set 5 scores.
     */
    public void resetSetFiveScores() {
        setA5.setText("");
        setB5.setText("");
    }




    /**
     * Displays announcement text.
     */
    public void displayAnnouncement(String msg) {
        TextView announcement = (TextView) findViewById(R.id.announcement);
        announcement.setText(String.valueOf(msg));
    }



}
