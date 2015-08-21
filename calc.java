import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class calc extends JFrame implements ActionListener {
	
	Button [] [] btn = new Button [3] [3];
	Button zero, one,two, three, four, five,six, seven, eight, nine, plus, minus, times, div,clear,equals;
	Label label1, label2;
	JTextField text1, text2; 
	static double sum, diff, prod, qou;
	String tem="", tempAns="", operator="", lastOperator="";
	double answer=0,  subAns=0;
	Boolean firstSol=true;

	public static void main  (String[] args)
	{
		
		calc test = new calc();
		test.addWindowListener(new WindowAdapter ()
		{public void windowClosing(WindowEvent e)
			{System.exit(0);}
});
	}
	
		calc () {
			setVisible (true);
			setSize(245,280);
			setTitle("Calculator");	
			setLayout(null);
			setBackground(Color.WHITE);
			setResizable(false);
		
			text1 = new JTextField("");
			text1.setHorizontalAlignment(JTextField.RIGHT);
			text1.setBounds(20,40,198,25);
			text1.setBackground(Color.WHITE);
			
			add(text1);
			text1.setEnabled(false);
			
			
			/*text2= new JTextField("");
			text2.setHorizontalAlignment(JTextField.RIGHT);
			text2.setBounds(20,62,198,25);
			text2.setBackground(Color.WHITE);
			add(text2);
			text2.setEnabled(false);*/
			
			zero= new Button("0");
			zero.setBounds(20,220,75,35);
			zero.addActionListener(this);
			add(zero);
			
			int b=0, c=1;
			for (int i=0; i<3;i++){
				
				int a=0;
				
				for (int j=0;j<3;j++){
					btn[i][j]= new Button(""+c);
					btn[i][j].setBounds(20+a, 180-b,35,35);
					btn[i][j].addActionListener(this);
					add (btn[i][j]);
					a+=40;c++;
				}
				b+=40;
				
			}
				one=btn[0][0];
				two=btn[0][1];
				three=btn[0][2];
				four=btn[1][0];
				five=btn[1][1];
				six=btn[1][2];
				seven=btn[2][0];
				eight=btn[2][1];
				nine=btn[2][2];
				
				plus = new Button("+");
				plus.setBounds(140,100,35,35);
				plus.addActionListener(this);
				add(plus);
				
				minus= new Button ("-");
				minus.setBounds(180,100,35,35);
				minus.addActionListener(this);
				add(minus);
				
				div= new Button ("/");
				div.setBounds(140,140,35,35);
				div.addActionListener(this);
				add(div);
				
				times= new Button ("*");
				times.setBounds(140,180,35,35);
				times.addActionListener(this);
				add(times);
				
				clear = new Button ("C");
				clear.setBounds(140,220,35,35);
				clear.addActionListener(this);
				add(clear);
				
				
				equals = new Button("=");
				equals.setBounds(180,140,35,35);
				equals.addActionListener(this);
				add(equals);
			}
	
		@Override
		public void actionPerformed (ActionEvent event){
						
						if(event.getSource()==one){
						tem+="1";
						text1.setText(tem);
						tempAns+="1";
						
						}
						if (event.getSource()==two)
						{
							tem+="2";
							text1.setText(tem);
							tempAns+="2";
						}
						if (event.getSource()==three)
						{
							tem+="3";
							text1.setText(tem);
							tempAns+="3";
						}
						if (event.getSource()==four)
						{
							tem+="4";
							text1.setText(tem);
							tempAns+="4";
						}
						if(event.getSource()==five)
						{
							tem+="5";
							text1.setText(tem);
							tempAns+="5";
						}
						if(event.getSource()==six)
						{
							tem+="6";
							text1.setText(tem);
							tempAns+=6;
						}
						if(event.getSource()==seven)
						{
							tem+="7";
							text1.setText(tem);
							tempAns+=7;
						}
						if(event.getSource()==eight)
						{
							tem+="8";
							text1.setText(tem);
							tempAns+=8;
						}
						if(event.getSource()==nine)
						{
							tem+="9";
							text1.setText(tem);
							tempAns+=9;
						}
						if(event.getSource()==zero)
						{
							tem+=0;
							text1.setText(tem);
							tempAns+=0;
						}
						if(event.getSource()==plus)
						{
							tem+="+";
							text1.setText(tem);
							operator+="+";	
						if(firstSol)
						{
							subAns= Double.parseDouble(tempAns);
							firstSol=false;
						}
						process();
						}
					if (event.getSource()==minus)
					{
						tem+="-";
						text1.setText(tem);
						operator+="-";
					if(firstSol){
						subAns= Double.parseDouble(tempAns);
						firstSol=false;
					}
					process();
					}
				if(event.getSource()==div)
				{
					tem+="/";
					text1.setText(tem);
					operator+="/";	
				
				if(firstSol){
					subAns= Double.parseDouble(tempAns);
					System.out.println("In the division loop: "+subAns);
					firstSol=false;
				}
				process();
				}
				
				if(event.getSource()==times)
				{
					tem+="*";
					text1.setText(tem);
					operator+="*";
				if(firstSol){
					subAns= Double.parseDouble(tempAns);
					firstSol=false;
				}
				process();
				}
				if(event.getSource()==clear){
					text1.setText(" ");
					/*text2.setText(" ");
					tem=" ";
					tempAns=" ";
					operator=" ";
				answer=0;//
					subAns=0;
					System.out.println("value of tempAns"+tempAns);
					firstSol=true;	*/
					tem=" ";
					tempAns=" ";
				}
				if(event.getSource()==equals){
					process();
					text1.setText(""+answer);
					tem=" ";
					tempAns=" ";	
					}
				}
				public void process(){
					answer=Double.parseDouble(tempAns);
					//System.out.println("the value @ line 240= "+answer);
					//System.out.println("Subanswer value at 243: "+subAns);
					if (lastOperator.equals("+"))
						answer=subAns+answer;
					else if(lastOperator.equals("-"))
						answer=subAns-answer;
					else if(lastOperator.equals("/"))
						answer=subAns/answer;
					else if(lastOperator.equals("*"))
						answer=subAns*answer;
					
					lastOperator=operator;
					subAns=answer;
					//System.out.println("the value @252= "+subAns);
					operator="";
					tempAns="";	
				
					}

		}



					
	
