package kr.or.dgit.jdbc_cafe_project.list;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.jdbc_cafe_project.dto.ShowAllByMargincost;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllBySalesprice;
import kr.or.dgit.jdbc_cafe_project.service.ShowAllByMargincostService;
import kr.or.dgit.jdbc_cafe_project.service.ShowAllBySalespriceService;

public class ShowAllByMargincostList extends JPanel {
	private ShowAllByMargincostService service;
	public JTable table;

	public ShowAllByMargincostList() {
		this.service = new ShowAllByMargincostService(); 
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	
	public void loadData() {
//		table.clearSelection();
		DefaultTableModel model=new DefaultTableModel(getData(), getColumnNames());
		table.setModel(model);
		setAlignWidth();
	}
	
	public void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1);
		setCellWidth(100, 150);
	}
	
	public void setCellWidth(int...width) {
		TableColumnModel cModel = table.getColumnModel();
		System.out.println(Arrays.toString(width));
		for(int i=0; i<width.length; i++){
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public void setAlign(int align, int...idx) {
		//0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		// idx = [0,2]
		for(int i=0; i<idx.length;i++){
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
	}
	
	public String[] getColumnNames() {
		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매량", "마진율", "공급가액", "부가세액", "판매금액", "마진가액" };
	}
	
	public Object[][] getData() {
		List<ShowAllByMargincost> lists = service.selectShowByAll();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			if(i==lists.size()-1){
				data[i] = lists.get(i).toArray2();
			}else{
				data[i] = lists.get(i).toArray();
			}
		}
		return data;
	}
}
