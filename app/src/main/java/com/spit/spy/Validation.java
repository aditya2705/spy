package com.spit.spy;

import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by Vaibhavi on 27-05-2016.
 */
public class Validation {

    //Regular Expressions
    private static final String TEXT_REGEX_CORRECT ="[a-zA-Z]+";
    private static final String TEXT_REGEX_NUMBER ="[a-zA-Z0-9]+";
    private static final String TEXT_REGEX_SC ="[a-zA-Z!@#$%^&*()_+ -*/;:'<>,.?\\[\\]/]+";
    private static final String TEXT_REGEX_NSC ="[a-zA-Z0-9!@#$%^&*()_+ -*/;:'<>,.?\\[\\]/]+";
    private static final String PHONE_REGEX_CORRECT = "[7-9]+[0-9]{9}";
    private static final String PHONE_REGEX_INCORRECT = "[0-6]+[0-9]{9}";
    private static final String AGE_REGEX = "[0-9]{3}";
    private static final String ADHAAR_REGEX = "[0-9]{12}";


    // Error Messages
    private static final String REQUIRED_MSG = "required";
    private static final String TEXT_MSG_NUMBER = "Numbers are not allowed";
    private static final String TEXT_MSG_SC = "special characters are not allowed";
    private static final String TEXT_MSG_NSC= "numbers and special characters are not allowed";
    private static final String TEXT_MSG_lENGTH = "Length must be less than 20";
    private static final String PHONE_MSG_INCORRECT = "Invalid Mobile number";
    private static final String PHONE_MSG_LENGTH = "Mobile number cannot be greater than 10 ";
    private static final String AGE_MSG_ZERO = "Age cannot be zero";
    private static final String AGE_MSG= "Enter valid age";

    private static final String ADHAAR_MSG= "Enter valid aadhar card number";


    public static boolean isText(EditText editText){


        String text = editText.getText().toString().trim();
        int length=text.length();
        editText.setError(null);

        //check text required and if editText is empty
        if (!hasText(editText) )
            return false;



        // Match with regex
        if (!Pattern.matches(TEXT_REGEX_CORRECT, text)) {

            if (Pattern.matches(TEXT_REGEX_NUMBER, text)) {
                editText.setError(TEXT_MSG_NUMBER);
                return false;
            }
            if (Pattern.matches(TEXT_REGEX_SC, text)) {
                editText.setError(TEXT_MSG_SC);
                return false;
            }
            if (Pattern.matches(TEXT_REGEX_NSC, text)) {
                editText.setError(TEXT_MSG_NSC);
                return false;
            }
      if(length>20) {
          editText.setError(TEXT_MSG_lENGTH);
      return false;
      }
               // editText.setError(TEXT_MSG);
            return false;
        };

        return true;

    }
    public static boolean isDate(EditText editText) {
    return true;
    }

    public static boolean isAge(EditText editText) {


        String text = editText.getText().toString().trim();
        editText.setError(null);

        //check text required and if editText is empty
        if (!hasText(editText) )
            return false;
if(text.equals(0)) {
    editText.setError(AGE_MSG_ZERO);
return  false;
}

        // Match with regex
        if (!Pattern.matches(AGE_REGEX, text))
        {
editText.setError(AGE_MSG);
            return false;
        }
        return true;
    }


    public static boolean isClass(EditText editText) {


        return true;
    }

    public static boolean isAmount(EditText editText) {

        return true;
    }


    public static boolean isAdhaarNumber(EditText editText) {
        String text = editText.getText().toString().trim();
        editText.setError(null);

        //check text required and if editText is empty
        if (!hasText(editText) )
            return false;
        if (!Pattern.matches(ADHAAR_REGEX, text))
        {
            editText.setError(ADHAAR_MSG);
            return false;
        }



        return true;
    }



    public static boolean isPhoneNumber(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        //check text required and if editText is empty
        if (!hasText(editText) )
            return false;



        // Match with regex
        if (!Pattern.matches(PHONE_REGEX_CORRECT, text)) {
            if (text.length() > 10)
            {       editText.setError(PHONE_MSG_LENGTH);
                return false;
        }
            if (Pattern.matches(PHONE_REGEX_INCORRECT, text))
                editText.setError(PHONE_MSG_INCORRECT);
            return false;
        };



        return true;
    }





    // check if input field is empty
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }



}
