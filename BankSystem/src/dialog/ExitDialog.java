package dialog;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.InitFrame;
import gui.UserMainFrame;

public class ExitDialog extends Dialog{
	Label la1, la2, la3, la4, la5;
	Label msgLb;
	Button exitButton, closeButton;
	Panel p1, p2;
	Frame parent;

	public ExitDialog(Frame parent) {
		super(parent, "���� ���̾�α�");
		
		this.parent = parent;

		p1 = new Panel();
		p2 = new Panel();

		la1 = new Label("");
		la2 = new Label("");
		la3 = new Label("");
		la4 = new Label("");
		la5 = new Label("");

		msgLb = new Label("�����Ͻðڽ��ϱ�?");
		exitButton = new Button("����");
		closeButton = new Button("���");

		p1.add(msgLb);

		p2.add(la1);
		p2.add(exitButton);
		p2.add(la2);
		p2.add(closeButton);
		p2.add(la3);

		// Dialog
		this.setLayout(new GridLayout(2, 1));
		this.add(p1);
		this.add(p2);
		this.setSize(250, 100);
		this.setResizable(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		// ��ư �۾�
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(parent instanceof UserMainFrame) {
					parent.dispose();
					//InitFrame�� ������ �� �ֵ��� �����ؾ���
				}
				if(parent instanceof InitFrame) {
					System.exit(0);
				}
			}
		});

		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}

	
	
}
