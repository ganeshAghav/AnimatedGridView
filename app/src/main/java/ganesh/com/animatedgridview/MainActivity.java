package ganesh.com.animatedgridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ganesh.com.library.AnimatedGridView;

public class MainActivity extends AppCompatActivity {

    AnimatedGridView agv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agv = (AnimatedGridView) findViewById(R.id.gridview);
        agv.setAdapter(new SampleAdapter());
    }
}