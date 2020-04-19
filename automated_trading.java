import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  
class automated_trading extends Frame{
	String[] reversals={"Choose Pattern"};
	String ewB, ewBu,patterntrend,diver,trendlines,s,trendline,r;
	float trendlinerr, rr;
	JComboBox reversal= new JComboBox();
	
	
	automated_trading(){
		JFrame automated_trading=new JFrame("Automated Trading Platform");
		automated_trading.setContentPane(new JLabel(new ImageIcon("background.jpg")));
		JLabel title = new JLabel("Welcome to Automated Trading Platform");
		title.setBounds(190,50,1000,40);
		automated_trading.add(title);
		Font f = new Font("TimesRoman",Font.BOLD,40);
		Font emwave = new Font("TimesRoman",Font.ITALIC,18);
		title.setForeground(Color.white);
		title.setFont(f);
		
		JLabel eMWave = new JLabel("Elliot Waves : ");
		eMWave.setForeground(Color.white);
		eMWave.setBounds(100,200,200,30);
		eMWave.setFont(emwave);
		automated_trading.add(eMWave);
		String[] ewave1={"Choose Wave","none","Wave A","Wave B","Wave C","Wave D","Wave E"};
		String[] ewave2={"Choose Wave","none","Wave 1","Wave 2","Wave 3","Wave 4","Wave 5"};
		JComboBox ewaves1 = new JComboBox(ewave1);
		JComboBox ewaves2 = new JComboBox(ewave2);
		ewaves1.setBounds(300,240,100,30);
		ewaves2.setBounds(420,240,100,30);
		CheckboxGroup whichwave = new CheckboxGroup();
		Checkbox w1 = new Checkbox("Bearish Wave", whichwave,false);
		Checkbox w2 = new Checkbox("Bullish Wave",whichwave,false);
		w1.setBounds(300, 200, 120, 30);
		w2.setBounds(420, 200, 120, 30);
		automated_trading.add(w1);
		automated_trading.add(w2);
		
		automated_trading.add(ewaves1);
		automated_trading.add(ewaves2);
		JLabel trendline = new JLabel("Trendline : ");
		trendline.setForeground(Color.white);
		trendline.setBounds(100,300,150,30);
		trendline.setFont(emwave);
		automated_trading.add(trendline);
		CheckboxGroup trend = new CheckboxGroup();
		Checkbox bottom = new Checkbox("Bottom", trend,false);
		Checkbox up = new Checkbox("Up",trend,false);
		Checkbox no = new Checkbox("No",trend,false);
		bottom.setBounds(300,300,100,30);
		up.setBounds(400,300,100,30);
		no.setBounds(500,300,100,30);
		JTextField trendpercentage = new JTextField("R:R");
		trendpercentage.setBounds(300,350,200,40);
		automated_trading.add(trendpercentage);
		automated_trading.add(bottom);
		automated_trading.add(up);
		automated_trading.add(no);
		JLabel divergence = new JLabel("Divergence : ");
		divergence.setForeground(Color.white);
		divergence.setBounds(100,450,150,30);
		divergence.setFont(emwave);
		
		CheckboxGroup diverge = new CheckboxGroup();
		Checkbox bd = new Checkbox("Bullish", diverge,false);
		Checkbox bed = new Checkbox("Bearish",diverge,false);
		Checkbox none = new Checkbox("No Divergence",diverge,false);
		bd.setBounds(300,450,100,30);
		bed.setBounds(300,490,100,30);
		none.setBounds(300,530,140,30);
		automated_trading.add(bd);
		automated_trading.add(bed);
		automated_trading.add(none);
		automated_trading.add(divergence);
		JLabel patterns = new JLabel("Choose Pattern : ");
		patterns.setForeground(Color.white);
		patterns.setBounds(760,200,200,30);
		patterns.setFont(emwave);
		automated_trading.add(patterns);
		String[] patternss ={"Choose Pattern","Reversal Pattern","Continuation Pattern","Bilateral Pattern"};
		JComboBox pattern = new JComboBox(patternss);
		pattern.setBounds(980,200,200,30);
		JButton choosepattern = new JButton("Choose Pattern type");
		choosepattern.setBounds(980,235,200,30);
		
		
		automated_trading.add(choosepattern);
		JLabel supportandresistance = new JLabel("Support Or Resistance : ");
		supportandresistance.setForeground(Color.white);
		supportandresistance.setBounds(760,400,300,30);
		supportandresistance.setFont(emwave);
		automated_trading.add(supportandresistance);
		CheckboxGroup sr = new CheckboxGroup();
		Checkbox support = new Checkbox("Support", sr,false);
		Checkbox resistance = new Checkbox("Resistance",sr,false);
		support.setBounds(1060,400,100,30);
		resistance.setBounds(1160,400,110,30);
		JTextField percentage = new JTextField("R:R");
		percentage.setBounds(1060,450,200,40);
		automated_trading.add(percentage);
		automated_trading.add(support);
		automated_trading.add(resistance);
		JLabel btc = new JLabel("Enter the Principle Amount : ");
		btc.setForeground(Color.white);
		btc.setBounds(760,560,350,30);
		btc.setFont(emwave);
		automated_trading.add(btc);
		JTextField btcamount = new JTextField("BTCs");
		btcamount.setBounds(1060,560,200,40);
		automated_trading.add(btcamount);
		JButton calculate = new JButton("CALCULATE STRATEGY");
		calculate.setBounds(470,620,300,40);
		calculate.setFont(emwave);
		ewaves2.setEnabled(false);
		ewaves1.setEnabled(false);
		automated_trading.add(pattern);
		automated_trading.add(calculate);
		reversal.setBounds(980, 275, 200,30);
		JLabel credits = new JLabel("Designed and Developed By : Saurabh Poonia, Tejas Singh Rana And Aditya Dhir");
		credits.setForeground(Color.white);
		credits.setBounds(300,670,1000,30);
		credits.setFont(emwave);
		automated_trading.add(credits);
		automated_trading.add(reversal);
		automated_trading.setSize(1356, 728);
		automated_trading.setSize(1356, 728);
		automated_trading.setLayout(null);
		automated_trading.setVisible(true);
		automated_trading.setLocationRelativeTo(null);
		 ewBu=(String)ewaves1.getItemAt(ewaves1.getSelectedIndex());
		 
						
		 ewB=(String)ewaves2.getItemAt(ewaves2.getSelectedIndex());
						
        
		//Events
		 bd.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
               diver = "Bullish";  
            }  
         });  
          bed.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              diver = "Bearish";  
            }  
         });
          bottom.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              trendlines = "Bottom";  
            }  
         });
          no.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              trendlines = "None";  
            }  
         });
          up.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              trendlines = "Up";  
            }  
         });
          support.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              s = "Support";  
            }  
         });
          resistance.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              r = "Resistance";  
            }  
         });
           w1.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              ewaves1.setEnabled(true);
              ewaves2.setEnabled(false);
              ewBu=(String)ewaves1.getItemAt(ewaves1.getSelectedIndex());
              ewB="none";

            }  
         });
            w2.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              ewaves2.setEnabled(true);
              ewaves1.setEnabled(false);
              ewB=(String)ewaves2.getItemAt(ewaves1.getSelectedIndex());
              ewBu="none";
            }  
         });
             choosepattern.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            patterntrend=(String)pattern.getItemAt(pattern.getSelectedIndex());
            	if(patterntrend=="Reversal Pattern")
            {
            	reversal.removeAllItems();
              	reversal.addItem("Double Top");
              	reversal.addItem("Double Bottom");
              	reversal.addItem("Head and Shoulders");
              	reversal.addItem("Inverse Head and Shoulders");
              	reversal.addItem("Rising Wedge");
              	reversal.addItem("Falling Wedge");

            }
            else if(patterntrend=="Continuation Pattern")
            {   
            	reversal.removeAllItems();
              	reversal.addItem("Falling Wedge");
              	reversal.addItem("Bullish Rectange");
              	reversal.addItem("Bullish Pennent");
              	reversal.addItem("Rising Wedge");
              	reversal.addItem("Bearish Rectangle");
              	reversal.addItem("Bearish Pennent");

            }
            else if(patterntrend=="Bilateral Pattern")
            {
            	reversal.removeAllItems();
              	reversal.addItem("Ascending Triangle");
              	reversal.addItem("Descending Triangle");
              	reversal.addItem("Symmetrical Triangle");
            }
            else
            	reversal.removeAllItems();
              
            }  
         });
         
             trendpercentage.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    trendpercentage.setText("");
  }
});
                         percentage.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    percentage.setText("");
  }
});
  btcamount.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    btcamount.setText("");
  }
});
         
		  calculate.addActionListener(new ActionListener()
		  {  
				public void actionPerformed(ActionEvent e)
					{  

						
						
		 
						
		 				ewB=(String)ewaves2.getItemAt(ewaves2.getSelectedIndex());

						patterntrend=(String)pattern.getItemAt(pattern.getSelectedIndex());
						if((ewB=="Wave 5" && ewBu=="Wave A")){
							if(patterntrend=="Continuation Pattern")
							{
								if(trendlines=="Up")
								{
								if(diver=="Bullish")
								{
									System.out.print("Long with 100%");
								}
							}

							}

						}
					    else if(ewBu=="Wave E"&& ewB=="Wave 1")
							{
							if(patterntrend=="Reversal Pattern")
							{
								if(trendlines=="Bottom")
								{
								if(diver=="Bearish")
								{
									System.out.print("Short with 100%");
								}
							}

							}

						}

						else if(ewBu=="Wave A"&& ewB=="none"|| ewB=="Wave 1"&&ewBu=="none")
						{
							System.out.print("You Need to Wait for Next Wave and lookout for continuous patterns in 1hr TF. ");
						}
						else if(ewBu=="Wave B"&&ewB=="none")
						{
							System.out.print(": wait for a continuous pattern.LONG at the breakout(15or30 min candle). TRADE with 100% here. ");
						}
						else if(ewB=="Wave 2"&&ewBu=="none")
						{
							System.out.print(": wait for a continuous pattern.Short at the breakout(15or30 min candle). TRADE with 100% here. ");

						}
						else if(ewBu=="Wave C"&&ewB=="none"|| ewB=="Wave 3"&&ewBu=="none"){
						
							System.out.print("wait for the wave to end, no trade here.lookout for continuous patterns in 1hr TF.");

						}
						else if(ewBu=="Wave D"&&ewB=="none")
							{
							System.out.print("wait for a continuous pattern to form.SHORT at the breakout(15or30 min candle).TRADE with 50% here.");
						}

					    else if( ewB=="Wave 4"&&ewBu=="none")
						{
							System.out.print("wait for a continuous pattern to form.LONG at the breakout(15or30 min candle).TRADE with 50% here.");
						}
						else if(ewBu=="Wave E"&&ewB=="none"|| ewB=="Wave 5"&&ewBu=="none" && trendlines=="None")
						{
							System.out.print("No Trade ");
						}
						else if(ewBu=="Wave A")
						{
							if(s=="Support"){

								if(trendlines=="Bottom")
								{
									trendlinerr=Float.parseFloat(trendpercentage.getText());
									if(trendlinerr<=1.25)
									{
										System.out.print("NO TRADE");
									}
									else if(trendlinerr>1.25 && trendlinerr<2)
									{
										System.out.print("TRADE with 60%");

									}
									else if(trendlinerr>2)
									{
										System.out.print("TRADE with 100%");

									}
								}
							}

						}
						else if(ewBu=="Wave B")
						{
							if(patterntrend=="Continuation Pattern")
							{
							if(s=="Support"){

								if(trendlines=="Bottom")
								{
									trendlinerr=Float.parseFloat(trendpercentage.getText());
									if(trendlinerr<=1.25)
									{
										System.out.print("NO TRADE");
									}
									else if(trendlinerr>1.25 && trendlinerr<2)
									{
										System.out.print("TRADE with 60%");

									}
									else if(trendlinerr>2)
									{
										System.out.print("TRADE with 100%");

									}
								}
							}

						}



						}
						else if(ewBu=="Wave D")
						{
							if(patterntrend=="Continuation Pattern")
							{
							if(s=="Support"){

								if(trendlines=="Bottom")
								{
									trendlinerr=Float.parseFloat(trendpercentage.getText());
									if(trendlinerr<=1.25)
									{
										System.out.print("NO TRADE");
									}
									else if(trendlinerr>1.25 && trendlinerr<2)
									{
										System.out.print("TRADE with 60%");

									}
									else if(trendlinerr>2)
									{
										System.out.print("TRADE with 100%");

									}
								}
							}

						}



						}
						else if(ewBu=="Wave 2"&&patterntrend=="Continuation Pattern" &&s=="Support"&&trendlines=="Bottom")
						{
						
									trendlinerr=Float.parseFloat(trendpercentage.getText());
									if(trendlinerr<=1.25)
									{
										System.out.print("NO TRADE");
									}
									else if(trendlinerr>1.25 && trendlinerr<2)
									{
										System.out.print("TRADE with 60%");

									}
									else if(trendlinerr>2)
									{
										System.out.print("TRADE with 100%");

									}
								}
							

						



							
						else if(ewBu=="Wave 4")
						{
							if(patterntrend=="Continuation Pattern")
							{
							if(s=="Support"){

								if(trendlines=="Bottom")
								{
									trendlinerr=Float.parseFloat(trendpercentage.getText());
									if(trendlinerr<=1.25)
									{
										System.out.print("NO TRADE");
									}
									else if(trendlinerr>1.25 && trendlinerr<2)
									{
										System.out.print("TRADE with 60%");

									}
									else if(trendlinerr>2)
									{
										System.out.print("TRADE with 100%");

									}
								}
							}

						}



						}
						else if(ewBu=="Wave E" && patterntrend=="Reversal Pattern" && trendlines=="Up" && diver=="Bullish" )

						{
							
									trendlinerr=Float.parseFloat(trendpercentage.getText());
									if(trendlinerr<=1.25)
									{
										System.out.print("NO TRADE");
									}
									else if(trendlinerr>1.25 && trendlinerr<2)
									{
										System.out.print("TRADE with 60%");

									}
									else if(trendlinerr>2)
									{
										System.out.print("TRADE with 100%");

									}
								}
								else if(ewBu=="Wave E" && patterntrend=="Reversal Pattern" && trendlines=="Bottom" && diver=="bullish")

								{
							
									System.out.println("Long with 100%");
								}
							
 else if(ewB=="Wave 5" && patterntrend=="Reversal Pattern" && trendlines=="Bottom" && diver=="Bearish" )

						{
							
									trendlinerr=Float.parseFloat(trendpercentage.getText());
									if(trendlinerr<=1.25)
									{
										System.out.print("NO TRADE");
									}
									else if(trendlinerr>1.25 && trendlinerr<2)
									{
										System.out.print("TRADE with 60%");

									}
									else if(trendlinerr>2)
									{
										System.out.print("TRADE with 100%");

									}
								}
								if(ewB=="Wave 5"&& ewBu=="Wave A" && patterntrend=="Reversal Pattern" && trendlines=="Up" && diver=="Bearish")

								{
							
									System.out.print("Short with 100%");
								}
							 else if(ewB=="Wave 5" && patterntrend=="Reversal Pattern" && trendlines=="Up" && diver=="Bearish")

								{
							
									System.out.print("Short with 100%");
								}
							 else if(ewB=="Wave 5" && ewBu== "Wave A" &&((patterntrend=="Reversal Pattern"&&diver=="Bearish")||(patterntrend=="Reversal Pattern"&&trendlines=="Bottom")||(diver=="Bearish"&&trendlines=="Bottom")))
							{
								System.out.print("Short with 70%");
							}
							 else if(ewBu=="Wave E" && ewB=="Wave 1"&&((patterntrend=="Reversal Pattern"&&diver=="Bullish")||(patterntrend=="Reversal Pattern"&&trendlines=="Up")||(diver=="Bullish"&&trendlines=="Up")))
							{
								System.out.print("Long with 70%");
							}



										
						
       				}  

    	  });  
		

	}
public static void main(String[] args)
	{
		new automated_trading();

	}
}