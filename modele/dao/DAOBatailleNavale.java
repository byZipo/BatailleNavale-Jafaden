package modele.dao;

import java.io.Serializable;

public abstract class DAOBatailleNavale implements Serializable{
	private static DAOBatailleNavale instanceDAOFile = new DAOBatailleNavaleFile();
	private static DAOBatailleNavale instance = instanceDAOFile;
	public enum DAO {FILE, INTER, SIMPLE};

	public abstract void saveBatailleNavale();
	
	public abstract void loadBatailleNavale();
	
	public static DAOBatailleNavale getInstance(){
		return instance;
	}
	
	public static void setInstance(DAO d){
		switch(d){
			case FILE : 
				instance = instanceDAOFile;
				break;
		}
	}
}
