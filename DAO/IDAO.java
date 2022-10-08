package DAO;

public interface IDAO {

	public void create();
	public void readAll(); 
	public void readOne(String name); 
	public boolean updateName(String searchName, String updaterName);
	public boolean delete(String deleteName);
}
