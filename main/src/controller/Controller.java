package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.AddPanel;
import view.View;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		view.getBtnAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnAdd();
			}
		});
	}

	protected void handlerBtnAdd() {
		view.setChildPanel(new AddPanel());
	}

}
