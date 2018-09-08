package knowyourtown.storage.webservice;

import knowyourtown.localdb.webservice.PeopleService;
import knowyourtown.localdb.webservice.People;
import knowyourtown.localdb.webservice.Person;
import knowyourtown.localdb.webservice.Place;
import knowyourtown.localdb.webservice.PlaceType;
import knowyourtown.localdb.webservice.Suggestion;

import introsde.ws.WeatherImplService;
import introsde.ws.Weather;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

//Service Implementation

@WebService(endpointInterface = "knowyourtown.storage.webservice.Storage",
    serviceName="StorageService")
public class StorageImplementation implements Storage 
{
	PeopleService service;
	People people;
	WeatherImplService weather_service_adaptor;
	Weather adaptor;
	
	public void init()
	{
		service = new PeopleService();
        people = service.getPeopleImplementationPort();
	}
	
	public void init_adaptor_weather()
	{
		weather_service_adaptor = new WeatherImplService();
        adaptor = weather_service_adaptor.getWeatherImplPort();
	}
	
	/* Manage Person*/
	
    @Override
    public Person readPerson(int id) {
    	init();    	
        System.out.println("Reading Person by id = "+id);
        Person p = people.readPerson(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getFirstname());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }

    @Override
    public int addPerson(Person person) {
    	init();
    	System.out.println("Save Person with id = " + person.getIdPerson());
    	return people.createPerson(person);
    }

    @Override
    public int updatePerson(Person person) {
    	init();
    	if(person == null)
    	{
    		System.out.println("Zio billy");
    		return 1;
    	}    	
    	System.out.println("Update Person with id = " + person.getIdPerson());
        return people.updatePerson(person);
    }

    @Override
    public int deletePerson(int id) {
    	init();
    	System.out.println("Delete Person with id = " + id);           
        return people.deletePerson(id);
    }
    
    
    /* Manage Place */
    
    @Override
    public Place readPlace(int pId, String placeType, int mId) {
        init();
    	System.out.println("Reading Place by pId = " + pId + ", mId = " + mId + ", type = " + placeType);
        List<Place> p = people.getPlaceHistory(pId, placeType);
        return p.get(0);
    }

    @Override
    public List<Place> getPlaces(int pId, String placeType) {
    	init();
    	System.out.println("Reading Place by pId = " + pId + ", type = " + placeType);
        List<Place> p = people.getPlaceHistory(pId, placeType);
        return p;
    }
    
    @Override
    public List<Place> getSomePlaces(int pId, String placeType, int nPlace) {
    	init();
    	System.out.println("Reading Place by pId = " + pId + ", type = " + placeType);
        List<Place> p = people.getSomePlace(pId, placeType, nPlace);
        return p;
    }
    
    @Override
    public List<Place> getLastPlace(int pId) {
    	init();
    	System.out.println("Reading Last Place by pId = " + pId);
        List<Place> p = people.readLastPlace(pId);
        return p;
    }
    
    @Override
    public Place getLastPlaceByType(int pId, String type) {
    	init();
    	System.out.println("Reading Last Place by pId = " + pId + " and type = " + type);
        Place p = people.readLastPlaceByType(pId, type);
        if (p!=null) {
            System.out.println("---> Found Place by id " + p.getIdPlace());
        } else {
            System.out.println("---> Didn't find any Place");
        }
        return p;
    }

    @Override
    public int addPlace(int pId, Place place) {
    	init();
    	System.out.println("Save Place with id = " + place.getIdPlace());
        
    	if(place.getPlaceType()==null)
    	{
    		System.out.println("QUi");
    	}
    	else
    	{
    		System.out.println("QUa " + place.getPlaceType().getType());
    	}
    	
        return people.createPlace(pId, place);
    }

    @Override
    public int updatePlace(int pId, Place place) {
    	init();
    	System.out.println("Update Place with id = " + place.getIdPlace());  	
    	return people.updatePlace(pId, place);
    }
    
    @Override
    public int deletePlace(int id) {
    	init();
    	System.out.println("Delete Place with id = " + id);
    	return people.deletePlace(id);
    }
    
    
    /* Manage PlaceType */
    
    @Override
    public PlaceType readPlaceType(int id) {
        init();
    	System.out.println("Reading PlaceType by id = " + id);
        PlaceType m = people.readPlaceType(id);
        if (m!=null) {
            System.out.println("---> Found PlaceType by id = " + id + " => " + m.getType());
        } else {
            System.out.println("---> Didn't find any PlaceType with  id = " + id);
        }
        return m;
    }

    @Override
    public List<PlaceType> getPlaceType() {
    	init();
    	System.out.println("Read PlaceType List");
        return people.getPlaceTypeList();
    }
    
    @Override
    public int getIdPlaceTypeByType(String type) {
    	init();
    	System.out.println("Read PlaceType List");
        return people.getIdPlaceTypeByType(type);
    }
    
        
    /* Manage Suggestion */
    
    @Override
    public List<Suggestion> getSuggestions(int pId) {
        init();
    	System.out.println("Reading Suggestion by id = " + pId);
        List<Suggestion> m = people.getSuggestions(pId);
        
        return m;
    }
    
    @Override
    public Suggestion readSuggestion(int pId, String placeType, int gId) {
        init();
    	System.out.println("Reading Suggestion by pId = " + pId + ", mId = " + gId + ", type = " + placeType);
        return people.readSuggestion(pId, placeType, gId);
    }

    @Override
    public List<Suggestion> getSuggestion(int pId, String placeType) {
    	init();
    	System.out.println("Reading Suggestion by pId = " + pId + ", type = " + placeType);
        List<Suggestion> p = people.getSuggestionHistory(pId, placeType);
        
        return p;
    }

    @Override
    public int addSuggestion(int pId, Suggestion suggestion) {
    	init();
    	System.out.println("Save Suggestion with id = " + suggestion.getIdSuggestion());
        
    	return people.createSuggestion(pId, suggestion);
    }

    @Override
    public int updateSuggestion(int pId, Suggestion suggestion) {
    	init();
    	System.out.println("Update Suggestion with id = " + suggestion.getIdSuggestion());
    	return people.updateSuggestion(pId, suggestion);
    }
    
    @Override
    public int deleteSuggestion(int id) {
    	init();
    	System.out.println("Delete Suggestion with id = " + id);
    	return people.deleteSuggestion(id);
    }

     @Override
    public Suggestion getSuggestionByTitle(int pId, String title){
	init();
	System.out.println("Suggestion by id = " + pId + " title = " + title);

	return people.getSuggestionByTitle(pId, title);
    }
    
    
    /* Manage Adaptor Weather */
    
    @Override
    public String getWeatherInformationByCity(String city) {
    	init_adaptor_weather();    	
        String b = adaptor.getWeatherInformationByCity(city);
        return b;
    }

    /* Manage Adaptor Motivation */
    @Override
    public String getQuote(){
        return "TODO";
    }

    @Override
    public String getQuote2(){
        return "TODO";
    }
}
