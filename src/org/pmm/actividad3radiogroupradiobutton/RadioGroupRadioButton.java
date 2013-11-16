package org.pmm.actividad3radiogroupradiobutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class RadioGroupRadioButton extends Activity {
	private EditText et1, et2;
	private TextView tv;
	private RadioGroup grupo;
	private RadioButton rd1, rd2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_group_radio_button);
		et1 = (EditText)findViewById(R.id.miEntrada1);
		et2 = (EditText)findViewById(R.id.miEntrada2);
		tv = (TextView)findViewById(R.id.miResultado);
		grupo = (RadioGroup)findViewById(R.id.miRadioGrupo);
//		rd1 = (RadioButton)findViewById(R.id.radio0);
//		rd2 = (RadioButton)findViewById(R.id.radio1);
		
		grupo.check(R.id.radio0);
		RadioGroup.OnCheckedChangeListener eventoGrupo = new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup radio, int checkedId) {
				int num1, num2, resul = 0;
				if(!et1.getText().toString().equals("") && !et2.getText().toString().equals("")){	
					num1 = Integer.parseInt((et1.getText().toString().trim()));
					num2 = Integer.parseInt((et2.getText().toString().trim()));
					if(checkedId == R.id.radio1){
						resul = num1 - num2;
					}
					else if(checkedId == R.id.radio0){
						resul = num1 + num2;
					}
					tv.setText(String.valueOf(resul));
					
				}

				
			}
		};
		grupo.setOnCheckedChangeListener(eventoGrupo);
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.radio_group_radio_button, menu);
		return true;
	}

}
