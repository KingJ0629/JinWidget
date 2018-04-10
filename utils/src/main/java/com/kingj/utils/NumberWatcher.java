package com.kingj.utils;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by Jin on 2018/4/10.
 * Description 控制商品数量的输入和显示
 */
public class NumberWatcher implements TextWatcher {
	
	private EditText mEditText;
	
	public NumberWatcher(final EditText mEditText) {
		this.mEditText = mEditText;
		
		// 初始化的时候过滤掉非法字符
		String origin = mEditText.getText().toString();
		try {
			Integer.parseInt(origin);
		} catch (NumberFormatException e) {
			mEditText.setText("1");
			mEditText.setSelection(mEditText.length());
		}
		
		// 过滤掉后面输入的非法字符
		mEditText.setFilters(new InputFilter[]{
				new InputFilter() {
					@Override
					public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
						String regex = "^[0-9]*$";
						boolean isNum = Pattern.matches(regex, charSequence.toString());
						return isNum ? charSequence : "";
					}
				}
		});
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		if (s.length() > 1 && s.toString().startsWith("0")) {
			String result = s.toString().replaceFirst("0", "");
			mEditText.setText(result);
		}
	}
}
