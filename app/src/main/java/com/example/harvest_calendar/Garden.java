package com.example.harvest_calendar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.domain.Event;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Garden extends AppCompatActivity {
    Button calendar;
    Button plot00, plot01, plot02, plot03, plot04, plot10, plot11, plot12, plot13, plot14, plot20, plot21, plot22;
    Button plot23, plot24, plot30, plot31, plot32, plot33, plot34, plot40, plot41, plot42, plot43, plot44;
    ImageView iplot00, iplot01, iplot02, iplot03, iplot04, iplot10, iplot11, iplot12, iplot13, iplot14, iplot20, iplot21, iplot22;
    ImageView iplot23, iplot24, iplot30, iplot31, iplot32, iplot33, iplot34, iplot40, iplot41, iplot42, iplot43, iplot44, plotTest;
    ProgressBar levelProg;
    TextView progressState;
    Integer currSelect = 0;
    ImageButton level0, level1, level2, level3, level4, level5, level6, level7, level8, level9;
    Dialog dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden);

        calendar = (Button) findViewById(R.id.calendarButton);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);

        actionBar.setTitle("Hi, userid");

        RelativeLayout relativeLayout = findViewById(R.id.gardenScene);
        relativeLayout.setBackgroundColor(Color.rgb(139, 69, 19));

        levelProg = findViewById(R.id.levelProg);
        levelProg.setProgress(100);

        levelProg.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 150, 123)));

        progressState = findViewById(R.id.progressStatement);

        progressState.setText("You are 400 away from a new plant!");

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Garden.this, Calendar.class);
                startActivity(intent2);
            }
        });

        iplot00 = findViewById(R.id.plot00);
        iplot01 = findViewById(R.id.plot01);
        iplot02 = findViewById(R.id.plot02);
        iplot03 = findViewById(R.id.plot03);
        iplot04 = findViewById(R.id.plot04);
        iplot10 = findViewById(R.id.plot10);
        iplot11 = findViewById(R.id.plot11);
        iplot12 = findViewById(R.id.plot12);
        iplot13 = findViewById(R.id.plot13);
        iplot14 = findViewById(R.id.plot14);
        iplot20 = findViewById(R.id.plot20);
        iplot21 = findViewById(R.id.plot21);
        iplot22 = findViewById(R.id.plot22);
        iplot23 = findViewById(R.id.plot23);
        iplot24 = findViewById(R.id.plot24);
        iplot30 = findViewById(R.id.plot30);
        iplot31 = findViewById(R.id.plot31);
        iplot32 = findViewById(R.id.plot32);
        iplot33 = findViewById(R.id.plot33);
        iplot34 = findViewById(R.id.plot34);
        iplot40 = findViewById(R.id.plot40);
        iplot41 = findViewById(R.id.plot41);
        iplot42 = findViewById(R.id.plot42);
        iplot43 = findViewById(R.id.plot43);
        iplot44 = findViewById(R.id.plot44);
        plotTest = findViewById(R.id.plotTest);

        plot00 = findViewById(R.id.plot00Button);
        plot01 = findViewById(R.id.plot01Button);
        plot02 = findViewById(R.id.plot02Button);
        plot03 = findViewById(R.id.plot03Button);
        plot04 = findViewById(R.id.plot04Button);
        plot10 = findViewById(R.id.plot10Button);
        plot11 = findViewById(R.id.plot11Button);
        plot12 = findViewById(R.id.plot12Button);
        plot13 = findViewById(R.id.plot13Button);
        plot14 = findViewById(R.id.plot14Button);
        plot20 = findViewById(R.id.plot20Button);
        plot21 = findViewById(R.id.plot21Button);
        plot22 = findViewById(R.id.plot22Button);
        plot23 = findViewById(R.id.plot23Button);
        plot24 = findViewById(R.id.plot24Button);
        plot30 = findViewById(R.id.plot30Button);
        plot31 = findViewById(R.id.plot31Button);
        plot32 = findViewById(R.id.plot32Button);
        plot33 = findViewById(R.id.plot33Button);
        plot34 = findViewById(R.id.plot34Button);
        plot40 = findViewById(R.id.plot40Button);
        plot41 = findViewById(R.id.plot41Button);
        plot42 = findViewById(R.id.plot42Button);
        plot43 = findViewById(R.id.plot43Button);
        plot44 = findViewById(R.id.plot44Button);

        plot00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot00.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot00);
                } else {
                    harvest(iplot00);
                }

            }
        });

        plot01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot01.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot01);
                } else {
                    harvest(iplot01);
                }
            }
        });

        plot02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot02.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot02);
                } else {
                    harvest(iplot02);
                }
            }
        });

        plot03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot03.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot03);
                } else {
                    harvest(iplot03);
                }
            }
        });
        plot04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot04.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot04);
                } else {
                    harvest(iplot04);
                }
            }
        });

        plot10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot10.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot10);
                } else {
                    harvest(iplot10);
                }
            }
        });

        plot11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot11.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot11);
                } else {
                    harvest(iplot11);
                }
            }
        });

        plot12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot12.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot12);
                } else {
                    harvest(iplot12);
                }
            }
        });

        plot13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot13.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot13);
                } else {
                    harvest(iplot13);
                }
            }
        });

        plot14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot14.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot14);
                } else {
                    harvest(iplot14);
                }
            }
        });

        plot20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot20.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot20);
                } else {
                    harvest(iplot20);
                }
            }
        });

        plot21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot21.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot21);
                } else {
                    harvest(iplot21);
                }
            }
        });


        plot22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot22.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot22);
                } else {
                    harvest(iplot22);
                }
            }
        });

        plot23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot23.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot23);
                } else {
                    harvest(iplot23);
                }
            }
        });

        plot24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot24.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot24);
                } else {
                    harvest(iplot24);
                }
            }
        });

        plot30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot30.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot30);
                } else {
                    harvest(iplot30);
                }
            }
        });

        plot31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot31.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot31);
                } else {
                    harvest(iplot31);
                }
            }
        });

        plot32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot32.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot32);
                } else {
                    harvest(iplot32);
                }
            }
        });

        plot33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot33.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot33);
                } else {
                    harvest(iplot33);
                }
            }
        });

        plot34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot34.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot34);
                } else {
                    harvest(iplot34);
                }
            }
        });

        plot40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot40.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot40);
                } else {
                    harvest(iplot40);
                }
            }
        });

        plot41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot41.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot41);
                } else {
                    harvest(iplot41);
                }
            }
        });

        plot42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot42.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot42);
                } else {
                    harvest(iplot42);
                }
            }
        });

        plot43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot43.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot43);
                } else {
                    harvest(iplot43);
                }
            }
        });

        plot44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iplot44.getDrawable().getConstantState() == plotTest.getDrawable().getConstantState()) {
                    open(iplot44);
                } else {
                    harvest(iplot44);
                }
            }
        });


    }

    public void open(final ImageView iv) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.plantpicker, null);
        builder.setView(customLayout);

        customLayout.setBackgroundColor(Color.rgb(253, 214, 183));

        int level = 9;
        level0 = customLayout.findViewById(R.id.level0);
        level1 = customLayout.findViewById(R.id.level1);
        level2 = customLayout.findViewById(R.id.level2);
        level3 = customLayout.findViewById(R.id.level3);
        level4 = customLayout.findViewById(R.id.level4);
        level5 = customLayout.findViewById(R.id.level5);
        level6 = customLayout.findViewById(R.id.level6);
        level7 = customLayout.findViewById(R.id.level7);
        level8 = customLayout.findViewById(R.id.level8);
        level9 = customLayout.findViewById(R.id.level9);

        if (level > 0) {
            level1.setImageResource(R.mipmap.corn);
        }

        if (level > 1) {
            level2.setImageResource(R.mipmap.carrot);
        }

        if (level > 2) {
            level3.setImageResource(R.mipmap.potato);
        }

        if (level > 3) {
            level4.setImageResource(R.mipmap.tomato);
        }

        if (level > 4) {
            level5.setImageResource(R.mipmap.mushroom);
        }

        if (level > 5) {
            level6.setImageResource(R.mipmap.pepper);
        }

        if (level > 6) {
            level7.setImageResource(R.mipmap.chile);
        }

        if (level > 7) {
            level8.setImageResource(R.mipmap.onion);
        }

        if (level > 8) {
            level9.setImageResource(R.mipmap.eggplant);
        }

        level0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.lettuce;
                clearSelection();
                level0.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });

        level1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.corn;
                clearSelection();
                level1.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.carrot;
                clearSelection();
                level2.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.potato;
                clearSelection();
                level3.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.tomato;
                clearSelection();
                level4.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });


        level5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.mushroom;
                clearSelection();
                level5.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });

        level6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.pepper;
                clearSelection();
                level6.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });

        level7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.chile;
                clearSelection();
                level7.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });

        level8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.onion;
                clearSelection();
                level8.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });

        level9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                currSelect = R.mipmap.eggplant;
                clearSelection();
                level9.setBackground(getDrawable(R.layout.buttonbackground));
            }
        });


        builder.setNegativeButton("Plant", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                iv.setImageResource(currSelect);
            }
        });

        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, 1300);
    }

    private void clearSelection() {
        level0.setBackgroundResource(0);
        level1.setBackgroundResource(0);
        level2.setBackgroundResource(0);
        level3.setBackgroundResource(0);
        level4.setBackgroundResource(0);
        level5.setBackgroundResource(0);
        level6.setBackgroundResource(0);
        level7.setBackgroundResource(0);
        level8.setBackgroundResource(0);
        level9.setBackgroundResource(0);
    }


    // Do something with the data
    // coming from the AlertDialog
    private void sendDialogDataToActivity(String data)
    {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    public void harvest(final ImageView view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Would you like to harvest this plot?");
        alertDialogBuilder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                view.setImageResource(R.mipmap.grass);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}

class GridAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Integer> listFiles;

    public GridAdapter(ArrayList<Integer> listFiles, Context mContext) {

        this.mContext = mContext;
        this.listFiles = listFiles;
    }

    @Override
    public int getCount() {
        return listFiles.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return listFiles.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = (ImageView) convertView;
        if (iv == null) {
            iv = new ImageView(mContext);
            iv.setLayoutParams(new GridView.LayoutParams(350, 450));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        iv.setImageResource(listFiles.get(position));
        return iv;
    }
}

