package com.hfad.mycoffee.play;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.os.Bundle;

import com.hfad.mycoffee.R;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Dialog dialog = createInstructionsDialog();
        dialog.show();
    }

    private Dialog createInstructionsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.cup_of_drink)
                .setTitle(R.string.instructions_title)
                .setMessage(R.string.instructions)
                .setPositiveButtonIcon(ContextCompat.getDrawable(this, android.R.drawable.ic_media_play));
        return builder.create();
    }
}
