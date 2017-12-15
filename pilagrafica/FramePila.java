package pilagrafica;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.MenuComponent;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ListIterator;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author david.ambros
 */
class FramePila extends Frame implements ActionListener, ItemListener {
	private String nomeFinestra;
	private Stack pila;
	TextField argomento;
	Label top;
	Label isEmpty;
	Button allLeft;
	TextField corrente;
	Button push;
	Button pop;
	Button right;
	Choice scelta;
	ListIterator<String> l;
	int contScelta = 0;
        

	//super va a chiamare i metodi di frame
	FramePila(String nomeFinestra, Stack p) {
		super(nomeFinestra);

		this.pila = p;
		setSize(600, 300);

		setLayout(new GridLayout(5, 3));

		Label vuoto = new Label();
		top = new Label("top");
		top.setBackground(Color.gray);
		isEmpty = new Label("isEmpty");
		isEmpty.setBackground(Color.gray);
		allLeft = new Button("<<");
		argomento = new TextField("argomento: ");
		corrente = new TextField("corrente");
		push = new Button("push");
		pop = new Button("pop");
		right = new Button(">");
		scelta = new Choice();
                scelta.addItemListener(this);

		add(vuoto);
		add(argomento);
		add(push);
		add(top);
		add(new Label());
		add(pop);
		add(isEmpty);
		add(new Label());
		add(new Label());
		add(allLeft);
		add(corrente);
		add(right);
		add(new Label());
		add(scelta);
		add(new Label());

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		}
		);

		push.addActionListener(this);
		pop.addActionListener(this);
		right.addActionListener(this);
		allLeft.addActionListener(this);

		l = pila.listIterator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == push) {
			pila.push(argomento.getText());
			top.setText((String) pila.peek());
			isEmpty.setText("isEmpty = " + pila.isEmpty());
			scelta.add(argomento.getText());
			contScelta++;
			l = pila.listIterator();
		}
		if (e.getSource() == pop) {
			if (pila.size() > 0) {
				try {
					pila.pop();
					top.setText((String) pila.peek());
				} catch (Exception ex) {
				}
				scelta.remove(contScelta - 1);
				isEmpty.setText("isEmpty = " + pila.isEmpty());
				contScelta--;
				l = pila.listIterator();
			}
		}
		if (e.getSource() == right) {
			if (l.hasNext()) {
				corrente.setText(l.next());
			}

		}
		if (e.getSource() == allLeft) {
			while (l.hasPrevious()) {
				corrente.setText(l.previous());
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
            System.out.println("ciioa");
            ListIterator i;
            for ( i=pila.listIterator(); i.hasNext()&&!i.next().toString().equals(e.getItem().toString());) {
            }
            
            corrente.setText(i.previous().toString());
            l=i;
	}
}
