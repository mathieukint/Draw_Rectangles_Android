package fr.epsi.montpellier.tp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editwidth;
    private EditText editheight;
    private View button_add;
    private View button_remove;
    private GeometryLayer gG;

    private SeekBar sBarHoriz;
    private TextView tViewHoriz;

    private SeekBar sBarVerti;
    private TextView tViewVerti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editwidth = findViewById(R.id.editwidth);
        editheight = findViewById(R.id.editheight);
        gG = findViewById(R.id.calque_dessin);

        sBarHoriz = findViewById(R.id.seekBar1);
        tViewHoriz = findViewById(R.id.position_horizontale);
        tViewHoriz.setText((sBarHoriz.getProgress() + "/" + sBarHoriz.getMax()));
        sBarHoriz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pvalX = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pvalX = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tViewHoriz.setText((pvalX + "/" + seekBar.getMax()));
            }
        });

        sBarVerti = findViewById(R.id.seekBar2);
        tViewVerti = findViewById(R.id.position_verticale);
        tViewVerti.setText(sBarVerti.getProgress() + "/" + sBarVerti.getMax());
        sBarVerti.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pvalY = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pvalY = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tViewVerti.setText(pvalY + "/" + seekBar.getMax());
            }
        });

    }



    public void buttonPressedAdd(View button_add){
        int largeur = Integer.parseInt(editwidth.getText().toString());
        int hauteur = Integer.parseInt(editheight.getText().toString());
        int x = sBarHoriz.getProgress();
        int y = sBarVerti.getProgress();

        addRect(x, y, largeur, hauteur);
    }

    public void buttonPressedRemove(View button_remove){
        gG.effacerList();
    }

    private void addRect(int editX, int editY, int editwidth, int editheight){
        //RectangleGeo rect = new RectangleGeo(editX, editY, editwidth, editheight);
        RectangleGeo rect = new RectangleGeo(editX, editY, (editwidth+editX), (editheight+editY));
        gG.ajouterRectangle(rect);
    }


}