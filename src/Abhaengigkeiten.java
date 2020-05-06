
public class Abhaengigkeiten implements AbhaengigkeitenIF {

	public String[][] dependencies;
	
	
	public Abhaengigkeiten() {};
	public Abhaengigkeiten(String[][] list){
		this.dependencies = list;
	}
	@Override
	public void setDependencies(String[][] list) {
		this.dependencies = list;

	}

	@Override
	public boolean isWellSorted(String[] sequence) {
		if(sequence == null) return true;								//Leere Tasklisten sind sortiert
		if(dependencies == null) dependencies = new String[][]{};		//wird behandelt wie leere Liste
		
		for(int zeiger=0; zeiger<sequence.length-1; zeiger++) {			//Iteriere durch Tasks	
			for(String[] dL: dependencies) {							//und alle dependencies
				if(sequence[zeiger].equals(dL[1])) {					//Pruefe ob Task Abhängigkeit hat
					boolean wasFound = false;							
					for(int i=0; i<zeiger; i++) {						//Schau ob nötiger Task schon vorkam
						if(sequence[i].equals(dL[0])) {					
							wasFound = true;							//Wenn gefunden wasFound=True
								}
					}
					if(!wasFound) return false;							//Wenn nicht ist die Liste nicht sortiert
				}
			}
			
			for(int i=0; i<zeiger; i++) {								//Prüfung ob Tasks mehrfach vorkamen
				if(sequence[i].equals(sequence[zeiger])) return false;
			}
		}
		
		return true;	//alles hat geklappt, also ist die Liste gut sortiert
	}

}
