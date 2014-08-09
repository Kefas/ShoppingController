package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		((AddPanel)view.getChildPanel()).getTxtPrice().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {			
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				handlerAddPriceText();
			}
		});
	}

	protected void handlerAddPriceText() {
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtPrice()){
			((AddPanel)view.getChildPanel()).getTxtPrice().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtPrice(false);
		}
	}

}
