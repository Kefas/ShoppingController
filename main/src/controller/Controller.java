package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import javax.swing.JOptionPane;

import model.Item;
import model.Model;
import view.AddPanel;
import view.PrintPanel;
import view.ShowPanel;
import view.View;

public class Controller {
	
	public static final String PATH = "C:\\Users\\piotr\\Dysk Google\\zakupy\\item_list.txt";

	private Model model;
	private View view;
	private ChartController chartController;
	
	/**
	 * timer
	 */
	Timer timer;
	
	/**
	 * map item to category
	 */
	private Map<String,String> itemToCategory;
	
	/**
	 * map item to food category
	 */
	private Map<String,String> itemToFoodCategory;
	

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		timer = new Timer();
		
		generateCategory(PATH);
		
		view.getBtnAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnAdd();
			}
		});
		
		view.getBtnShow().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnShow();
			}
		});
		
		view.getBtnPrint().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnPrint();
			}
		});
	}

	private void generateCategory(String path) {
		itemToCategory = new HashMap<String, String>();
		itemToFoodCategory = new HashMap<String, String>(); 
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				String[] parts = line.split(",");
				if(parts.length > 4){
					if(parts[1].equals("food")){
						itemToFoodCategory.put(parts[3], parts[2]);
						itemToCategory.put(parts[3], parts[1]);
					}
					else
						itemToCategory.put(parts[2], parts[1]);
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void handlerBtnPrint() {
		PrintPanel printPanel = new PrintPanel();
		this.chartController = new ChartController();
		chartController.setPrintPanel(printPanel);
		chartController.printChart();
		view.setChildPanel(printPanel);
		
	}

	protected void handlerBtnShow() {
		ShowPanel showPanel = new ShowPanel();
		showPanel.readFromFile("C:\\Users\\piotr\\Dysk Google\\zakupy\\item_list.txt");
		view.setChildPanel(showPanel);
		
	}
	
	

	protected void handlerBtnAdd() {
		view.setChildPanel(new AddPanel());
		
		((AddPanel)view.getChildPanel()).getTxtShop().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				handlerAddShopText();
			}
		});
		
		((AddPanel)view.getChildPanel()).getTxtItem().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				handlerDoneTypingName();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				handlerAddItemText();			
			}
		});
		
		((AddPanel)view.getChildPanel()).getTxtItem().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				handlerDoneTypingName();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
		
			}
		});

		((AddPanel)view.getChildPanel()).getTxtPrice().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
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

	/**
	 * if item is typed this method look in already added items to find category
	 */
	protected void handlerDoneTypingName() {
		((AddPanel)view.getChildPanel()).reset();
		System.out.println("handlerDoneTypingName");
		if(itemToCategory.containsKey(((AddPanel)view.getChildPanel()).getTxtItem().getText())){
			((AddPanel)view.getChildPanel()).getTxtCategory().setText(itemToCategory.get(((AddPanel)view.getChildPanel()).getTxtItem().getText()));
			((AddPanel)view.getChildPanel()).getTxtCategory().setEditable(false);
			if("food".equals(((AddPanel)view.getChildPanel()).getTxtCategory().getText())){
				if(itemToCategory.containsKey(((AddPanel)view.getChildPanel()).getTxtItem().getText())){
					((AddPanel)view.getChildPanel()).getTxtFoodCategory().setText(itemToFoodCategory.get(((AddPanel)view.getChildPanel()).getTxtItem().getText()));		
					
				}
			}
			else
				((AddPanel)view.getChildPanel()).getTxtFoodCategory().setText("");
			((AddPanel)view.getChildPanel()).getTxtFoodCategory().setEditable(false);
		}
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
		Item addEntry = new Item(
				addPanel.getTxtShop().getText(),
				addPanel.getTxtItem().getText(),
				addPanel.getTxtPrice().getText(),
				addPanel.getTxtDate().getText()
				);
		try {
			model.validateEntry(addEntry);
		} catch (Exception e) {
			((AddPanel) view.getChildPanel()).printInfo("Item: " + addEntry.getName() + " hasn't been added!", View.FAILURE);
			JOptionPane.showMessageDialog(null, "Validate problem: " + e.getMessage());
			proceedError("add", e.getMessage());
			return;
		}
//		model.saveEntry("C:\\Users\\piotr\\Dysk Google\\zakupy\\item_list.txt", addEntry);
//		model.saveEntry(PATH, addEntry);
		model.saveEntry("temp.txt", addEntry);
		((AddPanel) view.getChildPanel()).clear();
		((AddPanel) view.getChildPanel()).printInfo("Item: " + addEntry.getName() + " added succesfully!", View.SUCCESS);
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
