package com.mhsjava.android.calculatoria;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	//fuck the police
	String dBox, stored;
	char function;
	boolean justEqualed;
	TextView t;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	stored = dBox = "";
    	justEqualed = false;
    	t = (TextView)findViewById(R.id.textView1);
    	
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	stored = dBox = "";
    	justEqualed = false;
    	
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void buttonDown1(View view)
    {
    	if(justEqualed)			//if the equal button(NONEXISTANT) was just pressed
    		clearDown(view);		//pretend the user clicked clear also (WON'T HAPPEN)
    	dBox += "1";			//add the data value for the button (# or '.') to the displayed string
    	display(dBox);			//update the display to match this change
    }
    public void buttonDown2(View view)
    {
    	//t.setText("WORKIN BRO");
    	if(justEqualed)
    		clearDown(view);
    	dBox+="2";
    	display(dBox);
    }
    public void buttonDown3(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="3";
    	display(dBox);
    }
    public void buttonDown4(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="4";
    	display(dBox);
    }
    public void buttonDown5(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="5";
    	display(dBox);
    }
    public void buttonDown6(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="6";
    	display(dBox);
    }
    public void buttonDown7(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="7";
    	display(dBox);
    }
    public void buttonDown8(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="8";
    	display(dBox);
    }
    public void buttonDown9(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="9";
    	display(dBox);
    }
    public void buttonDown0(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox+="0";
    	display(dBox);
    }
    public void pointDown(View view)
    {
    	if(justEqualed)
    		clearDown(view);
    	dBox += ".";
    	display(dBox+".");
    }
    
    public void starDown(View view)
    {
    	if (stored.equals(""))
    	{
    		stored = dBox;
    		dBox = "";
    		function = '*';
    		return;
    	}
    	
    	stored = doMath(stored,function,dBox);
    	function = '*';
    	dBox = "";
    	display(stored);
    }
    public void slashDown(View view)
    {
    	justEqualed = false;
    	if (stored.equals(""))
    	{
    		stored = dBox;
    		dBox = "";
    		function = '/';
    		return;
    	}
    	
    	stored = doMath(stored,function,dBox);
    	function = '/';
    	dBox = "";
    	display(stored);
    }
    public void plusDown(View view)
    {
    	justEqualed = false;
    	if (stored.equals(""))
    	{
    		stored = dBox;
    		dBox = "";
    		function = '+';
    		return;
    	}
    	
    	stored = doMath(stored,function,dBox);
    	function = '+';
    	dBox = "";
    	display(stored);
    }
    public void minusDown(View view)
    {
    	justEqualed = false;
    	if (stored.equals(""))
    	{
    		stored = dBox;
    		dBox = "";
    		function = '-';
    		return;
    	}
    	
    	stored = doMath(stored,function,dBox);
    	function = '-';
    	dBox = "";
    	display(stored);
    }
    public void equalsDown(View view)
    {
    	justEqualed = false;
    	stored = doMath(stored,function,dBox);
    	display(stored);
    	dBox = "";
    	function = ' ';
    	
    	justEqualed = true;
    }
    
    public void clearDown(View view)
    {
    	stored = dBox = "";
    	function = ' ';

    	justEqualed = false;
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
    	//t.setText(display);		//Set the textview to display the String we want (?)
    	
    }
}
