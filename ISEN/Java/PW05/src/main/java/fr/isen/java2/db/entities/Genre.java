package fr.isen.java2.db.entities;

public class Genre {
	private Integer id;
	private String name;

	public Genre() {
	}

	public Genre(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Genre genre = (Genre) obj;
		if(this.id == genre.getId() && this.name.equals(genre.getName())){
			return true;
		}
		else{
			return false;
		}
		//return super.equals(obj);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
