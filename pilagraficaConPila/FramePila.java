package pilagrafica;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import pilagrafica.Pila.Iteratore;


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
	private Pila pila;
	TextField argomento;
	Label top;
	Label isEmpty;
	Button allLeft;
	TextField corrente;
	Button push;
	Button pop;
	Button right;
        Iteratore it;

	//super va a chiamare i metodi di frame
	FramePila(String nomeFinestra, Pila p) {
		super(nomeFinestra);
		this.pila = p;
		setSize(600, 300);

		setLayout(new GridLayout(4, 3));

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
		
                it=pila.iterator();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == push) {
			pila.push(argomento.getText());
			top.setText((String) pila.top());
			isEmpty.setText("isEmpty = " + pila.isEmpty());
                        it.goHead();
		}
		if (e.getSource() == pop) {
			pila.pop();
			top.setText((String) pila.top());
			isEmpty.setText("isEmpty = " + pila.isEmpty());
                       
		}
		if (e.getSource() == right) {
                   
			it.goOneDown();
                        corrente.setText((String) it.current());
                  
                    
		}
		if (e.getSource() == allLeft) {
                    it.goHead();
                    corrente.setText((String) it.current());
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
            
	}
}
