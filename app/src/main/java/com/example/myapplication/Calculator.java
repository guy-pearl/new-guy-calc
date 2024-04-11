package com.example.myapplication;

import static java.lang.Float.parseFloat;

import android.app.Activity;
import android.view.View;
import android.widget.Button; // Import Button class from Android SDK
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnDiv, btnKefel, btnBack, btnSoger1, btnSoger2, btnAC, btnDot, btnshave;
    TextView numdisplay, historyView;
    private String nums = "";
    boolean lastcharisop = true;

    public Calculator(Activity activity) {

        btn0 = (Button) activity.findViewById(R.id.btn0);
        btn1 = (Button) activity.findViewById(R.id.btn1);
        btn2 = (Button) activity.findViewById(R.id.btn2);
        btn3 = (Button) activity.findViewById(R.id.btn3);
        btn4 = (Button) activity.findViewById(R.id.btn4);
        btn5 = (Button) activity.findViewById(R.id.btn5);
        btn6 = (Button) activity.findViewById(R.id.btn6);
        btn7 = (Button) activity.findViewById(R.id.btn7);
        btn8 = (Button) activity.findViewById(R.id.btn8);
        btn9 = (Button) activity.findViewById(R.id.btn9);
        numdisplay = (TextView) activity.findViewById(R.id.numdisplay);
        historyView = (TextView) activity.findViewById(R.id.historyview);

        btnshave = (Button) activity.findViewById(R.id.btnshave);
        btnPlus = (Button) activity.findViewById(R.id.btnplus);
        btnMinus = (Button) activity.findViewById(R.id.btnminus);
        btnDiv = (Button) activity.findViewById(R.id.btndiv);
        btnKefel = (Button) activity.findViewById(R.id.btnkefel);
        btnBack = (Button) activity.findViewById(R.id.backbtn);
        btnAC = (Button) activity.findViewById(R.id.acbtn);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "0";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "1";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "2";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "3";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "4";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "5";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "6";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "7";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "8";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums += "9";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nums.length() >= 1) {
                    if (nums.charAt(nums.length() - 1) == ' ') {
                        nums = nums.substring(0, nums.length() - 1);
                    }
                    lastcharisop = Character.isDigit(nums.charAt(nums.length() - 1));
                    nums = nums.substring(0, nums.length() - 1);
                    numdisplay.setText(nums);
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastcharisop) {
                    return;
                }
                nums += "+";
                numdisplay.setText(nums);
                lastcharisop = true;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastcharisop) {
                    return;
                }
                nums += "-";
                numdisplay.setText(nums);
                lastcharisop = true;
            }
        });
        btnKefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastcharisop) {
                    return;
                }
                nums += "×";
                numdisplay.setText(nums);
                lastcharisop = true;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastcharisop) {
                    return;
                }
                nums += "÷";
                numdisplay.setText(nums);
                lastcharisop = true;
            }
        });
        btnshave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyView.setText(nums);
                try {

                    float result = XD(nums);
                    if (result % 1 == 0) {
                        numdisplay.setText(String.valueOf((int) result));
                    } else {
                        numdisplay.setText(String.valueOf(result));
                    }
                    nums = "";
                } catch (Exception e) {
                    System.out.println(e.getCause());
                    numdisplay.setText("ERORR");
                    nums = "";
                }
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums = "";
                numdisplay.setText(nums);
                lastcharisop = true;
            }
        });

    }

    public static String[] Open(String nums){
        String[] calc = new String[20];
        nums = nums.replaceAll(" ", "");
        String num = "";
        int i = 0,a = 0;
        while(i < nums.length()){
            char s = nums.charAt(i);
            if ((s != '-') && (s != '+') && (s != '×') &&( s != '÷')){
                num += s;
            }else{
                calc[a] = num;
                a++;
                calc[a] = String.valueOf(s);
                a++;
                num = "";
            }

            i++;
        }
        calc[a] = num;

        return calc;
    }


    public static int amout(String[] calc){
        int a= 0;
        while(!(calc[a].equals(null))){
            a++;
        }
        return a;
    }
    public static Float XD(String nums) {
        String[] calc = Open(nums);
        String num = "";

        int i = 0;
        while (calc[i] != null) {
            boolean flag = false;
            String move = calc[i];
            if (move.equals("×")) {
                int a = i+2,g = 0;
                num = Float.toString(parseFloat(calc[i - 1]) * parseFloat(calc[i + 1]));
                calc[i-1] = num;
                while(calc[a] != null){
                    calc[i + g] = calc[a];
                    calc[a] =null;
                    g++;
                    a++;
                    flag = true;
                }

            } else if ((move.equals("÷"))) {
                int a = i+2,g = 0;
                num = Float.toString(parseFloat(calc[i - 1]) / parseFloat(calc[i + 1]));
                calc[i-1] = num;
                while(calc[a] != null){

                    calc[i + g] = calc[a];
                    calc[a] =null;
                    g++;
                    a++;
                    flag = true;
                }

            }
            if (flag == false){i++;}

        }
        i=0;
        int d = 0;

                while (calc[i] != null) {
                    boolean flag = false;

                    if ((calc[i].equals("+"))) {
                        int a = i + 2, g = 0;
                        num = Float.toString(parseFloat(calc[i - 1]) + parseFloat(calc[i + 1]));
                        calc[i - 1] = num;

                        while ((calc[a]) != null) {
                            calc[i + g] = calc[a];
                            calc[a] = null;
                            g++;
                            a++;
                            flag = true;
                        }

                    } else if ((calc[i].equals("-"))) {
                        int a = i + 2, g = 0;
                        num = Float.toString(parseFloat(calc[i - 1]) - parseFloat(calc[i + 1]));
                        calc[i - 1] = num;
                        while (calc[a] != null) {

                            calc[i + g] = calc[a];
                            calc[a] = null;
                            g++;
                            a++;
                            flag = true;
                        }

                    }
                    if (flag == false){i++;}
                }
                i = 0;



        return parseFloat(calc[0]);
        }

    }



