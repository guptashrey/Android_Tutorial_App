package net.shreygupta.tutorial;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    private final int [] img = {
            R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6,
            R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10, R.drawable.r11, R.drawable.r12,
            R.drawable.r13, R.drawable.r14, R.drawable.r15, R.drawable.r16, R.drawable.r17, R.drawable.r18,
            R.drawable.r19, R.drawable.r20};

    private final String [] info = {
            "Initially developed by Android Inc., which Google bought in 2005, Android " +
                    "was unveiled in 2007, along with the founding of the Open Handset Alliance " +
                    "– a consortium of hardware, software, and telecommunication companies.",

            "onCreate() -> onStart() -> onRestoreInstanceState() -> onResume -> onPause() -> " +
                    "onSaveInstanceState() -> onStop() -> onDestroy().",

            "Whenever we change the orientation i.e. Either landscape -> portrait Or portrait -> " +
                    "landscape, the activity created again. If we want to fix the orientation, we " +
                    "need to do it in the manifest file.",

            "Log class is mainly used for debugging purpose. Methods Used: Log.e, Log.i, Log.v, Log.d, Log.w",

            "Event Handling: It can be done by two ways: 1. XML 2. Java.",

            "Toast is used to broadcast a message on any specific event. It uses a static method " +
                    "makeText which takes three parameters: Toast.makeText(Context, Message, Duration).",

            "Context is an abstract class which helps convey the msg in different classes. It helps" +
                    " in transferring data from one activity to other.",

            "View Group is a object which is responsible for arranging the components (Views) in different manner.",

            "Layout Inflator helps us to convert a XML file into Java object.",

            "Margin indicates the gap between boundary of UI component and its neighbour.",

            "Padding is gap between boundary and internal content.",

            "A user interface element that displays text to the user.",

            "It is similar to text view. Additional feature is that it is user editable.",

            "Allows the user to select one or more options from a set of available options.",

            "Text along with a radio check button. We need to group all radio buttons together " +
                    "to put constraint that only one of them can be selected.",

            "Types of Layouts: Linear, Relative, Table, Grid, Frame, Constant.",

            "Is a basic layout which arrange the different components either in vertical form or " +
                    "in horizontal form. By default it is horizontal.",

            "It is also a basic layout which arranges the views with respect to its parent or its neighbours.",

            "Arrange the views in tabular form (rows and columns). We add components with help of " +
                    "TableRow tag. By default it is at matchparent(Width) and wrapcontent(Height).",

            "It is a layout which arranges the views in tabular form. It is similar to table " +
                    "layout but here we can define number of rows and columns by the attribute " +
                    "Row count, Column count."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Resources res = getResources();
        String[] items = res.getStringArray(R.array.items);

        int pos = getIntent().getIntExtra("position", 0);

        final TextView tv1 = (TextView) findViewById(R.id.tv1);
        final TextView tv2 = (TextView) findViewById(R.id.tv2);
        final ImageView imgv = (ImageView) findViewById(R.id.imgv);

        tv1.setText(items[pos]);
        imgv.setImageResource(img[pos]);
        tv2.setText(info[pos]);

    }
}