package team_turtle;

import java.util.HashMap;

import java.awt.event.*;
import javax.swing.*;

public class Recipe_book {
	
	HashMap<String, Recipe_entry> rb;
	

	//make new Recipe Book object
	Recipe_book() {
			rb = new HashMap<String,Recipe_entry>();

		//Recipe_book ro = new Recipe_book();
		//ro.init();
		//return rb;
	}
	
	void init() {

		JFrame f1 = new JFrame("Button");

		JButton s = new JButton("Search Recipes");
		s.setBounds(150, 100, 300, 120);
		s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//print recipes
				JFrame sr = new JFrame("textfield");

				JTextField key = new JTextField("Name");
				key.setBounds(150,200,300,20);
				sr.add(key);
				
				JButton sub = new JButton("Search");
				sub.setBounds(150,400,300,120);
				sr.add(sub);
				
				
				sub.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rb.get(key.getText()).re_print();
					}
				});
				
				JButton exit = new JButton("Back to Menu");
				exit.setBounds(150,600,300,120);
				sr.add(exit);
				exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sr.dispose();
					}
				});
				
				sr.setSize(600, 800);
				sr.setLayout(null);
				sr.setVisible(true);
				sr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JButton list = new JButton("See All Recipes");
		list.setBounds(150, 300, 300, 120);
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//print recipes
				JFrame pr = new JFrame("textfield");

				for (String key: rb.keySet()) {
					rb.get(key).re_print();
				}
			}
		});
		JButton add = new JButton("Add Recipe");
		add.setBounds(150, 500, 300, 120);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add recipe
					JFrame tf = new JFrame("textfield");
					JPanel p = new JPanel();
					
					JTextField name = new JTextField("Name");
					name.setBounds(150,200,300,20);
					tf.add(name);
					JLabel nm = new JLabel("Name");
					p.add(nm);
					//tf.add(p);
					
					JLabel d = new JLabel("Description");
					tf.add(d);
					JTextField desc = new JTextField("Description");
					desc.setBounds(150,300,300,20);
					tf.add(desc);
					
					JLabel inl = new JLabel("Ingredient List");
					tf.add(inl);
					JTextField il = new JTextField("Ingredient List");
					il.setBounds(150,400,300,20);
					tf.add(il);
					
					JLabel ins = new JLabel("Instructions");
					tf.add(ins);
					JTextField inst = new JTextField("Instructions");
					inst.setBounds(150,500,300,20);
					tf.add(inst);
					//f1.add(name);
					
					JButton sub = new JButton("Submit");
					sub.setBounds(250,600,120,40);
					tf.add(sub);
					sub.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String n = name.getText();
							String de = desc.getText();
							String ingl = inl.getText();
							String instr = inst.getText();
							Recipe_entry re = new Recipe_entry(n,de,ingl,instr);
							rb.put(n, re);
							tf.dispose();
						}
					});
					
					tf.add(p);
					tf.setSize(600, 800);
					tf.setLayout(null);
					tf.setVisible(true);
					tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JButton des = new JButton("About Us");
		des.setBounds(250,675,100,40);
		
		f1.add(s);
		
		f1.add(list);
		
		f1.add(add);
		
		f1.add(des);
		
		f1.setSize(600, 800);
		f1.setLayout(null);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	//public void 
	
	public static void main(String[] args) {
		Recipe_book rb = new Recipe_book();
		rb.init();
		
	}
	
	class Recipe_entry {
		String[] re;
		
		Recipe_entry(String name, String desc, String il, String instructions) {
			re = new String[4];
			re[0] = name;
			re[1] = desc;
			re[2] = il;
			re[3] =instructions;
		}
		
		String re_print() {
			String out = "Name:\t"+re[0]+"\nDescription:\t"+re[1]
					+ "\nIngredient List:\t"+re[2]+"\n"
							+ "Instructions:\t"+re[3];
			System.out.println(out);
			return out;
		}
	}

}

