package com.sample;

public class WindowState {
	
	private String questionText;
	
	private String buttonText1 = "";
	
	private String answer = "";

    public WindowState(String text) {
        this.questionText = text;
    }

    public String getText() {
        return questionText;
    }
    
    public void setText(String text) {
        this.questionText = text;
    }
    
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public String getButtonText1() {
        return buttonText1;
    }
    public void setButtonText1(String buttonText1) {
        this.buttonText1 = buttonText1;
    }
}
