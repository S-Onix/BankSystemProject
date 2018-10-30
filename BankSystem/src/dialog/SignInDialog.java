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
import system.BankSystem;

public class SignInDialog extends Dialog {

	// 현재 시간 및 계좌 정보 출력

	BankSystem bs;

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

	String phoneFirst[] = { "02", "031", "032", "010" };

	// 확인, 취소, 중복 다이얼로그
	Dialog confirmD, cancelD, distinctD, messageD;
	

	boolean isClose = false;

	public SignInDialog(Frame parent, BankSystem bs) {
		super(parent, "회원가입 다이얼로그");

		this.bs = bs;

		this.setBounds(200, 200, 380, 400);
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
				JTextField temp = (JTextField) ke.getSource();
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

		// 버튼
		confirmButton = new Button("확인");
		confirmButton.setBounds(80, 350, 65, 30);
		this.add(confirmButton);

		initCancelDialog();
		initSaveDialog();

		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 조건 모든 입력사항 처리
				// JTextField idTf, pwTf, rePwTf, nameTf, phoneTf1, phoneTf2, emailTf;

				if (!idTf.getText().equals(null) || !pwTf.getText().equals(null) || !nameTf.getText().equals(null)
						|| !rePwTf.getText().equals(null) || !phoneTf1.getText().equals(null) || !phoneTf2.getText().equals(null)
						|| !emailTf.getText().equals(null)) {
					confirmD.setVisible(true);
				}
				else {
					
				}
				// 추가해야함
			}
		});

		cancelButton = new Button("취소");
		cancelButton.setBounds(160, 350, 65, 30);
		this.add(cancelButton);

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cancelD.setVisible(true);
				if (!getClose()) {
					dispose();
				}

			}
		});

		this.setModal(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	public Dialog initCancelDialog() {
		cancelD = new Dialog(this);
		Label msg = new Label("회원가입을 취소하겠습니까?");
		Button yesButton = new Button("네");
		Button noButton = new Button("아니요");

		cancelD.setLayout(null);
		cancelD.setTitle("회원가입을 취소하시겠습니까?");
		msg.setBounds(70, 40, 160, 30);
		yesButton.setBounds(70, 75, 50, 30);
		noButton.setBounds(160, 75, 50, 30);

		cancelD.add(msg);
		cancelD.add(yesButton);
		cancelD.add(noButton);

		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setClose(true);
				dispose();
			}
		});
		noButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		cancelD.setBounds(0, 0, 300, 120);
		cancelD.setResizable(false);
		cancelD.setModal(true);
		cancelD.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelD.dispose();
			}
		});
		return cancelD;

	}

	public Dialog initSaveDialog() {
		confirmD = new Dialog(this);
		Label msg = new Label("회원가입을 완료했습니다");
		Button yes = new Button("확인");
		confirmD.setTitle("회원가입을 완료했습니다");
		confirmD.setLayout(null);

		msg.setBounds(90, 40, 160, 30);
		yes.setBounds(135, 75, 50, 30);

		confirmD.add(msg);
		confirmD.add(yes);

		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveCustomer();
				dispose();

			}
		});

		confirmD.setBounds(0, 0, 300, 120);
		confirmD.setModal(true);
		confirmD.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// saveCustomer(customer 삽입);
				confirmD.dispose();
			}
		});

		return confirmD;

	}

	public void setClose(boolean isClose) {
		this.isClose = isClose;
	}

	public boolean getClose() {
		return this.isClose;
	}

	public void initDistinctDialog() {
		distinctD = new Dialog(this);
	}

	public void saveCustomer() {
		String email = emailTf.getText() + "@" + emailCho.getSelectedItem();
		String phoneNumber = phoneFirstCho.getSelectedItem() + "-" + phoneTf1.getText() + "-" + phoneTf2.getText();
		bs.signUp(idTf.getText(), pwTf.getText(), nameTf.getText(), email, phoneNumber);
		System.out.println("회원가입 완료");
	}

}
