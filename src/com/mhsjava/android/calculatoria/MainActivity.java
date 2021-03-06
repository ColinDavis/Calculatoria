package com.mhsjava.android.calculatoria;

//Colin's Mac GitHub Test

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	String dBox, stored;
	char function;
	boolean justEqualed;
	TextView t;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	setContentView(R.layout.activity_main);		//<===Makes Program WORK!!!!
    	t = (TextView)findViewById(R.id.textView1);
    	t.setText("0");
    	
    	stored = dBox = "";
    	justEqualed = false;
    	function = ' ';
    	
        super.onCreate(savedInstanceState); 
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	stored = dBox = "";
    	justEqualed = false;
    	function = ' ';
    	
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void buttonDown1(View view)
    {
    	if(justEqualed)			//if the equal button(NONEXISTANT) was just pressed
    		clearDown(view);		//pretend the user clicked clear also (WON'T HAPPEN)
    	dBox += "1";			//add the data value for the button (# or '.') to the displayed string
    	display(dBox);		//update the display to match this change
    	justEqualed = false;	
    }
    public void buttonDown2(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="2";
    	display(dBox);
    	justEqualed = false;
    }
    public void buttonDown3(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="3";
    	display(dBox);
    	justEqualed = false;
    }
    public void buttonDown4(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="4";
    	display(dBox);
    	justEqualed = false;
    }
    public void buttonDown5(View view)
    {
    	if(justEqualed)
    		clearDown/**PETER STANLEY**/(view);
    	dBox+="5";
    	display(dBox);
    	justEqualed = false;
    }
    public void buttonDown6(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="6";
    	display(dBox);
    	justEqualed = false;
    }
    public void buttonDown7(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="7";
    	display(dBox);
    	justEqualed = false;
    }
    public void buttonDown8(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="8";
    	display(dBox);
    	justEqualed = false;
    }
    public void buttonDown9(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="9";
    	display(dBox);
    	justEqualed = false;
    }
    public void buttonDown0(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="0";
    	display(dBox);
    	justEqualed = false;
    }
    public void pointDown(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox += ".";
    	display(dBox);
    	justEqualed = false;
    }
    
    public void starDown(View view)
    {
    	if (justEqualed)
    		function = '*';
    	if (stored.equals(""))
    	{
    		stored = dBox;
    		dBox = "";
    		function = '*';
    		return;
    	}
    	if (function != ' ')
    		function = '*';
    	
    	stored = doMath(stored,function,dBox);
    	dBox = "";
    	display(stored);
    }
    public void slashDown(View view)
    {
    	if (justEqualed)
    		function = '/';

    	justEqualed = false;
    	if (stored.equals(""))
    	{
    		stored = dBox;
    		dBox = "";
    		function = '/';
    		return;
    	}
    	
    	if (function != ' ')
    		function = '/';
    	
    	stored = doMath(stored,function,dBox);
    	dBox = "";
    	display(stored);
    }
    public void plusDown(View view)
    {
    	if (justEqualed)
    		function = '+';
    	justEqualed = false;
    	if (stored.equals(""))
    	{
    		stored = dBox;
    		dBox = "";
    		function = '+';
    		return;
    	}
    	if (function != ' ')
    		function = '+';
    	
    	stored = doMath(stored,function,dBox);
    	dBox = "";
    	display(stored);
    }
    public void minusDown(View view)
    {
    	if (justEqualed)
    		function = '-';
    	justEqualed = false;
    	if (stored.equals(""))
    	{
    		stored = dBox;
    		dBox = "";
    		function = '-';
    		return;
    	}
    	if (function != ' ')
    		function = '-';
    	
    	stored = doMath(stored,function,dBox);
    	dBox = "";
    	display(stored);
    }
    public void equalsDown(View view)
    {
    	if(justEqualed == false)
    	{
    		stored = doMath(stored,function,dBox);
    		display(stored);
    		dBox = "";
    		function = ' ';
    	}
    	
    	justEqualed = true;
    }
    
    public void clearDown(View view)
    {
    	stored = "";
    	dBox = "";
    	function = ' ';

    	justEqualed = false;
    	display("0");
    }
    
    public String doMath(String a, char _, String b)
    {
    	if(!goodDecimal(a) || !goodDecimal(b))
    		return "ERROR: DECIMAL SYNTAX";
    	
    	double x1 = Double.parseDouble(a);
    	double x2 = Double.parseDouble(b);
    	double ans= 0;
    	
    	switch(_)
    	{
    		case '*':
    			ans = x1*x2;
    			return ans+"";
    		case '/':
    			if(x2 == 0)
    				return "ERROR: /0";
    			ans = x1/x2;
    			return ans+"";
    		case '+':
    			ans = x1+x2;
    			return ans+"";
    		case '-':
    			ans = x1-x2;
    			return ans+"";
    	}
    	
    	return "ERROR: MATH FAILURE";
    }
    public boolean goodDecimal(String string)
    {
    	int count = 0;
    	for(int i=0; i<string.length(); i++)
    	{
    		if(string.charAt(i) == '.')
    			count ++;
    		if(count>1)
    			return false;
    	}
    	return true;
    }
    
    public void display(String display)
    {
    	t.setText(display);		//Set the TextView to display the String we want
    }
}
