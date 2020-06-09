
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  
class automated_trading_code extends JFrame{
	String[] reversals={"Choose Pattern"};
	String ewB, ewBu,patterntrend,diver,trendlines,s,trendline,r,na;
	float trendlinerr, rr,supportrr,resistancerr, bottomrr,uprr;
	JComboBox reversal= new JComboBox();
	boolean enable= true;
	boolean isenable(){
		return true;
	}
	boolean isdisable(){
		return false;
	}
	automated_trading_code(){
		JFrame automated_trading=new JFrame("Automated Trading Platform");
		automated_trading.setContentPane(new JLabel(new ImageIcon("background.jpg")));
		JLabel title = new JLabel("Welcome to Automated Trading Platform");
		title.setBounds(190,50,1000,40);
		automated_trading.add(title);
		Font f = new Font("TimesRoman",Font.BOLD,40);
		Font emwave = new Font("TimesRoman",Font.ITALIC,18);
		title.setForeground(Color.white);
		title.setFont(f);
		JDialog d = new JDialog(automated_trading , "Strategy", true);

		JLabel eMWave = new JLabel("Elliot Waves : ");
		eMWave.setForeground(Color.white);
		eMWave.setBounds(100,200,200,30);
		eMWave.setFont(emwave);
		automated_trading.add(eMWave);
		String[] ewave1={"Choose Wave","none","Wave A","Wave B","Wave C","Wave D","Wave E"};
		String[] ewave2={"Choose Wave","none","Wave 1","Wave 2","Wave 3","Wave 4","Wave 5"};
		JComboBox ewaves1 = new JComboBox(ewave1);
		JComboBox ewaves2 = new JComboBox(ewave2);
		JButton select=new JButton("Select Wave");
		select.setBounds(560,240,100,30);
		automated_trading.add(select);

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
    JLabel trendlineUL = new JLabel("Enter RR");
    trendlineUL.setForeground(Color.white);
    trendlineUL.setBounds(50,350,300,30);
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
    JLabel sandr = new JLabel("Enter RR");
    sandr.setForeground(Color.white);
    sandr.setBounds(760,450,300,30);
		automated_trading.add(supportandresistance);
		CheckboxGroup sr = new CheckboxGroup();
		Checkbox support = new Checkbox("Support", sr,false);
		Checkbox resistance = new Checkbox("Resistance",sr,false);
    Checkbox nahi = new Checkbox("None",sr,false);
		support.setBounds(1060,400,100,30);
		resistance.setBounds(1160,400,110,30);
    nahi.setBounds(1160,500,100,30);
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
		trendpercentage.setEnabled(true);
		automated_trading.add(pattern);
		automated_trading.add(calculate);
		reversal.setBounds(980, 275, 200,30);
		JLabel credits = new JLabel("Designed and Developed By : Saurabh Poonia, Tejas Singh Rana And Aditya Dhir");
		credits.setForeground(Color.white);
		credits.setBounds(300,670,1000,30);
		credits.setFont(emwave);
    JLabel strategy = new JLabel("");
            d.add(strategy);
            d.setSize(800,500);
      sandr.setFont(emwave);
      trendlineUL.setFont(emwave);
		automated_trading.add(credits);
		automated_trading.add(reversal);
    automated_trading.add(nahi);
		automated_trading.setSize(1356, 728);
		automated_trading.setSize(1356, 728);
		automated_trading.setLayout(null);
		automated_trading.setVisible(true);
		automated_trading.setLocationRelativeTo(null);
		
              
		 
		select.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) { 
           
            
            

          
               if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 1")
           {  
           	  
              
              strategy.setText("Wait for the Wave to Finish,No Trade, Lookout for Continuous Pattern(Wave 2) on 1 hr TF");
             
              d.setVisible(true);
              
              trendpercentage.setEnabled(isdisable());
              bed.setEnabled(isdisable());
              bd.setEnabled(isdisable());
              bottom.setEnabled(isdisable());
              up.setEnabled(isdisable());
              no.setEnabled(isdisable());
              
              support.setEnabled(isdisable());
              resistance.setEnabled(isdisable());
              pattern.setEnabled(isdisable());
              choosepattern.setEnabled(isdisable());
              none.setEnabled(isdisable());
              percentage.setEnabled(isdisable());
              calculate.setEnabled(isdisable());
              trendlineUL.setText("Enter RR :");
                  sandr.setText("Enter  :");
             
              
              



              }
              else if((String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave A")
           {  
              strategy.setText("Wait for the Wave to Finish,No Trade, Lookout for Continuous Pattern(Wave B) on 1 hr TF");
           	  
              
              d.setVisible(true);
              
              
              trendpercentage.setEnabled(isdisable());
              bed.setEnabled(isdisable());
              bd.setEnabled(isdisable());
              bottom.setEnabled(isdisable());
              up.setEnabled(isdisable());
              no.setEnabled(isdisable());
              
              support.setEnabled(isdisable());
              resistance.setEnabled(isdisable());
              pattern.setEnabled(isdisable());
              choosepattern.setEnabled(isdisable());
              none.setEnabled(isdisable());
              percentage.setEnabled(isdisable());
              calculate.setEnabled(isdisable());
              trendlineUL.setText("Enter RR :");
                  sandr.setText("Enter  :");
              
              
              

             



              }
                else if((String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave C" )
           {    
              strategy.setText("Wait for the Wave to Finish,No Trade, Lookout for Continuous Pattern(Wave D) on 1 hr TF");           
              d.setVisible(true);
              
              trendpercentage.setEnabled(isdisable());
              bed.setEnabled(isdisable());
              bd.setEnabled(isdisable());
              bottom.setEnabled(isdisable());
              up.setEnabled(isdisable());
              no.setEnabled(isdisable());
              
              support.setEnabled(isdisable());
              resistance.setEnabled(isdisable());
              pattern.setEnabled(isdisable());
              choosepattern.setEnabled(isdisable());
              none.setEnabled(isdisable());
              percentage.setEnabled(isdisable());
              calculate.setEnabled(isdisable());
              trendlineUL.setText("Enter RR :");
                  sandr.setText("Enter  :");
             
              
             



              }
               
           
             
               else if( (String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave D" || (String)ewaves1.getItemAt(ewaves1.getSelectedIndex())== "Wave B")
              {	
              trendline.setText(" Trendline");
              d.setVisible(false);
              
              trendpercentage.setEnabled(isenable());
              bed.setEnabled(isdisable());
              bd.setEnabled(isdisable());
              bottom.setEnabled(isenable());
              up.setEnabled(isdisable());
              no.setEnabled(isdisable());
              percentage.setEnabled(isenable());
              support.setEnabled(isenable());
              resistance.setEnabled(isdisable());
              pattern.setEnabled(isdisable());
              choosepattern.setEnabled(isdisable());
              none.setEnabled(isdisable());
              calculate.setEnabled(isenable());
              percentage.setText("0");
              trendpercentage.setText("0");
              btcamount.setText("0");
              trendlineUL.setText("Enter RR :");
                  sandr.setText("Enter  :");
              

              

              }
               else if( (String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 4" || (String)ewaves2.getItemAt(ewaves2.getSelectedIndex())== "Wave 2")
              {	
              trendline.setText(" Trendline");
              d.setVisible(false);
              
              trendpercentage.setEnabled(isenable());
              bed.setEnabled(isdisable());
              bd.setEnabled(isdisable());
              up.setEnabled(isenable());
              bottom.setEnabled(isdisable());
              no.setEnabled(isdisable());
              percentage.setEnabled(isenable());
              support.setEnabled(isdisable());
              resistance.setEnabled(isenable());
              pattern.setEnabled(isdisable());
              choosepattern.setEnabled(isdisable());
              none.setEnabled(isdisable());
              calculate.setEnabled(isenable());
              percentage.setText("0");
              trendpercentage.setText("0");
              btcamount.setText("0");
              trendlineUL.setText("Enter RR :");
                  sandr.setText("Enter  :");

              }
               else if( (String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 5")
              {	
              
              
              d.setVisible(false);
              
              
              
              trendpercentage.setEnabled(isdisable());
              bed.setEnabled(isenable());
              bd.setEnabled(isdisable());
              up.setEnabled(isenable());
              bottom.setEnabled(isdisable());
              no.setEnabled(isenable());
              percentage.setEnabled(isdisable());
              support.setEnabled(isdisable());
              resistance.setEnabled(isenable());
              pattern.setEnabled(isenable());
              choosepattern.setEnabled(isenable());
              none.setEnabled(isenable());
              calculate.setEnabled(isenable());
              percentage.setText("0");
              trendpercentage.setText("0");
              btcamount.setText("0");

              

              }
               else if( (String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave E")
              { 
              
              
              d.setVisible(false);
              
              
              
              trendpercentage.setEnabled(isdisable());
              bed.setEnabled(isdisable());
              bd.setEnabled(isenable());
              up.setEnabled(isdisable());
              bottom.setEnabled(isenable());
              no.setEnabled(isenable());
              percentage.setEnabled(isdisable());
              support.setEnabled(isenable());
              resistance.setEnabled(isdisable());
              pattern.setEnabled(isenable());
              choosepattern.setEnabled(isenable());
              none.setEnabled(isenable());
              calculate.setEnabled(isenable());
              percentage.setText("0");
              trendpercentage.setText("0");
              btcamount.setText("0");

              

              }

else if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 3")
           { 
              
              strategy.setText("Wait for the Wave to Finish,No Trade, Lookout for Continuous Pattern(Wave 4) on 1 hr TF");
              d.setVisible(true);
              
              trendpercentage.setEnabled(isdisable());
              bed.setEnabled(isdisable());
              bd.setEnabled(isdisable());
              bottom.setEnabled(isdisable());
              up.setEnabled(isdisable());
              no.setEnabled(isdisable());
              
              support.setEnabled(isdisable());
              resistance.setEnabled(isdisable());
              pattern.setEnabled(isdisable());
              choosepattern.setEnabled(isdisable());
              none.setEnabled(isdisable());
              percentage.setEnabled(isdisable());
              calculate.setEnabled(isdisable());
              trendlineUL.setText("Enter RR :");
                  sandr.setText("Enter  :");

              


              }

            }  

         });
           
						
        
		//Events
		 bd.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
               diver = "Bullish";  
            }  
         });  
     nahi.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
               na= "No"; 


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
              ewaves2.setSelectedIndex(0);

            }  
         });
            w2.addItemListener(new ItemListener() {  
            public void itemStateChanged(ItemEvent e) {               
              ewaves2.setEnabled(true);
              ewaves1.setEnabled(false);
              ewaves1.setSelectedIndex(0);
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
    trendpercentage.setText("0");
  }
});
                         percentage.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    percentage.setText("0");
  }
});

  btcamount.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    btcamount.setText("0");
  }
});
  automated_trading.add(sandr);
  automated_trading.add(trendlineUL);

         
		  calculate.addActionListener(new ActionListener()
		  {  
				public void actionPerformed(ActionEvent e)
					{  

						
						trendlinerr=Float.parseFloat(trendpercentage.getText());
              supportrr=Float.parseFloat(trendpercentage.getText());

            if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 4"||(String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave D"||(String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 2"||(String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave B")
             
              {if((trendlinerr<=1.25&&trendlinerr>=0) || (supportrr<=1.25&&supportrr>=0)){
                strategy.setText("NO TRADE");
                d.setVisible(true);}
              else if(1.25<trendlinerr&& trendlinerr<=2||1.25<supportrr && supportrr<=2){
                if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 4"||(String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave D")
                strategy.setText(" TRADE with 40% : BTC AMOUNT = "+(0.40*Float.parseFloat(btcamount.getText())));
                else if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 2"||(String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave B")
                strategy.setText(" TRADE with 60% : BTC AMOUNT = "+(0.60*Float.parseFloat(btcamount.getText())));
                d.setVisible(true);}
              else if(trendlinerr>2||supportrr>2)
              {if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 2"||(String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave B")
               strategy.setText(" TRADE with 100% : BTC AMOUNT = "+(1*Float.parseFloat(btcamount.getText())));
                else if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 4"||(String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave D")
                strategy.setText(" TRADE with 60% : BTC AMOUNT = "+(0.60*Float.parseFloat(btcamount.getText())));
                d.setVisible(true);
              }

		 				}

            else if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 5"||(String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave E")
            {
              if((String)ewaves2.getItemAt(ewaves2.getSelectedIndex())=="Wave 5")
              {
                if(trendlines=="Up"&&diver=="Bearish" &&r=="Resistance"&&patterntrend=="Reversal Pattern")
                {
                  trendlineUL.setText("Enter RR for Bottom Trendline");
                  sandr.setText("Enter Support RR :");
                  trendpercentage.setEnabled(isenable());
                  percentage.setEnabled(isenable());
                  trendlinerr=Float.parseFloat(trendpercentage.getText());
                  supportrr=Float.parseFloat(trendpercentage.getText());
                  {if(trendlinerr<=1.25&&trendlinerr>0|| supportrr<=1.25&&supportrr>0){
                strategy.setText("NO TRADE");
                d.setVisible(true);}
              else if(1.25<trendlinerr&& trendlinerr<=2||1.25<supportrr && supportrr<=2){
                
                strategy.setText(" TRADE with 60% : BTC AMOUNT = "+(0.60*Float.parseFloat(btcamount.getText())));
                d.setVisible(true);}
              else if(trendlinerr>2||supportrr>2)
              {

               strategy.setText(" TRADE with 100% : BTC AMOUNT = "+(1*Float.parseFloat(btcamount.getText())));
               d.setVisible(true);
              }

            }
            

          }
          else if((trendlines=="Up"&&diver=="Bearish"&& r=="Resistance")||(patterntrend=="Reversal Pattern"&&diver=="Bearish"&& r=="Resistance")||(trendlines=="Up"&&patterntrend=="Reversal Pattern"&& r=="Resistance")||(trendlines=="Up"&&diver=="Bearish"&& patterntrend=="Reversal Pattern"))
          {       trendlineUL.setText("Enter RR for Bottom Trendline");
                  sandr.setText("Enter Support RR :");
                  trendpercentage.setEnabled(isdisable());
                  percentage.setEnabled(isdisable());
                  trendpercentage.setEnabled(isenable());
                  percentage.setEnabled(isenable());
                  if(trendlinerr<=1.25 && trendlinerr>0 || supportrr<=1.25&&supportrr>0){
                strategy.setText("NO TRADE");
                d.setVisible(true);}
              else if(1.25<trendlinerr&& trendlinerr<=2||1.25<supportrr && supportrr<=2){
                
                strategy.setText(" TRADE with 60% of 80% : BTC AMOUNT = "+(0.60*(0.80*Float.parseFloat(btcamount.getText()))));
                d.setVisible(true);}
              else if(trendlinerr>2||supportrr>2)
              {

               strategy.setText(" TRADE with 80% : BTC AMOUNT = "+(0.8*Float.parseFloat(btcamount.getText())));
               d.setVisible(true);
              }
          }
          else if((trendlines=="Up"&&diver=="Bearish")||(patterntrend=="Reversal Pattern"&&diver=="Bearish")||(patterntrend=="Reversal Pattern"&& r=="Resistance")||(trendlines=="Up"&& patterntrend=="Reversal Pattern"))
          {       trendlineUL.setText("Enter RR for Bottom Trendline");
                  sandr.setText("Enter Support RR :");
                  trendpercentage.setEnabled(isdisable());
                  percentage.setEnabled(isdisable());
                  trendpercentage.setEnabled(isenable());
                  percentage.setEnabled(isenable());
                  if(trendlinerr<=1.25 && trendlinerr>0 || supportrr<=1.25&&supportrr>0){
                strategy.setText("NO TRADE");
                d.setVisible(true);}
              else if(1.25<trendlinerr&& trendlinerr<=2||1.25<supportrr && supportrr<=2){
                
                strategy.setText(" TRADE with 60% of 60% : BTC AMOUNT = "+(0.60*(0.60*Float.parseFloat(btcamount.getText()))));
                d.setVisible(true);}
              else if(trendlinerr>2||supportrr>2)
              {

               strategy.setText(" TRADE with 80% : BTC AMOUNT = "+(0.6*Float.parseFloat(btcamount.getText())));
               d.setVisible(true);
              }
          }
           else if((trendlines!="Up"&&diver!="Bearish"&&patterntrend!="Reversal Pattern"&&r!="Resistance"))
          {
                  
                strategy.setText("wait for Wave A to finish, lookout for continuous Pattern(Wave B) on 1 Hr Time Frame");
                d.setVisible(true);
              }
              
          else if((trendlines!="Up"&&diver=="Bearish" &&r!="Resistance"&&patterntrend!="Reversal Pattern")||(trendlines!="Up"&&diver!="Bearish" &&r=="Resistance"&&patterntrend!="Reversal Pattern")||(trendlines!="Up"&&diver!="Bearish" &&r!="Resistance"&&patterntrend=="Reversal Pattern")||(trendlines=="Up"&&diver!="Bearish" &&r!="Resistance"&&patterntrend!="Reversal Pattern"))
          {
            strategy.setText("wait for Wave A to finish, lookout for continuous Pattern(Wave B) on 1 Hr Time Frame");
                d.setVisible(true);

          }
  }
  else if((String)ewaves1.getItemAt(ewaves1.getSelectedIndex())=="Wave E")
              {
                if(trendlines=="Bottom"&&diver=="Bullish" &&s=="Support"&&patterntrend=="Reversal Pattern")
                {
                  trendlineUL.setText("Enter RR for Up Trendline");
                  sandr.setText("Enter Resistance RR :");
                  trendpercentage.setEnabled(isenable());
                  percentage.setEnabled(isenable());
                  trendlinerr=Float.parseFloat(trendpercentage.getText());
                  supportrr=Float.parseFloat(trendpercentage.getText());
                  {if(trendlinerr<=1.25&&trendlinerr>0|| supportrr<=1.25&&supportrr>0){
                strategy.setText("NO TRADE");
                d.setVisible(true);}
              else if(1.25<trendlinerr&& trendlinerr<=2||1.25<supportrr && supportrr<=2){
                
                strategy.setText(" TRADE with 60% : BTC AMOUNT = "+(0.60*Float.parseFloat(btcamount.getText())));
                d.setVisible(true);}
              else if(trendlinerr>2||supportrr>2)
              {

               strategy.setText(" TRADE with 100% : BTC AMOUNT = "+(1*Float.parseFloat(btcamount.getText())));
               d.setVisible(true);
              }

            }
            

          }
          else if((trendlines=="Bottom"&&diver=="Bullish"&& s=="Support")||(patterntrend=="Reversal Pattern"&&diver=="Bullish"&& s=="Support")||(trendlines=="Bottom"&&patterntrend=="Reversal Pattern"&& r=="Resistance")||(trendlines=="Bottom"&&diver=="Bullish"&& patterntrend=="Reversal Pattern"))
          {       trendlineUL.setText("Enter RR for Up Trendline");
                  sandr.setText("Enter Resistance RR :");
                  trendpercentage.setEnabled(isdisable());
                  percentage.setEnabled(isdisable());
                  trendpercentage.setEnabled(isenable());
                  percentage.setEnabled(isenable());
                  if(trendlinerr<=1.25 && trendlinerr>0 || supportrr<=1.25&&supportrr>0){
                strategy.setText("NO TRADE");
                d.setVisible(true);}
              else if(1.25<trendlinerr&& trendlinerr<=2||1.25<=supportrr && supportrr<=2){
                
                strategy.setText(" Long with 60% of 80% : BTC AMOUNT = "+(0.60*(0.80*Float.parseFloat(btcamount.getText()))));
                d.setVisible(true);}
              else if(trendlinerr>2||supportrr>2)
              {

               strategy.setText(" Long with 80% : BTC AMOUNT = "+(0.8*Float.parseFloat(btcamount.getText())));
               d.setVisible(true);
              }
          }
          else if((trendlines=="Bottom"&&diver=="Bullish")||(patterntrend=="Reversal Pattern"&&diver=="Bullish")||(patterntrend=="Reversal Pattern"&& s=="Support")||(trendlines=="Bottom"&& patterntrend=="Reversal Pattern"))
          {       trendlineUL.setText("Enter RR for Up Trendline");
                  sandr.setText("Enter Resistance RR :");
                  trendpercentage.setEnabled(isdisable());
                  percentage.setEnabled(isdisable());
                  trendpercentage.setEnabled(isenable());
                  percentage.setEnabled(isenable());
                  if(trendlinerr<=1.25 && trendlinerr>0 || supportrr<=1.25&&supportrr>0){
                strategy.setText("NO TRADE");
                d.setVisible(true);}
              else if(1.25<trendlinerr&& trendlinerr<=2||1.25<supportrr && supportrr<=2){
                
                strategy.setText(" Short with 60% of 60% : BTC AMOUNT = "+(0.60*(0.60*Float.parseFloat(btcamount.getText()))));
                d.setVisible(true);}
              else if(trendlinerr>2||supportrr>2)
              {

               strategy.setText(" Short with 80% : BTC AMOUNT = "+(0.6*Float.parseFloat(btcamount.getText())));
               d.setVisible(true);
              }
          }
           else if((trendlines!="Bottom"&&diver!="Bullish"&&patterntrend!="Reversal Pattern"&&s!="Support"))
          {
                  
                strategy.setText("wait for Wave 1 to finish, lookout for continuous Pattern(Wave 2) on 1 Hr Time Frame");
                d.setVisible(true);}
              
          else if((trendlines=="Bottom"&&diver=="Bullish" &&s=="Support"&&patterntrend=="Reversal Pattern")||(trendlines!="Bottom"&&diver!="Bullish" &&s!="Support"&&patterntrend=="Reversal Pattern")||(trendlines=="Bottom"&&diver!="Bullish" &&s!="Support"&&patterntrend!="Reversal Pattern")||(trendlines!="Bottom"&&diver!="Bullish" &&s=="Support"&&patterntrend!="Reversal Pattern")||(trendlines!="Bottom"&&diver=="Bullish" &&s!="Support"&&patterntrend!="Reversal Pattern"))
          {
            strategy.setText("wait for Wave 1 to finish, lookout for continuous Pattern(Wave 2) on 1 Hr Time Frame");
                d.setVisible(true);

          }
  }

  }  

          }

    	  });  
		

	}
}
public class ATS {
public static void main(String[] args)
	{
		new automated_trading_code();

	}
}