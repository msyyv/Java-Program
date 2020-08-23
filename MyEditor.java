import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class MyEditor extends JFrame implements ActionListener
{

     JTextArea Jta = new JTextArea(40, 54);
     JMenuBar menuBar;
     JMenuItem newEditor, openEditor, savePage,cut,copy,paste,selectall;
     JMenuItem font,Font1,Font2,Font3;
     JMenuItem fontStyle,fontStyle1,fontStyle2,fontStyle3;
     JMenuItem fontSize,fontSize1,fontSize2,fontSize3;
     JMenu File,Edit,Format,View,Help;
	
		String text=" ",dName=" ",fName=" ",sNameAs=" ";
		int tLength=0;
		
      	Font fon;
     
	public MyEditor()
		{
	                menuBar = new JMenuBar();
        		//Adding Main Menu
		File      = new JMenu("File");
		Edit      = new JMenu("Edit");
		Format  = new   JMenu("Format");
		View      = new  JMenu("View");
		Help       = new  JMenu("Help");
		fontStyle=new JMenu("fontStyle");
		font=new JMenu("Font");
		fontSize=new JMenu("fontSize");
		

		//setting menu in Menu Bar
        		menuBar.add(File);
		menuBar.add(Edit);
		menuBar.add(Format);
		menuBar.add(View);
		menuBar.add(Help);
        		setJMenuBar(menuBar);
		newEditor= new JMenuItem("New");
		openEditor= new JMenuItem("Open");
		cut= new JMenuItem("Cut");
		copy= new JMenuItem("Copy");
		paste= new JMenuItem("Paste");
		selectall= new JMenuItem("SelectAll");
		savePage= new JMenuItem("Save As");
		
		
		
		
		
		//Adding sub menu to Main Menu
		File.add(newEditor);
		File.add(openEditor);
		File.add(savePage);
		Edit.add(cut);
		Edit.add(copy);
		Edit.add(paste);
		Edit.add(selectall);
		Format.add(fontSize);
		Format.add(font);
		Format.add(fontStyle);
		
		//Adding Font
		font.add(Font1=new JMenuItem("Bradley Hand ITC"));
		font.add(Font2=new JMenuItem("Gabriola"));
		font.add(Font3=new JMenuItem("Arial"));
		
		
		//Adding FontStyle
		fontStyle.add(fontStyle1=new JMenuItem("Bold"));
		fontStyle.add(fontStyle2=new JMenuItem("Italic"));
		fontStyle.add(fontStyle3=new JMenuItem("Bold Italic"));
		
		//Adding FontSize
		fontSize.add(fontSize1=new JMenuItem("12"));
		fontSize.add(fontSize2=new JMenuItem("16"));
		fontSize.add(fontSize3=new JMenuItem("18"));	

		
		
		//adding actions on sub menu

		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectall.addActionListener(this);
		savePage.addActionListener(this);
		newEditor.addActionListener(this);
		fontStyle.addActionListener(this);
		fontStyle1.addActionListener(this);
		fontStyle2.addActionListener(this);
		fontStyle3.addActionListener(this);
		font.addActionListener(this);
		Font1.addActionListener(this);
		Font2.addActionListener(this);
		Font3.addActionListener(this);
		fontSize.addActionListener(this);
		fontSize1.addActionListener(this);
		fontSize2.addActionListener(this);
		fontSize3.addActionListener(this);
		
      
		add(new JScrollPane(Jta));//adding scroll in page
        		Jta.setLineWrap(true);
        		Jta.setWrapStyleWord(true);
		fon=new Font("Monotype Corsiva",Font.PLAIN,20);//setting Default size and family of font
		Jta.setFont(fon);
   	 }
	@Override
	public void actionPerformed(ActionEvent ae)
		{
			 System.out.println(" getSource::"+ae.getSource());
			 String command=(String)ae.getActionCommand();//variable to get all commands
			 System.out.println(" command::"+command);

			//File Sub Menu Function
			if(ae.getSource()==newEditor)//for new Page
				{
					dispose();//will Distroy Current JFrame
					createMain();
					System.out.println("Inside new Editor");

				}

				try
				{

					if(ae.getSource()==savePage)
					{
						System.out.println("inside savePage");
						FileDialog dialog=new FileDialog(this,"Save As",FileDialog.SAVE);
						dialog.setVisible(true);

						dName=dialog.getDirectory();
						fName=dialog.getFile();
						sNameAs=dName+fName;


						text=Jta.getText();
						tLength=text.length();
						byte buf[]=text.getBytes();

						File f1=new File(sNameAs);
						FileOutputStream fobj=new FileOutputStream(f1);
						for(int a=0;a<tLength;a++)
						{
							fobj.write(buf[a]);
						}
						fobj.close();
					}

						this.setTitle(fName);

				}
				catch(IOException e){
					System.out.println("fbgd");
						}

				
				//font menu
				if(command.equals("Bradley Hand ITC"))
					{
						String fontName=fon.getName();
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();
						
						fon=new Font("Bradley Hand ITC",fontStyles,fontSizes);
						Jta.setFont(fon);
						


					}
					if(command.equals("Gabriola"))
					{
						String fontName=fon.getName();
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();
						
						fon=new Font("Gabriola",fontStyles,fontSizes);
						Jta.setFont(fon);
						


					}
					if(command.equals("Arial"))
					{
						String fontName=fon.getName();
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();
						System.out.println("arial name==:"+fon.getName());
						fon=new Font("Arial",fontStyles,fontSizes);
						Jta.setFont(fon);
						


					}
					if(command.equals("Bold"))
					{
						String fontName=fon.getName();
						System.out.println("name==:"+fon.getName());
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();

						fon=new Font(fontName,Font.BOLD,fontSizes);
						Jta.setFont(fon);
					}
					if(command.equals("Italic"))
					{
						String fontName=fon.getName();
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();

						fon=new Font(fontName,Font.ITALIC,fontSizes);
						Jta.setFont(fon);
					}
					if(command.equals("Bold Italic"))
					{
						String fontName=fon.getName();
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();
						fon=new Font(fontName,Font.BOLD|Font.ITALIC,fontSizes);
						Jta.setFont(fon);
					}

					if(command.equals("12"))
					{
								
						
						String fontName=fon.getName();
						System.out.println("12name==:"+fon.getName());
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();
						fon=new Font(fontName,fontStyles,12);
						Jta.setFont(fon);
					}

					if(command.equals("16"))
					{
						String fontName=fon.getName();
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();

						fon=new Font(fontName,fontStyles,16);
						Jta.setFont(fon);
					}
					if(command.equals("18"))
					{
						String fontName=fon.getName();
						String fontFamily=fon.getFamily();
						int fontSizes=fon.getSize();
						int fontStyles=fon.getStyle();

						fon=new Font(fontName,fontStyles,18);
						Jta.setFont(fon);
					}
					
					
							

			//Edit Sub Menu Function
			
			if(ae.getSource()==cut)    
			Jta.cut();    
			if(ae.getSource()==paste)    
			Jta.paste();    
			if(ae.getSource()==copy)    
			Jta.copy();    
			if(ae.getSource()==selectall)    
			Jta.selectAll();    
			
       		}     

		

    public static void createMain()
	{
        		 JFrame frame = new MyEditor();
       		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       		 frame.pack();
       		 frame.setVisible(true);
		 frame.setTitle("MyEditor(By Rakesh Kumar)");

   	 }

    public static void main(String[] args)
	 {
       		 SwingUtilities.invokeLater(new Runnable(){
			
           				 public void run()
				{
             				 createMain();
          	 			 }
                                                });
   	 }//main method()
}//class


