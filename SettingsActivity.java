package edu.byuh.cis.cs203.numberedsquares;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.view.MotionEvent;
import android.widget.Switch;
import androidx.preference.SeekBarPreference;

public class SettingsActivity extends PreferenceActivity
{



    /**
     * takes care of all initialization stuff
     * @param b bundle (required)
     */
    @Override
    public void onCreate(Bundle b)
    {
        super.onCreate(b);

        //create preferences screen
        PreferenceScreen ps = getPreferenceManager().createPreferenceScreen(this);

        //create switch setting for music
        SwitchPreference music = new SwitchPreference(this);

        //set music title and words
        music.setTitle("Background Music");
        music.setSummaryOn("on");
        music.setSummaryOff("off");

        //default the music to be on
        music.setDefaultValue(true);

        //set key
        music.setKey("music setting");

        //add the music preference to the screen
        ps.addPreference(music);





        //create switch setting for speed/difficulty
        SwitchPreference difficulty = new SwitchPreference(this);

        //set speed title and words
        difficulty.setTitle("Difficulty");
        difficulty.setSummaryOn("hard");
        difficulty.setSummaryOff("easy");

        //default the difficulty to be easy
        difficulty.setDefaultValue(false);

        //set key
        difficulty.setKey("difficulty");

        //add the difficulty preference to the screen
        ps.addPreference(difficulty);



        //set the preference screen
        setPreferenceScreen(ps);




    }





    /**
     * overridden touch event method - gets called when user touches screen
     *
     * @param m - motion event (required)
     * @return always returns true
     */
    @Override
    public boolean onTouchEvent(MotionEvent m)
    {
        //if user touches screen, start game
        if(m.getAction() == MotionEvent.ACTION_DOWN)
        {

            //start the game (MainActivity)
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

            //kill the beginning page/activity
            finish();

        }

        //always returns true
        return true;
    }





    /**
     * facade method to return whether or not the music is on in settings
     * @param c context
     * @return returns true if the sound is on, false if it is off
     */
    public static boolean soundOn(Context c)
    {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("music setting",true);
    }




    /**
     * facade method to return whether or not the game is set to hard mode
     * @param c context
     * @return returns true if on hard mode, false if not
     */
    public static boolean isHard(Context c)
    {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("difficulty",true);
    }




}
