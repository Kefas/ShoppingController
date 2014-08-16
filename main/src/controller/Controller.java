package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import model.Item;
import model.Model;
import view.AddPanel;
import view.ShowPanel;
import view.View;

/**
 * @author piotr
 *
 */
public class Controller {
	
	/**
	 * Base path
	 */
	public static final String BASEPATH = "C:\\Users\\piotr\\Dysk Google\\zakupy\\";
			
	/**
	 * path to file with items
	 */
	public static String PATH = "C:\\Users\\piotr\\Dysk Google\\zakupy\\";

	/**
	 * item to category file
	 */
	public static final String ITEM_TO_CATEGORY_FILE = "itemToCategory.txt";
	
	/**
	 * item to food category file
	 */
	public static final String ITEM_TO_FOOD_CATEGORY_FILE = "itemToFoodCategory.txt";

	/**
	 * shop file
	 */
	private static final String SHOP_FILE = "shopList.txt";
	
	/**
	 * model 
	 */
	private Model model;
	
	/**
	 * view
	 */
	private View view;
	
	/**
	 * chart controller
	 */
	private ChartController chartController;
	
	/**
	 * map item to category
	 */
	private Map<String,String> itemToCategory;
	
	/**
	 * map item to food category
	 */
	private Map<String,String> itemToFoodCategory;
	
	/**
	 * shop list
	 */
	private List<String> shopList;

	/**
	 * is new shop added
	 */
	private boolean addedShop;

	private boolean addedCategory;

	private boolean addedFoodCategory;
	

	/**Controller constructor
	 * 
	 * @param model
	 * @param view
	 */
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		// set actual file with actual year and month
		Format format = new SimpleDateFormat("yyMM");
		PATH += format.format(Calendar.getInstance().getTime()) + ".txt";
		
		itemToCategory = new HashMap<String, String>();
		itemToFoodCategory = new HashMap<String, String>(); 
		shopList = new ArrayList<String>();
		generateCategory(ITEM_TO_CATEGORY_FILE, itemToCategory);
		generateCategory(ITEM_TO_FOOD_CATEGORY_FILE, itemToFoodCategory);
		generateShopList(SHOP_FILE, shopList);
		
		view.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                handlerExit();
                e.getWindow().dispose();
            }
        });
		
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

	

	/**
	 * handle exit
	 */
	protected void handlerExit() {
		if(addedCategory)
			saveCategory(ITEM_TO_CATEGORY_FILE, itemToCategory);
		if(addedFoodCategory)
			saveCategory(ITEM_TO_FOOD_CATEGORY_FILE, itemToFoodCategory);
		if(addedShop)
			saveShopList(SHOP_FILE, shopList);
	}

	/** save shopList in shopFile
	 * 
	 * @param shopFile
	 * @param shopList
	 */
	private void saveShopList(String shopFile, List<String> shopList) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(BASEPATH + shopFile, false)));
			for(String shopName : shopList)
				out.println(shopName);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	/**save categoryMap to categoryFile
	 * 
	 * @param categoryFile
	 * @param categoryMap
	 */
	private void saveCategory(String categoryFile, Map<String, String> categoryMap) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(BASEPATH + categoryFile, false)));
			for(Entry<String,String> entry : categoryMap.entrySet()){
				out.println(entry.getKey() + "," + entry.getValue());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**read categoryMap from categoryFile
	 * 
	 * @param categoryFile
	 * @param categoryMap
	 */
	private void generateCategory(String categoryFile, Map<String,String> categoryMap) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(BASEPATH + categoryFile));
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				String[] parts = line.split(",");
				categoryMap.put(parts[0], parts[1]);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**read shopList from shopFile
	 * 
	 * @param shopFile
	 * @param shopList
	 */
	private void generateShopList(String shopFile, List<String> shopList) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(BASEPATH + shopFile));
			String line = null;
			while((line = bufferedReader.readLine()) != null)
				shopList.add(line);
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * handle print button
	 */
	protected void handlerBtnPrint() {
		this.chartController = new ChartController(model, view);		
	}

	/**
	 * handle show button
	 */
	protected void handlerBtnShow() {
		ShowPanel showPanel = new ShowPanel();
		showPanel.readFromFile(PATH);
		view.setChildPanel(showPanel);	
	}

	/**
	 * handle add button
	 */
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
		
		((AddPanel)view.getChildPanel()).getTxtCategory().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				handlerAddCategoryText();
			}
		});
		
		((AddPanel)view.getChildPanel()).getTxtFoodCategory().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				handlerAddFoodCategory();
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
	 * if first click on addCategory text field erase text
	 */
	protected void handlerAddCategoryText() {
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtCategory()){
			((AddPanel)view.getChildPanel()).getTxtCategory().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtCategory(false);
		}
	}
	
	/**
	 * if first click on addFoodCategory text field erase text
	 */
	protected void handlerAddFoodCategory() {	
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtFoodCategory()){
			((AddPanel)view.getChildPanel()).getTxtFoodCategory().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtFoodCategory(false);
		}
	}

	/**
	 * if item is typed this method look in already added items to find category
	 */
	protected void handlerDoneTypingName() {
		((AddPanel)view.getChildPanel()).categoryReset();
		
		if(itemToCategory.containsKey(((AddPanel)view.getChildPanel()).getTxtItem().getText())){
			((AddPanel)view.getChildPanel()).getTxtCategory().setText(itemToCategory.get(((AddPanel)view.getChildPanel()).getTxtItem().getText()));
			((AddPanel)view.getChildPanel()).getTxtCategory().setEditable(false);
			((AddPanel)view.getChildPanel()).setFirstClickTxtCategory(false);
			if("food".equals(((AddPanel)view.getChildPanel()).getTxtCategory().getText())){
				if(itemToCategory.containsKey(((AddPanel)view.getChildPanel()).getTxtItem().getText())){
					((AddPanel)view.getChildPanel()).getTxtFoodCategory().setText(itemToFoodCategory.get(((AddPanel)view.getChildPanel()).getTxtItem().getText()));		
					((AddPanel)view.getChildPanel()).setFirstClickTxtFoodCategory(false);
					((AddPanel)view.getChildPanel()).getTxtFoodCategory().setEditable(false);
				}
					
			}
			else{
				((AddPanel)view.getChildPanel()).getTxtFoodCategory().setText("");
			}
		}
	}

	/**
	 * if first click on addShop text field erase text
	 */
	protected void handlerAddShopText() {
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtShop()){
			((AddPanel)view.getChildPanel()).getTxtShop().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtShop(false);
		}
	}
	
	/**
	 * if first click on addItem text field erase text
	 */
	protected void handlerAddItemText() {
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtItem()){
			((AddPanel)view.getChildPanel()).getTxtItem().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtItem(false);
		}
	}

	/**
	 * if first click on addPrice text field erase text
	 */
	protected void handlerAddPriceText() {
		if(((AddPanel)view.getChildPanel()).isFirstClickTxtPrice()){
			((AddPanel)view.getChildPanel()).getTxtPrice().setText("");
			((AddPanel)view.getChildPanel()).setFirstClickTxtPrice(false);
		}
	}

	/**
	 * handle addEntry button
	 */
	protected void handlerBtnAddEntry() {
		AddPanel addPanel =((AddPanel)view.getChildPanel());
		Item addEntry = new Item(
				addPanel.getTxtShop().getText(),
				addPanel.getTxtItem().getText(),
				addPanel.getTxtCategory().getText(),
				addPanel.getTxtFoodCategory().getText(),
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
		
		model.saveEntry(PATH, addEntry);
//		model.saveEntry("temp.txt", addEntry);
		
		if(!itemToCategory.containsKey(((AddPanel)view.getChildPanel()).getTxtItem().getText()))
			addedCategory = true;	
		if("food".equals(((AddPanel)view.getChildPanel()).getTxtCategory().getText()))
			if(!itemToCategory.containsKey(((AddPanel)view.getChildPanel()).getTxtItem().getText()))
				addedFoodCategory = true;
		
		if(addedCategory)
			itemToCategory.put(addEntry.getName(), addEntry.getCategory());
		if(addedFoodCategory)
			itemToFoodCategory.put(addEntry.getName(), addEntry.getFoodCategory());
		if(!contain(shopList, addEntry.getShop())){
			addedShop = true;
			shopList.add(addEntry.getShop());
		}
			
		
		((AddPanel) view.getChildPanel()).clear();
		((AddPanel) view.getChildPanel()).printInfo("Item: " + addEntry.getName() + " added succesfully!", View.SUCCESS);
	}

	/**is shopList contains shop
	 * 
	 * @param shopList
	 * @param shop
	 * @return
	 */
	private boolean contain(List<String> shopList, String shop) {
		boolean shopInList = false;
		for(String shopName : shopList)
			if(shopName.equals(shop))
				shopInList = true;
		return shopInList;
	}

	/**erase field which cause validation problem
	 * 
	 * @param function
	 * @param message
	 */
	private void proceedError(String function, String message) {
		if("add".equals(function)){
			if("shop".equals(message))
				((AddPanel)view.getChildPanel()).getTxtShop().setText("");
			else if("item".equals(message))
				((AddPanel)view.getChildPanel()).getTxtItem().setText("");
			else if("price".equals(message))
				((AddPanel)view.getChildPanel()).getTxtPrice().setText("");
			else if("date".equals(message))
				((AddPanel)view.getChildPanel()).getTxtDate().setText("");
			else if("category".equals(message))
				((AddPanel)view.getChildPanel()).getTxtCategory().setText("");
		}	
	}
}
