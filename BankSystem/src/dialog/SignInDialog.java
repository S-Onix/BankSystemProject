package dialog;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import person.Customer;

public class SignInDialog extends Dialog {

	// 현재 시간 및 계좌 정보 출력

	Label signInLb;

	Label idLb, pwLb, pwReLb, nameLb, genderLb, phoneLb, emailLb;
	Label hyponLb1, hyponLb2, hyponLb3;
	JTextField idTf, pwTf, rePwTf, nameTf, phoneTf1, phoneTf2, emailTf;

	// 성별(라디오박스)
	CheckboxGroup cg;
	Checkbox man, woman;
	// 이메일
	Choice emailCho;
	// 번호
	Choice phoneFirstCho;

	Button confirmButton, cancelButton, distinctButton;

	String emailStr[] = { "gmail.com", "naver.com", "daum.net", "yahoo.com", "기타입력" };

	String monthStr[] = { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

	String dayStr[] = { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
			"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

	String phoneFirst[] = { "02", "031", "032", "010" };

	public String[] makeYear() {
		String[] yearStr = new String[50];
		for (int i = 2018; i > 2018 - yearStr.length; i--) {

		}
		return yearStr;
	}

//	public SignInDialog(Frame parent, ArrayList<Customer> customers) {
	public SignInDialog(Frame parent) {
		super(parent, "Sign in Dialog");

		this.setBounds(200, 200, 400, 600);
		this.setLayout(null);

		// 회원가입 Label
		signInLb = new Label("회 원 가 입");
		signInLb.setBounds(this.getWidth() / 2 - 25, 40, 400, 50);
		this.add(signInLb);

		// 아이디 입력
		idLb = new Label("ID");
		idLb.setBounds(47, 100, 50, 25);
		this.add(idLb);
		idTf = new JTextField();
		// 10자 제한
		idTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				JTextField temp = (JTextField) ke.getSource();
				if (temp.getText().length() >= 10) {
					ke.consume();
				}
			}
		});

		idTf.setBounds(100, 100, 150, 25);
		this.add(idTf);

		distinctButton = new Button("중복 확인");
		distinctButton.setBounds(270, 100, 80, 25);
		this.add(distinctButton);
		distinctButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 중복발생 로직 및 dialog 출력
			}
		});

		// 패스워드 추가해야 할 사항 : 별모양으로 출력
		pwLb = new Label("PASSWORD");
		pwLb.setBounds(20, 130, 80, 25);
		this.add(pwLb);
		pwTf = new JTextField();
		pwTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				JTextField temp = (JTextField) ke.getSource();
				if (temp.getText().length() >= 10) {
					ke.consume();
				}
			}
		});
		pwTf.setBounds(100, 130, 150, 25);
		this.add(pwTf);

		rePwTf = new JTextField();
		rePwTf.setBounds(100, 160, 150, 25);
		this.add(rePwTf);
		rePwTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (pwTf.getText().equals(rePwTf.getText())) {
					pwReLb.setText("일치");
				} else
					pwReLb.setText("불일치");
			}
		});

		pwReLb = new Label("불일치");
		pwReLb.setBounds(255, 160, 70, 25);
		this.add(pwReLb);

//		47 190 50 25
		nameLb = new Label("이름");
		nameLb.setBounds(45, 210, 50, 25);
		this.add(nameLb);

		// 추가 해야하는 사항 : 글자 제한
		nameTf = new JTextField();
		nameTf.setBounds(100, 210, 150, 25);
		this.add(nameTf);
		nameTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				TextField temp = (TextField) ke.getSource();
				if (temp.getText().length() > 7) {
					ke.consume();
				}
			}
		});

		// 성별 (Customer 객체로 넘기는 부분 추가 해야함)
		genderLb = new Label("성별");
		genderLb.setBounds(45, 240, 50, 25);
		this.add(genderLb);
		cg = new CheckboxGroup();
		man = new Checkbox("남", false, cg);
		woman = new Checkbox("여", false, cg);

		man.setBounds(100, 240, 50, 25);
		woman.setBounds(160, 240, 50, 25);
		this.add(man);
		this.add(woman);

		// 이메일
		emailLb = new Label("이메일");
		emailLb.setBounds(40, 270, 50, 25);
		this.add(emailLb);
		emailTf = new JTextField();
		emailTf.setBounds(100, 270, 50, 25);
		hyponLb1 = new Label("@");
		hyponLb1.setBounds(155, 270, 15, 25);
		emailCho = new Choice();
		for (int i = 0; i < emailStr.length; i++) {
			emailCho.add(emailStr[i]);
		}
		emailCho.setBounds(180, 270, 100, 25);
		this.add(emailTf);
		this.add(hyponLb1);
		this.add(emailCho);

		// 전화번호
		phoneLb = new Label("전화번호");
		phoneLb.setBounds(32, 300, 50, 25);
		this.add(phoneLb);

		phoneFirstCho = new Choice();
		for (int i = 0; i < phoneFirst.length; i++) {
			phoneFirstCho.add(phoneFirst[i]);
		}
		phoneFirstCho.setBounds(100, 300, 50, 25);
		hyponLb2 = new Label("-");
		hyponLb2.setBounds(155, 300, 20, 25);
		phoneTf1 = new JTextField();
		phoneTf1.setBounds(175, 300, 70, 25);
		hyponLb3 = new Label("-");
		hyponLb3.setBounds(255, 300, 20, 25);
		phoneTf2 = new JTextField();
		phoneTf2.setBounds(275, 300, 70, 25);

		this.add(phoneFirstCho);
		this.add(hyponLb2);
		this.add(hyponLb3);
		this.add(phoneTf1);
		this.add(phoneTf2);
		
		
		//버튼
		confirmButton = new Button("확인");
		confirmButton.setBounds(80, 350, 65, 30);
		this.add(confirmButton);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}
	
	public void saveCustomer(Customer customer) {
		
	}

}
