package main;

import java.awt.EventQueue;

import model.Model;
import view.View;
import controller.Controller;

public class Main {

	private static View view;
	protected static Model model;
	protected static Controller controller;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	model = new Model();
                view = new View();
                view.setVisible(true);
                controller = new Controller(model, view);
            
            }
        });
		
		
	}

}
