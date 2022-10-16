package team_turtle;

import java.util.ArrayList;
import java.util.HashMap;

import java.awt.event.*;
import javax.swing.*;


public class Recipe_book {
	
	HashMap<String, Recipe_entry> rb;
	

	//make new Recipe Book object
	Recipe_book() {
			rb = new HashMap<String,Recipe_entry>();
	}
	
	void init() {

		JFrame f1 = new JFrame("Recipe Book");

		JButton s = new JButton("Search Recipes");
		s.setBounds(150, 100, 300, 120);
		s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//print recipes
				JFrame sr = new JFrame("Search Recipes");

				JTextField key = new JTextField("Name");
				key.setBounds(150,200,300,20);
				sr.add(key);
				
				JButton sub = new JButton("Search");
				sub.setBounds(150,400,300,120);
				sr.add(sub);
				
				sub.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Recipe_entry temp = rb.get(key.getText());
						JFrame pr = new JFrame("textfield");
						String out;
						if(temp != null) {
							out = temp.re_print();
						}
						else {
							out = "Recipe Not Available";
						}
						JTextArea ldis = new JTextArea(out);
						ldis.setBounds(150,100,300,500);
						ldis.setEditable(false);
						pr.add(ldis);
						//JScrollPane scroll = new JScrollPane (ldis, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								//JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						//scroll.setBounds(300,100,20,400);
						//pr.add(scroll);
						
						JButton bm = new JButton("Back to Menu");
						bm.setBounds(150,600,300,120);
						bm.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								pr.dispose();
							}
						});
						
						pr.add(bm);
						
						pr.setSize(600, 800);
						pr.setLayout(null);
						pr.setVisible(true);
						pr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
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
				JFrame pr = new JFrame("See All Recipes");
				String out = "";
				for (String key: rb.keySet()) {
					out = out.concat(rb.get(key).re_print()+"\n\n");
				}
				JTextArea ldis = new JTextArea(out);
				JScrollPane scroll = new JScrollPane (ldis, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				pr.add(scroll);
				ldis.setBounds(150,100,300,500);
				ldis.setEditable(false);
				pr.add(ldis);
				
				JButton bm = new JButton("Back to Menu");
				bm.setBounds(150,600,300,120);
				bm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pr.dispose();
					}
				});
				
				pr.add(bm);
				
				pr.setSize(600, 800);
				pr.setLayout(null);
				pr.setVisible(true);
				pr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		JButton add = new JButton("Add Recipe");
		add.setBounds(150, 500, 300, 120);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add recipe
					JFrame tf = new JFrame("Add Recipe");
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
							String ingl = il.getText();
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
		
		des.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ta = new JFrame("About Us");
				String spiel = "Our Story";
				JTextArea au = new JTextArea(spiel);
				JScrollPane scroll = new JScrollPane (au, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				ta.add(scroll);
				au.setBounds(150,100,300,500);
				au.setEditable(false);
				ta.add(au);
				
				JButton bm = new JButton("Back to Menu");
				bm.setBounds(150,600,300,120);
				bm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ta.dispose();
					}
				});
				
				ta.add(bm);
				
				ta.setSize(600, 800);
				ta.setLayout(null);
				ta.setVisible(true);
				ta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
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
							+ "Instructions:\t"+re[3]+"\n";
			//System.out.println(out);
			return out;
		}
	}

}

