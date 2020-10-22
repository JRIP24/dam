import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.Console;

import org.eclipse.jface.dialogs.IDialogLabelKeys;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;

public class Calculadora {

	protected Shell shell;
	private Text result;
	private Integer num1 = null;
	private Integer num2 = null;
	private Integer resultado = null;
	private String number = null;
	private String operation = null;
	
	void addnumber(Button num) {
		
		if (this.number == null) {
			number = num.getText();
		} else {
			number = number + num.getText();
		}
		
		result.setText(number);
	}
	
	void setOperation(Button buton, Label n1, Label n2, Label op) {
		
		if(this.number != null) {
			if (this.num1 == null) {
				
				this.num1 = Integer.parseInt(this.number);
				this.operation = buton.getText();
				
				number = "";
				result.setText("");				
				n1.setText(num1 + "");
				n2.setText("");
				op.setText(operation);
				
			}
		}
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculadora window = new Calculadora();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		
		
		
		
		shell = new Shell();
		shell.setSize(347, 454);
		shell.setText("SWT Application");
		
		Label n1 = new Label(shell, SWT.NONE);
		n1.setBounds(230, 10, 70, 17);
		
		Label op = new Label(shell, SWT.NONE);
		op.setBounds(230, 33, 70, 17);
		
		Label n2 = new Label(shell, SWT.NONE);
		n2.setBounds(230, 65, 70, 17);
		
		Button exec = new Button(shell, SWT.BORDER);
		exec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				if (num1 != null && operation != null) {
					
					num2 = Integer.parseInt(number);
					
					//Suma
					if (operation.equals("+")) {
						resultado = num1 + num2;
					}
					
					
					//Resta
					if (operation.equals("-")) {
						resultado = num1 - num2;
					}
					
					
					//Multiplicación
					if (operation.equals("*")) {
						resultado = num1 * num2;
					}
					
					
					//División
					if (operation.equals("/")) {
						
						if (num2 == 0) {
							
							result.setText("infinite");
							
						} else {
							resultado = num1 / num2;
						}
						
					}
					
					if (resultado != null) {
						n2.setText(num2 + "");
						result.setText(resultado + "");
						num1 = null;
						num2 = null;
						resultado = null;
						number = null;
						operation = null;
						
					}
					
					
				}
				
			}
		});
		exec.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		exec.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		exec.setBounds(97, 362, 129, 34);
		exec.setText("=");
		
		result = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		result.setEditable(false);
		result.setFont(SWTResourceManager.getFont("Ubuntu", 24, SWT.NORMAL));
		result.setText("0");
		result.setBounds(31, 103, 282, 89);
		
		
		Button btn0 = new Button(shell, SWT.NONE);
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				addnumber(btn0);
				
			}
		});
		btn0.setText("0");
		btn0.setBounds(31, 362, 61, 34);
		
		Button btn1 = new Button(shell, SWT.NONE);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn1);
				
			}
		});
		btn1.setBounds(31, 322, 61, 34);
		btn1.setText("1");
		
		Button btn2 = new Button(shell, SWT.NONE);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn2);
				
			}
		});
		btn2.setText("2");
		btn2.setBounds(98, 322, 61, 34);
		
		Button btn3 = new Button(shell, SWT.NONE);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn3);
				
			}
		});
		btn3.setText("3");
		btn3.setBounds(165, 322, 61, 34);
		
		Button btn6 = new Button(shell, SWT.NONE);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn6);
				
			}
		});
		btn6.setText("6");
		btn6.setBounds(165, 282, 61, 34);
		
		Button btn5 = new Button(shell, SWT.NONE);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn5);
				
			}
		});
		btn5.setText("5");
		btn5.setBounds(98, 282, 61, 34);
		
		Button btn4 = new Button(shell, SWT.NONE);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn4);
				
			}
		});
		btn4.setText("4");
		btn4.setBounds(31, 282, 61, 34);
		
		Button btn9 = new Button(shell, SWT.NONE);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn9);
				
			}
		});
		btn9.setText("9");
		btn9.setBounds(165, 242, 61, 34);
		
		Button btn8 = new Button(shell, SWT.NONE);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn8);
				
			}
		});
		btn8.setText("8");
		btn8.setBounds(98, 242, 61, 34);
		
		Button btn7 = new Button(shell, SWT.NONE);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				addnumber(btn7);
				
			}
		});
		btn7.setText("7");
		btn7.setBounds(31, 242, 61, 34);
		
		Button btnAdd = new Button(shell, SWT.NONE);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				setOperation(btnAdd, n1, n2, op);
				
			}
		});
		btnAdd.setText("+");
		btnAdd.setBounds(252, 242, 61, 34);
		
		Button btnSubs = new Button(shell, SWT.NONE);
		btnSubs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				setOperation(btnSubs, n1, n2, op);
				
			}
		});
		btnSubs.setText("-");
		btnSubs.setBounds(252, 282, 61, 34);
		
		Button btnMult = new Button(shell, SWT.NONE);
		btnMult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				setOperation(btnMult, n1, n2, op);
				
			}
		});
		btnMult.setText("*");
		btnMult.setBounds(252, 322, 61, 34);
		
		Button btnDiv = new Button(shell, SWT.NONE);
		btnDiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				setOperation(btnDiv, n1, n2, op);
				
			}
		});
		btnDiv.setText("/");
		btnDiv.setBounds(252, 362, 61, 34);
		

	}
}
