package friend.action;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FriendManager implements ActionListener, ListSelectionListener{
    
	
	private JTextField t1, t2, t3;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    private JCheckBox jcb1, jcb2, jcb3, jcb4, jcb5;
    private JButton b1, b2, b3, b4; 
    private JTextArea jta1;
    private DefaultListModel<FriendDTO> model;
    private JList<FriendDTO> jlist;
    private JRadioButton jrb1, jrb2;
    private JComboBox comboBox;
    private FriendDAO friendDAO = new FriendDAO();
    private FriendDTO friendDTO = new FriendDTO();
    
    public FriendManager() {
        JFrame jf = new JFrame();
        jf.getContentPane().setBackground(SystemColor.inactiveCaption);
        
        JLabel l1 = new JLabel("개인정보입력");
        l1.setFont(new Font("굴림", Font.BOLD, 12));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(100, 10, 84, 15);
        jf.getContentPane().add(l1);
                    
        jf.getContentPane().setLayout(null);
        
        l2 = new JLabel("전체목록");
        l2.setFont(new Font("굴림", Font.BOLD, 12));
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setBounds(447, 10, 57, 15);
        jf.getContentPane().add(l2);
        
        t1 = new JTextField();
        t1.setBounds(92, 87, 116, 21);
        jf.getContentPane().add(t1);
        t1.setColumns(10);
        
        l3 = new JLabel("전화번호:");
        l3.setFont(new Font("굴림", Font.BOLD, 12));
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setBounds(12, 128, 66, 15);
        jf.getContentPane().add(l3);
        
        String[] str = {"010","019"};
        comboBox = new JComboBox(str);
        comboBox.setBounds(94, 125, 51, 21);
        jf.getContentPane().add(comboBox);
        
        t2 = new JTextField();
        t2.setBounds(157, 125, 51, 21);
        jf.getContentPane().add(t2);
        t2.setColumns(10);
        
        t3 = new JTextField();
        t3.setColumns(10);
        t3.setBounds(220, 125, 51, 21);
        jf.getContentPane().add(t3);
        
        jrb1 = new JRadioButton("남성",true);//true해 놓으면  표시가 되어 있다
        jrb1.setBackground(SystemColor.inactiveCaption);
        jrb1.setFont(new Font("굴림", Font.BOLD, 12));
        jrb1.setHorizontalAlignment(SwingConstants.CENTER);
        jrb1.setBounds(94, 166, 51, 23);
        jf.getContentPane().add(jrb1);
        
        jrb2 = new JRadioButton("여성", false);
        jrb2.setBackground(SystemColor.inactiveCaption);
        jrb2.setHorizontalAlignment(SwingConstants.CENTER);
        jrb2.setFont(new Font("굴림", Font.BOLD, 12));
        jrb2.setBounds(157, 166, 51, 23);
        jf.getContentPane().add(jrb2);
        
        ButtonGroup group = new ButtonGroup();
        group.add(jrb1);
        group.add(jrb2);
        
        
        l4 = new JLabel("취    미:");
        l4.setHorizontalAlignment(SwingConstants.CENTER);
        l4.setFont(new Font("굴림", Font.BOLD, 12));
        l4.setBounds(12, 215, 66, 15);
        jf.getContentPane().add(l4);
        
        jcb1 = new JCheckBox("독서");
        jcb1.setBackground(SystemColor.inactiveCaption);
        jcb1.setFont(new Font("굴림", Font.BOLD, 12));
        jcb1.setBounds(94, 211, 51, 23);
        jf.getContentPane().add(jcb1);
        
        jcb2 = new JCheckBox("영화");
        jcb2.setBackground(SystemColor.inactiveCaption);
        jcb2.setFont(new Font("굴림", Font.BOLD, 12));
        jcb2.setBounds(149, 211, 51, 23);
        jf.getContentPane().add(jcb2);
        
        jcb3 = new JCheckBox("음악");
        jcb3.setBackground(SystemColor.inactiveCaption);
        jcb3.setFont(new Font("굴림", Font.BOLD, 12));
        jcb3.setBounds(204, 211, 51, 23);
        jf.getContentPane().add(jcb3);
        
        jcb4 = new JCheckBox("게임");
        jcb4.setBackground(SystemColor.inactiveCaption);
        jcb4.setFont(new Font("굴림", Font.BOLD, 12));
        jcb4.setBounds(259, 211, 51, 23);
        jf.getContentPane().add(jcb4);
        
        jcb5 = new JCheckBox("쇼핑");
        jcb5.setBackground(SystemColor.inactiveCaption);
        jcb5.setFont(new Font("굴림", Font.BOLD, 12));
        jcb5.setBounds(314, 211, 57, 23);
        jf.getContentPane().add(jcb5);
        
        b1 = new JButton("등록");
        b1.setFont(new Font("굴림", Font.BOLD, 12));
        b1.setBounds(40, 254, 66, 32);
        jf.getContentPane().add(b1);
        
        b2 = new JButton("수정");
        b2.setEnabled(false);
        b2.setFont(new Font("굴림", Font.BOLD, 12));
        b2.setBounds(118, 254, 66, 32);
        jf.getContentPane().add(b2);
        
        b3 = new JButton("삭제");
        b3.setEnabled(false);
        b3.setFont(new Font("굴림", Font.BOLD, 12));
        b3.setBounds(196, 254, 66, 32);
        jf.getContentPane().add(b3);
        
        b4 = new JButton("지우기");
        b4.setEnabled(false);
        b4.setFont(new Font("굴림", Font.BOLD, 12));
        b4.setBounds(274, 254, 76, 32);
        jf.getContentPane().add(b4);
        
        jta1 = new JTextArea();
        jta1.setBounds(12, 342, 554, 129);
        jf.getContentPane().add(jta1);
        
        l5 = new JLabel("개인정보분석");
        l5.setHorizontalAlignment(SwingConstants.CENTER);
        l5.setFont(new Font("굴림", Font.BOLD, 12));
        l5.setBounds(237, 306, 98, 15);
        jf.getContentPane().add(l5);
        
        
        jlist = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
        model = (DefaultListModel<FriendDTO>) jlist.getModel();
        jlist.setBounds(385, 66, 181, 220);
        jf.getContentPane().add(jlist);
        
        l6 = new JLabel("번    호:");
        l6.setFont(new Font("굴림", Font.BOLD, 12));
        l6.setHorizontalAlignment(SwingConstants.CENTER);
        l6.setBounds(12, 54, 57, 15);
        jf.getContentPane().add(l6);
        
        l7 = new JLabel("이    름:");
        l7.setHorizontalAlignment(SwingConstants.CENTER);
        l7.setFont(new Font("굴림", Font.BOLD, 12));
        l7.setBounds(12, 90, 57, 15);
        jf.getContentPane().add(l7);
        
        l8 = new JLabel("성    별:");
        l8.setHorizontalAlignment(SwingConstants.CENTER);
        l8.setFont(new Font("굴림", Font.BOLD, 12));
        l8.setBounds(12, 170, 57, 15);
        jf.getContentPane().add(l8);
        
        l9 = new JLabel();
        l9.setForeground(Color.WHITE);
        l9.setBackground(SystemColor.inactiveCaptionBorder);
        l9.setBounds(100, 54, 108, 15);
        jf.getContentPane().add(l9);
        
       
        jf.setBounds(200, 200, 594, 520);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //DB 모든 레코드(행)을 꺼내서 JList에 뿌리기
        List<FriendDTO> list = friendDAO.getFriendList(); //정보들을 리스트에 담기
        for(FriendDTO friendDTO : list) {
			model.addElement(friendDTO);//리스트에 있는 값들을 frinedDTO에 넣어서 model에 넣어주면
		}								//화면리스트에 db의 값들이 나온다.
    }//FriendManager
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			
			int seq = friendDAO.getSeq();
			
			System.out.println(seq);
			
			String name = t1.getText();//적혀진 이름 얻어오기
			String tel1 = (String)comboBox.getSelectedItem(); //010,019얻어오기  오브젝트를 스트링으로 형변환하기
			String tel2 = t2.getText();
			String tel3 = t3.getText();
			
			int gender = 0; 
			
			if(jrb1.isSelected()) gender=0; //라디오 버튼의 선택이 남자면 0 여자는 1
			else if(jrb2.isSelected()) gender=1;
			
			
			int read = jcb1.isSelected() ? 1 : 0; //조건연산자 사용 조건이 맞으면 1 아니면 0 참이면 1 거짓이면 0    체크되면 1 체크안되면 0      독서
			int movie = jcb2.isSelected() ? 1 : 0; // 영화
			int music = jcb3.isSelected() ? 1 : 0; // 음악
			int game = jcb4.isSelected() ? 1 : 0; // 게임
			int shopping = jcb5.isSelected() ? 1 : 0; // 쇼핑
			
			FriendDTO friendDTO = new FriendDTO();// DTO객체 생성
			friendDTO.setSeq(seq);
			friendDTO.setName(name); //하나하나씩 friendDTO로 변수와 내용 보내기
			friendDTO.setTel1(tel1);
			friendDTO.setTel2(tel2);
			friendDTO.setTel3(tel3);
			friendDTO.setGender(gender);
			friendDTO.setRead(read);
			friendDTO.setMovie(movie);
			friendDTO.setMusic(music);
			friendDTO.setGame(game);
			friendDTO.setShopping(shopping);
			
			//DB에 넣기
			int su = friendDAO.friendWrite(friendDTO);// 모든 변수를 friendDTO로 합쳐서 보낸다.
		
			//응답
			remove();//초기화
			jta1.setText("\n\t"+su+"명을 등록하였습니다.");
			model.addElement(friendDTO);//모델에 넣어주면 리스트에 나온다
			
			
			
		}else if(e.getSource() == b2) {
			friendDTO = jlist.getSelectedValue();
			
			int seq = friendDTO.getSeq();
			
			String name = t1.getText();//적혀진 이름 얻어오기
			String tel1 = (String)comboBox.getSelectedItem(); //010,019얻어오기  오브젝트를 스트링으로 형변환하기
			String tel2 = t2.getText();
			String tel3 = t3.getText();
			
			int gender = 0; 
			
			if(jrb1.isSelected()) gender=0; //라디오 버튼의 선택이 남자면 0 여자는 1
			else if(jrb2.isSelected()) gender=1;
			
			
			int read = jcb1.isSelected() ? 1 : 0; //조건연산자 사용 조건이 맞으면 1 아니면 0 참이면 1 거짓이면 0    체크되면 1 체크안되면 0      독서
			int movie = jcb2.isSelected() ? 1 : 0; // 영화
			int music = jcb3.isSelected() ? 1 : 0; // 음악
			int game = jcb4.isSelected() ? 1 : 0; // 게임
			int shopping = jcb5.isSelected() ? 1 : 0; // 쇼핑
			
			friendDTO = new FriendDTO();// DTO객체 생성
			
			friendDTO.setSeq(seq);
			friendDTO.setName(name); //하나하나씩 friendDTO로 변수와 내용 보내기
			friendDTO.setTel1(tel1);
			friendDTO.setTel2(tel2);
			friendDTO.setTel3(tel3);
			friendDTO.setGender(gender);
			friendDTO.setRead(read);
			friendDTO.setMovie(movie);
			friendDTO.setMusic(music);
			friendDTO.setGame(game);
			friendDTO.setShopping(shopping);
			
			//DB에 넣기
			int su = friendDAO.friendModify(friendDTO);// 모든 변수를 friendDTO로 합쳐서 보낸다.
		
			//응답
			
			jta1.setText("\n\t"+su+"명을 수정하였습니다.");
			
			model.set(jlist.getSelectedIndex(), friendDTO);
			
		}else if(e.getSource() == b3) {
			delete();
		}else if(e.getSource() == b4) {
			remove();
		}
		
	}
	
	private void delete() {	
		
		int su = friendDAO.deleteList(friendDTO); 
		
		model.removeElement(friendDTO);
		
		remove();
	}


	public void remove(){//입력하면 값이 화면에서 지워지게 하기
		t1.setText("");
		t2.setText("");
		t3.setText("");
		
		comboBox.setSelectedItem("010");
		
		jrb1.setSelected(true);//초기화되면 남성버튼위에 있기
		jrb2.setSelected(false);
		
		jcb1.setSelected(false); //초기화 화면 체기화하면 체크박스 없애기
		jcb2.setSelected(false);
		jcb3.setSelected(false);
		jcb4.setSelected(false);
		jcb5.setSelected(false);
		
		b1.setEnabled(true);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
	}


	public void event() {
		b1.addActionListener(this);
		
		b2.addActionListener(this);
		
		b3.addActionListener(this);
		
		b4.addActionListener(this);
		
		jlist.addListSelectionListener(this);//리스트를 클릭하면 왼쪽의 화면에 뭘 클릭했는지 나오는 명령어
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		System.out.println("index = "+jlist.getSelectedIndex());
		
		if(jlist.getSelectedIndex() == -1) return;
		
		friendDTO = jlist.getSelectedValue();
			
		
		t1.setText(friendDTO.getName());
		comboBox.setSelectedItem(friendDTO.getTel1());
		t2.setText(friendDTO.getTel2());
		t3.setText(friendDTO.getTel3());
		
		if(friendDTO.getGender() == 0)jrb1.setSelected(true);
		else if(friendDTO.getGender() == 1) jrb2.setSelected(true);
		
		jcb1.setSelected(friendDTO.getRead() == 1 ? true : false);//선택되면 true
		jcb2.setSelected(friendDTO.getMovie() == 1 ? true : false);
		jcb3.setSelected(friendDTO.getMusic() == 1 ? true : false);
		jcb4.setSelected(friendDTO.getGame() == 1 ? true : false);
		jcb5.setSelected(friendDTO.getShopping() == 1 ? true : false);
		
		b1.setEnabled(false);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		
	}
	
	
	public static void main(String[] args) {
        new FriendManager().event(); 
    }


	


	
}

