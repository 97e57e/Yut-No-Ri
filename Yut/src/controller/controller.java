package controller;

import java.util.ArrayList;

public class controller{
	
	public YutNoRiSet yutnoriset = new YutNoRiSet();

	public int playerTurn = 1;
	private static ArrayList<String> result;
	
	public int checkTurn(){
		return playerTurn;
	}
	
	public int nextTurn(){
		return playerTurn%4 + 1;
	}
	
	public boolean gameProgress(){
		int numCanMove=0;
		int catchPoint=0;
		result = new ArrayList<String>();
		String 
		
		do{
			if(catchPoint>=1){
				catchPoint--;
			}
			/*  Before Yut Roll State  */
			do{
				result.add(yutnoriset.rollyut()); //���� ���� ����� �迭�� ����
				numCanMove++;
				
			}while(result=="��"||"��");//�� ���� ������ �ѹ� �� ���� ������.
			
			while(numCanMove>=1){// ������ �� �ִ� Ƚ���� �����ִµ���
				
				/*  Choose Move Piece State  */
				choicePiece();// ������ ���� �����ϰ�
				if(numCanMove>1){       //2�� �̻� result�� ������
					showMovable(result);//������ �� �ִ� ĭ�� �����ְ�
					selectMovePoint();  //������ circle�� ������ ��
					move();             //�����δ�.
					numCanMove--;
				}
				else{
					move();	// numCanMove�� 1�̶�� �ٷ� �����̸� �ȴ�.
					numCanMove--;
				}
				
				/*  Piece Moved State  */
				if(checkCatch()){
					catchPoint++; // ���� ��� ���� ��Ҵٸ� checkPoint�� �÷���
				}
				
				if(checkGroup()){
					group();
				}
				
				if(checkArrive()){
					return checkEndGame(); // ���� ������ ������ ���� ���� ���ٸ� ������ ����ȴ�.
				}
			}
		}while(catchPoint>1); // checkPoint ��, ��� ���� ������ŭ ���� �� ���� �� �� ����.
		
		nextTurn(); // ���� ������ �� ���ƴµ� ������ �ȳ����ٸ� ���� �Ѱ���.
		return checkEndGame();
		
	}
	
	public boolean checkEndGame(){
		boolean end = false;
		if(numOfPiece<=0) {end = true;}
		return end;
	}
}



//
//void setOption(int playernum, int piecenum){
//	yutset.setOption
//}
//
//int checkTurn(){
//	return turn;
//}
//
//void rollYut(int turn){}
//void choosePiece(){}
//void showMovable(int){}
//void movePiece(){}
//boolean checkCatch(position){}
//boolean checkGroup(position){}
//boolean checkArriv(position){}
//
//int nextTurn(int turn){
//	int t = turn%(yutset.getNumOfPlayer()) + 1;
//	return t;
//}
//
//boolean checkEndGame(){}
//
//void restartGame(){}
//void endGame(){}