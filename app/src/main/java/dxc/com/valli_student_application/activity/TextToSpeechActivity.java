package dxc.com.valli_student_application.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import dxc.com.valli_student_application.R;

public class TextToSpeechActivity extends AppCompatActivity implements
        TextToSpeech.OnInitListener{

    /** Called when the activity is first created. */

    private TextToSpeech tts;
    private Button buttonSpeak;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);


        tts = new TextToSpeech(this, this);
        buttonSpeak = (Button) findViewById(R.id.button1);
        editText = (EditText) findViewById(R.id.editText1);

        buttonSpeak.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0)
            {
                speakOut();

                String msg=editText.getText().toString();
                Toast.makeText(getApplicationContext(), msg,
                        Toast.LENGTH_LONG).show();
            }

        });
    } // end of onCreate Method


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void speakOut() {
        String text = editText.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
//        tts.speak(text.subSequence(0,text.length()),TextToSpeech.QUEUE_FLUSH,null,"1");
//        tts.spe
//        tts.speak(text.subSequence(0,10),1,null,1);
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                buttonSpeak.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    @Override
    public void onDestroy() {
// Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

}
