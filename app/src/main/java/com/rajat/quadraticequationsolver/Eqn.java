package com.rajat.quadraticequationsolver;



import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.rajat.quadraticequationsolver.databinding.ActivityMainBinding;

public class Eqn extends BaseObservable {

    ActivityMainBinding binding;
    String a;
    String b;
    String c;

    public Eqn(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public Eqn() {
    }


    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;


    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;

    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;

    }

    public void eqnsolver(View view) {

       /* if (getA() == null || getB() == null || getC() == null){
            Toast.makeText(view.getContext(), "enter all values", Toast.LENGTH_SHORT).show();
        } else {*/

        try {
            int a = Integer.parseInt(getA());
            int b = Integer.parseInt(getB());
            int c = Integer.parseInt(getC());

            // Calculating the Discriminant

            double discriminant = ((b * b) - 4 * (a * c));


            double x1, x2;
            if (discriminant > 0) {
                // Two real and distinct roots (solutions)

                x1 = (-b + Math.sqrt(discriminant)) / (2 * a);


                x2 = (-b - Math.sqrt(discriminant)) / (2 * a);

                // Display the results in the textview
                binding.textView.setText("X1= " + x1 + " X2= " + x2);
            } else if (discriminant < 0) {
                // no real roots
                Toast.makeText(view.getContext(), "complex roots", Toast.LENGTH_SHORT).show();
            } else {
                // Discriminant = 0
                // One real solution (double root)
                x1 = -b / (2 * a);
                binding.textView.setText("x = " + x1);
            }


        }
        catch(Exception e){
            Toast.makeText(view.getContext(), "you enter wrong values you fool", Toast.LENGTH_SHORT).show();

        }

    }


    }

