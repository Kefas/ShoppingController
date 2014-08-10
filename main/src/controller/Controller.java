package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.AddEntry;
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
		
		((AddPanel)view.getChildPanel()).getTxtShop().addMouseListener(new MouseListener() {
			
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
				handlerAddShopText();
			}
		});

		((AddPanel)view.getChildPanel()).getTxtItem().addMouseListener(new MouseListener() {
			
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
				handlerAddItemText();
			}
		});

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
		
		((AddPanel)view.getChildPanel()).getBtnAddEntry().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnAddEntry();
			}
		});
	}

	protected void handlerAddShopText() {
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtShop()){
			((AddPanel)view.getChildPanel()).getTxtShop().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtShop(false);
		}
	}
	
	protected void handlerAddItemText() {
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtItem()){
			((AddPanel)view.getChildPanel()).getTxtItem().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtItem(false);
		}
	}

	protected void handlerAddPriceText() {
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtPrice()){
			((AddPanel)view.getChildPanel()).getTxtPrice().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtPrice(false);
		}
	}

	protected void handlerBtnAddEntry() {
		AddPanel addPanel =((AddPanel)view.getChildPanel());
		AddEntry addEntry = new AddEntry(
				addPanel.getTxtShop().getText(),
				addPanel.getTxtItem().getText(),
				addPanel.getTxtPrice().getText(),
				addPanel.getTxtDate().getText()
				);
		try {
			model.validateEntry(addEntry);
		} catch (Exception e) {
			((AddPanel) view.getChildPanel()).printInfo("Item: " + addEntry.getItem() + " hasn't been added!", View.FAILURE);
			JOptionPane.showMessageDialog(null, "Validate problem: " + e.getMessage());
			proceedError("add", e.getMessage());
			return;
		}
		model.saveEntry("C:\\Users\\piotr\\Dysk Google\\zakupy\\item_list.txt", addEntry);
//		model.saveEntry("temp.txt", addEntry);
		((AddPanel) view.getChildPanel()).clear();
		((AddPanel) view.getChildPanel()).printInfo("Item: " + addEntry.getItem() + " added succesfully!", View.SUCCESS);
	}

	private void proceedError(String function, String message) {
		if("add".equals(function)){
			if("shop".equals(message))
				((AddPanel)view.getChildPanel()).getTxtShop().setText("");
			if("item".equals(message))
				((AddPanel)view.getChildPanel()).getTxtItem().setText("");
			if("price".equals(message))
				((AddPanel)view.getChildPanel()).getTxtPrice().setText("");
			if("date".equals(message))
				((AddPanel)view.getChildPanel()).getTxtDate().setText("");
		}	
	}
}
