package com.delta.onsites.Calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.delta.onsites.R;
import com.delta.onsites.SharedViewModel;

public class InputFragment extends Fragment {

    public interface Listner {
        void sendAns(double ans);
    }

    private static final String TAG = "InputFragment";

    private boolean opr_present = false;

    private double num1, num2;

    private int index;

    private char operation;

    Listner listner;

    private SharedViewModel viewModel;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        TextView input = view.findViewById(R.id.input);

        Button one = view.findViewById(R.id.one);
        Button two = view.findViewById(R.id.two);
        Button three = view.findViewById(R.id.three);
        Button four = view.findViewById(R.id.four);
        Button five = view.findViewById(R.id.five);
        Button six = view.findViewById(R.id.six);
        Button seven = view.findViewById(R.id.seven);
        Button eight = view.findViewById(R.id.eight);
        Button nine = view.findViewById(R.id.nine);
        Button zero = view.findViewById(R.id.zero);

        Button decimal = view.findViewById(R.id.decimal);

        Button add = view.findViewById(R.id.add);
        Button sub = view.findViewById(R.id.subtract);
        Button mul = view.findViewById(R.id.multiply);
        Button div = view.findViewById(R.id.divide);
        Button equals = view.findViewById(R.id.equals);

        Button del = view.findViewById(R.id.del);
        Button ac = view.findViewById(R.id.ac);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append("0");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.append(".");
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputVal = input.getText().toString();

                if (inputVal.length() > 0) {

                    char last = inputVal.charAt(inputVal.length() - 1);

                    inputVal = inputVal.substring(0, inputVal.length() - 1);

                    if (last == '+' || last == '-' || last == 'x' || last == '/')
                        opr_present = false;

                    input.setText(inputVal);
                }
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                opr_present = false;
                index = 0;
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opr_present) {
                    try {
                        String inputVal = input.getText().toString();

                        Log.d(TAG, "for num1: " + inputVal);

                        num1 = Double.parseDouble(inputVal);

                        index = input.length() + 1;

                        operation = 'a';

                        input.append("+");

                        opr_present = true;
                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String inputVal = input.getText().toString();

                        inputVal = inputVal.substring(index);

                        Log.d(TAG, "for num2: " + inputVal);

                        num2 = Double.parseDouble(inputVal);

                        switch (operation) {
                            case 'a':
                                num1 = num1 + num2;
                                input.setText(num1 + "+");
                                break;

                            case 's':
                                num1 = num1 - num2;
                                input.setText(num1 + "+");
                                break;

                            case 'm':
                                num1 = num1 * num2;
                                input.setText(num1 + "+");
                                break;

                            case 'd':
                                num1 = num1 / num2;
                                input.setText(num1 + "+");
                                break;
                        }

                        operation = 'a';

                        index = input.getText().toString().length();

                        //listner.sendAns(num1);

                        viewModel.setAnswer(num1);

                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opr_present) {
                    try {
                        String inputVal = input.getText().toString();

                        num1 = Double.parseDouble(inputVal);

                        index = input.length() + 1;

                        operation = 's';

                        input.append("-");

                        opr_present = true;
                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String inputVal = input.getText().toString();

                        inputVal = inputVal.substring(index);

                        num2 = Double.parseDouble(inputVal);

                        switch (operation) {
                            case 'a':
                                num1 = num1 + num2;
                                input.setText(num1 + "-");
                                break;

                            case 's':
                                num1 = num1 - num2;
                                input.setText(num1 + "-");
                                break;

                            case 'm':
                                num1 = num1 * num2;
                                input.setText(num1 + "-");
                                break;

                            case 'd':
                                num1 = num1 / num2;
                                input.setText(num1 + "-");
                                break;
                        }

                        operation = 's';

                        index = input.getText().toString().length();

                        //listner.sendAns(num1);

                        viewModel.setAnswer(num1);

                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opr_present) {
                    try {
                        String inputVal = input.getText().toString();

                        num1 = Double.parseDouble(inputVal);

                        index = input.length() + 1;

                        operation = 'm';

                        input.append("x");

                        opr_present = true;
                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String inputVal = input.getText().toString();

                        inputVal = inputVal.substring(index);

                        num2 = Double.parseDouble(inputVal);

                        switch (operation) {
                            case 'a':
                                num1 = num1 + num2;
                                input.setText(num1 + "x");
                                break;

                            case 's':
                                num1 = num1 - num2;
                                input.setText(num1 + "x");
                                break;

                            case 'm':
                                num1 = num1 * num2;
                                input.setText(num1 + "x");
                                break;

                            case 'd':
                                num1 = num1 / num2;
                                input.setText(num1 + "x");
                                break;
                        }

                        operation = 'm';

                        index = input.getText().toString().length();

                        //listner.sendAns(num1);

                        viewModel.setAnswer(num1);

                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opr_present) {
                    try {
                        String inputVal = input.getText().toString();

                        num1 = Double.parseDouble(inputVal);

                        index = input.length() + 1;

                        operation = 'd';

                        input.append("/");

                        opr_present = true;
                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String inputVal = input.getText().toString();

                        inputVal = inputVal.substring(index);

                        num2 = Double.parseDouble(inputVal);

                        switch (operation) {
                            case 'a':
                                num1 = num1 + num2;
                                input.setText(num1 + "/");
                                break;

                            case 's':
                                num1 = num1 - num2;
                                input.setText(num1 + "/");
                                break;

                            case 'm':
                                num1 = num1 * num2;
                                input.setText(num1 + "/");
                                break;

                            case 'd':
                                num1 = num1 / num2;
                                input.setText(num1 + "/");
                                break;
                        }

                        operation = 'd';

                        index = input.getText().toString().length();

                        //listner.sendAns(num1);

                        viewModel.setAnswer(num1);

                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getParentFragmentManager();

                if (!opr_present) {
                    try {
                        String inputVal = input.getText().toString();

                        num1 = Double.parseDouble(inputVal);

                        index = 0;

                        input.setText("");

                        opr_present = false;

                        //listner.sendAns(num1);

                        viewModel.setAnswer(num1);

                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String inputVal = input.getText().toString();

                        inputVal = inputVal.substring(index);

                        num2 = Double.parseDouble(inputVal);

                        switch (operation) {
                            case 'a':
                                num1 = num1 + num2;
                                input.setText("");
                                break;

                            case 's':
                                num1 = num1 - num2;
                                input.setText("");
                                break;

                            case 'm':
                                num1 = num1 * num2;
                                input.setText("");
                                break;

                            case 'd':
                                num1 = num1 / num2;
                                input.setText("");
                                break;
                        }

                        opr_present = false;

                        index = 0;

                        //listner.sendAns(num1);

                        viewModel.setAnswer(num1);

                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

/*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Listner)
            listner = (Listner) context;
        else
            throw new RuntimeException("Did not implement interface");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner = null;
    }
 */
