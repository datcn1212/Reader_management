import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;

import java.util.ArrayList;

public class Reader_management extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTable table;
	reader dg = new reader();
	private ArrayList<reader> list = new ArrayList<>();
	int number = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reader_management frame = new Reader_management();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reader_management() {
		setTitle("QUẢN LÝ ĐỘC GIẢ");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 622);
		DefaultTableModel model = new DefaultTableModel() {

		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};

		table = new JTable(model);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		//create 5 columns
		// create header row
		model.addColumn("STT");
		model.addColumn("Mã độc giả");
		model.addColumn("Họ tên độc giả");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		
		
		JLabel lblNewLabel_1 = new JLabel("Mã độc giả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(53, 69, 108, 40);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(171, 78, 564, 22);
		getContentPane().add(textArea1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ tên độc giả");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(53, 119, 108, 40);
		getContentPane().add(lblNewLabel_1_1);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(171, 128, 564, 22);
		getContentPane().add(textArea2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(53, 169, 108, 40);
		getContentPane().add(lblNewLabel_1_2);
		
		JTextArea textArea3 = new JTextArea();
		textArea3.setBounds(171, 178, 564, 22);
		getContentPane().add(textArea3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(53, 218, 108, 40);
		getContentPane().add(lblNewLabel_1_3);
		
		JTextArea textArea4 = new JTextArea();
		textArea4.setBounds(171, 227, 564, 22);
		getContentPane().add(textArea4);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(887, 78, 85, 21);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dg.setMadocgia(textArea1.getText());
				dg.setTendocgia(textArea2.getText());
				dg.setDiachi(textArea3.getText());
				dg.setDienthoai(textArea4.getText());
				list.add(dg);
				number++;
				model.addRow(new Object[] {
						number,dg.getMadocgia(),dg.getTendocgia(),dg.getDiachi(),dg.getDienthoai()
				});
			}
		});
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSa.setBounds(887, 127, 85, 21);
		getContentPane().add(btnSa);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
				    table.setValueAt(textArea1.getText(), table.getSelectedRow(), 1);
				    table.setValueAt(textArea2.getText(), table.getSelectedRow(), 2);
				    table.setValueAt(textArea3.getText(), table.getSelectedRow(), 3);
				    table.setValueAt(textArea4.getText(), table.getSelectedRow(), 4);
				}
				JOptionPane.showMessageDialog(null,"Sửa thành công!");
				stt(table);
			}
		});
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXa.setBounds(887, 178, 85, 21);
		getContentPane().add(btnXa);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
		               // remove selected row from the model
		               model.removeRow(table.getSelectedRow());
		               JOptionPane.showMessageDialog(null, "Xóa thành công!");
		               stt(table);
		            }
			}
		});
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThot.setBounds(887, 227, 85, 21);
		getContentPane().add(btnThot);
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 312, 919, 221);
		getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(171, 263, 85, 21);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setText(null);
				textArea2.setText(null);
				textArea3.setText(null);
				textArea4.setText(null);
			}
		});
	}
	
	//set true number of row
	public void stt(JTable table) {
		for(int k = 0; k < table.getRowCount(); k++) {
			table.setValueAt(k+1, k, 0);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
