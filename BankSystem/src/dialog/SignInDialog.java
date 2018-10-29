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

	// ���� �ð� �� ���� ���� ���

	Label signInLb;

	Label idLb, pwLb, pwReLb, nameLb, genderLb, phoneLb, emailLb;
	Label hyponLb1, hyponLb2, hyponLb3;
	JTextField idTf, pwTf, rePwTf, nameTf, phoneTf1, phoneTf2, emailTf;

	// ����(�����ڽ�)
	CheckboxGroup cg;
	Checkbox man, woman;
	// �̸���
	Choice emailCho;
	// ��ȣ
	Choice phoneFirstCho;

	Button confirmButton, cancelButton, distinctButton;

	String emailStr[] = { "gmail.com", "naver.com", "daum.net", "yahoo.com", "��Ÿ�Է�" };

	String phoneFirst[] = { "02", "031", "032", "010" };

	// Ȯ��, ���, �ߺ� ���̾�α�
	Dialog confirmD, cancelD, distinctD;

	boolean isClose = false;

//	public SignInDialog(Frame parent, ArrayList<Customer> customers) {
	public SignInDialog(Frame parent) {
		super(parent, "Sign in Dialog");

		this.setBounds(200, 200, 380, 400);
		this.setLayout(null);

		// ȸ������ Label
		signInLb = new Label("ȸ �� �� ��");
		signInLb.setBounds(this.getWidth() / 2 - 25, 40, 400, 50);
		this.add(signInLb);

		// ���̵� �Է�
		idLb = new Label("ID");
		idLb.setBounds(47, 100, 50, 25);
		this.add(idLb);
		idTf = new JTextField();
		// 10�� ����
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

		distinctButton = new Button("�ߺ� Ȯ��");
		distinctButton.setBounds(270, 100, 80, 25);
		this.add(distinctButton);
		distinctButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �ߺ��߻� ���� �� dialog ���
			}
		});

		// �н����� �߰��ؾ� �� ���� : ��������� ���
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
					pwReLb.setText("��ġ");
				} else
					pwReLb.setText("����ġ");
			}
		});

		pwReLb = new Label("����ġ");
		pwReLb.setBounds(255, 160, 70, 25);
		this.add(pwReLb);

		nameLb = new Label("�̸�");
		nameLb.setBounds(45, 210, 50, 25);
		this.add(nameLb);

		// �߰� �ؾ��ϴ� ���� : ���� ����
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

		// ���� (Customer ��ü�� �ѱ�� �κ� �߰� �ؾ���)
		genderLb = new Label("����");
		genderLb.setBounds(45, 240, 50, 25);
		this.add(genderLb);
		cg = new CheckboxGroup();
		man = new Checkbox("��", false, cg);
		woman = new Checkbox("��", false, cg);

		man.setBounds(100, 240, 50, 25);
		woman.setBounds(160, 240, 50, 25);
		this.add(man);
		this.add(woman);

		// �̸���
		emailLb = new Label("�̸���");
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

		// ��ȭ��ȣ
		phoneLb = new Label("��ȭ��ȣ");
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

		// ��ư
		confirmButton = new Button("Ȯ��");
		confirmButton.setBounds(80, 350, 65, 30);
		this.add(confirmButton);

		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirmD.setVisible(true);
				// �߰��ؾ���
			}
		});

		cancelButton = new Button("���");
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
		
		initCancelDialog();
		initSaveDialog();

		this.setModal(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	public void initCancelDialog() {
		cancelD = new Dialog(this);
		Label msg = new Label("ȸ�������� ����ϰڽ��ϱ�?");
		Button yes = new Button("��");
		Button no = new Button("�ƴϿ�");
		
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setClose(true);
				dispose();
			}
		});
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		cancelD.setBounds(100, 100, 300, 200);
		cancelD.setModal(true);
		cancelD.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelD.dispose();
			}
		});

	}

	public void initSaveDialog() {
		confirmD = new Dialog(this);
		Label msg = new Label("ȸ�������� �Ϸ��߽��ϴ�");
		Button yes = new Button("Ȯ��");

		
		confirmD.setBounds(100,100,300,200);
		confirmD.setModal(true);
		confirmD.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//saveCustomer(customer ����);
				confirmD.dispose();
			}
		});

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

	public void saveCustomer(Customer customer) {

	}

}
