package com.example.androidstudio.garraa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final ImageView imgView = (ImageView) findViewById(R.id.imageView);
            final TextView tv1 = (TextView) findViewById(R.id.textView);
            final TextView tv2 = (TextView) findViewById(R.id.textView2);
            final TextView tv3 = (TextView) findViewById(R.id.textView3);
            final TextView tv4 = (TextView) findViewById(R.id.textView4);
            final TextView tv5 = (TextView) findViewById(R.id.textView5);
            imgView.setOnTouchListener(new View.OnTouchListener(){
                float initialX, initialY,finalX,finalY;

                @Override
                public boolean onTouch(View view, MotionEvent motionEvent){
                    int event = motionEvent.getAction();

                    switch(event){
                        case MotionEvent.ACTION_DOWN:
                            initialX = motionEvent.getX();
                            initialY = motionEvent.getY();
                            //Toast.makeText(getApplicationContext(), "Value of X: "+initialX+" Y: "+initialY,Toast.LENGTH_SHORT).show();
                            tv1.setText("X1: " + initialX+" Y1: "+initialY);
                            return true;
                        case MotionEvent.ACTION_UP:
                            int x = imgView.getBottom();
                            int y = imgView.getRight();
                            finalX = motionEvent.getX();
                            finalY = motionEvent.getY();
                            tv5.setText("X2: " + finalX + " Y2: " +finalY);
                            tv2.setText("X1 - X2: " + Math.abs((initialX - finalX)) + "\n" + "Y1 - Y2: " +Math.abs((initialY - finalY)));
                            String motion = "";
                            int X = x/2;
                            int Y = y/2;
                            String quadrant = "";
                            tv4.setText("Quadrant: ");
                            if(finalX>initialX){
                                //Toast.makeText(getApplicationContext(),"SWIPED RIGHT"+"\n"+"Value of X: "+finalX+" Y: "+finalY,Toast.LENGTH_SHORT).show();
                                tv5.setText("X2: " + finalX + " Y2: " +finalY);
                                tv2.setText("X1 - X2: " + Math.abs((initialX - finalX)) + "\n" + "Y1 - Y2: " +Math.abs((initialY - finalY)));
                                motion+="SWIPED RIGHT ";
                            }
                            if(finalX<initialX){
                                //Toast.makeText(getApplicationContext(),"SWIPED LEFT"+"\n"+"Value of X: "+finalX+" Y: "+finalY,Toast.LENGTH_SHORT).show();
                                tv5.setText("X2: " + finalX + " Y2: " +finalY);
                                tv2.setText("X1 - X2: " + Math.abs((initialX - finalX)) +"\n" +"Y1 - Y2: " +Math.abs((initialY - finalY)));
                                motion+="SWIPED LEFT ";
                            }
                            if(finalY<initialY){
                                //Toast.makeText(getApplicationContext(),"SWIPED UP"+"\n"+"Value of X: "+finalX+" Y: "+finalY,Toast.LENGTH_SHORT).show();
                                tv5.setText("X2: " + finalX + " Y2: " +finalY);
                                tv2.setText("X1 - X2: " + Math.abs((initialX - finalX)) + "\n"+"Y1 - Y2: " +Math.abs((initialY - finalY)));
                                motion+="SWIPED UP ";
                            }
                            if(finalY>initialY){
                                //Toast.makeText(getApplicationContext(),"SWIPED DOWN"+"\n"+"Value of X: "+finalX+" Y: "+finalY,Toast.LENGTH_SHORT).show();
                                tv5.setText("X2: " + finalX + " Y2: " +finalY);
                                tv2.setText("X1 - X2: " + Math.abs((initialX - finalX)) + "\n"+"Y1 - Y2: " +Math.abs((initialY - finalY)));
                                motion+="SWIPED DOWN ";
                            }
                            tv3.setText("Motion: "+motion);
                            if(finalX!=initialX && finalY!=initialY) {
                                if (finalX > X && finalY > Y) {
                                    quadrant = "Quadrant IV";
                                }
                                if (finalX < X && finalY > Y) {
                                    quadrant = "Quadrant III";
                                }
                                if (finalX < X && finalY < Y) {
                                    quadrant = "Quadrant II";
                                }
                                if (finalX > X && finalY < Y) {
                                    quadrant = "Quadrant I";
                                }
                                tv4.setText("Quadrant: " + "\n" + quadrant);
                            }















                            return true;
                    }

                    return true;
                }
            });
        }
    }

